import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    HashMap<String, String> map = new HashMap<>();

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      map.put(st.nextToken(), st.nextToken());
    }

    ArrayList<String> keySet = new ArrayList<>(map.keySet());
    keySet.sort(Comparator.reverseOrder());
    for (String str : keySet) {
      if (map.get(str).equals("enter")) {
        System.out.println(str);
      }
    }
  }
}
