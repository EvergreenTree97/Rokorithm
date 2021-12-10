import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int sticker[][]; //스티커를 저장할 배열
    static int dp[][]; //최대 값 저장할 배열
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < T; i++){
            int n = Integer.parseInt(br.readLine());
            sticker = new int[2][n+1];
            dp = new int[2][n+1];
            for(int j = 0 ; j < 2 ;j++){
                StringTokenizer st= new StringTokenizer(br.readLine());
                for(int k = 1; k <= n ; k++){
                    sticker[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            sb.append(dp(n)).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    /* 단순히 규칙을 찾으려고 하지만 말고, 이전 값이 다음 값에 어떤 영향을 미칠 지*/
    // 시작은 위쪽 시작이거나, 아랫 쪽 시작 둘 중하나이다. 그리고 두 가지 경우로 전진한다.
    // 1. 바로 다음 대각선의 경우
    // 2. 두 칸 뒤 대각선의 경우 (3칸 뒤 대각선은 이전 대각선을 거쳐서 오는게 더 크다)
    static int dp(int n){
         dp[0][0] = dp[1][0] = 0; // 시작에서 두번 째 값을 계산하기 위해 0번째에서 오는 경우
         dp[0][1] = sticker[0][1]; dp[1][1] = sticker[1][1]; //현재 최대값은 곧 그 값
         for(int i = 2; i <= n ; i++){
             dp[0][i] = Math.max(dp[1][i-1],dp[1][i-2]) + sticker[0][i];
             dp[1][i] = Math.max(dp[0][i-1],dp[0][i-2]) + sticker[1][i];
         }
         return Math.max(dp[0][n],dp[1][n]);
    }
}
