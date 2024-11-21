package objectpackage;

import java.util.Arrays;

public class MaxMinDemo {
  public static void main(String[] args) {
    int[] scores = {40,30,70,90,100};
    int max = findMax(scores);
    int min = findMin(scores);

//    for(int i=1; i<score.length; i++){
//      if(score[i] > max) max = score[i];
//      else if(score[i] < min) min = score[i];
//    }


    System.out.println(Arrays.toString(scores));
    System.out.printf("배열의 최소값은 %d 이고, 최대값은 %d 입니다.", min, max);
  }

  private static int findMin(int[] s) {
    int min = s[0];
    for (int i = 1; i < s.length; i++) {
      if(min > s[i]) min = s[i];
    }
    return min;
  }

  private static int findMax(int[] s) {
    int max = s[0];
    for (int i = 1; i < s.length; i++) {
      if(max < s[i]) max = s[i];
    }
    return max;
  }
}
