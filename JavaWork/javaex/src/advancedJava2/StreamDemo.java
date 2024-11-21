package advancedJava2;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class StreamDemo {
  public static void main(String[] args) {
    //before
    List<Integer> list = new ArrayList<>();
    Random r = new Random();

    for (int i = 0; i < 10; i++) {
      list.add(r.nextInt(30));
    }

    List<Integer> gt10List = new ArrayList<>();
    for (Integer i : list) {
      if(i > 10) {
        gt10List.add(i);
      }
    }

    Collections.sort(gt10List);
    System.out.println(gt10List.size() + " : " + gt10List);
    //after

    list.stream()
        .filter(i -> i > 10)
        .sorted()
        .forEach(System.out::println);
  }
}
