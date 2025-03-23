package demo;
import java.util.Arrays;


public class Service {
  public boolean isTreadSafe(String[] args) {
    return Arrays.stream(args)
        .filter(arg -> arg.equals("SAFE"))
        .findFirst()
        .map(arg -> arg.equals("SAFE"))
        .orElse(false);
  }
}
