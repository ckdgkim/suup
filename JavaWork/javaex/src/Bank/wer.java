import java.util.HashMap;
import java.util.Map;

public class wer {
  public static void main(String[] args) {
    // HashMap 생성
    Map<String, Integer> map = new HashMap<>();

    // 데이터 추가
    map.put("사과", 10);
    map.put("바나나", 20);
    map.put("오렌지", 30);

    // 데이터 가져오기
    System.out.println("사과의 수량: " + map.get("사과"));
  }
}