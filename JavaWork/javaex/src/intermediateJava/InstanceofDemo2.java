package intermediateJava;

public class InstanceofDemo2 {
  public static void main(String[] args) {
    Circle c1 = new Circle(5);
    Circle c2 = new Circle(5);
    Circle c3 = new Circle(3);
    Person p = new Person();

    System.out.println(c1.equals(c2));
    System.out.println(c1.equals(c3));
    System.out.println(c1.equals(p));
  }
}

class Circle {
  int radius;

  public Circle(int radius) {
    this.radius = radius;
  }

  @Override
  public boolean equals(Object obj) {
    if(obj instanceof Circle) {
      Circle c = (Circle) obj;
      return this.radius == c.radius;
    }
    return false;
  }
}
