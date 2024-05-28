import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n;
    static int m;
    static Queue<Integer> q = new LinkedList<>();
    static int[] arr = new int[100001];
    static int time;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();


        q.add(n);
        arr[n] = 1;
        if (n == m) {
            System.out.println(0);
            q.poll();
        }
        loop:
        while (!q.isEmpty()) {
            int size = q.size();
            time++;
            for (int i = 0; i < size; i++) {
                int temp = q.poll();
                if (checkQ(temp - 1)) {
                    break loop;
                }
                if (checkQ(temp + 1)) {
                    break loop;
                }
                if (checkQ(temp * 2)) {
                    break loop;
                }
            }
        }
        sc.close();
    }

    private static boolean checkQ(int x) {
        if (x > 100000 || x < 0) {
            return false;
        }
        if (arr[x] == 1) {
            return false;
        }
        arr[x] = 1;
        q.add(x);
        if (x == m) {
            System.out.println(time);
            return true;
        }
        return false;
    }
}
