import java.io.IOException;
import java.util.*;

public class Main{
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        int max = 0;
        int i =0;
        for(i=0; i<N; i++) {
        	arr[i]=sc.nextInt();
        
        if(arr[i] > max) {
    		max = arr[i];
        }
        }
        double sum = 0;
        for(double value : arr) {
        	value = (value/max)*100;
        	
        	sum = sum+ value;
        	
        }
        double sum2 = sum/N;
        System.out.println(sum2);
    }
    } 
