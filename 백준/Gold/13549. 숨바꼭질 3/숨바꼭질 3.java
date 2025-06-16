import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int k;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        isVisited = new boolean[100001];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{n, 0});
        isVisited[n] = true;

        int min = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            isVisited[poll[0]] = true;
            if (poll[0] == k) {
                min = Math.min(min, poll[1]);
            }

            if (poll[0] * 2 < 100001 && !isVisited[poll[0] * 2]) {
                q.offer(new int[]{poll[0] * 2, poll[1]});
            }
            if (poll[0] + 1 < 100001 && !isVisited[poll[0] + 1]) {
                q.offer(new int[]{poll[0] + 1, poll[1] + 1});
            }
            if (poll[0] - 1 >= 0 && !isVisited[poll[0] - 1]) {
                q.offer(new int[]{poll[0] - 1, poll[1] + 1});
            }
        }

        bw.write(String.valueOf(min));
        br.close();
        bw.close();
    }
}