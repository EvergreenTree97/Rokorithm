import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int cup[]; //스티커를 저장할 배열
    static int dp[]; //최대 값 저장할 배열
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        cup = new int[n+1]; dp = new int[n+1];
        for(int i = 1 ; i <= n; i++){
            cup[i] = Integer.parseInt(br.readLine());
        }
        sb.append(dp(n));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    /*dp[i]는 i까지의 최대값
    * 3번째 dp값을 어떻게 처리해야 하나 고민했었다,
    * 3번째가 중복되지 않는 i-1 그대로나, i-2+현재값, i-3+i-1+현재값 이 세 가지 경우를 이용하여
    *
    * */
    static int dp(int n){
         dp[1]= cup[1];
         if(n>1) dp[2] = cup[1]+cup[2];
         for(int i = 3; i<= n ;i++){
             // 세 개 연속으로 합이 나오지 않으려면, 세 가지중 하나가 최대값이 된다.
             // 1. 바로 이전 값
             // 2. 2 번째 전 최댓값과 현재 값
             // 3. 3 번째 전 최댓값과 바로 이전 값과 현재 값
             // 모든 경우에 반복하면 2개가 중복되지 않은 채 dp에 최대값이 기억된다.
             dp[i] = Math.max(dp[i-1],Math.max(dp[i-2]+cup[i],dp[i-3]+cup[i-1]+cup[i]));
         }
         return dp[n];
    }
}
