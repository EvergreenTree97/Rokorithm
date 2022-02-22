import java.io.*;
import java.util.*;

public class Main {
    static int M, N, K;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\evergreen\\Documents\\hello-spring\\untitled\\src\\input.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int res = 0;
        for (int i = 0; i <= K; i++) {
            res = Math.max(calc(M-i,N-(K-i)),res);
        }
        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();

    }
    static int calc(int m,int n){
        m = m/2;
        return Math.min(m,n);
    }

}