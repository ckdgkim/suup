package collection_framework;

import interface_package.InterfaceDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class scoreTest {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    List<Integer> l = new ArrayList<>();
    while (true){
      System.out.println("점수를 입력하세요.");
      int n = in.nextInt();
      if (n < 0){
        break;
      }else {
        l.add(n);
      }
    }
    System.out.println("전체 학생은 " + l.size() +"이다.");
    for (int i = 0; i < l.size(); i++) {
      System.out.println("학생들의 성적 : " + l.get(i) + "점이다.");

    }
  }
}
