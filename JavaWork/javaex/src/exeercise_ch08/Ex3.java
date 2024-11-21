package exeercise_ch08;

import java.util.Calendar;

public class Ex3 {
  public static void main(String[] args) {
    String[] weekName = {"일", "월", "화", "수", "목", "금", "토"};
    String[] noonName = {"오전", "오후"};
    Calendar c = Calendar.getInstance();

    //코드추가
    int year = c.get(Calendar.YEAR);
    int month = c.get(Calendar.MONTH) + 1;
    int day = c.get(Calendar.DAY_OF_MONTH);
    int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
    String week = weekName[dayOfWeek - 1];
    int am_pm = c.get(Calendar.AM_PM);
    String noon = noonName[am_pm];
    int hour = c.get(Calendar.HOUR);
    int minute = c.get(Calendar.MINUTE);
    int second = c.get(Calendar.SECOND);

    System.out.println(year + "년 " + month + "월 " + day + "일");
    System.out.println(week + "요일 " + noon);
    System.out.println(hour + "시 " + minute + "분 " + second + "초");
  }
}
