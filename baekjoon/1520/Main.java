import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int dx[] = {-1,0,1,0};
    static int dy[] = {0,-1,0,1};
    static int M,N;
    static int map[][];
    static int memo[][];
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        memo = new int[M][N];
        for(int i = 0; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                memo[i][j] = -1;
            }
        }
        System.out.print( dfs(new Point(0,0)));

    }
    static int dfs(Point cur){
        //1. 체크인
        //2. 도착지인가
        if(cur.x == M-1 && cur.y == N-1){ //목적지에 도착하면 1을 리턴
            return 1;
        }
        if(memo[cur.x][cur.y] > -1){ //이미 방문했던 곳이라면 리턴
            return memo[cur.x][cur.y];
        }
        memo[cur.x][cur.y] = 0; //도착 예정에없다면 0을 유지
        //3. 연결된 곳 순회
        for(int i = 0 ; i < 4 ; i++){
            //4. 갈 수 있는가
            int nextX = cur.x+dx[i];
            int nextY = cur.y+dy[i];
            if(nextX >= 0 && nextX < M && nextY >= 0 && nextY < N
                    && map[nextX][nextY] < map[cur.x][cur.y]){
                //5. 간다
                memo[cur.x][cur.y]  += dfs(new Point(nextX,nextY));
            }
        }
        //6. 체크아웃
        return memo[cur.x][cur.y];
    }

}
class Point{
    int x, y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
