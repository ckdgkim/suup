package advancedJava2;

import java.util.function.Consumer;
import java.util.function.ObjIntConsumer;

public class ConsumerDemo {
  public static void main(String[] args) {
    Consumer<String> printX = System.out::println;
//  1.      new Consumer<String>() {
//      @Override
//      public void accept(String s) {
//        System.out.println(s);
//      }
//    };
    //2. s -> System.out.println(s);
    printX.accept("hello world");

    ObjIntConsumer<String> printITimes = (s, x) -> {
      for (int i = 0; i < x ; i++) {
        System.out.println(s);
      };
    };

//        new ObjIntConsumer<String>() {
//      @Override
//      public void accept(String s, int value) {
//        for (int i = 0; i < value ; i++) {
//          System.out.println(s);
//        }
//      }
//    };
    printITimes.accept("hello",3);
  }
}
