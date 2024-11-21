package advancedJava2;

public class ThreadDemo2 {
  public static void main(String[] args) {
    Thread thread0 = new Thread(new Task());
    Thread thread1 = new Thread(new Task());
    Thread thread2 = new Thread(new Task());
    Thread thread3 = new Thread(new Runnable() {
      @Override
      public void run() {
        for (int i = 0; i < 5; i++) {
          int result = 5/0;
          String s = null;
          System.out.println(s.length());
          try {
            Thread.sleep(500);
          } catch (InterruptedException e) {
          }
        }
      }
    });

    thread3.start();

    thread0.start();
    System.out.println(Thread.currentThread().getName());
    int res = 5/0;
    System.out.println(res);

    thread1.start();
    thread2.start();




  }
}

class Task implements Runnable {
  @Override
  public void run() {
    for (int i = 0; i < 5; i++) {
      System.out.println(i + " : " + Thread.currentThread().getName());
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
      }
    }
  }
}
