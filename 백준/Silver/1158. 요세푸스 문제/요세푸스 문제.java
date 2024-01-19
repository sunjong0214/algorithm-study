import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    Queue<Integer> list = new LinkedList<>();
    Queue<Integer> temp = new LinkedList<>();
    for (int i = 1; i <= n; i++) {
      list.offer(i);
    }
    int idx = k;
    StringBuilder sb = new StringBuilder();
    sb.append("<");
    while (n != 0) {
      if (list.isEmpty()) {
        list = temp;
      }
      if (idx != 1) {
        temp.offer(list.poll());
        idx--;
      } else {
        idx = k;
        n--;
        if (n != 0) {
          sb.append(list.poll() + ", ");
        } else {
          sb.append(list.poll());
        }
      }
    }
    sb.append(">");
    System.out.println(sb);
    br.close();
  }
}
