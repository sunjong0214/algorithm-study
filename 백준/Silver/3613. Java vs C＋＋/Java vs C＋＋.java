import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String variable = br.readLine();
        String[] split = variable.split("_");
        StringBuilder sb = new StringBuilder();
        if (split.length <= 1) {
            for (int i = 0; i < variable.length(); i++) {
                if (variable.charAt(i) >= 97 && variable.charAt(i) <= 122) {
                    sb.append(variable.charAt(i));
                } else if (sb.length() != 0 && variable.charAt(i) <= 90 && variable.charAt(i) >= 65) {
                    sb.append("_").append(Character.toChars(variable.charAt(i) + 32));
                } else {
                    sb = new StringBuilder("Error!");
                    bw.write(sb + "");
                    br.close();
                    bw.close();
                    return;
                }
            }
        } else {
            for (int i = 0; i < split.length; i++) {
                if (split[i].length() == 0) {
                    sb = new StringBuilder("Error!");
                    bw.write(sb + "");
                    br.close();
                    bw.close();
                    return;
                }
                for (int j = 0; j < split[i].length(); j++) {
                    if (sb.length() != 0 && i != 0 && j == 0 && split[i].charAt(j) >= 90 && variable.charAt(i) <= 122) {
                        sb.append(Character.toChars(split[i].charAt(0) - 32));
                    } else if (split[i].charAt(j) >= 97 && variable.charAt(i) >= 65) {
                        sb.append(split[i].charAt(j));
                    } else {
                        sb = new StringBuilder("Error!");
                        bw.write(sb + "");
                        br.close();
                        bw.close();
                        return;
                    }
                }
            }
        }
        bw.write(sb + "");
        br.close();
        bw.close();
    }
}
