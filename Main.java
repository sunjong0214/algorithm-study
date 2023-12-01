import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    String[] str = new String[n];
    String[] strTemp = new String[n];
    int[] strLen = new int[n];
    String sTemp = null;

    for (int i=0; i<n; i++) {
      str[i] = br.readLine();
      strLen[i] = str[i].length();
    }
    for (int i=0; i<str.length; i++){
      for (int j=0; j<str.length; j++) {
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
        for (int i=0; i<str.length; i++){
          for (int j=1; j<str.length; j++) {
            if (strLen[i] == strLen[j]) {
            int charIndex = 0;
              while (true) {
                char[] strChar = new char[50];
                strChar[charIndex] = str[i].charAt(charIndex);
                char[] strChar2 = new char[50];
                strChar2[charIndex] = str[j].charAt(charIndex);
                if (strChar[charIndex] == strChar2[charIndex]) {
                  charIndex++;
                  if (str[i].charAt(charIndex) == '\0'){
                    str[j] = null;
                  }
                  break;
                } else if (strChar[charIndex] < strChar2[charIndex]) {
                  break;
                } else if (strChar[charIndex] > strChar2[charIndex]) {
                  sTemp = str[j];
                  str[j] = str[i];
                  str[i] = sTemp;
                  break;
                }
              }
            }
        }
      }
    for (int i=0; i<n; i++) {
      bw.write(str[i] + "\n");
    }
    br.close();
    bw.flush();
    bw.close();
  }
}
