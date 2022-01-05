import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean[] prime = new boolean[1001];//false일 경우 소수
        prime[0] = prime[1] = true; //0과 1은 소수가 아님
        for(int i = 2 ; i * i <= 1000; i++) { // i의 제곱이 N보다 커지면 지울 필요 없음
            if(!prime[i]){
                for(int j = i * i  ; j <= 1000 ; j += i){// 시작점을 제외한 배수는 모두 소수가 아님
                    prime[j] = true;
                }
            }
        }
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;
        for(int i = 0 ; i < N ;i++){
            if(!prime[Integer.parseInt(st.nextToken())])count++;
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}
