import java.io.*;

public class Main {
    static long dp[][]; //N자리수의 자리값이 몇개인지 저장하는 배열
    static int N;
    final static long mod = 1000000000;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        dp = new long[101][10];
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

         //길이가 1인 첫 번째 자리수는 0 빼고 하나씩 있음
         for(int i = 1; i < 10 ;i++){
             dp[1][i] = 1;

         }
         for(int i =2 ;i<= 100;i++){
             for(int j = 0 ; j <10;j++){
                 if(j==0){
                     //0 일때는 이전 자리수가 1만 가능
                     dp[i][0] = dp[i-1][1] % mod;
                 }
                 //9 때도 이전 자리수가 8만 됨
                 else if(j == 9){
                     dp[i][9] = dp[i-1][8] % mod;
                 }
                 //이 외의 경우 이전 자리수 +1,-1
                 else{
                     dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % mod;
                 }
             }
         }
    }
}
