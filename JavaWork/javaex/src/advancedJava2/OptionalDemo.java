package advancedJava2;

import java.util.Optional;

public class OptionalDemo {
  public static void main(String[] args) {
    String s1 = "hello";
    String s2 = null;

    Optional<String> o1 = Optional.ofNullable(s1);
    Optional<String> o2 = Optional.ofNullable(s2);

    if(o2.isPresent()) {
      Util.print(o2.get());
    } else {
      Util.print(o2);
      System.out.println("값이 없음");
    }

    if(o1.isPresent()) {
      Util.print(o1.get());
    } else {
      Util.print(o1);
      System.out.println("값이 없음");
    }

    o1.ifPresent(Util::print);

//    String result = o2.orElse("값이 없음");
//    System.out.println(result);
    Util.printWithParenthesis(o2.orElse("값이 없음"));
  }
}
