package objectpackage;

class Circle {
  // 필드 - 캡슐화 전
  static final double PI = Math.PI;
  private int radius = 1;
  // 생성자 (기본생성자~~~)
  public Circle(int radius) {
    if(radius <= 0){
      System.out.println("원의 반지름은 0보다 커야 합니다.");
    } else {
      this.radius = radius;
    }
  }
  // 메서드
  /**
   * 원의 반지름을 출력하는 메서드
   * 인스턴스를 생성해야 호출할 수 있는 메서드
   * 매개변수X 리턴값X
   */
  public void printRadius(){
    System.out.println("원의 반지름 : " + radius);
  }
  /**
   * 원의 넓이를 구하여 반환하는 메서드
   * 매개변수 X 리턴값 O (double)
   */
  public double getArea() {
    double area = PI * radius * radius;
    return area;
  }

  public int getRadius() {
    return radius;
  }

  public void setRadius(int radius) {
    if(radius <= 0){
      System.out.println("원의 반지름은 0보다 커야 합니다.");
    } else {
      this.radius = radius;
    }
  }

  @Override
  public String toString(){
    return "원의 반지름이 " + radius + "이고, 넓이가 " + getArea() + "인 원입니다.";
  }

//  @Override
//  public String toString() {
//    return "Circle{" +
//        "radius=" + radius +
//        '}';
//  }
}
