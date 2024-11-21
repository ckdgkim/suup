package exercise_ch09;

public class TicketTest {
  //1. 티켓의 가격으로 크고 작음을 비교해야 한다.
  //2. 배열에서 특정 가격보다 티켓의 가격이 큰 것이 몇개 있는지를 세는 메소드가 필요하다.
  //3. 메서드는 티켓 뿐 아니라 비교를 할 수 있는 다른 객체가 와도 재사용 가능해야 한다.
  public static void main(String[] args) {
    Ticket[] a = {
        new Ticket(1000),
        new Ticket(2000),
        new Ticket(3000),
    };
    System.out.println(countGT(a, a[0]));
  }

  public static <T extends Comparable> int countGT(T[] t, T e) {
    int count = 0;
    for (T t1 : t) {
      if(t1.compareTo(e) > 0) count++;
    }
    return count;
  }
}

class Ticket implements Comparable{
  int price;

  public Ticket(int price) {
    this.price = price;
  }

  @Override
  public int compareTo(Object o) {
    if(o instanceof Ticket) {
      Ticket t = (Ticket) o;
      return this.price - t.price;
    }
    return -999;
  }
}
