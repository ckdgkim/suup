package basic;

public class MethodDemo {
  public static void main(String[] args) {
    System.out.println(sum(1,10)); // 55
    System.out.println(sum(10,100)); // 5005
    System.out.println(sum(100,1000)); // 495550
  }

  /**
   * 두개의 숫자를 입력받아서 start 로부터 end까지의 합을 구하는 method
   * @param start
   * @param end
   * @return
   */
  public static int sum(int start ,int end) {
    int sum = 0;
    for(int i = start ;i <= end;i++) {
      sum = sum + i; // 반복되는 부분은 그대로 두고, 변하는 부분만 변수로 치환
    }
    return sum;
  }
}
