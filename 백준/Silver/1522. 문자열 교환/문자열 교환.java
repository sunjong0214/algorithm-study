import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        // 가장 큰 b는 움직이지 않는다 -> 제거 가능
        // 그 뒤로 b를 한 곳으로 모으는 수
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a') {
                count++;
            }
        }

        int length = str.length();
        str = str + str + str;

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            String temp = str.substring(i, i + count);
            int tempMin = 0;
            for (int j = 0; j < temp.length(); j++) {
                if (temp.charAt(j) == 'b') {
                    tempMin++;
                }
            }
            min = Math.min(min, tempMin);
        }

        bw.write(min + "");
        br.close();
        bw.close();
    }
}