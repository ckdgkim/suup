package intermediateJava;

import java.util.Arrays;

public class UpcastingDemo {
  public static void main(String[] args) {
//    Student s = new Student();
//    System.out.println(s.name);
//    System.out.println(s.number);
//    s.whoami();
//    s.work();
//
//    Person p = s;
//    //System.out.println(p.number);
//    //p.work();
//    System.out.println(p.name);
//    p.whoami();

    Person[] persons = new Person[5];
    persons[0] = new Student();
    System.out.println(persons[0].seq);
    persons[1] = new Army();
    System.out.println(persons[1].seq);
    persons[2] = new Owner();
    System.out.println(persons[2].seq);
    persons[3] = new Employee();
    System.out.println(persons[3].seq);
    persons[4] = new Employee();
    System.out.println(persons[4].seq);
    //System.out.println(persons);
    System.out.println(Arrays.toString(persons));
  }
}

class Person {
  static int seq;
  String name = "사람";
  public Person() {
    seq++;
  }
  void whoami(){
    System.out.println("나는 사람이다.");
  }
}

class Student extends Person {
  int number = 7;
  void work() {
    System.out.println("나는 공부한다.");
  }
}

class Employee extends Person {
  int number = 10;
  void work() {
    System.out.println("나는 회사에서 일한다.");
  }
}

class Owner extends Person {
  int number = 3;
  void work() {
    System.out.println("나는 회사를 관리한다.");
  }
}

class Army extends Person {
  int number = 1;
  void work() {
    System.out.println("나는 국가를 지킨다.");
  }
}