package interface_package;

public class Talkable3 {
  public static void main(String[] args) {
    speak(new Korean());
    speak(new American());
  }

  public static void speak(Talkable talkable) {
    talkable.talk();
  }
}
