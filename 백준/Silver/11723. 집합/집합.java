import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    LinkedList<Character> list = new LinkedList<>();

    int n = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    while (n-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String cmd = st.nextToken();

      if (cmd.equals("add")) {
        list.addLast((st.nextToken()).charAt(0));
      } else if (cmd.equals("remove")) {
        char item = (char) (Integer.parseInt(st.nextToken()) + 48);
        list.remove((Character) item);
      } else if (cmd.equals("check")) {
        char item = (char) (Integer.parseInt(st.nextToken()) + 48);
        if (list.contains(item)) {
          sb.append("1\n");
        } else {
          sb.append("0\n");
        }
      } else if (cmd.equals("toggle")) {
        char item = (char) (Integer.parseInt(st.nextToken()) + 48);
        if (list.contains(item)) {
          list.remove((Character) item);
        } else {
          list.add(item);
        }
      } else if (cmd.equals("all")) {
        list.clear();
        for (int i = 1; i <= 20; i++) {
          list.addLast((char) (i+48));
        }
      } else {
        list.clear();
      }
    }
    if (sb.length() != 0) {
      sb.deleteCharAt(sb.length() - 1);
    }
    bw.write(sb + "");
    br.close();
    bw.close();
  }
}
