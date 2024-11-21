package exercise_ch06;

public class Ex5 {
  public static void main(String[] args) {
    Phone[] phones = { new Phone("황진이"),
                       new Telephone("길동이", "내일"),
                       new Smartphone("민국이", "갤러그")
                      };

    for (Phone phone : phones) {
      if(phone instanceof Smartphone){
        Smartphone s = (Smartphone) phone;
        s.playGame();
      } else if(phone instanceof Telephone) {
        Telephone t = (Telephone) phone;
        t.autoAnswering();
      } else if(phone instanceof Phone) {
        phone.talk();
      }
    }
  }
}

class Phone{
  //필드
  protected String owner;
  //생성자
  public Phone(String owner) {
    this.owner = owner;
  }
  //메서드
  void talk(){
    System.out.println(owner + "가 통화중");
  }
}

class Telephone extends Phone{
  //필드
  private String when;
  //생성자
  public Telephone(String owner, String when) {
    super(owner);
    this.when = when;
  }
  //메서드
  void autoAnswering(){
    System.out.println(owner + "가 부재중이니 "+ when + "에 전화 요망");
  }
}

class Smartphone extends Telephone {
  // 필드
  private String game;
  // 생성자
  public Smartphone(String owner, String game) {
    super(owner, "");
    this.game = game;
  }
  // 메서드
  void playGame() {
    System.out.println(owner + "가 "+ game+ " 게임 중");
  }
}
