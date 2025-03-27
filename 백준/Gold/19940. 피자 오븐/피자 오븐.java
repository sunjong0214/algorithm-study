import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static int t, n;
    static int[] cmd = {60, 10, 1};
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            result = new int[5];
            n = Integer.parseInt(br.readLine());
            int num = n;
            if (num % cmd[0] > 35) {
                result[0] = num / cmd[0] + 1;
                num = num % cmd[0] - cmd[0];
            } else {
                result[0] = num / cmd[0];
                num = num % cmd[0];
            }
            if (num < 0) { // 빼줘야됨
                result[2] = Math.abs(num / cmd[1]);
            } else {
                result[1] = num / cmd[1];
            }
            num %= cmd[1];
            if (Math.abs(num) > 5) {
                if (num < 0) {
                    result[2]++;
                    result[3] = 10 - Math.abs(num);
                } else {
                    result[1]++;
                    result[4] = 10 - num;
                }
            } else {
                if (num < 0) {
                    result[4] = Math.abs(num);
                } else {
                    result[3] = num;
                }
            }
            for (int r : result) {
                bw.write(r + " ");
            }
            bw.write("\n");
        }
        br.close();
        bw.close();
    }
}