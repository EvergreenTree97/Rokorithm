import java.io.*;

public class Main {
    static long dp[];
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        solve();
        for(int i = 0 ; i < T ; i++){
           sb.append(dp[Integer.parseInt(br.readLine())]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void solve() {
        dp = new long[101];
        dp[0] = 0;
        dp[1] = dp[2] = dp[3] = 1;
        for(int i = 4; i <= 100 ;i++){
            dp[i] = dp[i-3] + dp[i-2];
        }

    }
}