import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result =0;
        int N = Integer.parseInt(br.readLine());
        for(int i =1; i<=N;i++){
            result = result + i;
        }
        System.out.println(result);
    }
}