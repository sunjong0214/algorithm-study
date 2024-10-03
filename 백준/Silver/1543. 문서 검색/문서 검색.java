import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        String word = br.readLine();
        int size = str.length();
        int result = 0;
        boolean isP = true;
        for (int i = 0; i < size; i++) {
            if (str.charAt(i) == word.charAt(0)) {
                isP = true;
                for (int j = 0; j < word.length(); j++) {
                    if (str.length() - 1 < i + j || str.charAt(j + i) != word.charAt(j)) {
                        isP = false;
                        break;
                    }
                }
                if (isP) {
                    result++;
                    str = str.substring(i + word.length());
                    i = -1;
                    size = str.length();
                }
            }
        }
        bw.write(result + "");
        br.close();
        bw.close();
    }
}
