package exercise_ch07;

public class Ex3_1 {
  public static void main(String[] args) {
    //Line l1 = new Line(10);
    Line l2 = new Line(20);
    String l1 = "String";

    if(l2.compareTo(l1) == -999) {
      System.out.println("선의 길이를 비교할 수 없습니다.");
      return;
    };
    if (l2.compareTo(l1) > 0) {
      System.out.print(l2);
      System.out.print(" 이 더 깁니다.");
    } else if (l2.compareTo(l1) < 0) {
      System.out.print(l1);
      System.out.print(" 이 더 깁니다.");
    } else if (l2.compareTo(l1) == 0){
      System.out.print("두 선의 길이가 같습니다.");
    }
  }
}
