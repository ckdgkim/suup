package advancedJava2;

import java.util.Comparator;
import java.util.stream.Stream;

public class FilterDemo {
  public static void main(String[] args) {
    Stream<String> s = Stream.of("a1","a2","b1","c1","c2","c3");
    s.filter(x -> x.startsWith("c"))
        .skip(2)
        .forEach(System.out::println);

    Stream<Integer> iStream = Stream.of(1,2,1,3,3,2,4);
    iStream.filter(i -> i % 2 == 1)
        .distinct()
        .forEach(System.out::println);
    // 인구가 1억이 넘는 국가 중에서, 인구가 큰 순서대로 , 2개만 출력하시오.
    System.out.println("인구가 1억이 넘는 국가 중에서, 인구수가 많은 2개의 나라 : ");
    Stream<Nation> nations = Nation.nations.stream();
    nations.filter(n -> n.getPopulation() > 100)
        .sorted(Comparator.comparing(Nation::getPopulation).reversed())
        .limit(2)
        .forEach(System.out::println);

  }
}
