import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 치킨집 2, 집 1
        // 치킨집 3개 있어 -> 그럼 치킨 0번이 없을 때 , 치킨 1번이 없을 때, 치킨 2번 없을 때, (0, 1) ....
        // 모든 경우의 수 2의 치킨집 수 승
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] city = new int[n][n];

        List<int[]> chicken = new ArrayList<>();
        List<int[]> homes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
                if (city[i][j] == 2) chicken.add(new int[]{i, j});
                if (city[i][j] == 1) homes.add(new int[]{i, j});
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < (1 << chicken.size()); i++) {
            if (Integer.bitCount(i) != m) continue;

            int tempSum = 0;
            int[] dist = new int[homes.size()];
            Arrays.fill(dist, Integer.MAX_VALUE);
            for (int j = 0; j < homes.size(); j++) { // 집에서 확인
                for (int z = 0; z < chicken.size(); z++) {
                    if ((i & (1 << z)) != 0)  // 1이면 뛰어넘기
                        dist[j] = Math.min(dist[j], Math.abs(chicken.get(z)[0] - homes.get(j)[0]) + Math.abs(chicken.get(z)[1] - homes.get(j)[1]));
                }
            }
            for (int dis : dist) {
                if (dis == Integer.MAX_VALUE) continue;
                tempSum += dis;
            }
            min = Math.min(min, tempSum);
        }
        bw.write(min + "");

        br.close();
        bw.close();
    }
}