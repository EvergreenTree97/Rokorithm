import java.io.*;
import java.util.*;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int sum = 0;
        for(int i = m-1 ; i >=0 ; i--){
            int n = Integer.parseInt(st.nextToken());
            sum += (int)Math.pow(A,i) * n;
        }
        bw.write(trans(sum,B));
        bw.flush();
        bw.close();
    }
    static String trans(int N, int B){
        Stack<Integer> stack = new Stack<>();
        while(N > B-1){
            stack.push((N % B));
            N /= B;
        }
        stack.push(N);
        StringBuilder sb= new StringBuilder();
        while(!stack.isEmpty()) sb.append(stack.pop()).append(" ");
        return sb.toString();
    }
}

