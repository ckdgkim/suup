package objectpackage;

import java.util.Arrays;

public class RandomEx4 {
  public static void main(String[] args) {
//    double random ;
//    for (int i = 0; i < 10 ; i++) {
//      random = Math.random();
//      System.out.printf("%f , %f , %f \n", random , random * 2, random * 3);
//    }
    String[] name = {"가위", "바위", "보"};
    System.out.println(name);
    System.out.println(Arrays.toString(name));
    int index ;
    for (int i = 0; i < 10 ; i++) {
      // 가위, 바위, 보 를 랜덤하게 출력
      index = (int)(Math.random() * 3);
      System.out.println(name[index]);
    }
  }
}
