package miniproject_bank1;

import java.time.LocalDateTime;

public class BankStatementE {
  private static long seqno;
  private BankStatement bankStatement;
  private LocalDateTime date;
  private String accountNumber;
  private String customerId;
  private long balance;
  private long employeeNum;
  private ProcessingStatus status;

  public BankStatementE(Account account, BankStatement bankStatement, Banker banker) {
    this.seqno = ++seqno;
    this.bankStatement = bankStatement;
    this.date = LocalDateTime.now();
    this.accountNumber = account == null ? null : account.getAccountNumber();
    this.customerId = account == null? null : account.getCustomerId();
    this.balance = account == null? 0 : account.balance;
    this.employeeNum = banker.getId();
  }

  public BankStatementE Success() {
    this.status = ProcessingStatus.정상;
    return this;
  }

  public BankStatementE Error() {
    this.status = ProcessingStatus.오류;
    return this;
  }

  public void setProcessingStatus(ProcessingStatus status) {
    this.status = status;
  }

  public long getSeqno() {
    return seqno;
  }

  public void setAccount(Account account) {
    this.accountNumber = account.getAccountNumber();
    this.customerId = account.getCustomerId();
    this.balance = account.balance;
  }

  @Override
  public String toString() {
    return "BankStatementE{" +
        "bankStatement=" + bankStatement +
        ", date=" + date +
        ", accountNumber='" + accountNumber + '\'' +
        ", customerId='" + customerId + '\'' +
        ", balance=" + balance +
        ", employeeNum=" + employeeNum +
        ", status=" + status +
        '}';
  }
}
