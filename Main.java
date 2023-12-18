import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int[] num = new int[n];
    int sum = 0;
    for(int i=0; i<n; i++) {
      num[i] = Integer.parseInt(br.readLine());
      sum += num[i];
    }
    int avg = sum/k;
    int count = 0;
    while (count != k) {
      count = 0;
      for (int i=0; i<n; i++) {
        count += num[i]/avg;
      }
      if (count != k) {
        avg--;
      }
    }
    bw.write(avg + "\n");
    br.close();
    bw.flush();
    bw.close();
  }
}
