import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    String[] str = new String[n];
    String[] strTemp = new String[n];
    int[] strLen = new int[n];
    String sTemp = null;
    int i = 0;
    int j = 0;
    for (i=0; i<n; i++) {
      str[i] = br.readLine();
      strLen[i] = str[i].length();
    }
    for (i=0; i<str.length; i++){
      for ( j=0; j<str.length; j++) {
        if (strLen[i] < strLen[j]) {
          int temp = strLen[j];
          strLen[j] = strLen[i];
          strLen[i] = temp;
          sTemp = str[j];
          str[j] = str[i];
          str[i] = sTemp;
        }
      }
    }
    j = 0;
    for (i=0; i<str.length; i++) {
      if (i+2 > str.length){
        strTemp[j] = str[i];
        break;
      }
      if (str[i].equals(str[i+1])) {
        continue;
      }
        strTemp[j] = str[i];
        j++;
    }
    int tempIndex = j;
    j = 0;
    int check = 0;
    int checkIndex = 0;
    for (i=0; i<tempIndex; i++){
      if (i+2 > tempIndex)
        break;
        if (check == 0)
          checkIndex = i;
        else if (check == 1)
          i = checkIndex;
      if (strTemp[i].length() == strTemp[i+1].length()){
        
        for (j=0; j<str[i].length(); ) {
            if (strTemp[i].charAt(j) > strTemp[i+1].charAt(j)) {
              String temp = strTemp[i];
              strTemp[i] = strTemp[i+1];
              strTemp[i+1] = temp;
              check = 1;
              break;
            } else if (strTemp[i].charAt(j) == strTemp[i+1].charAt(j)) {
              j++;
              continue;
            } else {
              check = 2;
              break;
            }
          }
      }
    }
    for ( i=0; i<tempIndex+1; i++) {
      if (strTemp[i] == "1"){
        continue;
      }
      bw.write(strTemp[i] + "\n");
    }
    br.close();
    bw.flush();
    bw.close();
  }
}
