package exercise_ch06;

public class Ex3 {
  public static void main(String[] args) {
    Person[] persons = new Person[3];
    persons[0] = new Person(22, "길동이");
    persons[1] = new Student(23,"황진이", "100");
    persons[2] = new ForeignStudent(30, "Amy", "200", "U.S.A");

    for (Person person : persons) {
      System.out.println(person.show() + "]");
    }
  }
}

class Person {
  //필드
  private int age;
  private String name;
  //생성자
  public Person(int age, String name) {
    this.age = age;
    this.name = name;
  }
  //메서드
  public int getAge() {
    return age;
  }
  public void setAge(int age) {
    this.age = age;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  String show(){
    return "사람[이름 : " + name + ", 나이 : " + age ;
  }
}

class Student extends Person {
  //필드
  private String number;
  //생성자
  public Student(int age, String name, String number) {
    super(age, name);
    this.number = number;
  }
  //메서드
  public String getNumber() {
    return number;
  }
  public void setNumber(String number) {
    this.number = number;
  }

  @Override
  String show() {
    return super.show() + ", 학번 : " + number ;
  }
}

class ForeignStudent extends Student {
  //필드
  private String nationality;
  //생성자
  public ForeignStudent(int age, String name, String number, String nationality) {
    super(age, name, number);
    this.nationality = nationality;
  }
  //메서드
  public String getNationality() {
    return nationality;
  }
  public void setNationality(String nationality) {
    this.nationality = nationality;
  }

  @Override
  String show() {
    return super.show() + ", 국적 : " + nationality;
  }
}
