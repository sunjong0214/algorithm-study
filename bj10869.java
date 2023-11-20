import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * bj10869
 */
public class bj10869 {

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int x = Integer.parseInt(st.nextToken());
    int y = Integer.parseInt(st.nextToken());
    bw.write((x+y) + "\n" + (x-y) + "\n" + (x*y) + "\n" + (x/y) + "\n" + (x%y) + "\n");
    br.close();
    bw.flush();
    bw.close();
  }
}