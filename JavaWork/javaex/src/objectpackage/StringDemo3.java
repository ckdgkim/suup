package objectpackage;

public class StringDemo3 {
  public static void main(String[] args) {
    String s1 = "Hello";
    String s2 = ", java";

    s1 = "hello";

    System.out.println("s1의 길이는 " + s1.length());
    String concat = s1.concat(s2);

    System.out.println(s1.toUpperCase());
    System.out.println(s1);

    System.out.println(s2.substring(2));
    System.out.println(s2.substring(2,4));

    System.out.println(String.valueOf(10).equals("10"));
    String s4 = """
        hello,
                        java
        12345
        """;
    System.out.println(s4);

    """
        aaabbb""".length();
    "aaa".length();
  }
}
