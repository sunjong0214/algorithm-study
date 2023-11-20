import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj10250 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    StringTokenizer st;
    int n = Integer.parseInt(br.readLine());
    for(int i=0; i<n; i++){
      st = new StringTokenizer(br.readLine(), " ");
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      int z = Integer.parseInt(st.nextToken());

      int room = 1;
      while((x-z)<0){
        z = z-x;
        room++;
      }
      if(room<10)
        z = z*10;
      bw.write(z+ "" + room + "\n");
    }
    br.close();
    bw.flush();
    bw.close();
  }
}
