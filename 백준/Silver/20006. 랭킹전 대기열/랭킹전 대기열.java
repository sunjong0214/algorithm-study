import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Room {
        int level;
        int size;
        List<Player> player = new ArrayList<>();

        public Room(int level, int size) {
            this.level = level;
            this.size = size;
        }
    }

    static class Player {
        int level;
        String name;

        public Player(int level, String name) {
            this.level = level;
            this.name = name;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int size = Integer.parseInt(st.nextToken());
        List<Room> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            boolean flag = false;
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).size != 0 && (list.get(j).level - 10 <= level && list.get(j).level + 10 >= level)) {
                    list.get(j).player.add(new Player(level, name));
                    list.get(j).size--;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                list.add(new Room(level, size));
                list.get(list.size() - 1).player.add(new Player(level, name));
                list.get(list.size() - 1).size--;
            }
        }
        for (Room room : list) {
            room.player.sort((a, b) -> a.name.compareTo(b.name));
            if (room.size == 0) {
                bw.write("Started!\n");
            } else {
                bw.write("Waiting!\n");
            }
            for (Player player : room.player) {
                bw.write(player.level + " " + player.name + "\n");
            }
        }
        br.close();
        bw.close();
    }
}