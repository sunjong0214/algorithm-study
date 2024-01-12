import java.io.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String str = br.readLine();
    StringTokenizer st = new StringTokenizer(str, " ");
    int n = Integer.parseInt(st.nextToken()); // 큐의 사이즈
    int x = Integer.parseInt(st.nextToken()); // 뽑아내려고 하는 수
    str = br.readLine();
    st = new StringTokenizer(str, " ");
    LinkedList<Integer> deque = new LinkedList<>();
    for (int i = 1; i <= n; i++) {
      deque.addLast(i);
    }
    int result = 0;
    while (x != 0) {
      int num = Integer.parseInt(st.nextToken());
      int idx = deque.indexOf(num);
      if (idx > deque.size() / 2) {
        while (deque.peekFirst() != num) {
          deque.offerFirst(deque.pollLast());
          result++;
        }
        deque.pollFirst();
        x--;
      } else {
        while (deque.peekFirst() != num) {
          deque.offerLast(deque.pollFirst());
          result++;
        }
        deque.pollFirst();
        x--;
      }
    }
    bw.write(result + "");
    br.close();
    bw.close();
  }
}
