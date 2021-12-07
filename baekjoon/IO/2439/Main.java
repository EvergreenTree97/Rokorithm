import java.io.*;
import java.util.StringTokenizer;
public class Main {
    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for(int i = 0,k = N-1; i < N;i++, k--){
            for(int j = 0; j < k; j++){
                sb.append(" ");
            }
            for(int j = k ;j <N; j++){
                sb.append("*");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
