import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long iter = gcd(Math.max(A,B),Math.min(A,B));
        StringBuilder sb= new StringBuilder();
        for(int i = 0 ; i < iter;i++){
            sb.append("1");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    //1의 개수의 최소공약수를 구해서 1을 추가
    static long gcd(long a, long b){
        while(b != 0){
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}