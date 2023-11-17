import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj2920 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int[] arr = new int[8];
    int i = 0;
    int check = 0;
    while(st.hasMoreTokens()){
      arr[i] = Integer.parseInt(st.nextToken());
      if(i != 0 && (arr[i] - arr[i-1] == 1)){
        check = 1;
        i++;
        continue;
      }else if(i != 0 && arr[i] - arr[i-1] == -1){
        check = 2;
        i++;
        continue;
      }else if(i !=0){
        check = 0;
        break;
      }
      i++;
    }
    if(check == 1){
      bw.write("ascending"+"\n");
    }else if(check == 2){
      bw.write("descending"+"\n");
    }else{
      bw.write("mixed"+"\n");
    }
    br.close();
    bw.flush();
    bw.close();
  }
}
