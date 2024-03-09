import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    String[] arr = new String[n];

    for (int i = 0; i < n; i++) {
      arr[i] = br.readLine();
    }

    Arrays.sort(arr, new Comparator<String>() {
      @Override
      public int compare(String s1, String s2) {
        String[] arr1 = s1.split(" ");
        String[] arr2 = s2.split(" ");
        if (arr1[1].equals(arr2[1])) {
          if (arr1[2].equals(arr2[2])) {
            if (arr1[3].equals(arr2[3])) {
              return arr1[0].compareTo(arr2[0]);
            }
            return Integer.parseInt(arr2[3]) - Integer.parseInt(arr1[3]);
          }
          return Integer.parseInt(arr1[2]) - Integer.parseInt(arr2[2]);
        }
        return Integer.parseInt(arr2[1]) - Integer.parseInt(arr1[1]);
      }
    });

    for (String s : arr) {
      String[] temp = s.split(" ");
      bw.write(temp[0] + "\n");
    }
    br.close();
    bw.close();
  }
}
