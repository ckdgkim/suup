package basic;

public class MethodDemo2 {
  public static void main(String[] args) {
    // 매개변수는 있고, 반환값은 없는 메소드로 작성하세요.
    oddOrEven(2); // 2는 짝수입니다
    oddOrEven(5); // 5는 홀수입니다
    oddOrEven(10); // 10은 짝수입니다
//    int num = 2;
//    String result = "";
//    result = (num % 2 == 0) ? "짝수" : "홀수" ;
//    System.out.printf("%d 은 %s 입니다.\n", num, result);
//
//    num = 5;
//    result = "";
//    result = (num % 2 == 0) ? "짝수" : "홀수" ;
//    System.out.printf("%d 은 %s 입니다.\n", num, result);
//
//    num = 10;
//    result = "";
//    result = (num % 2 == 0) ? "짝수" : "홀수" ;
//    System.out.printf("%d 은 %s 입니다.\n", num, result);
  }

  public static void oddOrEven(int num) {
    String result = "";
    result = (num % 2 == 0) ? "짝수" : "홀수" ;
    System.out.printf("%d 은 %s 입니다.\n", num, result);
  }
}
