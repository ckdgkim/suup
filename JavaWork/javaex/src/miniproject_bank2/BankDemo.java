package miniproject_bank2;

import miniproject_bank2.Enum.BankCode;
import miniproject_bank2.Enum.TransactionStatus;
import miniproject_bank2.Enum.TransactionType;

import java.util.Scanner;

public class BankDemo {

  static Scanner in = new Scanner(System.in);

  public static void main(String[] args) {
    out: while (true) {
      System.out.println("1 계좌 생성 / 2 입금 / 3 출금 / 4 잔액 조회 / 5 계좌 삭제 / 6 종료");

      int option = in.nextInt();
      in.nextLine();

      switch (option) {
        case 1:
          createAccount();
          break;
        case 2:
          deposit();
          break;
        case 3:
          withdraw();
          break;
        case 4:
          balanceInquiry();
          break;
        case 5:
          deleteAccount();
          break;
        case 6:
          break out;
        default:
          System.out.println("1번부터 6번까지 입력해 주세요");
          break;
      }
    }
  }

  public static void createAccount() {
    // 고객 생성
    Customer customer = new Customer(BankCode.HANA);

    boolean valid = false;
    String number = null;

    while (!valid) {
      System.out.println("주민번호 앞자리 6자리 입력");
      number = in.nextLine();

      if (number.length() == 6) {
        if (number.matches("\\d+")) {
          customer.customerNumber = number;
          valid = true;
        } else {
          System.out.println("숫자만 입력해 주세요.");
        }
      } else {
        System.out.println("6자리 숫자를 입력해 주세요.");
      }
    }

    System.out.println("이름 입력");
    String name = in.nextLine();
    customer.name = name;

    Customer.customerMap.put(number, customer);
    System.out.println(Customer.customerMap.get(number).toString());

    // 계좌 생성
    int count = Account.accountMap.size() + 1;

    Account account = new Account(customer, count);

    valid = false;
    String password = null;

    while (!valid) {
      System.out.println("비밀번호 4자리 입력");
      password = in.nextLine();

      if (password.length() == 4) {
        if (password.matches("\\d+")) {
          account.password = password;
          valid = true;
        } else {
          System.out.println("숫자만 입력해 주세요.");
        }
      } else {
        System.out.println("4자리 숫자를 입력해 주세요.");
      }
    }

    Account.accountMap.put(account.accountNumber, account);
    System.out.println(Account.accountMap.get(account.accountNumber).toString());

    // 내역 업데이트
    Account.updateTransaction(TransactionType.CREATE, TransactionStatus.NORMAL, 0, account.customer);
  }

  public static void deposit() {
    System.out.println("계좌 번호 입력");
    String accountNumber = in.nextLine();

    System.out.println("비밀번호 입력");
    String password = in.nextLine();

    long money = inputMoney();

    // 계좌 정보 업데이트
    Account account = Account.accountInquiry(accountNumber, password);
    long deposit = Account.deposit(account, money);

    String message = (account == null) ? " " : "입금 후 잔액" + deposit + "원";
    System.out.println(message);
  }

  public static void withdraw() {
    System.out.println("계좌 번호 입력");
    String accountNumber = in.nextLine();

    System.out.println("비밀번호 입력");
    String password = in.nextLine();

    long money = inputMoney();

    // 계좌 정보 업데이트
    Account account = Account.accountInquiry(accountNumber, password);
    long withdraw = Account.withdraw(account, money);

    String message = (account == null) || (withdraw == -1) ? " " : "출금 후 잔액" + withdraw + "원";
    System.out.println(message);
  }

  public static void balanceInquiry() {
    System.out.println("계좌 번호 입력");
    String accountNumber = in.nextLine();

    System.out.println("비밀번호 입력");
    String password = in.nextLine();

    // 계좌 정보 업데이트
    Account account = Account.accountInquiry(accountNumber, password);
    long balance = Account.balanceInquiry(account, password);

    String message = (account == null) ? " " : "잔액" + balance + "원";
    System.out.println(message);
  }

  public static void deleteAccount() {
    System.out.println("계좌 번호 입력");
    String accountNumber = in.nextLine();

    System.out.println("비밀번호 입력");
    String password = in.nextLine();

    // 계좌 정보 업데이트
    Account account = Account.accountInquiry(accountNumber, password);
    Account.deleteAccount(account);
  }

  public static long inputMoney() {
    boolean valid = false;
    long money = 0;

    while (!valid) {
      System.out.println("입금 금액 입력");
      money = (long) in.nextInt();

      if (money >= 0) {
        valid = true;
      } else {
        System.out.println("0보다 큰 숫자를 입력해 주세요");
      }
    }

    return money;
  }
}
