import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    HashSet<String> set = new LinkedHashSet<>();
    for (int i = 0; i < m; i++) {
      String str = br.readLine();
      if (set.contains(str)) {
        set.remove(str);
      }
      set.add(str);
    }
    for (String str : set) {
      if (n-- == 0) {
        break;
      }
      bw.write(str + "\n");
    }
    br.close();
    bw.close();
  }
}
