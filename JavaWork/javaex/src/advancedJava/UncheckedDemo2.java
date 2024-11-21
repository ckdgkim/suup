package advancedJava;

import java.util.ArrayList;
import java.util.List;

public class UncheckedDemo2 {
  public static void main(String[] args) {
    int[] array = {1,2,3};
    int[] array2 = null;
    List<String> list = new ArrayList<>();

    // 리스트에서 유효하지 않은 인덱스를 접근할 때 발생
    // IndexOutOfBoundsException이 발생하고, 이는 IllegalArgumentException의 하위 클래스입니다.

    try {
//      int result = 3 / 0;
//      System.out.println(result);
      //System.out.println(array[3]);
      String value = list.get(0); // 리스트가 비어있기 때문에 유효하지 않은 인덱스 접근
      System.out.println(array2[3]);
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("인덱스 범위를 벗어났습니다.");
    } catch (NullPointerException e){
      System.out.println("배열이 정상적으로 생성되지 않았습니다.");
    } catch (ArithmeticException e) {
      System.out.println("0 으로 나눌 수 없습니다.");
    } catch (Exception e) {
      //System.out.println("알 수 없는 예외가 발생했습니다.");
      e.printStackTrace();
      System.out.println(e.getMessage());
    }



    System.out.println("프로그램 종료");





    // 예외가 발생하지 않을 경우 출력되지 않음
   //System.out.println("Value: " + value);
  }

  public static void add(int a, int b){
    System.out.println(a+b);
  }
}
