package miniproject_bank1;

class Input {
  private String accountNumber;
  private String customerId;
  private String password;

  public Input(String accountNumber, String customerId, String password) {
    this.accountNumber = accountNumber;
    this.customerId = customerId;
    this.password = password;
  }

  public Input(String accountNumber, String customerId) {
    this.accountNumber = accountNumber;
    this.customerId = customerId;
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public String getCustomerId() {
    return customerId;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
