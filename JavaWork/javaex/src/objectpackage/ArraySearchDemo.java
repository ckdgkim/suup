package objectpackage;

import java.util.Arrays;

public class ArraySearchDemo {
  public static void main(String[] args) {
    int[] numbers = {77,88,66,99,11,22,33}; // 11 을 찾아라.
    int findNumber = 33;
    int findIndex = -1;
    for (int i = 0; i < numbers.length; i++) {
      if(numbers[i] == findNumber){
        findIndex = i;
        break;
      }
    }

    System.out.println(numbers.length + "개의 요소가 있음");
    if(findIndex < 0)
      System.out.println("찾지 못함");
    else
      System.out.println(findIndex + "번 index 위치에서 해당 요소를 찾음");

    System.out.println("정렬하기 전 : " + Arrays.toString(numbers));
    Arrays.sort(numbers);
    System.out.println("정렬한 후 : " + Arrays.toString(numbers));
    int i = Arrays.binarySearch(numbers, 77);
    System.out.println(i);
  }
}
