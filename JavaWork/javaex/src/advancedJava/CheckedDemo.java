package advancedJava;

public class CheckedDemo {
  public static void main(String[] args) {
    try {
      Thread.sleep(100);
      System.out.println("0.1 초동안 아무일도 일어나지 않음");
    } catch (InterruptedException e) {
      //throw new RuntimeException(e);
      System.out.println("예외가 발생했습니다.");
    }
  }
}
