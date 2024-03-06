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
    int idx = n - 1;
    int result = 0;
    while (money != 0) {
      if (arr[idx] > money) {
        idx--;
      } else {
        result += money / arr[idx];
        money %= arr[idx];
      }
    }
    System.out.println(result);
    br.close();
  }
}