import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> s = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for(int i = 0 ; i< N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()){
                case "push" :
                    s.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop" :
                    if(s.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(s.pop()).append("\n");
                    break;
                case "size" :
                    sb.append(s.size()).append("\n");
                    break;
                case "empty" :
                    if(s.isEmpty()) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;
                case "top" :
                    if(s.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(s.peek()).append("\n");
                    break;
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}