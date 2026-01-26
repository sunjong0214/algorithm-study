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

    // 남자는 1, 여자는 0 ex) 3학년 남학생 -> 1 3
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int[][] arr = new int[7][2];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int gender = Integer.parseInt(st.nextToken());
      int grade = Integer.parseInt(st.nextToken());
      arr[grade][gender]++;
    }

    int result = 0;
    for (int i = 1; i < 7; i++) {
      for (int j = 0; j < 2; j++) {
        result += (arr[i][j] / k);
        if (arr[i][j] % k != 0) result++;
      }
    }
    bw.write(String.valueOf(result));
    br.close();
    bw.close();
  }
}