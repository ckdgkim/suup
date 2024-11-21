package advancedJava;

import java.util.Calendar;

public class CalendarDemo {
  public static void main(String[] args) {
    Calendar c = Calendar.getInstance();
    System.out.println(c);
    System.out.println(c.get(Calendar.YEAR));
    System.out.println(c.get(2) + 1);
    System.out.println(c.get(Calendar.DAY_OF_MONTH));
  }
}

