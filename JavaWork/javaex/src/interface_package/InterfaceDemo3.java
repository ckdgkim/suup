package interface_package;

public class InterfaceDemo3 {
  public static void main(String[] args) {
    TV tv = new TV();
    tv.turnOn();
    tv.turnOff();
    Controllable.reset();
    tv.repair();

    Computer computer = new Computer();
    computer.turnOn(); // 컴퓨터를 켠다.
    computer.turnOff(); // 컴퓨터를 끈다.
    Controllable.reset(); // 장비를 공장초기화한다.
    computer.repair(); // 컴퓨터를 수리한다.

    Notebook notebook = new Notebook();
    notebook.turnOn();
    notebook.turnOff();
    notebook.repair();
    notebook.inMyBag();
  }
}
