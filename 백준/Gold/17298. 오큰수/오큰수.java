import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    Stack<Integer[]> stack = new Stack<>();
    int N = Integer.parseInt(br.readLine());
    Integer[][] arr = new Integer[N][2];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i][0] = Integer.parseInt(st.nextToken());
      arr[i][1] = i;
    }


    for (int i = 0; i < N; i++) {
      if (stack.isEmpty()) {
        stack.push(arr[i]);
        continue;
      }
      if (stack.peek()[0] > arr[i][0]) {
        stack.push(arr[i]);
      } else {
        while (!stack.isEmpty() && stack.peek()[0] < arr[i][0]) {
          stack.pop()[0] = arr[i][0];
        }
        stack.push(arr[i]);
      }
    }

    while (!stack.isEmpty()) {
      stack.pop()[0] = -1;
    }
    for (int i=0; i<N; i++) {
      bw.write(arr[i][0] + " ");
    }
    br.close();
    bw.close();
  }
}