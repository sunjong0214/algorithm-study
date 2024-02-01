import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringBuilder st = new StringBuilder();
    st = tower(1, 3, n, st);
    System.out.println(st.length() / 4);
    st.deleteCharAt(st.length()-1);
    System.out.println(st);
  }

  // n을 a -> b로 옮김
  // 그러기 위해선 n-1을 빈 곳으로 옮겨야함
  // 1,2,3 이 있다면 3을 1번 장대->3번 장대로 옮기고 싶을 때
  // 1,2를 2번 장대로 옮긴 뒤, 남은 3을 3번 장대로 옮겨야함
  static StringBuilder tower(int a, int b, int n, StringBuilder st) {
    if (n == 0) {
      return st;
    }
    tower(a, 6-(a+b), n-1, st);
    st.append(a + " " + b + "\n");
    tower(6-(a+b), b, n-1, st);
    return st;
  }
}
