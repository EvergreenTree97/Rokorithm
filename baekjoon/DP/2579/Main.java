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
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        sb.append(solve(arr,N));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    static int solve(int arr[], int N){
         int udp[] = new int[N];
         int ddp[] = new int[N];
         int b[] = new int[N];
        for(int i = N-1 ; i >=0 ; i--){  //가장 긴 증가하는 부분수열 구하기
            ddp[i] = 1;
            for(int j = N-1 ; j > i ; j--){
                if((arr[j] < arr[i]) && ddp[j]+1 > ddp[i]){
                    ddp[i] = ddp[i]+1;
                }
            }

        }
        for(int i = 0 ; i < N ; i++){  //가장 긴 감소하는 부분수열 끝부터 구하기
            udp[i] = 1;
            for(int j = 0 ; j < i ; j++){
                if((arr[j] < arr[i]) && udp[j]+1 > udp[i]){
                    udp[i] = udp[j]+1;
                }
            }
            b[i] = udp[i] + ddp[i] - 1; //두 개를 더하면 바이토닉 수열, 중복 하나 제거
         }
         int max = -1;
         for(int i = 0 ; i < N ; i++){
            if(max < b[i]) max = b[i];
         }
         return max;
    }

}