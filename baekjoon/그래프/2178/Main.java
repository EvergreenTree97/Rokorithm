import java.io.*;
import java.util.*;

public class Main {
    static int g[][], w, h;
    static boolean visited[][];
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        h= Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        g = new int[w][h];
        visited = new boolean[w][h];
        boolean allRipe = true;
        for (int i = 0; i < h; i++) {
            String s = br.readLine();
            for (int j = 0; j < w; j++) {
                g[j][i] = s.charAt(j)-'0';
            }
        }
        bfs(0, 0);
        bw.write(String.valueOf(g[w-1][h-1]));
        bw.flush();
        bw.close();
    }
    /* dfs를 사용하여 끝에 도달하면 return하게 하여 풀었으나, 최소 거리가 나오지 않는다. 또한 시간 초과가 난다고 한다.
    *  BFS를 사용하는 경우 -> 최소 비용 문제, 간선의 가중치가 1, 정점과 간선의 개수가 적음
    * 따라서 bfs가 효과적이다.*/
    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        while(!q.isEmpty()){
            int p[] = q.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = p[0] + dx[i];
                int nextY = p[1] + dy[i];
                if (nextX >= 0 && nextX < w && nextY >= 0 && nextY < h) {
                    if (g[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                        visited[nextX][nextY] = true;
                        g[nextX][nextY] = g[p[0]][p[1]] + 1;
                        q.offer(new int[]{nextX,nextY});
                    }
                }
            }
        }

    }
}
