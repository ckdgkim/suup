package advancedJava;

import exercise_ch07.Line;

public class ClassDemo {
  public static void main(String[] args) {
    Line line = new Line(10);

    Class aClass = line.getClass();
    System.out.println(aClass.getName());
    System.out.println(aClass.getSimpleName());
    System.out.println(aClass.getTypeName());
    System.out.println(aClass.getPackage().getName());
  }
}
