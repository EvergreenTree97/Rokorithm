import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb= new StringBuilder();
        for(int i = 0 ; i < T;i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long arr[] = new long[n];
            for(int j = 0 ; j < n ;j++){
                arr[j] = Long.parseLong(st.nextToken());
            }
            long res = 0;
            for(int j = 0 ; j < n-1 ;j++){
                for(int k = j+1 ; k < n ; k++){
                    res += gcd(arr[j],arr[k]);
                }

            }
            sb.append(res).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    static long gcd(long a, long b){
        while(b != 0){
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}