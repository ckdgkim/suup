package interface_package;

public class InstanceDemo6 {
  public static void main(String[] args) {
    Movable m = new Vehicle();
    Vehicle v = new Car();
    Movable c = new Car();

    m.move(3);
    v.move(10);
    c.move(100);

    Car car1 = (Car)c;
    Car car2 = (Car)v;

    car1.show();
    car2.show();
  }
}
