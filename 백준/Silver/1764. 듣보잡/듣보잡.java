import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    Map<String, String> map = new HashMap<>();
    Map<String, String> rMap = new HashMap<>();
    for (int i = 0; i < n; i++) {
      map.put(br.readLine(), "listen");
    }
    for (int i = 0; i < m; i++) {
      String str = br.readLine();
      if (map.get(str) != null) {
        rMap.put(str, str);
      }
    }
    List<String> list = new ArrayList<>(rMap.keySet());
    Collections.sort(list, (s1, s2) -> {
      for (int i = 0; i < 20; i++) {
        if (i == s1.length() || i == s2.length()) {
          break;
        }
        if (s1.charAt(i) != s2.charAt(i)) {
          return s1.charAt(i) - s2.charAt(i);
        }
      }
      return s1.length() - s2.length();
    });
    bw.write(list.size() + "\n");
    for (String str : list) {
      bw.write(str + "\n");
    }
    br.close();
    bw.close();
  }
}