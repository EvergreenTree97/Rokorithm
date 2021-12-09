import java.io.*;

public class Main {
    static int dp[][]; //N자리수의 자리값이 몇개인지 저장하는 배열
    static int N;
    static final int MAX = 1000;
    final static long mod = 10007;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        dp = new int[MAX+1][10];
        dp();
        int N = Integer.parseInt(br.readLine());
        long sum = 0;
        for(int i = 0 ; i <= 9; i++){
            sum += dp[N][i];
        }
        sb.append(sum % mod);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    static void dp(){
         //길이가 1일때 1~9까지 하나씩 존재
         for(int i = 0; i < 10 ;i++){
             dp[1][i] = 1;
         }
         // 각 자리수의 이전값은, 자기 자신 이상 9 이하까지 가질 수 있음
         // 이전 정보들의 값을 이용하여 자기 자신 이상 9 이하 값 결과를 도출해냄
         for(int i =2 ;i<= MAX;i++){
             for(int j = 0 ; j <10;j++){
                 int sum= 0;
                 for(int k = j; k < 10;k++){
                     sum += dp[i-1][k] % mod;
                 }
                 dp[i][j] += sum;
             }
         }
    }
}
