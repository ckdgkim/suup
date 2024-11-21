package basic;

public class MethodDemo3 {
  public static void main(String[] args) {
    // method의 이름은 add , 매개변수는 2개이고 데이터타입은 int
    // 2개의 숫자를 더해서 그 결과를 반환하는 메서드를 만들어라.
    // 메서드의 반환타입은 int
    // add(2,3) 출력 ; add(10,20) 출력; add(100,200) 출력
    //----------------
    // method의 이름은 divide , 매개변수는 2개이고 데이터타입은 int
    // 첫번째 매개변수를 두번째 매개변수로 나눈 몫을 구해서 그 결과를 반환하는 메서드를 만들어라.
    // 메서드의 반환타입은 int
    // divide(2,3) 출력 ; divide(20,10) 출력; divide(200,100) 출력
    // 단,.................주의사항 !!!!!
    //----------
    // method의 이름은 minus , 매개변수는 2개이고 데이터타입은 int
    // 첫번째 매개변수에서 두번째 매개변수를 빼서 그 결과를 반환하는 메서드를 만들어라.
    // 메서드의 반환타입은 int
    // minus(2,3) 출력 ; minus(20,10) 출력; minus(200,100) 출력
    //------------
    // method의 이름은 multiply , 매개변수는 2개이고 데이터타입은 int
    // 첫번째 매개변수와 두번째 매개변수를 곱해서 그 결과를 반환하는 메서드를 만들어라.
    // 메서드의 반환타입은 int
    // multiply(2,3) 출력 ; multiply(20,10) 출력; multiply(200,100) 출력
    int a = 2, b = 10;
    System.out.println(add(a,b));
    System.out.println(minus(a,b));
    System.out.println(multiply(a,b));
    System.out.println(divide(a,b));
  }

  public static int add(int num1, int num2) {
    return num1 + num2;
  }

  public static int minus(int num1, int num2) {
    return num1 - num2;
  }

  public static int multiply(int num1, int num2) {
    return num1 * num2;
  }

  public static int divide(int num1, int num2) {
    if(num2 == 0) return 0;
    return num1 / num2;
  }
}
