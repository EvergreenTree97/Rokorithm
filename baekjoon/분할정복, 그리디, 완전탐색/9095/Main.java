import java.io.*;

public class Main {
    static int MAX = 10;
    static int dp[] = new int[MAX+1];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        solve();
        for(int i = 0 ; i<T; i++){
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    static void solve(){ // 내가 헤맸던 이유.. 어떻게 1일 땐 1 하나만 사용했지 생각해보니 1,2,3 사용이었다..
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i = 4 ; i<= MAX; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
    }
}
