import java.io.*;
import java.util.*;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String N = br.readLine();

        /* 오히려 각 문자에 대한 이진수값을 대입하는 함수를 만들어 놓고
        * 코드가 조금 길어지더라도 효과가 더 좋은것 같다.*/

        if(N.equals("0")) {
            sb.append("0");
        }else{
            Stack<Integer> stack = new Stack<>();
            int c = N.charAt(0)-'0';
            for(int j = 0 ; j < 3 ; j++, c/=2){
                stack.push(c%2);
            }
            while(stack.peek() == 0) stack.pop();
            while(!stack.isEmpty()) sb.append(stack.pop());
            for(int i = 1 ; i < N.length() ; i++){
                c = N.charAt(i)-'0';
                for(int j = 0 ; j < 3 ; j++, c/=2){
                    stack.push(c%2);
                }
                while(!stack.isEmpty()) sb.append(stack.pop());
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}