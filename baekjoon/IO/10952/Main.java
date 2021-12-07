import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int A,B;
        while(true){
            String s = br.readLine();
            A = s.charAt(0)-'0';
            B = s.charAt(2)-'0';
            if(A == 0 && B == 0 ){
                break;
            }
            sb.append(A+B).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}