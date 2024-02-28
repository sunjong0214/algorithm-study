import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int[] cnt = new int[2000001];

    int n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      int temp = Integer.parseInt(br.readLine());
      cnt[temp + 1000000]++;
    }

    for (int i = 2000000; i >= 0; i--) {
      while (cnt[i] > 0) {
        bw.write((i-1000000) + "\n");
        cnt[i]--;
      }
    }
    br.close();
    bw.close();
  }
}
