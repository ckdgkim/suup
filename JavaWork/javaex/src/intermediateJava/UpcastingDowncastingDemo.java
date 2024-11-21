package intermediateJava;

public class UpcastingDowncastingDemo {
  public static void main(String[] args) {
//    Person p = new Person();
//    Student s = (Student) p;

      Student s = new Student();
      Person p = s;  //  자동 형변환, upcasting
      String name = p.name;
      p.whoami();
//      p.number;
//      p.work();
      Student s2 = (Student) p;
      int number = s2.number;
      s2.work();
  }
}
