import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int gcd = gcd(A,B);
        StringBuilder sb= new StringBuilder();
        sb.append(gcd).append("\n").append(A*B/gcd);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    static int gcd(int a , int b){
        while(b!=0){
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
//최소공배수 = 두 수의 곱 / 최대공약수