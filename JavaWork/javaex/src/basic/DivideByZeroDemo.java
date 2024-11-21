package basic;

import java.util.Scanner;

public class DivideByZeroDemo {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    Scanner in2 = new Scanner(System.in);
    System.out.println("Scanner 각각 생성 후 비교 " + (in2 == in));
    in2 = in;
    System.out.println("Scanner 주소값 복사 후 비교 " + (in2 == in));

  //  double result = 5 / 0.0 - 2000000000000000000000000000d;
    double result = 5 % 0.0 + 200;
    System.out.printf("5 나머지연산 2.0 는 %.2f 입니다.", result);
//    System.out.println("양수 정수를 입력해주세요 : ");
//    int i = in.nextInt();
//    if(i == 0) {
//      System.out.println("0으로 나눌 수 없습니다.");
//    }
//    if(i > 0) {
//      int result = 5/i;
//      System.out.printf("5 나누기 %d 는 %d 입니다.", i, result);
//    }
  }
}
