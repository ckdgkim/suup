package Bank;

import java.time.LocalDate;

public class BankSystem {
  public static void main(String[] args) {
    BankCode bankCode = BankCode.SHINHAN;
    Customer customer = new Customer(bankCode, "1", "901010","홍길동", LocalDate.now());
    Account account = new Account(bankCode, "12345", customer, LocalDate.now(), " password123");
    account.deposit(50000);
    if (account.passwordCheck("password123")){
      boolean normal = account.withdraw(20000);
      if (normal){
        System.out.println("출금 완료. 잔액: " + account.getBalance() + "원");
      } else {
        System.out.println("잔액 부족으로 출금 실패.");
      }
    }else {
      System.out.println("비밀번호가 일치하지 않습니다.");
    }
    System.out.println("계좌번호 " + account.getAccountNum());
    System.out.println("잔액 : " + account.getBalance() + "원");

    BankTeller bankTeller = new BankTeller(bankCode, "E001", "김직원");
    TransactionHistory transactionHistory = new TransactionHistory("T001", WorkCode.deposit, account, customer,50000,bankTeller,Status.normal);

    System.out.println("거래번호 " + transactionHistory.sequenceNum);
    System.out.println("거래유형 " + transactionHistory.workCode);
    System.out.println("처리상태 " + transactionHistory.status);
  }
}
