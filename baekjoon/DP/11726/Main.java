import java.io.*;

public class Main {
    static int MAX = 1000;
    static int dp[] = new int[MAX+1];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        solve();
        System.out.print(dp[X]);
    }
    static void solve(){ // 1 이상인 수에 대해 1이 되기 위한 최소값을 구하면서 올라간다.
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for(int i = 4 ; i<= MAX; i++){
            dp[i] = (dp[i-2] + dp[i-1]) % 10007;
        }
    }
    // 하나 출력이면 그냥 print쓰자..
}
