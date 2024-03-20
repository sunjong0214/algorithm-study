import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  static int[][] D;
  static int[][] house;
  static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    N = Integer.parseInt(br.readLine());
    D = new int[N + 5][3];
    house = new int[N + 5][3];
    StringTokenizer st;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      house[i][0] = Integer.parseInt(st.nextToken());
      house[i][1] = Integer.parseInt(st.nextToken());
      house[i][2] = Integer.parseInt(st.nextToken());
    }
    D[0][0] = house[0][0];
    D[0][1] = house[0][1];
    D[0][2] = house[0][2];
    func(1);
    bw.write(Math.min(D[N - 1][0], Math.min(D[N - 1][1], D[N - 1][2])) + "\n");
    br.close();
    bw.close();
  }

  static void func(int x) {
    if (x == N) {
      return;
    }
    D[x][0] = Math.min(D[x - 1][1], D[x - 1][2]) + house[x][0];
    D[x][1] = Math.min(D[x - 1][0], D[x - 1][2]) + house[x][1];
    D[x][2] = Math.min(D[x - 1][0], D[x - 1][1]) + house[x][2];
    func(x + 1);
  }
}