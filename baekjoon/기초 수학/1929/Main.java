import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final int MAX = 1000000;
        boolean[] prime = new boolean[MAX+1];//false일 경우 소수
        prime[0] = prime[1] = true; //0과 1은 소수가 아님
        for(int i = 2 ; i * i <= MAX; i++) { // i의 제곱이 N보다 커지면 지울 필요 없음
            if(!prime[i]){
                for(int j = i * i  ; j <= MAX ; j += i){// 시작점을 제외한 배수는 모두 소수가 아님
                    prime[j] = true;
                }
            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        StringBuilder sb= new StringBuilder();
        for(int i = M ; i <= N ;i++){
            if(!prime[i]) sb.append(i+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
