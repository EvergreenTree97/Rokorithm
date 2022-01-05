import java.io.*;
import java.util.*;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        if(N == 0 )sb.append(0);
        else{
            Stack<Integer> stack = new Stack<>();
            while(N != 0){
                if(N % -2 == -1){
                    stack.push(Math.abs(N % 2));
                    N = N / -2 +1;
                }else{
                    stack.push(N%2);
                    N /= -2;
                }
            }
            while(!stack.isEmpty()) sb.append(stack.pop());
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}

