package objectpackage;

import java.util.Arrays;

public class VarArgsDemo {
  public static void main(String[] args) {
    printSum(1,10);
    printSum(1,10,20);
    printSum(1,10,20,30);
    printSum(1,10,20,30,40,50,60,70);
  }

  private static void printSum(int n, int... numbers) {
    int sum = 0;
    for (int number : numbers) {
      sum += number;
    }
    System.out.println(Arrays.toString(numbers));
    System.out.println(sum);
  }

//  private static void printSum(int i, int j) {
//
//  }
//
//  private static void printSum(int i, int j, int k) {
//
//  }
//
//  private static void printSum(int i, int j, int k, int l) {
//
//  }
}
