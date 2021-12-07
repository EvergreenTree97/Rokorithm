import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int max = N * 2 - 1;
        for(int i = 1, k = max; i <= N ;i++){
            for(int j = 1; j <= k; j++){
                if(j < i ) sb.append(" ");
                else sb.append("*");
            }
            k--;
            sb.append("\n");
        }
        for(int i = N+1,k = N+1; i <= max;i++){
            for(int j = 1; j <= k; j++){
                if(j <= max-i) sb.append(" ");
                else sb.append("*");
            }
            k++;
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
