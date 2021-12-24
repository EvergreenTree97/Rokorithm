import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        sb.append(solve(N));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static int solve(int N) {
        int[] dp = new int[N+1]; // 어떤 자연수 N을 제곱수로 나타낼 때 항의 최소 개수
        for(int i = 1 ; i <= N ; i++){
            dp[i] = i; //1의 제곱으로 표현한다고 가정, 초기화
        }
        for(int i = 1; i<= N ; i++){
            for(int j = 1; j*j <= i ; j++){
                dp[i] = Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        return dp[N];
    }
}
