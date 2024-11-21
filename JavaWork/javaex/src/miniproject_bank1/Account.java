package miniproject_bank1;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

class Account {
  public static Random rand = new Random();

  private String customerId;
  private BankCode bankCode;
  private String accountNumber;
  private String password;

  public String getCustomerId() {
    return customerId;
  }

  public String getPassword() {
    return password;
  }

  public AccountStatus getStatus() {
    return status;
  }

  long balance;

  private LocalDateTime openingDate;



  private LocalDateTime closingDate;
  private AccountStatus status = AccountStatus.정상;

  public Account(Customer customer, Bank bank, String password) {
    this.customerId = customer.customerId;
    this.bankCode = bank.getBankCode();
    this.password = password;
    this.openingDate = LocalDateTime.now();
    setAccountNumber(bank);
    // 중복 계좌 여부 확인 해야함
    balance = 0L;
  }

  public void getBalance(Input input) {
    if (!checkInputP(input)) return;
    if (!checkStatus()) return;

    System.out.println("현재 잔액은 " + balance + "원 입니다.");
  }


  public void deposit(long balance, Input input) {
    if (!checkInput(input)) return;
    if (!checkStatus()) return;

    this.balance += balance;
    System.out.println("거래 후 잔액은 " + this.balance + "원 입니다.");
  }

  public boolean withdraw(long balance, Input input) {
    if (!checkInputP(input)) return false;
    if (!checkStatus()) return false;

    if (balance > this.balance) {
      System.out.println("잔액보다 출금액이 큽니다. 현재 잔액은 " + this.balance + "입니다.");
      return false;
    } else {
      this.balance -= balance;
      System.out.println("거래 후 잔액은 " + this.balance + "원 입니다.");
      return true;
    }
  }

  public boolean checkStatus() {
    if (status.equals(AccountStatus.휴면)) {
      System.out.println("해당 계좌는 현재 휴면 상태입니다."); // 휴면상태 자동 해지할지 아니면 해지 메서드를 만들지 고민
      return false;
    } else if (status.equals(AccountStatus.해지)) {
      System.out.println("해당 계좌는 해지되었습니다.");
      return false;
    } else {
      return true;
    }
  }

  public boolean checkInput(Input input) {
    boolean result = false;
    if (!input.getAccountNumber().equals(this.accountNumber)) {
      System.out.println("계좌번호가 일치하지 않습니다. 계좌번호를 확인해주세요.");
    } else if (!input.getCustomerId().equals(this.customerId)) {
      System.out.println("고객정보가 일치하지 않습니다. 비밀번호를 확인해주세요.");
    } else {
      result = true;
    }
    return result;
  }

  public boolean checkInputP(Input input) {
    boolean result = false;
    if (!input.getAccountNumber().equals(this.accountNumber)) {
      System.out.println("계좌번호가 일치하지 않습니다. 계좌번호를 확인해주세요.");
    } else if (!input.getPassword().equals(this.password)) {
      System.out.println("비밀번호가 일치하지 않습니다. 비밀번호를 확인해주세요.");
    } else if (!input.getCustomerId().equals(this.customerId)) {
      System.out.println("고객정보가 일치하지 않습니다. 비밀번호를 확인해주세요.");
    } else {
      result = true;
    }
    return result;
  }

  public boolean closeAccount(Input input) {
    if (!checkInputP(input)) return false;
    if (balance != 0) {
      System.out.println("잔액 " + balance + "원을 출금한 뒤 계좌 삭제됩니다.");
      balance = 0;
    }
    closingDate = LocalDateTime.now();
    status = AccountStatus.해지;
    return true;
  }

  public void setPassword(Input input, String newPassword) {
    if (!checkInput(input)) return;
    this.password = newPassword;
  }

  public String getAccountNumber() {
    return this.accountNumber;
  }

  private String setAccountNumber(Bank bank) {
    ArrayList<String> accountList = bank.getAccountsAll();
    String newNumber = String.valueOf(Account.rand.nextInt(10000));
    newNumber = String.format("%-5s", newNumber).replace(" ", "0");
    while (accountList.contains(newNumber)) {
      newNumber = String.valueOf(Account.rand.nextInt(10000));
      newNumber = String.format("%-5s", newNumber).replace(" ", "0");
    }
    this.accountNumber = newNumber;
    return newNumber;
  }

  @Override
  public String toString() {
    return "Account[" +
        "customerId='" + customerId + '\'' +
        ", bankCodeEnum=" + bankCode +
        ", accountNumber='" + accountNumber + '\'' +
        ", balance=" + balance +
        ", openingDate=" + openingDate +
        ", closingDate=" + closingDate +
        ", status=" + status +
        ']';
  }
}
