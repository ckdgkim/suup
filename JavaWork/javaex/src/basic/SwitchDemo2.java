package basic;

import java.util.Scanner;

public class SwitchDemo2 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("요일을 입력하세요 (Mon,Tue,Wed,Thu,Fri,Sat,Sun) : ");
    String day = in.nextLine();
    switch (day) {
      case "Mon" :
      case "Tue" :
      case "Wed" :
      case "Thu" :
      case "Fri" :
        System.out.println("평일입니다.");
        break;
      case "Sat" :
      case "Sun" :
        System.out.println("주말입니다.");
        break;
      default :
        System.out.println("알수 없는 문자가 입력되었습니다.");
    }
  }
}
