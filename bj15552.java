import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 15552
 */
public class bj15552 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    StringTokenizer st;

    for(int i=0; i<n; i++){
      st = new StringTokenizer(br.readLine()," "); //공백을 기준으로 토큰화

      bw.write((Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())) + "\n"); //nextToken = 토큰을 하나씩 꺼내옴
    }
    br.close();
    bw.flush(); //남아있는 데이터 출력 이걸 해줘야 결과가 나옴
    bw.close();
  }
}