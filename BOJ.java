import java.io.*;
import java.util.Scanner;
import java.lang.*;

public class BOJ {
  public static void main (String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[10];
    int max = 0;
    int temp = 0;
    int second = 0;
    while (n > 0) {
      temp = n%10;
      // if(temp == 9) {
      //   temp = 6;
      // }
      arr[temp]++;
      if (max < arr[temp]) {
        second = temp;
        max = arr[temp];
      }
      n = n/10;
    }
    if (max <= (arr[6]+arr[9])) {
      max = (arr[6]+arr[9])/2;
      if (arr[second] > max) {
        max = arr[second];
      }
    }
    bw.write(max + "\n");
    br.close();
    bw.flush();
    bw.close();
  }
}