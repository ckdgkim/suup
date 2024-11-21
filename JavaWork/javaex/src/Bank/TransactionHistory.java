package Bank;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TransactionHistory {
  String sequenceNum;
  WorkCode workCode;
  Account account;
  Customer customer;
  int transactionAmount;
  BankTeller bankTeller;
  Status status;
  LocalDate transactonDate;

  public TransactionHistory(String sequenceNum, WorkCode workCode, Account account, Customer customer, int transactionAmount, BankTeller bankTeller, Status status) {
    this.sequenceNum = sequenceNum;
    this.workCode = workCode;
    this.account = account;
    this.customer = customer;
    this.transactionAmount = transactionAmount;
    this.bankTeller = bankTeller;
    this.status = status;
    this.transactonDate = LocalDate.now();
  }
}
