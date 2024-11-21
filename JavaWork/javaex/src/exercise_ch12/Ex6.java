package exercise_ch12;

import advancedJava2.Nation;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class Ex6 {
  public static void main(String[] args) {
    List<Member> list = Arrays.asList(
        new Member("홍길동",30),
        new Member("손흥민",25),
        new Member("신유빈",20)
    );

//    list.stream()
//        .map(m -> m.getAge())
//        .average();

    OptionalDouble average = list.stream()
        .mapToInt(m -> m.getAge())
        .average();

    System.out.println("평균 나이는 " + average.getAsDouble());
  }
}

class Member {
  private String name;
  private int age;

  public Member(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }
}