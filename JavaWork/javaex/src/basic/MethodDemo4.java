package basic;

public class MethodDemo4 {
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
    int a = 1_000_000, b = 2_000_000;
    long long1 = 1_000_000_000_000L, long2 = 2_000_000_000_000L;
    System.out.println(longAdd(long1,long2));
    System.out.println(longMinus(long1,long2));

    System.out.println(add(a,b));
    System.out.println(minus(a,b));
    System.out.println(multiply(a,b));
    System.out.println(longMultiply(a,b));
    System.out.println(divide(a,b));
    System.out.printf("%.4f \n" ,doubleDivide(a,b));
  }

  public static int add(int num1, int num2) {
    return num1 + num2;
  }

  public static long longAdd(long num1, long num2) {
    return num1 + num2;
  }

  public static int minus(int num1, int num2) {
    return num1 - num2;
  }

  public static long longMinus(long num1, long num2) {
    return num1 - num2;
  }

  public static int multiply(int num1, int num2) {
    return num1 * num2;
  }

  public static long longMultiply(int num1, int num2) {
    return (long)num1 * num2;
  }

  public static int divide(int num1, int num2) {
    if(num2 == 0) return 0;
    return num1 / num2;
  }

  public static double doubleDivide(int num1, int num2) {
    if(num2 == 0) return 0;
    return (double)num1 / num2;
  }
}
