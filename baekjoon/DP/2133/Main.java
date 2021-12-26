import java.io.*;

public class Main {
    static int dp[];
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        if( N % 2 != 0) {
            sb.append(0);
        }else{
            solve(N);
            sb.append(dp[N]);
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void solve(int N) {
        dp = new int[31]; //0: 3개짜리 모양 1: 5개짜리 모양
        dp[0] = 1;
        for(int i = 2; i <= N ;i += 2){
            dp[i] = 3 * dp[i-2]; //3개짜리 블록 증가
            for(int j = 0; j < i-2; j +=2){ // 이전 값 제외한 특수 모양 추가
                dp[i] += 2*dp[j];
            }
        }
    }
}

// 3
// 11 3 * 3 + 2
// 41 11 * 3 + 2 * 3 + 2
// 153 41 * 3 + 22 + 3 * 2 + 2