import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());
        bw.write(String.valueOf(trans(N,B)));
        bw.flush();
        bw.close();
    }
    static int trans(String N, int B){
        int sum = 0;
        for(int i = N.length()-1, j = 0;i>=0 ;i--,j++){
            char c = N.charAt(i);
            if(c <= '9') sum += (c-'0') * Math.pow(B,j);
            else sum += (c-'A'+10) * Math.pow(B,j);
        }
        return sum;
    }
}