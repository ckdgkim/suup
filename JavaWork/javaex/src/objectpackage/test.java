package objectpackage;

import java.util.Arrays;
import java.util.Scanner;

public class test {
  public static void main(String[] args) {
    Circle circle = new Circle(1);
    int r = circle.getRadius();
    double area = r * r * Math.PI ;
    System.out.printf("원의 반지름은 %d, 넓이는 %.2f입니다.", r, area);

  }
}
