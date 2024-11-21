package advancedJava2;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class FindDemo {
  public static void main(String[] args) {
    Stream<Nation> stream = Nation.nations.stream();
    Optional<Nation> any = stream.filter(n -> n.isIsland()).findFirst();
    System.out.println(any);

    //any.ifPresent(nation -> System.out.println(nation.getName()));
    stream = Nation.nations.stream();
    Optional<Nation> max = stream.max(Comparator.comparing(n -> n.getPopulation()));
    System.out.println(max.get().getName());

    // 인구가 1억(population > 100)이 넘는 나라의 수
    stream = Nation.nations.stream();
    long count = stream.filter(n -> n.getPopulation() > 100)
        .count();
    System.out.println("인구가 1억이 넘는 나라의 수는 " + count + " 입니다.");
  }
}
