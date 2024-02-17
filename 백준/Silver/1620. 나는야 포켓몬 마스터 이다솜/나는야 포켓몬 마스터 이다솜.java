import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    HashMap<String, Integer> map = new HashMap<>();
    HashMap<Integer, String> map2 = new HashMap<>();
    for (int i = 1; i <= n; i++) {
      String str = br.readLine();
      map.put(str, i);
      map2.put(i, str);
    }
    // List<String> keySet = new ArrayList<>(map.keySet());
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < m; i++) {
      String str = br.readLine();
      if (str.charAt(0) >= 65) {
        sb.append(map.get(str) + "\n");
      } else {
        sb.append(map2.get(Integer.parseInt(str)) + "\n");
      }

      // for (Map.Entry<Integer, String> e : map.entrySet()) {
      //   int key = e.getKey();
      //   String value = e.getValue();

      //   if (Integer.toString(key).equals(str)) {
      //     sb.append(value + "\n");
      //     break;
      //   } 
      //   if (value.equals(str)) {
      //     sb.append(key + "\n");
      //     break;
      //   }
      // }
    }
    sb.deleteCharAt(sb.length() - 1);
    System.out.println(sb);
  }
}
