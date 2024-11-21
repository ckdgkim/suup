package miniproject_bank1;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

class Customer {
  public static long seqno;
  String name;
  String customerId;
  Map<String, Account> accounts; // customerId, 계좌

  LocalDateTime registerTime;
  LocalDateTime finalTransactionDate;

  public Customer(String id, String name) {
    this.customerId = id;
    this.name = name;
    this.accounts = new HashMap<>();
    this.registerTime = LocalDateTime.now();
    seqno = seqno + 1;
  }

  public Map<String, Account> getAccounts() {
    return accounts;
  }

  public Account creatAccount(Bank bank, String password) {
    Account a = new Account(this, bank, password);
    accounts.put(a.getAccountNumber(), a);
    setFinalTransactionDate();
    return a;
  }

  public void closeAccount(Input input) {
    if (accounts.containsKey(input.getAccountNumber())) {
      if (accounts.get(input.getAccountNumber()).closeAccount(input)) {
        // accounts.remove(input.getAccountNumber());
        // 리스트에서 지우지 말고 상태만 변환할것. -> 중복된 계좌 생성 X 추후 조회하기 위해서
      } else {
        System.out.println("계좌 해지에 실패하였습니다.");
      }
    } else {
      System.out.println("해당하는 계좌가 없습니다.");
    }
    setFinalTransactionDate();
  }

  public void setFinalTransactionDate() {
    finalTransactionDate = LocalDateTime.now();
  }
}
