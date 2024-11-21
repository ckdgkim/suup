package basic;

public class RecursiveCallDemo {
  // 재귀적으로 팩토리얼을 계산하는 메소드
  public static int factorial(int n) {
    // 기본 조건: n이 1 이하이면 1을 반환, 이 조건을
    if (n <= 1) {
      return 1;
    }
    // 재귀 호출: n * factorial(n - 1)
    return n * factorial(n - 1);
  }

  public static void main(String[] args) {
    int number = 5; // 예시로 5의 팩토리얼을 계산
    int result = factorial(number);
    System.out.println(number + "! = " + result);
  }
}
