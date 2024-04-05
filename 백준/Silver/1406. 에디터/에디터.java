import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

//    public static class ArrayList {
//        public static final int CAPACITY = 500001;
//        public Character[] array = new Character[CAPACITY];
//        public int size = 0;
//
//        public void add(Character value) {
//            array[size++] = value;
//        }
//
//        public Character get(int index) {
//            return array[index];
//        }
//
//        public Character remove() {
//            if (size == 0) return null;
//            Character rm = array[--size];
//            array[size] = null;
//            return rm;
//        }
//    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        Stack<Character> list = new Stack<>();

        for (int i=0; i<str.length(); i++) {
            list.add(str.charAt(i));
        }

        int N = Integer.parseInt(br.readLine());
        Stack<Character> temp = new Stack<>();

        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if (cmd.equals("P")) {
                list.push(st.nextToken().charAt(0));
            } else if (cmd.equals("B")) {
                if(!list.isEmpty()) list.pop();
            } else if (cmd.equals("L")) {
                if(!list.isEmpty()) temp.push(list.pop());
            } else if (cmd.equals("D")) {
                if(!temp.isEmpty()) list.push(temp.pop());
            }
        }

        while (!list.isEmpty()) {
            temp.push(list.pop());
        }
        while (!temp.isEmpty()) {
            bw.write(temp.pop() + "");
        }
        br.close();
        bw.close();
    }
}
