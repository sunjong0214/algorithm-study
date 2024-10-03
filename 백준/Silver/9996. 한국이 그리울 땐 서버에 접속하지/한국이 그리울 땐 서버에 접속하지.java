import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String patten = br.readLine();
        String[] split = patten.split("\\*");
        for (int i = 0; i < n; i++) {
            boolean isP = true;
            String file = br.readLine();
            for (int j = 0; j < split[0].length(); j++) {
                if (file.charAt(j) != split[0].charAt(j)) {
                    bw.write("NE\n");
                    isP = false;
                    break;
                }
            }
            if (!isP) continue;
            file = file.substring(split[0].length());
            int sIdx = 1;
            for (int j = split[1].length() - 1; j >= 0; j--) {
                if (file.length() < split[1].length() || file.charAt(file.length() - sIdx++) != split[1].charAt(j)) {
                    bw.write("NE\n");
                    isP = false;
                    break;
                }
            }
            if (!isP) continue;
            bw.write("DA\n");
        }
        br.close();
        bw.close();
    }
}
