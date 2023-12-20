import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj3273 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[1000001];
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int x = Integer.parseInt(br.readLine());
    int result = 0;
    while (st.hasMoreTokens()) {
      if (x > 1000000){
        break;
      }
      int index = Integer.parseInt(st.nextToken());
      int sum = x-index;
      if(sum < 0) {
        continue;
      }
      if (arr[index] == 1) {
        result++;
      }
      arr[x-index]++;
    }
    bw.write(result + "\n");
    br.close();
    bw.flush();
    bw.close();
  }
}
