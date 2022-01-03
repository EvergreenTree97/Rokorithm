import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1 ; i <= N ;i++){
            q.offer(i);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int idx = 1;
        /* 큐의 사이즈가 1임을 묻는 if문이 while문 안에 있어서 연산이 하나 늘어난 것 같다.
        * q의 사이즈가 1일때가지 반복하게 함으로써 if문을 하나 줄였다.
        * */
        while(q.size() != 1){
            for(int i = 0 ; i < K-1 ;i++){
                q.offer(q.poll());
            }
            sb.append(q.poll()).append(", ");
        }
        sb.append(q.poll()).append(">");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}