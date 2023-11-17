import java.io.*;
import java.util.StringTokenizer;

public class bj2675 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    char[] arr = new char[20];
    int x = Integer.parseInt(br.readLine());
    for(int j=0; j<x; j++){
      StringTokenizer st = new StringTokenizer(br.readLine()," ");
      int rep;
      String alpa;
      rep = Integer.parseInt(st.nextToken());
      alpa = st.nextToken();
      for(int i=0; i<alpa.length(); i++){
        arr[i] = alpa.charAt(i);
        for(int k=0; k<rep; k++){
          bw.write(arr[i]+"");
        }
      }
      bw.write("\n");
    }
    br.close();
    bw.flush();
    bw.close();
  }
}
