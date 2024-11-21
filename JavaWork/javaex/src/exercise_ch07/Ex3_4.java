package exercise_ch07;

import java.util.Arrays;
import java.util.Collections;

public class Ex3_4 {
  public static void main(String[] args) {
    Person[] persons = {
        new Person("홍길동",32,170,75),
        new Person("박지성",40,175,68),
        new Person("손흥민",20,180,70)
    };

//    for (Person person : persons) {
//      System.out.println(person);
//    }

    //Arrays.sort(persons);
    Arrays.sort(persons, Collections.reverseOrder());

    for (Person person : persons) {
      System.out.println(person);
    }
  }
}

class Person implements Comparable{
  String name;
  int age,height,weight;

  public Person(String name, int age, int height, int weight) {
    this.name = name;
    this.age = age;
    this.height = height;
    this.weight = weight;
  }

  @Override
  public String toString() {
    return "Person[" +
        "이름='" + name + '\'' +
        ", 나이=" + age +
        ", 키=" + height +
        ", 몸무게=" + weight +
        ']';
  }

  @Override
  public int compareTo(Object o) {
    if(o instanceof Person){
      Person p = (Person) o;
      return this.age - p.age;
    }
    return 0;
  }
}