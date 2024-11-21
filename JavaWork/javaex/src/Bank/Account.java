package Bank;

import java.time.LocalDate;

public class Account {
  BankCode bankCode;
  String accountNum;
  Customer customer;
  LocalDate openDate;
  LocalDate closeDate;
  boolean DormantAccount;
  String password;
  int balance;

  public Account(BankCode bankCode, String accountNumber, Customer customer, LocalDate openDate, String password){
    this.bankCode = bankCode;
    this.accountNum = accountNumber;
    this.customer = customer;
    this.openDate = openDate;
    this.password = password;
    this.balance = 0;
    this.DormantAccount = false;
  }

  public BankCode getBankCode() {
    return bankCode;
  }

  public String getAccountNum() {
    return accountNum;
  }

  public Customer getCustomer() {
    return customer;
  }

  public LocalDate getOpenDate() {
    return openDate;
  }

  public LocalDate getCloseDate() {
    return closeDate;
  }

  public boolean isDormantAccount() {
    return DormantAccount;
  }

  public int getBalance() {
    return balance;
  }

  public void deposit(double amount){
    this.balance += amount;
  }
  public boolean withdraw(double amount){
    if (balance >= amount){
      balance -= amount;
      return true;
    } else {
      return false;
    }
  }

  public void closeAccount(){
    this.closeDate = LocalDate.now();
    this.DormantAccount = true;
  }

  public boolean passwordCheck(String password){
    return this.password.equals(password);
  }
}
