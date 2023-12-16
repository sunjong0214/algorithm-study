import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class bj1181 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    String[] str = new String[n];
    int i = 0;

    for (i=0; i<n; i++) {
      str[i] = br.readLine();
    }

    Arrays.sort(str, new Comparator<String>() {
     
      public int compare(String a, String b) {
        if(a.length() == b.length()) {
          return a.compareTo(b);
        } else {
          return a.length()-b.length();
        }
      }
    });
    bw.write(str[0] + "\n");
    for ( i=1; i<str.length; i++) {
      if (str[i].equals(str[i-1])) {
        continue;
      }
      bw.write(str[i] + "\n");
    }
    br.close();
    bw.flush();
    bw.close();
  }
}
