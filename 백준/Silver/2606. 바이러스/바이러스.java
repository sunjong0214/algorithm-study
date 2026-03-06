import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        graph = new int[n + 1][n + 1];
        visited = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());

            graph[to][from] = 1;
            graph[from][to] = 1;
        }

        search(1, n);

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (visited[i]) cnt++;
        }

        bw.write((cnt - 1) + "");
        br.close();
        bw.close();
    }

    static void search(int start, int n) {
        if (start > n) return;
        if (visited[start]) return;

        visited[start] = true;
        for (int i = 1; i <= n; i++) {
            if (graph[start][i] == 1) {
                search(i, n);
            }
        }
    }
}