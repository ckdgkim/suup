package interface_package;

/**
 * askjashd
 *
 */
public interface Controllable {
  /**
   *
   *  수리기능이 구현되어 있습니다. 오버라이드 가능합니다.
   * @return  없음
   */
  default void repair() {
    show("장비를 수리한다.");
  }
  static void reset(){
    System.out.println("장비를 공장초기화한다.");
  }

  /**
   *
   * @param s
   */
  private void show(String s){
    System.out.println(s);
  }

  /**
   * * 장비를 켜고 끄는 기능을 구현해야 하며,
   */
  void turnOn();
  void turnOff();
}
