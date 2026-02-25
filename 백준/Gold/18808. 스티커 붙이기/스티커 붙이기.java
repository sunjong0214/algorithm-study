import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[][] notebook;
    static int[] degree = {0, 1, 2, 3};
    static int n;
    static int m;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        notebook = new int[n][m];
        List<int[][]> stickers = new ArrayList<>();
        int[] sna = new int[k];
        int[] sma = new int[k];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int sn = Integer.parseInt(st.nextToken());
            int sm = Integer.parseInt(st.nextToken());
            sna[i] = sn;
            sma[i] = sm;
            int[][] sticker = new int[12][12];
            for (int j = 0; j < sn; j++) {
                st = new StringTokenizer(br.readLine());
                for (int z = 0; z < sm; z++) {
                    sticker[j][z] = Integer.parseInt(st.nextToken());
                }
            }
            stickers.add(sticker);
        }
        for (int z = 0; z < k; z++) {
            int sn = sna[z];
            int sm = sma[z];
            int[][] spinSticker = stickers.get(z);
            boolean at = false;
            for (int s = 0; s < 4; s++) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (check(spinSticker, i, j, sn, sm)) {
                            at = true;
                            break;
                        }
                    }
                    if (at) break;
                }
                if (at) break;
                spinSticker = spin(spinSticker, sn, sm);
                int temp = sn;
                sn = sm;
                sm = temp;
            }
        }

        bw.write(max + "");
        br.close();
        bw.close();
    }

    static int[][] spin(int[][] sticker, int sn, int sm) {
        int[][] temp = new int[12][12];
        for (int i = 0; i < sn; i++) {
            for (int j = 0; j < sm; j++) {
                temp[j][sn - 1 - i] = sticker[i][j];
            }
        }
        return temp;
    }

    static boolean check(int[][] sticker, int i, int j, int sn, int sm) {
        if (i + sn > n || j + sm > m) return false;
        for (int si = i; si < i + sn; si++) {
            for (int sj = j; sj < j + sm; sj++) {
                if (notebook[si][sj] == 1 && sticker[si - i][sj - j] == 1) return false;
            }
        }
        for (int si = i; si < i + sn; si++) {
            for (int sj = j; sj < j + sm; sj++) {
                if (notebook[si][sj] == 0 && sticker[si - i][sj - j] == 1) {
                    notebook[si][sj] = 1;
                    max++;
                }
            }
        }
        return true;
    }
}