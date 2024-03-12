import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
  static class Group {
    String[] member;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    Map<String, Group> map = new HashMap<>();
    Map<String, String> map2 = new HashMap<>();
    for (int i = 0; i < n; i++) {
      String name = br.readLine();
      int num = Integer.parseInt(br.readLine());
      Group group = new Group();
      group.member = new String[num];
      for (int j = 0; j < num; j++) {
        String member = br.readLine();
        group.member[j] = member;
        map2.put(member, name);
      }
      map.put(name, group);
    }
    for (int i = 0; i < m; i++) {
      String name = br.readLine();
      int quizNum = Integer.parseInt(br.readLine());
      if (quizNum == 1) {
        bw.write(map2.get(name) + "\n");
      } else {
        String[] member = map.get(name).member;
        Arrays.sort(member);
        for (String s : member) {
          bw.write(s + "\n");
        }
      }
    }
    br.close();
    bw.close();
  }
}