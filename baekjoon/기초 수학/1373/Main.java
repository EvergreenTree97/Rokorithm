import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String N = br.readLine();
        bw.write(trans(N));
        bw.flush();
        bw.close();
    }
    static String trans(String N){
        Stack<Character> stack = new Stack();
        int last = N.length() % 3;
        int iter = N.length() / 3;
        for(int i = 0,j = N.length(); i < iter ; i++, j -= 3){
            String s = N.substring(j-3,j);
            stack.push(extract(s));
        }
        if(last != 0) stack.push(extract(N.substring(0,last)));
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }
    static char extract(String s){
        int sum = 0;
        for(int i = s.length()-1, j = 0;i>=0 ;i--,j++){
            int c = s.charAt(i)-'0';
            sum += (c * Math.pow(2,j));
        }
        return (char)(sum+'0');
    }
}