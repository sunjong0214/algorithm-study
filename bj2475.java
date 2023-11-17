import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj2475 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine()," ");
    int sum = 0;
    int result = 0;
    while(st.hasMoreTokens()){
      int x = 0;
      x = Integer.parseInt(st.nextToken());
      sum = x*x+sum;
    }
    result = sum %  10;
    bw.write(result + "\n");
    br.close();
    bw.flush();
    bw.close();
  }
}
