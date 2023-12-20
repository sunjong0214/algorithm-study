import java.io.*;
import java.util.Scanner;
import java.lang.*;

public class bj1475 {
  public static void main (String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String n = br.readLine();
    int[] arr = new int[10];
    int max = 0;
    int temp = 0;
    for (int i=0; i<n.length(); i++) {
      temp = n.charAt(i);
      arr[temp-48]++;
    }
    max = (arr[6] + arr[9]) / 2;
    if ((arr[6] + arr[9]) % 2 == 1) {
      max++;
    }
    for (int i=0; i<arr.length; i++) {
      if (i == 6 || i == 9){
        continue;
      }
      if (arr[i] > max) {
        max = arr[i];
      }
    }
    bw.write(max + "\n");
    br.close();
    bw.flush();
    bw.close();
  }
}