import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int max = N * 2 - 1;
        int k;
        for (int i = 1; i <= max; i++) {
            if(i <= N) k = N-i;
            else k = i-N;
            for(int j = 1; j <= N;j++){
                if(j <= k) sb.append(" ");
                else sb.append("*");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
