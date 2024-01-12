import java.io.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    Deque<Integer> deque = new LinkedList<>();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      String str = br.readLine();
      StringTokenizer st = new StringTokenizer(str, " ");
      switch (st.nextToken()) {
        case "push_front":
          deque.addFirst(Integer.parseInt(st.nextToken()));
          break;
        case "push_back":
          deque.addLast(Integer.parseInt(st.nextToken()));
          break;
        case "pop_front":
          if (deque.isEmpty())
            sb.append(-1 + "\n");
          else
            sb.append(deque.removeFirst() + "\n");
          break;
        case "pop_back":
          if (deque.isEmpty())
            sb.append(-1 + "\n");
          else
            sb.append(deque.removeLast() + "\n");
          break;
        case "size":
          sb.append(deque.size() + "\n");
          break;
        case "empty":
          if (!deque.isEmpty())
            sb.append(0 + "\n");
          else
            sb.append(1 + "\n");
          break;
        case "front":
          if (deque.isEmpty())
            sb.append(-1 + "\n");
          else
            sb.append(deque.peekFirst() + "\n");
          break;
        case "back":
          if (deque.isEmpty())
            sb.append(-1 + "\n");
          else
            sb.append(deque.peekLast() + "\n");
          break;
      }
    }
    bw.write(sb + "");
    br.close();
    bw.close();
  }
}