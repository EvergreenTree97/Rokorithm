import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        sb.append(solve(arr, N));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static int solve(int arr[], int N) {
        int max = arr[0];
        int dp[] = new int[N];
        dp[0] = arr[0];
        for(int i = 1 ; i < N ; i++){
            dp[i] = Math.max(dp[i-1]+arr[i],arr[i]);
            max = Math.max(max,dp[i]);
        }
        return max;
    }

}