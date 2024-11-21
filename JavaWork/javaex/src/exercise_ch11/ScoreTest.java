package exercise_ch11;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ScoreTest {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    List<Integer> scoreList = new ArrayList<>();

    System.out.println("학생들의 점수를 , 로 구분해서 한 줄에 입력하세요");
    String scores = in.nextLine();
    StringTokenizer st = new StringTokenizer(scores, " ,");
    int sum = 0;
    int score;
    String token;
    while (st.hasMoreTokens()) {
      token = st.nextToken();
      try {
        score = Integer.parseInt(token);
        System.out.println(score);
        scoreList.add(score);
      } catch (NumberFormatException e) {
        System.out.println("학생의 점수는 정수형태로 입력하셔야 합니다.");
      }
    }
    // 학생의 수, 총점과 평균을 구한다.
    System.out.println(scoreList.size());
    for (Integer i : scoreList) {
      sum += i;
    }
    double avg = (double) sum / scoreList.size();
    System.out.println("sum : " + sum + ", avg : " + avg);
  }
}
