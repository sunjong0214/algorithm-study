import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * bj1001
 */
public class bj1008 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st;

    st = new StringTokenizer(br.readLine(), " ");
    bw.write((Double.parseDouble(st.nextToken()) / Double.parseDouble(st.nextToken())+"\n"));
    br.close();
    bw.flush();
    bw.close();

  }
}