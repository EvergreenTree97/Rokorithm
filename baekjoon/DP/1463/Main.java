import java.io.*;

/*
DP - 이전 정보값을 토대로 결과를 찾아내는것,
분할 정복과는 다르게 이전 정보값이 모두 일정함
 */

public class Main {
    static int count = 0;
    static int dp[] = new int[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int X = Integer.parseInt(br.readLine());
        solve();
        sb.append(dp[X]);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    static void solve(){ // 1 이상인 수에 대해 1이 되기 위한 최소값을 구하면서 올라간다.
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;
        for(int i = 4 ; i<= 1000000; i++){
            if(i % 6 == 0){
                dp[i] = Math.min(dp[i/3],dp[i/2])+1;
            } else if(i % 3 == 0){
                dp[i] = Math.min(dp[i/3],dp[i-1])+1;
            }else if(i % 2 == 0){
                dp[i] = Math.min(dp[i-1],dp[i/2])+1;
            }else{
                dp[i] = dp[i-1]+1;
            }

        }
    }
}
