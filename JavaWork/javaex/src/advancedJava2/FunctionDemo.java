package advancedJava2;

import java.util.function.Function;

public class FunctionDemo {
  public static void main(String[] args) {
    Function<String, Integer> lengthCount = s -> s.length();
//        new Function<String, Integer>() {
//      @Override
//      public Integer apply(String s) {
//        return s.length();
//      }
//    };
    System.out.println(lengthCount.apply("hello"));
  }
}
