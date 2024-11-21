package com.example.product;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;

@Slf4j
@WebServlet("/products")
public class ProductController extends HttpServlet {
  ProductDAO service;

  public void init(ServletConfig config) throws ServletException {
    service = new ProductDAO();
    service.open();
    log.info("init()");
  }

  public void destroy(){
    service.close();
    log.info("destroy()");
  }

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String action = req.getParameter("action");
    String method = req.getMethod();
    String view = "";
    log.info("action: {} " , action);
    log.info("method: {} " , method);

    if (action == null){
      resp.sendRedirect("/products?action=list");
    } else {
      switch (action){
        case "list":
          view = list(req, resp);
          req.getRequestDispatcher(view).forward(req, resp);
          log.info(view);
          break;
        case "info":
          view = info(req, resp);
          req.getRequestDispatcher(view).forward(req, resp);
          log.info(view);
          break;
        case "create":
          view = create(req, resp);
          if (method.equals("GET")) {
            req.getRequestDispatcher(view).forward(req, resp);
            log.info(view);
          } else if (method.equals("POST")) {
            resp.sendRedirect(view);
            log.info(view);
          }
          break;
        case "update":
          view = update(req, resp);
          if (method.equals("GET")){
            log.info(view);
            req.getRequestDispatcher( view).forward(req,resp);
          } else if (method.equals("POST")){
            resp.sendRedirect(view);
            log.info(view);
          }
          break;
        case "delete":
          view = delete(req, resp);
          resp.sendRedirect(view);
          log.info(view);
          break;
      }
    }
  }

  private String list(HttpServletRequest req, HttpServletResponse resp) {
    List<Product> products = service.findAll();
    req.setAttribute("products", products);
    return "productList.jsp";
  }

  private String info(HttpServletRequest req, HttpServletResponse resp) {
    Product product = service.findById(Integer.parseInt(req.getParameter("id")));
    req.setAttribute("product", product);
    return "productInfo.jsp";
  }

  private String create(HttpServletRequest req, HttpServletResponse resp) {
    String method = req.getMethod();
    String view="";
    if (method.equals("POST")) {
      Product p = new Product(
          0,
          req.getParameter("name"),
          req.getParameter("description"),
          Integer.parseInt(req.getParameter("price"))
      );
      service.create(p);
      view="/products?action=list";
    } else if (method.equals("GET")){
      view="productCreate.jsp";
    }
    log.info("HTTP method: {}", method);
    return view;
  }

  private String update(HttpServletRequest req, HttpServletResponse resp) {
    String method = req.getMethod();
    String view = "";

    if (method.equals("POST")) {
      int id = Integer.parseInt(req.getParameter("id"));
      String name = req.getParameter("name");
      String description = req.getParameter("description");
      int price = Integer.parseInt(req.getParameter("price"));

      log.info("수정할 상품 정보 id: {}, name: {}, description: {}", id, name, description);

      Product p = new Product(id, name, description, price);
      service.updateProduct(p);
      view="/products?action=info&id=" + p.getId();

    } else if (method.equals("GET")){
      int id = Integer.parseInt(req.getParameter("id"));
      Product p = service.findById(Integer.parseInt(req.getParameter("id")));
      req.setAttribute("p", p);
      view="productUpdate.jsp";
    }
    log.info("HTTP method: {}", method);
    return view;
  }

  private String delete(HttpServletRequest req, HttpServletResponse resp){
    int id = Integer.parseInt(req.getParameter("id"));

    service.deleteProduct(id);
    return "/products?action=list";
  }
}
