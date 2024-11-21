package miniproject_bank1;

public class Banker {
  private static long id;
  private BankCode bankCode;
  private String name;

  public Banker(BankCode bankCode, String name) {
    this.bankCode = bankCode;
    this.id = this.id + 1;
    this.name = name;
  }

  public static long getId() {
    return id;
  }

  public static void setId(long id) {
    Banker.id = id;
  }

  public BankCode getBankCode() {
    return bankCode;
  }

  public void setBankCode(BankCode bankCode) {
    this.bankCode = bankCode;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
