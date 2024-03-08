import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    Map<String, Integer> map = new HashMap<>();
    int cnt = 1;
    for (int i = 0; i < n; i++) {
      String str = br.readLine();
      if (map.containsKey(str)) {
        map.put(str, map.get(str) + 1);
      } else {
        map.put(str, cnt);
      }
    }
    List<String> list = new ArrayList<>(map.keySet());
    String s = list.remove(0);
    long result = Long.parseLong(s);
    int min = map.get(s);
    for (String str : list) {
      int temp = map.get(str);
      if (min < temp) {
        result = Long.parseLong(str);
        min = temp;
        continue;
      }
      if (min == temp) {
        if (result  > Long.parseLong(str)) {
          result = Long.parseLong(str);
        }
      }
    }
    bw.write(result + "\n");
    br.close();
    bw.close();
  }
}