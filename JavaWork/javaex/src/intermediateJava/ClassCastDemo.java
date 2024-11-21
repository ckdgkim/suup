package intermediateJava;

public class ClassCastDemo {
  public static void main(String[] args) {
    Triangle triangle = new Triangle(3,3,3);
    //Eagle e = triangle;
    Figure f = triangle;
    System.out.println(f.poly);
  }
}
