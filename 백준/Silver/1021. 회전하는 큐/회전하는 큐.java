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

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken()); // 큐의 크기
    int M = Integer.parseInt(st.nextToken()); // 뽑을 수의 개수
    st = new StringTokenizer(br.readLine());

    LinkedList<Integer> q = new LinkedList<>();

    for (int i = 1; i <= N; i++) {
      q.add(i);
    }

    int result = 0;
    for (int i = 0; i < M; i++) {
      int loc = Integer.parseInt(st.nextToken());
      int move = 0;
      for (int j = 0; j < q.size(); j++) {
        if (q.peek() == loc) {
          break;
        }
        q.add(q.remove());
        move++;
      }
      if (move > q.size() / 2) { // 뒤에서 뽑아야하는 경우라면 빼기
        move = Math.abs(move - q.size());
      }
      q.remove();
      result += move;
      if (q.isEmpty()) {
        break;
      }
    }
    bw.write(result + "");
    br.close();
    bw.close();
  }
}
