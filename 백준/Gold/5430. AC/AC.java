import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine()); // 테스트 횟수
    LinkedList<Integer> deque = new LinkedList<>();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      String command = br.readLine(); // 명령어
      int size = Integer.parseInt(br.readLine()); // 배열 크기
      deque = arrSplits(br.readLine(), size); // 배열 입력 받은거 숫자로 나누기
      try {
        if (process(command, deque) == false) {
          sb.append("[");
          while (!deque.isEmpty()) {
            sb.append(deque.pollLast());
            if (!deque.isEmpty()) {
              sb.append(",");
            }
          }
          sb.append("]\n");
        } else {
          sb.append("[");
          while (!deque.isEmpty()) {
            sb.append(deque.pollFirst());
            if (!deque.isEmpty()) {
              sb.append(",");
            }
          }
          sb.append("]\n");
        }
      } catch (Exception e) {
        sb.append("error\n");
      }
    }
    bw.write(sb + "");
    br.close();
    bw.close();
  }

  static boolean process(String command, LinkedList<Integer> deque) {

    boolean isRight = true;
    for (char cmd : command.toCharArray()) {
      if (cmd == 'R') {
        isRight = !isRight;
        continue;
      }
      if (cmd == 'D' && isRight == true) {
        if (deque.isEmpty()) {
          throw new NoSuchElementException();
        }
        deque.pollFirst();
      } else {
        if (deque.isEmpty()) {
          throw new NoSuchElementException();
        }
        deque.pollLast();
      }
    }
    return isRight;
  }

  static LinkedList<Integer> arrSplits(String str, int idx) {
    StringTokenizer st = new StringTokenizer(str, "[,]");
    LinkedList<Integer> deque = new LinkedList<>();
    while (st.hasMoreTokens()) {
      deque.addLast(Integer.parseInt(st.nextToken()));
    }
    return deque;
  }
}
