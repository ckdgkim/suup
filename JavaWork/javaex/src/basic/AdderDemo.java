package basic;

public class AdderDemo {
  public static void main(String[] args) {
    int i = 0,j ;
    //j = i++; // 후위연산자, 연산을 먼저, 값증가를 나중에
    j = i;
    i++;

    System.out.printf("i = %d , j = %d \n", i,j);

    int x = 0, y;
    //y = ++x; // 전위연산자, 값증가를 먼저, 연산을 나중에
    ++x;
    y = x;
    System.out.printf("x = %d , y = %d", x,y);
  }
}
