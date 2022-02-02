import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int dx[] = {-1,0,1,0};
    static int dy[] = {0,-1,0,1};
    static int map[][];
    static boolean visited[][];
    static int dp[][];
    static int N, M;
    static int max = 1;
    static boolean isLoop = false;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\evergreen\\Documents\\hello-spring\\untitled\\src\\input.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dp = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j)-'0';
            }
        }
        visited[0][0] = true;
        dfs(0,0,1);
        if(!isLoop){
            bw.write(String.valueOf(max));
        }else{
            bw.write(String.valueOf(-1));
        }

        bw.flush();
        bw.close();
    }

    static void dfs(int x, int y, int dist){
        //체크인
        dp[x][y] = dist;
        //목적지인가?
        if(dist > max){
            max = dist;
        }
        //연결된 곳 순회
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i] * map[x][y];
            int ny = y + dy[i] * map[x][y];
            //  갈 수 있는가?
            if(nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] != 'H'-'0'){
                if(visited[nx][ny]){
                    isLoop = true;
                    return;
                }
                if(dp[nx][ny] > dist) continue;
                visited[nx][ny] = true;
                dfs(nx,ny,dist+1);
                //체크 아웃
                visited[nx][ny] = false;
            }
        }

    }
}