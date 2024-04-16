import java.io.*;

public class Main {
    public static class MyStack<T> {
        private Object[] arr;
        private int size;

        public MyStack() {
            this.arr = new Object[100001];
            size = 0;
        }

        public T[] arr() {
            return (T[]) arr;
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
        MyStack<Long[]> stack = new MyStack<>();

        int N = Integer.parseInt(br.readLine());

        long sum = 0L;
        for (int i = 0; i < N; i++) {
            long mark = 0L;
            long num = Long.parseLong(br.readLine());
            while (!stack.isEmpty()) {
                if (stack.peek()[0] > num) {
                    mark = stack.peek()[1] + 1;
                    sum += mark;
                    break;
                }
                stack.pop();
            }
            stack.push(new Long[] {num, mark});
        }
        bw.write(sum + "");
        br.close();
        bw.close();
    }
}
