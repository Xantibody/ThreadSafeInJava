package demo;

public class Counter {
  private int count = 0;
  private final boolean isThreadSafe;
  private final Object lock = new Object();

  public Counter(boolean isThreadSafe) {
    this.isThreadSafe = isThreadSafe;
  }

  public void increment() {
    if (isThreadSafe) {
      synchronized (lock) {
        count++;
      }
    } else {
      count++;
    }
  }

  public int getCount() {
    if (isThreadSafe) {
      synchronized (lock) {
        return count;
      }
    } else {
      return count;
    }
  }
}
