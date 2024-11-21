package basic;

public class OverloadDemo {
  public static void main(String[] args) {
    // method의 이름은 longAdd , 매개변수는 2개이고 데이터타입은 long
    // 2개의 숫자를 더해서 그 결과를 반환하는 메서드를 만들어라.
    // 메서드의 반환타입은 long
    //----------------
    // method의 이름은 doubleDivide , 매개변수는 2개이고 데이터타입은 int
    // 첫번째 매개변수를 두번째 매개변수로 나눈 몫을 구해서 그 결과를 반환하는 메서드를 만들어라.
    // 메서드의 반환타입은 double (출력시에 소숫점 4째자리까지 해달라)
    // divide(2,3) 출력 ; ==> 0.6666
    // 단,주의사항 !!!!! , 0 으로 나누어지지 않도록 주의
    //----------
    // method의 이름은 longMinus , 매개변수는 2개이고 데이터타입은 long
    // 첫번째 매개변수에서 두번째 매개변수를 빼서 그 결과를 반환하는 메서드를 만들어라.
    // 메서드의 반환타입은 long
    //------------
    // method의 이름은 longMultiply , 매개변수는 2개이고 데이터타입은 int
    // 첫번째 매개변수와 두번째 매개변수를 곱해서 그 결과를 반환하는 메서드를 만들어라.
    // 메서드의 반환타입은 long
    // multiply(2_000_000,1_000_000) 출력 ; ==-> 2조
    int a = 1, b = 2;
    long long1 = 1L, long2 = 2L;
    double da = 1.0, db = 2.0;
    System.out.println(add(long1,long2));
    System.out.println(minus(long1,long2));

    System.out.println(add(a,b));
    System.out.println(minus(a,b));
    System.out.println(multiply(a,b));
    System.out.println(multiply(long1,long2));
    System.out.println(divide(a,b));
    System.out.printf("%.4f \n" ,divide(da,db));
  }

  public static int add(int num1, int num2) {
    return num1 + num2;
  }

  public static long add(long num1, long num2) {
    return num1 + num2;
  }

  public static int minus(int num1, int num2) {
    return num1 - num2;
  }

  public static long minus(long num1, long num2) {
    return num1 - num2;
  }

  public static int multiply(int num1, int num2) {
    return num1 * num2;
  }

  public static long multiply(long num1, long num2) {
    return num1 * num2;
  }

  public static int divide(int num1, int num2) {
    if(num2 == 0) return 0;
    return num1 / num2;
  }

  public static double divide(double num1, double num2) {
    if(num2 == 0) return 0;
    return num1 / num2;
  }
}
