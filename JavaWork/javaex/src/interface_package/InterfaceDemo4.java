package interface_package;

public class InterfaceDemo4 {
  public static void main(String[] args) {
    /*controllable 객체배열을 이용(TV와 컴퓨터객체를 배열에 저장)
    반복문으로 모든 배열의 요소인 각 객체에 대해서 각각 켜고 끄고 수리한다.
        최종적으로 공장초기화 한다.*/
//    Controllable[] controllables = new Controllable[2];
//    controllables[0] = new TV();
//    controllables[1] = new Computer();
    Controllable[] controllables = {new TV(),new Computer()};

    for (Controllable controllable : controllables) {
      controllable.turnOn();
      controllable.turnOff();
      controllable.repair();
    }
    Controllable.reset();
//    controllables[0].turnOn();
//    controllables[0].turnOff();
//    controllables[0].repair();
//
//    controllables[1].turnOn();
//    controllables[1].turnOff();
//    controllables[1].repair();
  }
}
