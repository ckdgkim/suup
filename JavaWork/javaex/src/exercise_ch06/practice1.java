//package exercise;
//
//public class practice1 {
//  public static void main(String[] args) {
//    Circle c = new Circle(5);
//    ColoredCircle cc = new ColoredCircle(10,"빨간색");
//    c.show();
//    cc.show();
//  }
//}
//
//class Circle {
//  int radius;
//
//  void show() {
//    System.out.println("반지름이 " + radius + "인 원이다.");
//  }
//
//  Circle(int radius) {
//    this.radius = radius;
//  }
//}
//
//class ColoredCircle extends Circle {
//  String color;
//  void show() {
//    System.out.println("반지름이 " + radius +"인" + color + "원이다.");
//  }
//  ColoredCircle(int radius, String color){
//    super(radius);
//    this.color = color;
//  }
//}
