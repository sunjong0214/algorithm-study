import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static StringBuilder sb;
    static int[] nums;
    static boolean[] visited;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            sb = new StringBuilder();
            if (n == 0) break;

            nums = new int[n];
            visited = new boolean[n];
            arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            back(0, 0);
            bw.write(sb.toString() + "\n");
        }

        br.close();
        bw.close();
    }

    private static void back(int at, int depth) {
        if (depth == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(nums[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = at; i < n; i++) {
            if (visited[i]) continue;
            nums[depth] = arr[i];
            visited[i] = true;
            back(i + 1, depth + 1);
            visited[i] = false;
        }
    }

}