import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int val[];
        int i,sum;
        val = new int[N];
        for(i = 0; i < N; i++){
            val[i] = Integer.parseInt(br.readLine());
        }
        int res = 0;
        for(i = N-1; i>= 0; i--){
            if(K == 0 ) break;
            if(val[i] > K) {
                continue;
            }
            do{
                K = K-val[i];
                res++;
            }while(K >= val[i]);
        }
        System.out.print(res);
    }
}
