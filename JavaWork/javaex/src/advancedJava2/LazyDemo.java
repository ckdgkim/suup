package advancedJava2;

import java.util.stream.IntStream;

public class LazyDemo {
  public static void main(String[] args) {
    IntStream is = IntStream.rangeClosed(1,5);

    is.filter(i -> {
      System.out.println("filter : " + i);
      return i % 2 == 0;
    }).map(i -> {
      System.out.println("map : " + i);
      return i * i;
    }).forEach(System.out::println);
  }
}
