import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        Stack<Character> stack = new Stack();
        ArrayList<Integer> arr = new ArrayList<>(); // 레이저 배열(닫는 괄호 인덱스)
        int sum = 0;
        for(int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);
            if(s.charAt(i) == '(') { //여는 괄호 추가
                stack.push(c);
                continue;
            }
            if(s.charAt(i) == ')'){ //닫힌 괄호일 경우
                stack.pop();
                // 전 괄호가 열린 괄호면 레이저이므로, 이전까지의 stack 사이즈가 잘린 토막이 된다.
                if(s.charAt(i-1) =='(') sum += stack.size();
                else sum++; //레이저가 아닌 토막의 끝이므로, 뒤쪽 한 단 +1
            }
        }
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}