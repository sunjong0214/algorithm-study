import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int money = Integer.parseInt(st.nextToken());
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }
    int result = 0;
    for (int idx = n - 1; idx >= 0; idx--) {
      if (money >= arr[idx]) {
        result += money / arr[idx];
        money %= arr[idx];
      }
    }
    System.out.println(result);
    br.close();
  }
}