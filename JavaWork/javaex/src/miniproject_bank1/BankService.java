package miniproject_bank1;

import java.util.Scanner;
import java.util.StringTokenizer;

public class BankService {
  private final Bank bank;
  private final Banker banker = new Banker(BankCode.KAKAKO, "employee");
  // 직원을 연결하는 코드 구현

  public BankService(Bank bank) {
    this.bank = bank;
  }

  public void register(Scanner sc) {
    System.out.println("생년월일 8자리, 성함을 ,로 구분해 입력해주세요.");
    StringTokenizer st = new StringTokenizer(sc.nextLine(), ", ");
    Customer customer = new Customer(st.nextToken(), st.nextToken());
    bank.addCustomers(customer);

    System.out.println("고객 등록이 완료되었습니다.");
  }

  public void depositMoney(Scanner sc) {
    System.out.println("계좌번호, 생년월일 8자리를 ,로 구분해 입력해주세요.");
    StringTokenizer st = new StringTokenizer(sc.nextLine(), ", ");
    Input newInput = new Input(st.nextToken(), st.nextToken());
    long money = Long.parseLong(sc.nextLine());

    // 현금 입금,인출의 경우 10으로 나눠떨어지는 수만 받게 조건걸어야 함
    // 전자거래의 경우 1원 단위 거래가 가능하므로 따로 조건 걸지 않음
    if (money < 0) {
      System.out.println("입금 금액이 잘못 입력되었습니다.");
      return;
    }
    BankStatementE bs = new BankStatementE(null, BankStatement.입금, banker);;

    try {
      Account account = bank.getAccount(newInput.getAccountNumber());
      account.deposit(money, newInput);
      bs.setAccount(account);
      bank.addStatement(bs.Success());
    } catch (Exception e) {
      System.out.println("계좌정보가 잘못되었습니다. 다시 입력해주세요.");
      bank.addStatement(bs.Error());
    }

  }

  public void withdrawMoney(Scanner sc) {
    System.out.println("계좌번호, 생년월일 8자리, 비밀번호를 ,로 구분해 입력해주세요.");
    StringTokenizer st = new StringTokenizer(sc.nextLine(), ", ");
    Input newInput = new Input(st.nextToken(), st.nextToken(), st.nextToken());
    long money = Long.parseLong(sc.nextLine());

    // 현금 입금,인출의 경우 10으로 나눠떨어지는 수만 받게 조건걸어야 함
    // 전자거래의 경우 1원 단위 거래가 가능하므로 따로 조건 걸지 않음
    if (money < 0) {
      System.out.println("출금 금액이 잘못 입력되었습니다.");
      return;
    }
    BankStatementE bs = new BankStatementE(null, BankStatement.출금, banker);;

    try {
      Account account = bank.getAccount(newInput.getAccountNumber());
      bs.setAccount(account);
      if (account.withdraw(money, newInput)) {
        bank.addStatement(bs.Success());
      } else {
       bank.addStatement(bs.Error());
      }
    } catch (Exception e) {
      System.out.println("계좌정보가 잘못되었습니다. 다시 입력해주세요.");
      bank.addStatement(bs.Error());
    }
  }

  public void inquiryAccount(Scanner sc) {
    System.out.println("계좌번호, 생년월일 8자리, 비밀번호를 ,로 구분해 입력해주세요.");
    StringTokenizer st = new StringTokenizer(sc.nextLine(), ", ");
    Input newInput = new Input(st.nextToken(), st.nextToken(), st.nextToken());
    Account account;
    BankStatementE bs = new BankStatementE(null, BankStatement.조회, banker);;

    try {
      account = bank.getAccount(newInput.getAccountNumber());
      if (account.checkInput(newInput)) {
        System.out.println(account.toString());
        bs.setAccount(account);
        bank.addStatement(bs.Success());
      } else {
        bank.addStatement(bs.Error());
      }
    } catch (Exception e) {
      bank.addStatement(bs.Error());
    }
  }

  public void createAccount(Scanner sc) {
    System.out.println("생년월일 8자리, 비밀번호를 ,로 구문해 입력해주세요.");
    StringTokenizer st = new StringTokenizer(sc.nextLine(), ", ");
    Customer c = bank.getCustomers(st.nextToken());
    String password = st.nextToken();
    BankStatementE bs = new BankStatementE(null, BankStatement.생성, banker);;

    try {
      Account newAccount = c.creatAccount(bank, password);
      bank.addAccounts(newAccount.getAccountNumber(), newAccount);
      System.out.println("새로운 계좌를 생성하였습니다. 계좌번호는 " + newAccount.getAccountNumber() + "입니다.");
      bs.setAccount(newAccount);
      bank.addStatement(bs.Success());
    } catch (Exception e) {
      System.out.println("계좌 생성에 실패하였습니다.");
      bank.addStatement(bs.Error());
    }
  }

  public void closeAccount(Scanner sc) {
    System.out.println("계좌번호, 생년월일 8자리, 비밀번호를 ,로 구분해 입력해주세요.");
    StringTokenizer st = new StringTokenizer(sc.nextLine(), ", ");
    Input newInput = new Input(st.nextToken(), st.nextToken(), st.nextToken());
    BankStatementE bs = new BankStatementE(null, BankStatement.삭제, banker);;

    try {
      Account account = bank.getAccount(newInput.getAccountNumber());
      bs.setAccount(account);
      if (account.closeAccount(newInput)) {
        System.out.println("계좌가 해지되었습니다.");
        bank.addStatement(bs.Success());
      } else {
        System.out.println("정보를 잘못 입력하였습니다. 확인해주세요.");
        bank.addStatement(bs.Error());
      }
    } catch (Exception e) {
      System.out.println("계좌 정보가 잘못되었습니다. 다시 입력해주세요.");
      bank.addStatement(bs.Success());
    }
  }
}
