import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int i = 0 ; i< T ; i++){
            Stack<Character> stack = new Stack<>();
            String s = br.readLine();
            if(s.charAt(0) == ')') {
                sb.append("NO").append("\n");
                continue;
            }
            for(int j = 0 ; j < s.length(); j++){
                char x = s.charAt(j);
                if( x == '(') stack.push(x);
                else if(stack.isEmpty()){
                    stack.add(x);
                    break;
                }
                else stack.pop();
            }
            if(stack.isEmpty()) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}