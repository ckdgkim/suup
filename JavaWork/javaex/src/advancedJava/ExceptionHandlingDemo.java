package advancedJava;

import java.io.IOException;

public class ExceptionHandlingDemo {
  public static void main(String[] args) throws IllegalArgumentException {
    try {
      method1();
    } catch (IOException e) {
      System.out.println("예외가 발생했습니다.");
    } finally {
      System.out.println("프로그램 종료");
    }
  }

  public static void method1() throws IllegalArgumentException, IOException{
    //throw new IllegalArgumentException();
    //throw new IOException();
  }
}
