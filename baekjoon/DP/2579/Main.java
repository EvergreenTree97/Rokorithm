import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        sb.append(solve(arr, N));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static int solve(int arr[], int N) {
        int dp[] = new int[N+1];
        if(N == 1){
            return arr[1]; //계단이 하나일 땐 첫 계단이 최댓값
        }else if(N == 2){
            return arr[2]+arr[1]; // 계단이 두개일땐 두 계단의 합
        }else if(N == 3){
            return Math.max(arr[1]+arr[3],arr[2]+arr[3]);
            //계단이 세개 일때는 1+2 or 1+3
        }
        dp[1] = arr[1];
        dp[2] = arr[2]+arr[1];
        dp[3] = Math.max(arr[1]+arr[3],arr[2]+arr[3]);
        for(int i =4 ; i <= N ; i++){
            // * 누적합에 dp[i-1] 값을 사용한다면 올바른 결과가 나오지 않음
            // 1. 두 개 전까지의 최대값 + 현재 계단
            // 2. 세 개 전까지의 최대값 + 이전계단 + 현재계단
            dp[i] = Math.max(dp[i-2]+arr[i],dp[i-3]+arr[i-1]+arr[i]);
        }
        return dp[N];
    }

}