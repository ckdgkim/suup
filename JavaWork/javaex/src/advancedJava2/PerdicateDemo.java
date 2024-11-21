package advancedJava2;

import java.util.function.BiPredicate;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class PerdicateDemo {
  public static void main(String[] args) {
    IntPredicate even = i -> i % 2 == 0 ;
    System.out.println(even.test(3));
    System.out.println(even.test(4));
//        new IntPredicate() {
//      @Override
//      public boolean test(int value) {
//        return value % 2 == 0 ;
//      }
//    };

    BiPredicate<Integer, Integer> bi = (i,j) -> i == j ;
    System.out.println(bi.test(2,2));
    System.out.println(bi.test(2,4));
//        new BiPredicate<Integer, Integer>() {
//      @Override
//      public boolean test(Integer integer, Integer integer2) {
//        return false;
//      }
//    };

    Predicate<Integer> positive = i -> i > 0 ;
    System.out.println(positive.test(-10));
    System.out.println(positive.test(2));
//        new Predicate<Integer>() {
//      @Override
//      public boolean test(Integer integer) {
//        return false;
//      }
//    }
  }
}
