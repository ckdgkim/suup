package collection_framework;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MapDemo2 {
  public static void main(String[] args) {
    Map<Fruit, Integer> fruits = new HashMap<>();
    Fruit f1 = new Fruit("사과");
    Fruit f2 = new Fruit("딸기");
    fruits.put(f1,5);
    fruits.put(f2,3);
    fruits.put(f1,10);
    System.out.println(fruits.size());
    System.out.println(fruits.get(f2));
  }
}

class Fruit {
  String name ;

  public Fruit(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Fruit fruit)) return false;
    return Objects.equals(name, fruit.name);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(name);
  }

  @Override
  public String toString() {
    return name ;
  }
}