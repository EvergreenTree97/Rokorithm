import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("C:\\Users\\evergreen\\Documents\\hello-spring\\untitled\\src\\input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int year=1;
        for(int i = 0 ; ;i++){
           int e = i % 15 +1;
           int s = i % 28 +1;
           int m = i % 19 +1 ;
           if(e == E && s == S && m == M){
              break;
           }
           year++;
        }
        System.out.print(year);
    }
}
