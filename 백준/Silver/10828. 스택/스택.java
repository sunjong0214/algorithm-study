
import java.io.*;
import java.lang.Object;
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

    int n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String cmd = st.nextToken();
      if (cmd.equals("push")) {
        stack.push(Integer.parseInt(st.nextToken()));
      } else if (cmd.equals("pop")) {
        Integer temp = stack.pop();
        if (temp == null) {
          bw.write(-1 + "\n");
        } else {
          bw.write(temp + "\n");
        }
      } else if (cmd.equals("size")) {
        bw.write(stack.size() + "\n");
      } else if (cmd.equals("empty")) {
        if (stack.isEmpty()) {
          bw.write(1 + "\n");
        } else {
          bw.write(0 + "\n");
        }
      } else {
        if (stack.peek() == null) {
          bw.write(-1 + "\n");
        } else {
          bw.write(stack.peek() + "\n");
        }
      }
    }
    br.close();
    bw.close();
  }
}


