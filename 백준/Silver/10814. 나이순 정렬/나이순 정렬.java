import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
  static class Person {
    int age;
    String name;

    public Person(int age, String name) {
      this.age = age;
      this.name = name;
    }

    public String toString() {
      return age + " " + name + "\n";
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    Person[] person = new Person[n];
    StringTokenizer st;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      person[i] = new Person(Integer.parseInt(st.nextToken()), st.nextToken());
    }
    Arrays.sort(person, (p1, p2) -> p1.age - p2.age);
    for (int i = 0; i < n; i++) {
      System.out.print(person[i].toString());
    }
    br.close();
  }
}
