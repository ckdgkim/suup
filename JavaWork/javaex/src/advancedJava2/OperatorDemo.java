package advancedJava2;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class OperatorDemo {
  public static void main(String[] args) {
    UnaryOperator<String> addStrings = s -> s + "!!!";
//        new UnaryOperator<String>() {
//      @Override
//      public String apply(String s) {
//        return s + "!!!";
//      }
//    };

    System.out.println(addStrings.apply("hello"));

    BinaryOperator<String> concat = (s1, s2) -> s1 + "," + s2 ;
//        new BinaryOperator<String>() {
//      @Override
//      public String apply(String s1, String s2) {
//        return s1 + ","+ s2 ;
//      }
//    };
    System.out.println(concat.apply("hello","world"));
  }
}
