package advancedJava2;

import java.util.Comparator;
import java.util.stream.Stream;

public class SortedDemo {
  public static void main(String[] args) {
    Stream<String> s1 = Stream.of("d1", "a1", "b1", "c2", "e1");
    s1.sorted()
        .forEach(System.out::println);

    System.out.println("나라이름 순");
    Stream<Nation> n1 = Nation.nations.stream();
     n1.sorted(Comparator.comparing(Nation::getName))
       .forEach(Util::printWithParenthesis);

    System.out.println("\n GDPRank 순");
    Stream<Nation> n2 = Nation.nations.stream();
    n2.sorted(Comparator.comparing(Nation::getGdpRank))
        .map(n -> n.getName())
        .forEach(Util::printWithParenthesis);
  }
}
