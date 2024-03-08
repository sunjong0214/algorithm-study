import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    String[] arr = new String[n];
    for (int i = 0; i < n; i++) {
      arr[i] = br.readLine();
    }
    Arrays.sort(arr, (s1, s2) -> {
      if (s1.length() != s2.length()) {
        return s1.length() - s2.length();
      } else if (s1.length() == s2.length()) {
        int s1Sum = 0;
        int s2Sum = 0;
        for (int i = 0; i < s1.length(); i++) {
          if (s1.charAt(i) >= 48 && s1.charAt(i) <= 57) {
            s1Sum += (s1.charAt(i)) - 48;
          }
          if (s2.charAt(i) >= 48 && s2.charAt(i) <= 57) {
            s2Sum += s2.charAt(i) - 48;
          }
        }
        if (s1Sum != s2Sum) {
          return s1Sum - s2Sum;
        }
      }
      for (int i = 0; i < s1.length(); i++) {
        if (s1.charAt(i) != s2.charAt(i)) {
          return s1.charAt(i) - s2.charAt(i);
        }
      }
      return 0;
    });
    for (String str : arr) {
      System.out.println(str);
    }
    br.close();
    bw.close();
  }
}