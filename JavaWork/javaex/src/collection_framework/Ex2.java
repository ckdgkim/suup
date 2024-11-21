//package collection_framework;
//
//import java.util.HashSet;
//
//public class Ex2 {
//  public static void main(String[] args) {
//    HashSet<HashsetTest> set = new HashSet<>();
//    for (HashsetTest person : set) {
//      System.out.println(person);
//    }
//    set.add(new HashsetTest("김열공",20));
//    set.add(new HashsetTest("최고봉",56));
//    set.add(new HashsetTest("우등생",16));
//    set.add(new HashsetTest("나자바",35));
//    System.out.println(set);
//  }
//}
//
//class Person{
//  String name;
//  int age;
//
//  public Person(String name, int age) {
//    this.name = name;
//    this.age = age;
//  }
//
//  @Override
//  public String toString() {
//    return "Person{" +
//        "name='" + name + '\'' +
//        ", age=" + age +
//        '}';
//  }
//}