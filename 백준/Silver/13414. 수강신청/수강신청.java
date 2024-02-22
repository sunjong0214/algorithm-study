import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    HashMap<String, Integer> map = new HashMap<>();
    String[] priority = new String[m];
    for (int i = 0; i < m; i++) {
      map.put(br.readLine(), i);
    }
    List<String> list = new ArrayList<>(map.keySet());
    for (int i = 0; i < list.size(); i++) {
      priority[map.get(list.get(i))] = list.get(i);
    }
    int i = 0;
    while (n != 0) {
      if (i == priority.length) {
        break;
      }
      if (priority[i] == null) {
        i++;
        continue;
      } else {
        System.out.println(priority[i]);
        i++;
        n--;
      }
    }
  }
}
