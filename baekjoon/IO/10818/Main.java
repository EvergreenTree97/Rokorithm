import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb= new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int max = -10000001;
        int min = 1000001;
        for(int i =0; i< N ; i++){
            int n = Integer.parseInt(st.nextToken());
            if(n <min) min = n;
            if(n > max) max = n;
        }
        sb.append(min).append(" ").append(max);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}