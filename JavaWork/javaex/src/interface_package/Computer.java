package interface_package;

public class Computer implements Controllable{
  @Override
  public void repair() {
    System.out.println("컴퓨터를 수리한다.");
  }

  @Override
  public void turnOn() {
    System.out.println("컴퓨터를 켠다.");
  }

  @Override
  public void turnOff() {
    System.out.println("컴퓨터를 끈다.");
  }
}
