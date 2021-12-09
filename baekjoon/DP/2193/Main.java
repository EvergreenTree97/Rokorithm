import java.io.*;

public class Main {
    static long dp[]; //N자리수의 자리값이 몇개인지 저장하는 배열
    static int N;
    static final int MAX = 90;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        dp = new long[MAX+1];
        dp();
        N = Integer.parseInt(br.readLine());
        sb.append(dp[N]);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    // 맞춘 문제인데.. 자료형 때문에 틀렸네
    // 이 문제는 피보나치랑 점화식이 같다. int형이 아니라 long 으로 해야한다.
    static void dp(){
         dp[1] = 1;
         dp[2] = 1;
         dp[3] = 2;
         for(int i = 4 ; i<= 90; i++){
             dp[i] = (dp[i-2] + dp[i-1]);
         }
    }
}
