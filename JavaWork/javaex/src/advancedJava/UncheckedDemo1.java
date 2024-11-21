package advancedJava;

import java.util.StringTokenizer;

public class UncheckedDemo1 {
  public static void main(String[] args) {
    String s = "time is money";
    StringTokenizer st = new StringTokenizer(s);

    while(st.hasMoreElements()) {
      System.out.println(st.nextElement());
    }

    st = new StringTokenizer(s);
    System.out.println(st.nextElement());

  }
}
