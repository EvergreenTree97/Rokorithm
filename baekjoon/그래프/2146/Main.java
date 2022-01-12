import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {
    static int N;
    static int[][] g;
    static int[][] group;
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        group = new int[N][N];
        g = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                g[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        /* 같은 섬끼리 묶기*/
        int flag = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (g[i][j] == 1 && group[i][j] == 0) {
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i, j});
                    group[i][j] = ++flag;
                    while (!q.isEmpty()) {
                        int xy[] = q.poll();
                        int curX = xy[0];
                        int curY = xy[1];
                        for (int k = 0; k < 4; k++) {
                            int nextX = curX + dx[k];
                            int nextY = curY + dy[k];
                            if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
                                if (group[nextX][nextY] == 0 && g[nextX][nextY] == 1) {
                                    q.add(new int[]{nextX,nextY});
                                    group[nextX][nextY] = flag;
                                }
                            }
                        }
                    }
                }
            }
        }
        /* 섬은 0, 외부는 -1로 초기화*/
        int[][] dist = new int[N][N];
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                 dist[i][j] = -1;
                 if(g[i][j] == 1){
                     q.add(new int[]{i,j}); //섬들을 추가
                     dist[i][j] = 0;
                 }
            }
        }
        while(!q.isEmpty()){
            int[] p = q.poll();
            int curX = p[0]; int curY = p[1];
            for(int i = 0 ; i < 4;i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
                    if(dist[nextX][nextY] == -1){
                        dist[nextX][nextY] = dist[curX][curY] + 1;
                        group[nextX][nextY] = group[curX][curY];
                        q.add(new int[]{nextX,nextY});
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < N; i++){
            for(int j = 0 ; j < N ; j++){
                for(int  k= 0 ; k < 4;k++){
                    int nextX = i + dx[k];
                    int nextY = j + dy[k];
                    if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
                        if(group[i][j] != group[nextX][nextY]){
                            min = Math.min(min,dist[i][j]+dist[nextX][nextY]);
                        }
                    }
                }
            }
        }
        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
    }
}
// 이전 코드, 모든 bfs를 구하느라 느림
/*
public class Main {
    static int N;
    static int[][] g;
    static boolean[][] visited;
    static int[][] visited2;
    static Queue<int[]> outLines = new LinkedList<>();
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N][N];
        g = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                g[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int flag = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (g[i][j] == 1 && !visited[i][j]) {
                    findOutLine(i, j,flag++);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        while(!outLines.isEmpty()){
            int p[] = outLines.poll();
            min = Math.min(findMinBridge(p[0],p[1]),min);
        }
        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
    }

    static void findOutLine(int x, int y,int flag) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        while (!q.isEmpty()) {
            int xy[] = q.poll();
            int curX = xy[0];
            int curY = xy[1];
            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
                    if (!visited[nextX][nextY]) {
                        if (g[nextX][nextY] == 1) {
                            visited[nextX][nextY] = true;
                            q.offer(new int[]{nextX, nextY});
                        } else {
                            g[curX][curY] = flag;// 테두리
                            outLines.offer(new int[]{curX, curY});
                        }
                    }
                }
            }
        }
    }

    static int findMinBridge(int x, int y) {
        visited2 = new int[N][N];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited2[x][y] = 0;
        int dist = N;
        while (!q.isEmpty()) {
            int xy[] = q.poll();
            int curX = xy[0];
            int curY = xy[1];
            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
                    if (visited2[nextX][nextY] == 0) {
                        if (g[nextX][nextY] >= 2 && g[x][y] != g[nextX][nextY]) {
                            return visited2[curX][curY];
                        }else{
                            q.offer(new int[]{nextX,nextY});
                            visited2[nextX][nextY] = visited2[curX][curY] + 1;
                        }
                    }
                }
            }
        }
        return dist;
    }

}
// 1. 전체 요소에 대해 탐색해서 테두리를 찾아낸다
// 2. 테두리에서 bfs를 통해 테두리를 찾아낸다.
*/