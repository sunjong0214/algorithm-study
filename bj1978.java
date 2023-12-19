import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * bj1978
 */
public class bj1978 {

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    int result = 0;
    for (int j=0; j<n; j++) {
      int count = 0;
      int x = Integer.parseInt(st.nextToken());
      if (x == 1) {
        continue;
      }
      for (int i=x-1; i>=2; i--){
        if( x%i == 0) {
          count++;
          break;
        }
      }
      if (x == 2) {
        count = 0; 
      }
      if(count == 0) {
        result++;
      }
    }
    bw.write(result + "\n");
    br.close();
    //bw.flush();
    bw.close();
  }
}