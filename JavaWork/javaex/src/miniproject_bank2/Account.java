package miniproject_bank2;

import miniproject_bank2.Enum.BankCode;
import miniproject_bank2.Enum.TransactionStatus;
import miniproject_bank2.Enum.TransactionType;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Account {
  // 계좌: 계좌 번호 + 계좌 객체
  public static Map<String, Account> accountMap = new HashMap<>();

  Customer customer;
  String accountNumber;			    // 계좌번호 5자
  LocalDate accountOpenDate;		// 계좌 개설 일자
  LocalDate accountColoseDate;	// 계좌 삭제 일자
  Boolean isDormantt;   			  // 휴면 계좌 여부
  String password;     			    // 비밀번호
  long balance;        			    // 잔고

  // 계좌 생성
  public Account(Customer customer, int accountCounter) {
    this.customer = customer;
    this.accountNumber = String.format("%05d", accountCounter);
    this.accountOpenDate = LocalDate.now();
    this.accountColoseDate = null;
    this.isDormantt = false;
    this.balance = 0;
  }

  // 출금
  // 해당 은행에 계좌가 있고, 계좌번호와 고객번호, 비밀번호가 일치하면 잔액 한도 내에서 출금을 할 수 있다.
  public static long withdraw(Account account, long money) {
    if (account != null) {
      if (account.balance >= money) {
        account.balance -= money;
        setLastTransactionDate(account.customer.customerNumber);
        updateTransaction(TransactionType.WITHDRAWAL, TransactionStatus.NORMAL, money, account.customer);
        return account.balance;
      } else {
        updateTransaction(TransactionType.WITHDRAWAL, TransactionStatus.ERROR, money, account.customer);
        System.out.println("잔액이 부족합니다");
      }
    }

    return -1;
  }

  // 입금
  // 해당 은행에 계좌가 있고, 계좌번호와 고객번호가 일치하면 입금을 할 수 있다.
  public static long deposit(Account account, long money)  {
    if (account != null) {
      account.balance += money;
      setLastTransactionDate(account.customer.customerNumber);
      updateTransaction(TransactionType.DEPOSIT, TransactionStatus.NORMAL, money, account.customer);
      return account.balance;
    }

    return 0;
  }

  // 잔액 조회
  // 해당 은행에 계좌가 있고, 계좌번호와 고객번호, 비밀번호가 일치하면 잔액을 조회할 수 있다.
  public static long balanceInquiry(Account account, String password) {
    if (account != null) {
      setLastTransactionDate(account.customer.customerNumber);
      updateTransaction(TransactionType.INQUIRY, TransactionStatus.NORMAL, 0, account.customer);
      return account.balance;
    }

    return 0;
  }

  // 계좌 삭제
  // 더이상 거래를 원하지 않으면 계좌를 없앨 수 있다. 이 때 잔액이 남아있으면 모두 출금처리 후 삭제처리한다.
  // (계좌번호,고객번호,비밀번호 일치확인 필요)
  public static void deleteAccount(Account account)  {
    if (account != null) {
      updateTransaction(TransactionType.WITHDRAWAL, TransactionStatus.NORMAL, account.balance, account.customer);

      account.balance = 0;
      account.accountColoseDate = LocalDate.now();
      account.isDormantt = true;
      setLastTransactionDate(account.customer.customerNumber);
      updateTransaction(TransactionType.DELETE, TransactionStatus.NORMAL, 0, account.customer);
    }
  }

  // 계좌 조회
  public static Account accountInquiry(String accountNumber, String password) {
    Account account = accountMap.get(accountNumber);

    if (account != null) {
      if (account.password.equals(password)) {
        return account;
      } else {
        System.out.println("비밀호가 일치하지 않습니다.");
      }
    } else {
      System.out.println("계좌가 없습니다");
    }

    return null;
  }

  public static void setLastTransactionDate(String customerNumber) {
    Customer customer = Customer.customerMap.get(customerNumber);
    Customer.setLastTransactionDate(customerNumber);
  }

  public static void updateTransaction(TransactionType type, TransactionStatus status, long money, Customer customer) {
    Banker banker = new Banker(BankCode.HANA, "123456", "뱅커");
    Transaction transaction = new Transaction(type, status, money, customer, banker);
    Transaction.update(transaction);
  }

  @Override
  public String toString() {
    return "Account{" +
        "customer=" + customer +
        ", accountNumber='" + accountNumber + '\'' +
        ", accountOpenDate=" + accountOpenDate +
        ", accountColoseDate=" + accountColoseDate +
        ", isDormantt=" + isDormantt +
        ", password='" + password + '\'' +
        ", balance=" + balance +
        '}';
  }
}
