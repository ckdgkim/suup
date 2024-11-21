package exercise_ch07;

public abstract class Controller {
  // 필드
  boolean power;
  // 생성자 X
  // 메서드
  void show() {
    if(power){
      System.out.println(getName() + "가 켜졌습니다.");
    } else {
      System.out.println(getName() + "가 꺼졌습니다.");
    }
  }
  abstract String getName() ;
}

class TV extends Controller {
  //생성자
  public TV(boolean power) {
    super.power = power;
  }
  //메서드
  @Override
  String getName() {
    return "TV";
  }
}

class Radio extends Controller {
  //생성자
  public Radio(boolean power) {
    super.power = power;
  }
  //메서드
  @Override
  String getName() {
    return "Radio";
  }
}
