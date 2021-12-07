import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int k = N;
            for (int j = 1; j <= k+i; j++) {
                if(j <k-i){
                    sb.append(" ");
                }else{
                    sb.append("*");
                }
            }
            if(i < N-1){
                sb.append("\n");
            }

        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
