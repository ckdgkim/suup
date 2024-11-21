package collection_framework;

import java.util.List;
import java.util.Stack;

public class StackDemo {
  public static void main(String[] args) {
    List<String> list = new Stack<>();
    Stack<String> st = new Stack<>();
    System.out.println(list.isEmpty());
    System.out.println(st.empty());
    st.push("a"); // addFirst
    st.push("b"); // addFirst
    st.push("c"); // addFirst
    st.push("d");// addFirst
    System.out.println(st);
    System.out.println(st.peek()); // getFirst
    System.out.println(st.search("a")+ "번째에서 찾음");
    System.out.println(st.search("b") + "번째에서 찾음");
    System.out.println(st.search("c") + "번째에서 찾음");
    System.out.println(st.search("d") + "번째에서 찾음");
    while(!st.empty()) {
      st.pop(); // removeFirst
      System.out.println(st);
    }
  }
}
