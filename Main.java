import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String str = br.readLine();
    int[] alpabat = new int[26];
    for (int i =0; i<str.length(); i++) {
      alpabat[str.charAt(i)-97]++;
    }
    for (int result : alpabat) {
      bw.write(result + " ");
    }
    br.close();
    bw.close();
  }
}
