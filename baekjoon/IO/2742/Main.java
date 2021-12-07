import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int A,B;
        int N = Integer.parseInt(br.readLine());
        for(int i = N; i>0;i--){
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
}