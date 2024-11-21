package advancedJava2;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectorDemo {
  public static void main(String[] args) {
    Set<String> nationNames = Nation.nations.stream()
        .map(n -> n.getName())
        .collect(Collectors.toSet());

    for (String nationName : nationNames) {
      System.out.println(nationName);
    }

    Set<Nation.Type> collect = Nation.nations.stream()
        .map(n -> n.getType())
        .collect(Collectors.toSet());

    for (Nation.Type type : collect) {
      System.out.println(type);
    }

    List<String> list = Nation.nations.stream()
        .map(n -> n.getName())
        .limit(3)
        .collect(Collectors.toList());

    for (String s : list) {
      System.out.println(s);
    }

    Map<String, Double> nationsMap = Nation.nations.stream()
        .filter(Nation::isIsland)
        .collect(Collectors.toMap(Nation::getName, Nation::getPopulation));

    System.out.println(nationsMap);
  }
}
