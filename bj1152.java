import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * bj1152
 */
public class bj1152 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    int i = 0;

    String str = br.readLine();
    st = new StringTokenizer(str," ");
/*     while(st.hasMoreTokens()){
      st.nextToken();
      i++;
    }
*/    
//    bw.write(i + "");
    bw.write(st.countTokens() + "\n"); //토큰의 갯수는 countTokens로 쉽게 출력 가능
    br.close();
    bw.close();
  }
}