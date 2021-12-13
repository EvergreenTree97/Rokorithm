import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int seq[];
    static int dp[]; //최대 값 저장할 배열
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        seq = new int[N];
        dp = new int[N];
        StringTokenizer st= new StringTokenizer(br.readLine());
        for(int i = 0 ; i<N;i++){
           seq[i] = Integer.parseInt(st.nextToken());
        };
        sb.append(dp(N));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static int dp(int n){
         for(int i = 0 ; i< n;i++){
             dp[i] = 1;
             for(int j = 0 ;j <i ;j++){
                 if(seq[j] < seq[i] && dp[i] <dp[j]+1){
                     dp[i] = dp[j] + 1;
                 }
             }
         }
         int max = -1;
         for(int i = 0 ; i< n; i++){
             if(max < dp[i]) max = dp[i];
         }
         return max;
    }
}
