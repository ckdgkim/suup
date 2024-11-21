package exercise_ch11;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class HashsetTest {
  public static void main(String[] args) {
    Set<Person> set = new HashSet<>();
    set.add(new Person("김열공",20));
    set.add(new Person("최고봉",56));
    set.add(new Person("우등생",16));
    set.add(new Person("나자바",35));
    set.add(new Person("나자바",35));
    set.add(new Person("우등생",16));
    Iterator<Person> it = set.iterator();
    Person p;
    while(it.hasNext()) {
      p = it.next();
      System.out.println(p.name + " : " + p.age);
    }

    it = set.iterator();
    while(it.hasNext()) {
      System.out.print(it.next() + " ");
    }
  }
}

class Person {
  String name;
  int age;

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Person person)) return false;
    return age == person.age && Objects.equals(name, person.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, age);
  }

  @Override
  public String toString() {
    return "Person[" +
        name + " : " +
        age +
        ']';
  }
}