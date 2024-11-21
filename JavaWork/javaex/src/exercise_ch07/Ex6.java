package exercise_ch07;

public class Ex6 {
  public static void main(String[] args) {
    Human.echo();
    Student s = new Student(20);
    s.print();
    s.eat();

    Human p = new Worker();
    p.print();
    p.eat();
  }
}
