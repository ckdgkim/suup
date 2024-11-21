package exercise_ch08;

public class CircleTest {
  public static void main(String[] args) {
    Circle c1 = new Circle(3);
    Circle c2 = new Circle(3);

    if (c1.equals(c2))
      System.out.println("c1과 c2는 같다.");
    else
      System.out.println("c1과 c2는 다르다.");
  }

  static class Circle {
    int r;
    double area;


    public Circle(int r) {
      this.r = r;
      this.area = r * r * Math.PI;

    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj) return true;
      if (obj == null || getClass() != obj.getClass()) return false;
      Circle circle = (Circle) obj;
      return r == circle.r && Double.compare(circle.area, area) == 0;
    }
  }
}