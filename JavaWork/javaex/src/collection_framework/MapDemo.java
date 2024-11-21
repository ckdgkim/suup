package collection_framework;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {
  public static void main(String[] args) {
    Map<String, Integer> map = Map.of("딸기",5,"바나나",3,"사과",2);
    HashMap<String, Integer> hm = new HashMap<>(map);
    System.out.println(hm.size());
    System.out.println("바나나의 갯수 : " + hm.get("바나나"));
    hm.put("딸기", 10);
    System.out.println("딸기의 갯수 : " + hm.get("딸기"));
    hm.put("수박",5);
    System.out.println(hm.size());
    System.out.println("수박의 갯수 : " + hm.get("수박"));
  }
}
