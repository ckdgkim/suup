package advancedJava2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo2 {
  public static void main(String[] args) {
    Runnable task = () -> {
      for (int i = 0; i < 5; i++) {
        System.out.println(Thread.currentThread().getName() + " : " + i);
        try {
          Thread.sleep(500);
        } catch (InterruptedException e) {
        }
      }
    };

    //Thread thread = new Thread(task);
    ExecutorService service = Executors.newFixedThreadPool(4);
    service.submit(task);
    service.submit(task);
    service.submit(task);

    service.shutdown();

    service.submit(task);
    service.submit(task);
    service.submit(task);

    for (int i = 0; i < 5; i++) {
      System.out.println(Thread.currentThread().getName() + " : " + i);
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
      }
    }
  }
}
