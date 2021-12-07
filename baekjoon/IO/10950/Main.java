import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int A,B;
        int N = Integer.parseInt(br.readLine());
        for(int i =0; i<N;i++){
            st = new StringTokenizer(br.readLine());
            A =  Integer.parseInt(st.nextToken());
            B =  Integer.parseInt(st.nextToken());
            sb.append(A+B).append("\n");
        }
        System.out.println(sb);
    }
}
