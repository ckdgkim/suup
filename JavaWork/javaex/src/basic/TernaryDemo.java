package basic;

import java.util.Scanner;

public class TernaryDemo {
  public static void main(String[] args) {
    // x 값을 입력받는다. x 가 0보다 크거나 같으면 양수입니다.
    // 0 보다 작으면 음수입니다. 출력하도록 조건연산자를 이용해서 작성하시오.
    Scanner in = new Scanner(System.in);
    System.out.println("정수형 숫자를 입력하세요(양수,0,음수 관계 없음) : ");
    int i = in.nextInt();
    String result = "";
//    if (i >= 0) {
//      result = "양수";
//    } else {
//      result = "음수";
//    }
    result = (i >= 0) ? "양수" : "음수" ;
    System.out.printf("입력한 숫자는 %d 이며, %s 입니다", i, result);
  }
}
