import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int x = Integer.parseInt(st.nextToken());
    int mult = Integer.parseInt(st.nextToken());
    int divi = Integer.parseInt(st.nextToken());

    System.out.println(pow(x, mult, divi));
  }

  static long pow(int x, int mult, int divi) {
    if (mult == 1) {
      return x % divi;
    }
    long value = pow(x, mult / 2, divi);
    value = value * value % divi;
    if (mult % 2 == 0) return value;
    return value * x % divi;
  }
}
