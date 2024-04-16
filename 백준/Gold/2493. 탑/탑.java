import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  public static class MyStack<T> {

    private Object[] arr;
    private int size;

    public MyStack() {
      this.arr = new Object[500001];
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
      return (T) arr[size - 1];
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

    MyStack<int[]> stack = new MyStack<>();

    int N = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    int top = 1;
    while (st.hasMoreTokens()) {
      int[] num = new int[] {Integer.parseInt(st.nextToken()), top++};
      while (true) {
        if (stack.peek() != null && num[0] > stack.peek()[0]) {
          stack.pop();
        } else {
          int[] temp = stack.peek();
          if (temp == null) {
            bw.write(0 + " ");
          } else {
            bw.write(stack.peek()[1] + " ");
          }
          stack.push(num);
          break;
        }
      }
    }
    br.close();
    bw.close();
  }
}
