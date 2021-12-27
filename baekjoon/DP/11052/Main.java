import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int P[] = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N ; i++){
            P[i] = Integer.parseInt(st.nextToken());
        }
        bw.write(String.valueOf(solve(N,P)));
        bw.flush();
        bw.close();
    }

    static int solve(int N, int P[]) {
        int[] dp = new int[N+1]; //n 개의 카드를 갖기 위해 지불하는 금액의 최댓값
        for(int i = 1;i <= N ;i++){
            for(int j = 1 ; j <=i ;j++){
                dp[i] = Math.max(dp[i],dp[i-j]+P[j]); //Max(P[n],dp[n-1]+P[1]...,dp[N-N],dp[N]
            }
        }
        return dp[N];
    }
}