package objectpackage;

public class ArrayDemo2 {
  public static void main(String[] args) {
    int[] scores = new int[]{10,20,30,40,50};
    for (int i = 0; i < scores.length ; i++) {
      System.out.print(scores[i] + ",");
    }
    System.out.println("");


    scores = new int[10];
    //scores.length = 8;
    for (int i = 0; i < scores.length ; i++) {
      scores[i] = i + 1 ;
      System.out.print(scores[i]+ ",");
    }
//    scores[0] = 1;
//    scores[1] = 2;
//    scores[2] = 3;
//    scores[3] = 4;
//    scores[4] = 5;
//    scores[5] = 6;
//    scores[6] = 7;
//    scores[7] = 8;
//    scores[8] = 9;
//    scores[9] = 10;

  int[] scores2 = {10,20,30,40,50,60,70};

  }
}
