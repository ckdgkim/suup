package intermediateJava;

public class TypeCastingDemo {
  public static void main(String[] args) {
    Vehicle v = new Car(); // 자동 형변환 , upcasting
    System.out.println(v.name);
    v.whoami();
    Vehicle.move();
    v.move();

    Car c = new Car();
    System.out.println(c.name);
    c.whoami();
    c.move();

    Sportscar s = new Sportscar();
    System.out.println(s.name);
    s.whoami();
    s.equal();
    s.move();
    Sportscar.move();
  }
}

class Vehicle {
  String name = "탈 것";
  void whoami() {
    System.out.println("나는 탈 것이다.");
  }
  static void move() {
    System.out.println("이동하다.");
  }
}

class Car extends Vehicle {
  String name = "자동차";
  @Override
  void whoami() {
    System.out.println("나는 자동차이다.");
  }
  static void move() {
    System.out.println("달리다.");
  }
}

class Sportscar extends Vehicle {
  String name = "스포츠카";

  void equal () {
    System.out.println("나의 이름 : " + this.name);
    System.out.println("부모의 이름 : " + super.name);
  }

  @Override
  void whoami() {
    System.out.println("나는 스포츠카이다.");
  }

  static void move(){
    System.out.println("쌩 달리다.");
  }
}