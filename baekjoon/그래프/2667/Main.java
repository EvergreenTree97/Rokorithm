import java.io.*;
import java.util.*;

public class Main {
    static int N, g[][];
    static boolean visited[][];
    static int totalCount = 0, count = 0;
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        g = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                g[i][j] = s.charAt(j) - '0';
            }
        }
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && g[i][j] == 1) {
                    count = 0;
                    bfs(i, j);
                    arr.add(count);
                    totalCount++;
                } else continue;
            }
        }
        Collections.sort(arr);
        sb.append(totalCount + "\n");
        for (int i : arr) {
            sb.append(i).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    /*
    * 원래 코드는 큐에서 빼내서 범위를 체크했지만
    * 큐에 삽입하기 전에 체크해서 메모리를 줄일 수 있었다.
    * */
    static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        visited[x][y] = true;
        count++;
        while (!q.isEmpty()) {
            Point p = q.poll();
            int curX = p.x;
            int curY = p.y;
            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
                    if (g[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                        visited[nextX][nextY] = true;
                        count++;
                        q.offer(new Point(nextX, nextY));
                    }
                }
            }
        }
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}