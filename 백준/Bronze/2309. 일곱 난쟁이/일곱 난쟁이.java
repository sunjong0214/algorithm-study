import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] arr = new int[9];
    for (int i = 0; i < 9; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }
    Arrays.sort(arr);
    int sum = 0;
    int i = 0;
    while (i < 9) {
      sum += arr[i++];
    }
    int x = 0;
    int temp = 0;
    int temp2 = 0;
    loop: for (int j = 0; j < arr.length - 1; j++) {
      for (int k = j + 1; k < arr.length; k++) {
        x = arr[j] + arr[k];
        if (sum - 100 == x) {
          temp = arr[k];
          temp2 = arr[j];
          break loop;
        }
      }
    }
    for (int z = 0; z < i; z++) {
      if (arr[z] == temp || arr[z] == temp2) {
        continue;
      }
      System.out.println(arr[z]);
    }
    br.close();
  }
}