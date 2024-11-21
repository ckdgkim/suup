package basic;

public class IncrementDemo {
  public static void main(String[] args) {
    int x = 0;
    System.out.println("increment 메소드 호출 전 x = " + x);
    increment(x);
    System.out.println("increment 메소드 호출 후 x = " + x);
  }

  public static void increment(int n) {
    System.out.println("increment 메소드 시작 n = " + n);
    n++;
    System.out.println("increment 메소드 종료 n = " + n);
  }
}
