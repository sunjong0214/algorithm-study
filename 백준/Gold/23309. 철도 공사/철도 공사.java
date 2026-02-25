import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] pre = new int[1000001];
        int[] post = new int[1000001];

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int node = Integer.parseInt(st.nextToken());
            arr[i] = node;
            if (i == 0) continue;
            pre[node] = arr[i - 1];
            post[arr[i - 1]] = node;
        }

        pre[arr[0]] = arr[n - 1];
        post[arr[n - 1]] = arr[0];

        // cmd 따라 추가 삭제
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            int iNode = Integer.parseInt(st.nextToken());
            int preIdx = pre[iNode];
            int postIdx = post[iNode];

            if (cmd.equals("BN")) {
                int newNode = Integer.parseInt(st.nextToken());

                pre[newNode] = iNode;
                post[newNode] = post[iNode];

                post[iNode] = newNode;
                pre[postIdx] = newNode;

                bw.write(postIdx + "\n");
            } else if (cmd.equals("BP")) {
                int newNode = Integer.parseInt(st.nextToken());

                post[newNode] = iNode;
                pre[newNode] = pre[iNode];

                post[preIdx] = newNode;
                pre[iNode] = newNode;

                bw.write(preIdx + "\n");
            } else if (cmd.equals("CN")) {
                post[iNode] = post[postIdx];
                pre[post[postIdx]] = iNode;

                bw.write(postIdx + "\n");
            } else {
                pre[iNode] = pre[preIdx];
                post[pre[preIdx]] = iNode;

                bw.write(preIdx + "\n");
            }
        }

        br.close();
        bw.close();
    }
}