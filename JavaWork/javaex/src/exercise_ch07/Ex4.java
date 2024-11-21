package exercise_ch07;

public class Ex4 {
  public static void main(String[] args) {
    speak(new Korean());
    speak(new American());
  }

  public static void speak(Talkable talkable) {
    talkable.talk();
  }
}
