package objectpackage;

public class WithArrayDemo {
  public static void main(String[] args) {
    // 배열 scores , 4 개의 int score 를 저장
    //int scores[] ;
    String s1 = "";

    int[] scores = {90,75,85,75,80,90,100,60,99,88};
    int sum = 0;
    System.out.println(scores.length);
    for (int i = 0; i < scores.length; i++) {
      System.out.println(scores[i]);
      sum += scores[i];
    }
    System.out.println(sum);

    // 평균값 구하기, 소숫점 2자리까지 출력 (단, 재사용성 고려)
    double avg = sum / (double)scores.length ;
    System.out.printf("평균은 %.2f 입니다." , avg);

//    System.out.println(scores[0]);
//    System.out.println(scores[1]);
//    System.out.println(scores[2]);
//    System.out.println(scores[3]);
  }
}
