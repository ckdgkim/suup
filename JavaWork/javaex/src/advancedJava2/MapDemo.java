package advancedJava2;

import java.util.stream.Stream;

public class MapDemo {
  public static void main(String[] args) {
    Stream<String> s1 = Stream.of("a1", "b1", "c1", "b2", "c2");
    s1.map(String::toUpperCase)
        .forEach(System.out::println);

    Stream<Integer> i1 = Stream.of(1,2,1,3,3,2,4);
    i1.map(i -> i * 2)
        .forEach(System.out::println);

    Stream<String> s2 = Stream.of("a1", "a2", "a3");
    s2.map(s -> s.substring(1))
        .mapToInt(Integer::parseInt)
        .mapToObj(i -> "b" + i)
        .forEach(Util::printWithParenthesis);


  }
}
