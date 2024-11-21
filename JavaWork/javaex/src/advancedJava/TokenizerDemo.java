package advancedJava;

import java.util.StringTokenizer;

public class TokenizerDemo {
  public static void main(String[] args) {
    String s = "of the people, by the people, for the people";

    StringTokenizer st = new StringTokenizer(s, " ,");
    while(st.hasMoreElements()) {
      System.out.println(st.nextElement());
    }
  }
}
