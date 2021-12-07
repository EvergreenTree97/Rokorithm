import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int max = 2*N-1;
        int k = N;
        for(int i = 1,start = N, end =N ; i < N; i++){
            for(int j = 1;j <= k;j++){
                if(j == start || j == end) sb.append("*");
                else sb.append(" ");
            }
            k++; start--; end++;
            sb.append("\n");
        }
        for(int j = 1; j <= k;j++){
            sb.append("*");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
