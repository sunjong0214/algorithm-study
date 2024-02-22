import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    StringTokenizer st;
    for (int i = 0; i < n; i++) {
      int m = Integer.parseInt(br.readLine());
      HashMap<String, Integer> map = new HashMap<>();
      for (int j = 0; j < m; j++) {
        st = new StringTokenizer(br.readLine());
        String temp = st.nextToken();
        String type = st.nextToken();
        int count = 1;
        if (map.containsKey(type)) {
          count = map.get(type);
          count++;
        }
        map.put(type, count);
      }
      List<String> list = new ArrayList<>(map.keySet());
      int result = 1;
      for (String str : list) {
        result *= map.get(str) + 1;
      }
      bw.write(result - 1 + "\n");
    }
    br.close();
    bw.close();
  }
}
