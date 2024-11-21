package intermediateJava;

public class InstanceofDemo {
  public static void main(String[] args) {
    Student s = new Student();
    Person p = new Person();
    Army a = new Army();

    System.out.println(s instanceof Student);
    System.out.println(s instanceof Person);
    System.out.println(s instanceof Object);
    System.out.println(a instanceof Person);
    //System.out.println(s instanceof String);

    downcast(s);
    downcast(a);
    //downcast("aksjdfkasjdhfkasjdhfka");
  }

  private static void downcast(Person p) {
    if (p instanceof Student s) {
      //Student s = (Student)p;
      System.out.println(s.number);
      s.work();
    }
    if (p instanceof Army a) {
      //Army a = (Army)p;
      System.out.println(a.number);
      a.work();
    }
  }
}
