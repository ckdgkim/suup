package miniproject_bank2;

import miniproject_bank2.Enum.BankCode;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Customer {
  // 고객: 고객 번호 + 고객 객체
  public static Map<String, Customer> customerMap = new HashMap<>();

  BankCode bankCode;      		// 은행코드
  String customerNumber; 			// 고객번호 주민번호 앞자리 6자리
  String name;           			// 고객 이름
  LocalDate firstTransactionDate; // 신규 거래 일자
  LocalDate lastTransactionDate; 	// 최종 거래 일자

  public Customer(BankCode bankCode) {
    this.bankCode = bankCode;
    this.firstTransactionDate = LocalDate.now();
    this.lastTransactionDate = LocalDate.now();
  }

  //고객의 cru 는 거래가 있을때 같이 진행됨, 고객정보 삭제는 이번에는 고려대상이 아님

  // 고객 조회
  public static Customer customerInquiry(String customerNumber) {
      Customer customer = customerMap.get(customerNumber);

    if (customer == null) {
      System.out.println("고객 정보가 없습니다");
    }

    return customer;
  }

  // 고객 거래 발생 시 업데이트
  public static void setLastTransactionDate(String customerNumber) {
    Customer customer = customerInquiry(customerNumber);
    customer.lastTransactionDate = LocalDate.now();
    System.out.println(Customer.customerMap.get(customerNumber).toString());
  }

  @Override
  public String toString() {
    return "Customer{" +
        "bankCode=" + bankCode +
        ", customerNumber='" + customerNumber + '\'' +
        ", name='" + name + '\'' +
        ", firstTransactionDate=" + firstTransactionDate +
        ", lastTransactionDate=" + lastTransactionDate +
        '}';
  }
}

