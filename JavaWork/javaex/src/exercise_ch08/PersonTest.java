package exercise_ch08;

public class PersonTest {
  public static void main(String[] args) {
    Person p1 = new Person("1111111", "홍길동");
    Person p2 = new Person("1111111", "손흥민");

    if(p1.equals(p2))
      System.out.println("같은 사람이다.");
    else
      System.out.println("다른 사람이다.");
  }
}

class Person {
  String number;
  String name;

  public Person(String number, String name) {
    this.number = number;
    this.name = name;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Person person = (Person) obj;
    return number.equals(person.number);


  }
}
