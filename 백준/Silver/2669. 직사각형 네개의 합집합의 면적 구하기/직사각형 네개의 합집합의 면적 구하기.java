import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st;
    boolean[][] arr = new boolean[100][100];
    // 1 - 2 는 왼쪽 아래 x,y 3 - 4 는 오른쪽 위
    for (int i = 0; i < 4; i++) {
      st = new StringTokenizer(br.readLine());
      int leftX = Integer.parseInt(st.nextToken());
      int leftY = Integer.parseInt(st.nextToken());
      int rightX = Integer.parseInt(st.nextToken());
      int rightY = Integer.parseInt(st.nextToken());
      
      for (int j = leftX; j < leftX + rightX - leftX; j++) {
        for (int z = leftY; z < leftY + rightY - leftY; z++) {
          arr[j][z] = true;
        }
      }
    }

    int result = 0;
    for (int i = 0; i < 100; i++) {
      for (int j = 0; j < 100; j++) {
        if (arr[i][j]) result++;
      }
    }

    bw.write(String.valueOf(result));
    br.close();
    bw.close();
  }
}