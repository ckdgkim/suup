package Bank;

public class BankTeller {
  BankCode bankCode;
  String employeeNum;
  String employeeName;

  public BankTeller(BankCode bankCode, String employeeNum, String employeeName) {
    this.bankCode = bankCode;
    this.employeeNum = employeeNum;
    this.employeeName = employeeName;
  }
}
