package advancedJava;

public class WrapperDemo {
  public static void main(String[] args) {
    //Integer ic = new Integer(10) ;  코드 없어짐(since jdk 9)
    Integer ic = 10; // 자동 박싱
    System.out.print(ic.getClass().getSimpleName());
    System.out.println(ic);
    int i = ic.intValue();
    i = ic; // 자동 언박싱
    System.out.println(i);

    Long lc = 10000000000000L;
    long l = lc;

    Double dc = 20.0;
    double d = dc;
  }
}
