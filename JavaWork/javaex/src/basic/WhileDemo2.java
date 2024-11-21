package basic;

import java.util.Scanner;

public class WhileDemo2 {
  public static void main(String[] args) {
    // 점수를 입력받아서 해당 점수의 Grade 를 매기는 프로그램
    // 10 ==> "A", 9 ==> "B" , 8 ==> "C", 0 ~ 7 ==> "D"
    Scanner in = new Scanner(System.in);
    while(true) {
      // 여기서부터
      System.out.println("점수를 입력해주세요 ( 1~10 ) ");
      int score = in.nextInt();

      if(score < 0) break;

      String grade = "";
      switch(score) {
        case 10 :
          grade = "A";
          System.out.println(grade);
          break;
        case 9 :
          grade = "B";
          System.out.println(grade);
          break;
        default :
          grade = "C";
          System.out.println(grade);
      }
      // 여기까지를 계속 반복한다.
    }

  }
}
