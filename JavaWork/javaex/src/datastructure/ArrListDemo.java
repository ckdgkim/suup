package datastructure;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrListDemo {
  public static void main(String[] args) {
    ArrList<Integer> arr = new ArrList<>();
    System.out.println(arr.length() + ":" + arr.size());
    boolean add = arr.add(10);
    System.out.print(arr + "==>");
    System.out.println(arr.length() + ":" + arr.size());
    arr.add(20);
    System.out.print(arr + "==>");
    System.out.println(arr.length() + ":" + arr.size());
    arr.add(30);
    System.out.println(arr.peek(2) + " : index 2번째 요소입니다.");
    System.out.print(arr + "==>");
    System.out.println(arr.length() + ":" + arr.size());
    Integer removed = arr.remove(); // 맨 마지막 엘리먼트가 삭제됨
    System.out.println(removed + "가 삭제됨");
    System.out.print(arr + "==>");
    System.out.println(arr.length() + ":" + arr.size());
    removed = arr.remove(); // 맨 마지막 엘리먼트가 삭제됨
    System.out.println(removed + "가 삭제됨");
    System.out.print(arr + "==>");
    System.out.println(arr.length() + ":" + arr.size());
    removed = arr.remove(); // 맨 마지막 엘리먼트가 삭제됨
    System.out.println(removed + "가 삭제됨");

    System.out.print(arr + "==>");
    System.out.println(arr.length() + ":" + arr.size());

    ArrayList<Integer> javaArr = new ArrayList<>();
    System.out.println(javaArr.size());
    javaArr.add(10);
    javaArr.add(20);
    javaArr.add(30);


    javaArr.remove(javaArr.size() - 1);
    System.out.println(javaArr.size());
  }
}
