import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for(int i = 1; i<= N;i++) { // 총 N개의 줄
            for(int j = 1 ;j <= N-i;j++) { //N-i번만큼 빈칸 출력
                sb.append(" ");
            }
            for(int j = 1; j < i * 2; j++){ //i*2보다 작은만큼 반복하면서 홀수면 별
                if(j%2 ==1)sb.append("*");
                else sb.append(" ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
