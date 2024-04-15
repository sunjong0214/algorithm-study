import java.io.*;

public class Main {
    public static class MyStack<T> {
        private Object[] arr;
        private int size;

        public MyStack() {
            this.arr = new Object[100001];
            size = 0;
        }

        public void push(T item) {
            arr[size++] = (T) item;
        }

        public T pop() {
            if (size == 0) {
                return null;
            }
            size--;
            T save = (T) arr[size];
            arr[size] = null;
            return save;
        }

        public T peek() {
            if (size == 0) {
                return null;
            }
            return (T) arr[size-1];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        MyStack<Integer> stack = new MyStack<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                stack.pop();
            } else {
                stack.push(num);
            }
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        bw.write(sum + "\n");
        br.close();
        bw.close();
    }
}
