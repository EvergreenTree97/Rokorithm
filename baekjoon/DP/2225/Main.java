import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        sb.append(solve(N,K));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static int solve(int N,int K) {
        dp = new int[201][201];
        for(int i = 1 ; i <= K ; i++){ //0번째 항부터 구해줘야 함
            dp[i][0] = 1;
        }
        for(int i = 1; i <= K ; i++){
            for(int j = 1; j <= N ; j++){
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000000;
            }
        }
        return dp[K][N];
    }
}