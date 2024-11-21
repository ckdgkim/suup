package objectpackage;

import java.util.Scanner;

public class StringEx3 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String s = "";
    while (true) {
      //String s = "www.Java.Com";
      System.out.println("URL 을 입력하세요 : ");
      s = in.nextLine();
      String sLow = s.toLowerCase();
      // bye 와 같으면
      if(sLow.equals("bye")) break;
      if(sLow.contains("java")) {
        System.out.println("java 를 포함합니다.");
      };
      if(sLow.endsWith("com")) {
        System.out.println("com 으로 끝납니다.");
      };
    }
  }
}
