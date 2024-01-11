import java.io.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    StringTokenizer st;
    Queue<Integer> queue = new LinkedList<>();
    StringBuilder sb = new StringBuilder();
    int no = 0;
    for (int i = 0; i < n; i++) {
      String str = br.readLine();
      st = new StringTokenizer(str, " ");
      if (str.equals("front")) {
        if (!queue.isEmpty()) {
          sb.append(queue.peek() + "\n");
        } else {
          sb.append(-1 + "\n");
        }
      } else if (str.equals("back")) {
        if (!queue.isEmpty()) {
          sb.append(no + "\n");
        } else {
          sb.append(-1 + "\n");
        }
      } else if (str.equals("size")) {
        sb.append(queue.size() + "\n");
      } else if (str.equals("pop")) {
        if (!queue.isEmpty()) {
          sb.append(queue.poll() + "\n");
        } else {
          sb.append(-1 + "\n");
        }
      } else if (str.equals("empty")) {
        if (queue.isEmpty()) {
          sb.append(1 + "\n");
        } else {
          sb.append(0 + "\n");
        }
      } else if (st.nextToken().equals("push")) { // push
        no = Integer.parseInt(st.nextToken());
        queue.offer(no);
      }
    }
    System.out.print(sb);
    br.close();
    bw.close();
  }
}
