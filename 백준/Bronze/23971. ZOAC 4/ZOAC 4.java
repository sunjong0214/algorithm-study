import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int h = Integer.parseInt(st.nextToken()); // 세로 최대 값
    int w = Integer.parseInt(st.nextToken()); // 가로 최대 값
    int n = Integer.parseInt(st.nextToken()); // 세로
    int m = Integer.parseInt(st.nextToken()); // 가로

    int y = h / (n + 1); // 세로 몇개 들어갈 수 있는지
    if (h % (n + 1) != 0) {
      y++;
    }
    int x = w / (m + 1); // 가로 몇개 들어갈 수 있는지
    if (w % (m + 1) != 0) {
      x++;
    }
    System.out.println(y*x);
  }
}
