import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        /* N이 두개 이상의 곱셈으로 나타낼 수 있을 때, 인수중 하나는
        * 반드시 루트 N보다 작다! */
        for(int i = 2;i <= Math.sqrt(N);i++){
            while(N % i == 0){
                sb.append(i+"\n");
                N /= i;
            }
        }
        if(N > 1) sb.append(N); //남는 것이 있다면, 그것은 소수이고 인수임이 분명하다.
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
