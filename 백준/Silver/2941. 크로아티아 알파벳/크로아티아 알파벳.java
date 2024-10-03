import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == 'c') {
                if (i + 1 < str.length() && (str.charAt(i + 1) == '=' || str.charAt(i + 1) == '-')) {
                    i++;
                }
            } else if (c == 'd') {
                if (i + 1 < str.length() && str.charAt(i + 1) == '-') {
                    i++;
                } else if (i + 2 < str.length() && str.charAt(i + 1) == 'z' && str.charAt(i + 2) == '=') {
                    i += 2;
                }
            } else if (c == 'l') {
                if (i + 1 < str.length() && str.charAt(i + 1) == 'j') i++;
            } else if (c == 'n') {
                if (i + 1 < str.length() && str.charAt(i + 1) == 'j') i++;
            } else if (c == 's') {
                if (i + 1 < str.length() && str.charAt(i + 1) == '=') i++;
            } else if (c == 'z') {
                if (i + 1 < str.length() && str.charAt(i + 1) == '=') i++;
            }
            result++;
        }
        bw.write(result + "");
        br.close();
        bw.close();
    }
}
