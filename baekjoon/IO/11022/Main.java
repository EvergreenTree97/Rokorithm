import java.io.*;
import java.util.StringTokenizer;
public class Main {
    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for(int i =0; i<N;i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            int A =Integer.parseInt(st.nextToken());
            int B =Integer.parseInt(st.nextToken());
            sb.append("Case #").append(i+1).append(": ");
            sb.append(A).append(" + ").append(B).append(" = ");
            sb.append(A+B).append("\n");

        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}