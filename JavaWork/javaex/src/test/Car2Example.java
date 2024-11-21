package test;

public class Car2Example {
  public static void main(String[] args) {
    Car2 myCar = new Car2();

    myCar.tire = new Tire();
    myCar.run();

    myCar.tire = new HankookTire();
    myCar.run();

    myCar.tire = new KumhoTire();
    myCar.run();
  }
}
