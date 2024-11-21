package basic;

public class SumDemo {
  public static void main(String[] args) {
    // 1부터 10까지의 합을 구하라.
    int sum = 0;
    for(int i = 1;i <= 10;i++) {
      sum = sum + i; // 반복되는 부분은 그대로 두고, 변하는 부분만 변수로 치환
    }
    System.out.println("1부터 10까지의 합은 "+ sum);

    sum = 0;
    for(int i = 10;i <= 100;i++) {
      sum = sum + i; // 반복되는 부분은 그대로 두고, 변하는 부분만 변수로 치환
    }
    System.out.println("10부터 100까지의 합은 "+ sum);

    sum = 0;
    for(int i = 100;i <= 1000;i++) {
      sum = sum + i; // 반복되는 부분은 그대로 두고, 변하는 부분만 변수로 치환
    }
    System.out.println("100부터 1000까지의 합은 "+ sum);
  }
}
