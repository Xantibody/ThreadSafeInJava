package demo;

// このコードは、よくあるスレッドセーフなカウンターを作成するためのコードです。
public class Main {
  public static void main(String[] args) {

    if (1 < args.length){
      System.out.println("plz args to SAFE or UNSAFE");
      return;
    }

    Service service = new Service();
    Counter counter = new Counter(service.isTreadSafe(args));
    int loop = 100000;

    Thread t1 = new Thread(() -> {
      for (int i = 0; i < loop; i++) {
        counter.increment();
      }
    });
    Thread t2 = new Thread(() -> {
      for (int i = 0; i < loop; i++) {
        counter.increment();
      }
    });

    t1.start();
    t2.start();

    try {
      t1.join();
      t2.join();

    } catch (InterruptedException e) {
      System.out.println(e.getMessage());
    }
    System.out.println(counter.getCount()); // Thread Safeなら200000が表示されるはず
  }
}
