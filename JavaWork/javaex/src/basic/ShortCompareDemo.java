package basic;

public class ShortCompareDemo {
  public static void main(String[] args) {
    String s1 = new String("Hello");
    String s2 = new String("Hello");

    s2 = s1 ;

    if (s1 != null && s1.equals(s2)) {
      System.out.println("문자열의 내용이 동일합니다.");
    }

    System.out.println("두 문자열이 똑같은가 ? " + (s1 == s2));

  }
}
