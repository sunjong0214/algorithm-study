import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    HashMap<String, String> map = new HashMap<>();
    String url;
    String pwd;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      url = st.nextToken();
      pwd = st.nextToken();
      map.put(url, pwd);
    }
    for (int i =0; i < m; i++) {
      bw.write(map.get(br.readLine()) + "\n");
    }
    br.close();
    bw.close();
  }
}
