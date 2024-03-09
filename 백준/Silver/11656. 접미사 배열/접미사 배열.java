import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String str = br.readLine();
    String[] arr = new String[str.length()];
    for (int i = 0; i < str.length(); i++) {
      arr[i] = str.substring(i, str.length());
    }

    Arrays.sort(arr);

    for (String s : arr) {
      bw.write(s + "\n");
    }
    br.close();
    bw.close();
  }
}