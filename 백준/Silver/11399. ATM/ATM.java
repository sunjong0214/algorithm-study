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
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      int time = Integer.parseInt(st.nextToken());
      arr[i] = time;
    }
    Arrays.sort(arr);
    int result = 0;
    int sum = 0;
    for (int i = 0; i < n; i++) {
      result += sum + arr[i];
      sum += arr[i];
    }
    bw.write(result + "\n");
    br.close();
    bw.close();
  }
}