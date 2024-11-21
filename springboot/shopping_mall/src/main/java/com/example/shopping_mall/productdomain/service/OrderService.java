package com.example.shopping_mall.productdomain.service;

import com.example.shopping_mall.productdomain.dto.OrderCreateDto;
import com.example.shopping_mall.productdomain.dto.OrderInquiryDto;
import com.example.shopping_mall.productdomain.dto.OrderProductCreateDto;
import com.example.shopping_mall.productdomain.entity.*;
import com.example.shopping_mall.productdomain.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderProductRepository orderProductRepository;
    private final MemberRepository memberRepository;
    private final ProductRepository productRepository;
    private final StockRepository stockRepository;
    private final DeliveryRepository deliveryRepository;

    public OrderInquiryDto getOneOrderByMember(String userId) {
        Member member = memberRepository.findByUserId(userId).get();
        Optional<Order> byMember = orderRepository.findByMember(member);
        if (byMember.isPresent()) {
            Order order = byMember.get();
            OrderInquiryDto.of(order);
        }
        return null;
    }

    public OrderInquiryDto createOrder(OrderCreateDto orderDto,
                                       OrderProductCreateDto... orderProductDtos) {
        Member member = memberRepository.findById(orderDto.getMemberId()).get();
        List<OrderProduct> orderProducts = new ArrayList<>();
        for (OrderProductCreateDto orderProductDto : orderProductDtos) {
            Product product = productRepository.findById(orderProductDto.getProductId()).get();
            Stock stock = stockRepository.findByWarehouseAndProduct(Warehouse.KR, product).get();
            OrderProduct orderProduct = OrderProduct.createOrderProduct(
                    product, orderProductDto.getQuantity(), product.getPrice(), stock
            );
            orderProducts.add(orderProduct);
        }

        Delivery delivery = new Delivery(// delivery_id가 long이면 0L로 줘도 되지만 Long인 경우에는 null로 줘야한다.
                null, null, orderDto.getAddress(),
                DeliveryStatus.prepared,
                LocalDateTime.now()
        );

        Order order = Order.createOrder(member, delivery, orderProducts);
        delivery.setOrder(order);
        // order가 저장될 때 delivery와 orderProduct은 영속성 전이에 의해 함께 저장된다.
        Order save = orderRepository.save(order);
        log.info("order : {}", save.getOrderId());
        OrderInquiryDto orderInquiryDto = OrderInquiryDto.of(save);
        log.info("orderInquiryDto : {}", orderInquiryDto);

        return orderInquiryDto;
    }

    public void cancelOrder(int orderId) {
        // 주문을 조회
        Order order = orderRepository.findById((long) orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        // 주문에 속한 모든 주문 상품을 취소
        for (OrderProduct orderProduct : order.getOrderProducts()) {
            cancelOrderProduct(orderProduct.getOrderProductId());
        }

        // 전체 주문 취소
        order.totalOrderCancel();

        // 상태 변경 후 저장
        orderRepository.save(order);
    }

    public void cancelOrderProduct(long orderProductId) {
        // 주문 상품 조회
        OrderProduct orderProduct = orderProductRepository.findById(orderProductId)
                .orElseThrow(() -> new RuntimeException("Order product not found"));

        // 해당 상품의 재고 조회
        Optional<Stock> stockOptional = stockRepository.findByWarehouseAndProduct(Warehouse.KR, orderProduct.getProduct());
        if (!stockOptional.isPresent()) {
            throw new RuntimeException("Stock not found");
        }

        // 재고 업데이트 (상품 수량을 증가)
        Stock stock = stockOptional.get();
        orderProduct.cancelOrderProduct(stock);

        // 주문 상태에 따라 전체 주문 취소 혹은 부분 취소 처리
        Order order = orderProduct.getOrder();
        List<OrderProduct> orderProducts = order.getOrderProducts();

        int canceledCount = 0;
        for (OrderProduct product : orderProducts) {
            if (product.getStatus() == OrderProductStatus.canceled) {
                canceledCount++;
            }
        }

        // 부분 취소일 경우
        if (orderProducts.size() - canceledCount > 1) {
            order.partialOrderCancel(orderProduct);
        } else {
            // 전체 취소일 경우
            order.totalOrderCancel();
        }

        // 변경된 주문 상태를 저장
        orderRepository.save(order);
    }

//    public void cancelOrderProduct(long orderProductId) {
//        OrderProduct byId = orderProductRepository.findById(orderProductId).get();
//        Optional<Stock> byWarehouseAndProduct = stockRepository.findByWarehouseAndProduct(Warehouse.KR, byId.getProduct());
//        if (byWarehouseAndProduct.isPresent()) {
//            Stock stock = byWarehouseAndProduct.get();
//            // 상품에 대한 캔슬, 재고 up
//            orderProduct.cancelOrderProduct(stock);
//            Order order = orderProduct.getOrder();
//            List<OrderProduct> details = orderProduct.getOrder().getOrderProducts();
//            int cntCancel = 0;
//            for (OrderProduct detail : details) {
//                if (detail.getStatus() == OrderProductStatus.canceled) {
//                    cntCancel++;
//                }
//            }
//            if (details.size() - cntCancel > 1) {
//                order.partialOrderCancel(orderProduct);
//            } else {
//                order.totalOrderCancel();
//            }
//            Order save = orderRepository.save(order);
//            {
////            orderProduct.getOrder().getOrderProducts().size()
////            A = 3, B = 2(취소) ==> 전체취소
////            A = 3, B = 2 ==> 부분취소
//            }
//
//        }
//    }
}
