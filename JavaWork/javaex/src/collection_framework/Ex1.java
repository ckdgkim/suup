package collection_framework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

public class Ex1 {
  public static void main(String[] args) {

    Collection<String> s = new ArrayList<>();
    s = new LinkedList<>();
    s.add("갈매기");
    s.add("나비");
    s.add("다람쥐");
    s.add("라마");
    for (String s1 : s){
      if (s1.length() == 2){
        System.out.println(s1);
      }
    }
  }
}
