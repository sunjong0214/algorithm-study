import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, s, g;
    static boolean[] isVisited;
    static int[] building;
    static int u;
    static int d;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        isVisited = new boolean[n];
        building = new int[n];
        s = Integer.parseInt(st.nextToken()) - 1;
        g = Integer.parseInt(st.nextToken()) - 1;
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        isVisited[s] = true;
        building[g] = -1;
        q.offer(s);
        if (s == g) {
            bw.write(0 + "");
        } else {
            while (!q.isEmpty() && q.peek() != g) {
                int idx = q.poll();
                up(idx, u);
                down(idx, d);
            }
            int result = building[g];
            if (result == -1) {
                bw.write("use the stairs");
            } else {
                bw.write(String.valueOf(result));
            }
        }
        br.close();
        bw.close();
    }

    private static void down(int idx, int d) {
        int uIdx = idx - d;
        if (uIdx < 0 || uIdx >= n) {
            return;
        }
        if (isVisited[uIdx]) {
            building[uIdx] = Math.min(building[idx] + 1, building[uIdx]);
            return;
        }
        q.offer(uIdx);
        isVisited[uIdx] = true;
        if (building[uIdx] <= 0) {
            building[uIdx] = building[idx] + 1;
        } else {
            building[uIdx] = Math.min(building[idx] + 1, building[uIdx]);
        }
    }

    private static void up(int idx, int move) {
        int uIdx = idx + move;
        if (uIdx < 0 || uIdx >= n) {
            return;
        }
        if (isVisited[uIdx]) {
            building[uIdx] = Math.min(building[idx] + 1, building[uIdx]);
            return;
        }
        q.offer(uIdx);
        isVisited[uIdx] = true;
        if (building[uIdx] <= 0) {
            building[uIdx] = building[idx] + 1;
        } else {
            building[uIdx] = Math.min(building[idx] + 1, building[uIdx]);
        }
    }
}