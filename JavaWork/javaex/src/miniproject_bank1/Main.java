package miniproject_bank1;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Bank bank = new Bank(BankCode.KAKAKO);
    int input;
    boolean run = true;

    BankService bankService = new BankService(bank);

    while (run) {
      System.out.println("\n====" +
          "업무를 선택해주세요.====\n" +
          "0. 고객등록\n" +
          "1. 입금\n" +
          "2. 출금\n" +
          "3. 조회\n" +
          "4. 계좌개설\n" +
          "5. 계좌폐쇄\n" +
          "6. 프로그램 종료\n");

      try {
        input = Integer.parseInt(sc.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("정확한　값을　입력해주세요.");
        continue;
      }

      switch (input) {
        case 0:
          bankService.register(sc);
          continue;
        case 1:
          bankService.depositMoney(sc);
          continue;
        case 2:
          bankService.withdrawMoney(sc);
          continue;
        case 3:
          bankService.inquiryAccount(sc);
          continue;
        case 4:
          bankService.createAccount(sc);
          continue;
        case 5:
          bankService.closeAccount(sc);
          continue;
        default:
          System.out.println("시스템을 종료합니다.");
          run = false;
          break;
      }
    }

    for (Long seq : bank.getStatementL().keySet()) {
      System.out.println(seq + " : " + bank.getStatementL().get(seq));
    }
  }
}

