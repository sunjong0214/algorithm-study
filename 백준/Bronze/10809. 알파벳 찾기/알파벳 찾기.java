import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int arr[] = new int[26];
        
	        for(int i=0; i<arr.length;i++) {
	        	arr[i] = -1;
	        }
        
        String s = sc.nextLine();
        
        	for(int i=0;i<s.length();i++){
        		int x = s.charAt(i);
        		if(arr[x-'a'] == -1) {
        		arr[x-'a']=i;
        		}
        	}
        	for(int val : arr) {
        System.out.print(val+" ");
        }
    }
}