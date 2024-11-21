package advancedJava2;

import java.util.Arrays;
import java.util.Comparator;

public class LambdaDemo3 {
  public static void main(String[] args) {
    String[] strings = {"abcde", "a", "abc"};

    Arrays.sort(strings,
                (o1, o2) -> o2.length() - o1.length());
    for (String string : strings) {
      System.out.println(string);
    }

  }
}
