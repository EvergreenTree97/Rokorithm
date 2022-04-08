import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, -1, 0, 1};
    static int N, M, K;
    static char map[][];
    static char word[];
    static int dp[][][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        word = br.readLine().toCharArray();
        dp = new int[N][M][word.length];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == word[0]) {
                    count += dfs(0, i, j);
                }
            }
        }
        System.out.print(count);
    }

    static int dfs(int idx, int x, int y) {
        //만약 도착이면 1 리턴
        if (idx == word.length - 1) return dp[x][y][idx] = 1;

        //왔던 지점이라면 그 값을 리턴
        if (dp[x][y][idx] != -1) return dp[x][y][idx];

        //방문했다면 0으로 초기화
        dp[x][y][idx] = 0;
        for (int i = 0; i < 4; i++) {
            for (int k = 1; k <= K; k++) {
                int nextX = x + dx[i] * k;
                int nextY = y + dy[i] * k;
                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {

                    if (map[nextX][nextY] == word[idx + 1]) {
                        //메모이제이션이 가능한 이유, 1칸을 2칸을 건너 뛰더라도
                        //이전 문자는 동일하기 때문에 현재 문자에서 갈수 있는 경로들을 합쳐주면 된다.
                        dp[x][y][idx] += dfs(idx+1, nextX, nextY);
                    }
                }
            }
        }
        return dp[x][y][idx];
    }

}