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
                        a[4]++;
                        return 0;
                    }
                }
            }
        });

        for (int i = 0; i < n; i++) {
            if (arr[i][0] == k) {
                if (arr[i][4] == 0) {
                    bw.write((i + 1) + "");
                } else {
                    for (int j = i - 1; j >= 0; j--) {
                        if (arr[j][4] == 0) {
                            bw.write((j + 1) + "");
                            break;
                        }
                    }
                }
            }
        }

        br.close();
        bw.close();
    }
}