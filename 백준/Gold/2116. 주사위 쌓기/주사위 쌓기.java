import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new int[6]);
            list.get(i)[0] = Integer.parseInt(st.nextToken());
            list.get(i)[1] = Integer.parseInt(st.nextToken());
            list.get(i)[2] = Integer.parseInt(st.nextToken());
            list.get(i)[3] = Integer.parseInt(st.nextToken());
            list.get(i)[4] = Integer.parseInt(st.nextToken());
            list.get(i)[5] = Integer.parseInt(st.nextToken());
        }

        int[] top = {0, 1, 2, 3, 4, 5};
        int[] bottom = {5, 3, 4, 1, 2, 0};

        int max = 0;
        for (int i = 0; i < 6; i++) {
            // 모든 경우의 수 탐색 -> bottom과 같을 때 최대값, 근데 같은 값이 여러개있을 수 있으니 모두 확인
            int tTop = list.get(0)[top[i]];
            int tBottom = list.get(0)[bottom[i]];
            int tMax = 0;
            for (int j = 0; j < 6; j++) {
                if (j != top[i] && j != bottom[i]) {
                    tMax = Math.max(tMax, list.get(0)[j]);
                }
            }
            for (int j = 1; j < n; j++) {
                // 각 면이 bottom과 같은지 확인
                // 확인 후 max 값 확인
                int checkMax = 0;
                for (int z = 0; z < 6; z++) {
                    if (tBottom == list.get(j)[z]) {
                        for (int k = 0; k < 6; k++) {
                            if (k != top[z] && k != bottom[z])
                                checkMax = Math.max(checkMax, list.get(j)[k]);
                        }
                        tTop = list.get(j)[top[z]];
                        tBottom = list.get(j)[bottom[z]];
                        break;
                    }
                }
                tMax += checkMax;
            }
            max = Math.max(max, tMax);
        }

        bw.write(max + "");
        br.close();
        bw.close();
    }
}