import java.io.*;
import java.util.*;

public class Main {
    static boolean broken[];
    public static void main(String[] args) throws Exception {

        System.setIn(new FileInputStream("C:\\Users\\evergreen\\Documents\\hello-spring\\untitled\\src\\input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        broken = new boolean[10];
        int min = Math.abs(N-100);
        StringTokenizer st;
        if(M>0){
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                broken[Integer.parseInt(st.nextToken())] = true;
            }
        }
        for(int i = 0; i <= 1000000; i++) {
              int len = Solution(i);
              if(len != 0){
                  int count = Math.abs(i-N);
                  if(min > len+ count){
                     min = len+count;
                  }
              }
        }
        System.out.println(min);
    }
    private static int Solution(int n){
        int len=0;
        if(n == 0){
            if(broken[0])
                len = 0;
            else{
                len = 1;
            }
            return len;
        }
        while(n > 0){
            if(broken[n%10]){
                len = 0;
                return len;
            }
            len++;
            n /= 10;
        }
        return len;
    }
}
