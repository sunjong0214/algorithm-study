import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  static int gcd;
  static int lcm;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    GCD(n, m);
    LCM(n, m);
    bw.write(gcd + "\n" + lcm);
    br.close();
    bw.close();
  }

  static void GCD(int a, int b) {
    if (a % b == 0) {
      gcd = b;
      return;
    }
    GCD(b, a % b);
  }

  static void LCM(int a, int b) {
    lcm = a * b / gcd;
    return;
  }
}