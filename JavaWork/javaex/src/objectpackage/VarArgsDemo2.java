package objectpackage;

import java.util.Arrays;

public class VarArgsDemo2 {
  public static void main(String[] args) {
    System.out.println(sum(1,2,3,4));
    int[] arr = {2,3};
    System.out.println(sum(1,arr));
    System.out.println(sum(1,2,3,4,5));
  }

  private static int sum(int n, int... numbers) {
    int sum = 0;
    for (int number : numbers) {
      sum += number;
    }
    return sum;
  }
}
