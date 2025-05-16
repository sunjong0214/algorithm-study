import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][5];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
            arr[i][3] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (a, b) -> {
            if (a[1] != b[1]) {
                return b[1] - a[1];
            } else {
                if (a[2] != b[2]) {
                    return b[2] - a[2];
                } else {
                    if (a[3] != b[3]) {
                        return b[3] - a[3];
                    } else {
                        return 0;
                    }
                }
            }
        });

        for (int i = 0; i < n; i++) {
            if (i != 0 && arr[i][1] == arr[i - 1][1] && arr[i][2] == arr[i - 1][2] && arr[i][3] == arr[i - 1][3]) {
                if (arr[i - 1][4] != 0) {
                    arr[i][4] = arr[i - 1][4];
                } else {
                    arr[i][4] = i - 1;
                }
            }
            if (arr[i][0] == k) {
                if (arr[i][4] == 0) {
                    bw.write((i + 1) + "");
                } else {
                    bw.write((arr[i][4] + 1) + "");
                }
            }
        }

        br.close();
        bw.close();
    }
}