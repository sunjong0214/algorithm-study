import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    long n = Long.parseLong(st.nextToken());
    long c = Long.parseLong(st.nextToken());

    Map<Long, Integer> map = new LinkedHashMap<>();
    st = new StringTokenizer(br.readLine());

    int max = 0;
    for (int i = 0; i < n; i++) {
      long num = Long.parseLong(st.nextToken());
      map.put(num, map.getOrDefault(num, 0) + 1);
      if (max < map.get(num)) {
        max = map.get(num);
      }
    }
    while (!map.isEmpty()) {
      List<Long> list = new ArrayList<>(map.keySet());
      for (long num : list) {
        if (map.get(num) == max) {
          for (int i = 0; i < map.get(num); i++) {
            bw.write(num + " ");
          }
          map.remove(num);
        }
      }
      max--;
    }
    br.close();
    bw.close();
  }
}