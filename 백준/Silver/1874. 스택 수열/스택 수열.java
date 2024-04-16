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

    MyStack<Integer> stack = new MyStack<>();

    int N = Integer.parseInt(br.readLine());

    int x = 1;
    StringBuilder sb = new StringBuilder();
    while (N-- > 0) {
      int num = Integer.parseInt(br.readLine());
      while (x <= num) {
        stack.push(x++);
        sb.append("+\n");
      }
      if (x > N && !stack.peek().equals(num)) {
        sb = new StringBuilder();
        sb.append("NO\n");
        break;
      }
      stack.pop();
      sb.append("-\n");
    }
    bw.write(sb + "");
    br.close();
    bw.close();
  }
}