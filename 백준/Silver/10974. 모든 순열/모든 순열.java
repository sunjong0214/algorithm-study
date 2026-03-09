import java.io.*;

public class Main {
    static int[] arr;
    static boolean[] selected;
    static int n;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());


        arr = new int[n];
        selected = new boolean[n + 1];

        func(0);

        br.close();
        bw.close();
    }

    static void func(int depth) throws IOException {
        if (depth == n) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(arr[i]).append(" ");
            }
            bw.write(sb.toString() + "\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (selected[i]) continue;
            selected[i] = true;
            arr[depth] = i;
            func(depth + 1);
            selected[i] = false;
        }
    }
}
