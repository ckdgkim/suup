package advancedJava2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {
    public static void main(String[] args) {
      Runnable task = () -> {
        for (int i = 0; i < 5; i++) {
          System.out.print("잘가. ");
          System.out.println(Thread.currentThread().getName());
          try {
            Thread.sleep(500);
          } catch (InterruptedException e) {
          }
        }
      };
      ExecutorService exec = Executors.newFixedThreadPool(4);
      exec.submit(task);

      for (int i = 0; i < 5; i++) {
        System.out.print("안녕. ");
        System.out.println(Thread.currentThread().getName());
        try {
          Thread.sleep(500);
        } catch (InterruptedException e) {
        }
      }
      exec.shutdown();
    }
}
