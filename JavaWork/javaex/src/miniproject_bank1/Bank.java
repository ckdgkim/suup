package miniproject_bank1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Bank {
  private BankCode bankCode;
  private Map<String, Account> accounts; // accountNumber, account
  private Map<String, Customer> customers; // customerId, customer
  private Map<Long, BankStatementE> statementL; // statement seqno, statement

  public Bank(BankCode bankCode) {
    this.bankCode = bankCode;
    accounts = new HashMap<>();
    customers = new HashMap<>();
    statementL = new HashMap<>();
  }

  public void addStatement(BankStatementE bankStatement) {
    this.statementL.put(bankStatement.getSeqno(), bankStatement);
  }
  public BankCode getBankCode() {
    return bankCode;
  }

  public Account getAccount(String accountNumber) {
    try {
      Account account = accounts.get(accountNumber);
      return account;
    } catch (NullPointerException e) {
      System.out.println("해당하는 계좌가 없습니다.");
      return null;
    }
  }

  public Map<Long, BankStatementE> getStatementL() {
    return this.statementL;
  }

  public ArrayList<String> getAccountsAll() {
    return new ArrayList<>(accounts.keySet());
  }

  public void addAccounts(String accountNumber, Account account) {
    this.accounts.put(account.getAccountNumber(), account);
  }

  public Customer getCustomers(String customerId) {
    return customers.get(customerId);
  }

  public void addCustomers(Customer customer) {
    this.customers.put(customer.customerId, customer);
  }
}
