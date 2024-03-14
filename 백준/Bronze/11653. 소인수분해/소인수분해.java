import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    if (n != 1 && prime(n) == true) {
      bw.write(n + "\n");
      n = 0;
    }
    for (int i = 2; i <= n; i++) {
      if (n % i != 0) {
        continue;
      }
      n /= i;
      if (prime(i) == true) {
        bw.write(i + "\n");
      }
      i = 1;
    }
    br.close();
    bw.close();
  }

  static boolean prime(int num) {
    if (num == 2) {
      return true;
    }
    for (int i = 2; i <= Math.sqrt(num); i++) {
      if (num % i == 0) {
        return false;
      }
    }
    return true;
  }
}