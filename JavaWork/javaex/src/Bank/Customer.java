package Bank;

import java.time.LocalDate;

public class Customer {
  BankCode bankCode;
  String sequenceno;
  String customerNum;
  String customerName;
  LocalDate firstTransactionDate;
  LocalDate lastTransactionDate;

  public Customer(BankCode bankCode, String sequenceno, String customerNum, String customerName, LocalDate firstTransactionDate) {
    this.bankCode = bankCode;
    this.sequenceno = sequenceno;
    this.customerNum = customerNum;
    this.customerName = customerName;
    this.firstTransactionDate = firstTransactionDate;
    this.lastTransactionDate = firstTransactionDate;
  }

  public void updateLastTransactionDate() {
    this.lastTransactionDate = LocalDate.now();
  }
}
