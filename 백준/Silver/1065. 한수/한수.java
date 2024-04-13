	import java.util.Scanner;
	
	public class Main{
		//x=<1000, x의 각자리, 각 자리수가 등차수열인지, 그 갯수
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int x = sc.nextInt();
			int zz =0;
			for(int i=1;i<=x;i++) {
				int n = hansu(i);
				if(n==1) {
					zz++;
				}else {
					
				}
				
			}
			System.out.println(zz);
		}
		public static int hansu(int y) {
			int result=0;//123
			if(y>99) {
				int z1 = y/10;//12
				int z = y%10;//3
				int z2=z1/10;//1
				int z3=z1%10;//2
				int sum = z-z3;
				int sum2 = z3-z2;
				if(sum==sum2) {
					result=1;
					return result;
				}else {
					return result;
				}
			}else {
				result=1;
				return result;
			}
		}
	}