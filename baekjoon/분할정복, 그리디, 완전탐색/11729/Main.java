import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int count = 0;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\evergreen\\Documents\\hello-spring\\untitled\\src\\input.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        hanoi(N,1,3,2);
        bw.write(String.valueOf(count+"\n"));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    //start에서 to로 via를 거쳐 총 N개의 원반을 운반할때 이동경로
    static void hanoi(int N,int start, int to , int via){
          if(N == 1) {
              count++;
              sb.append(start+" "+to).append("\n");
          }else{

              //먼저 위의 작은 원반들을 통로로 옮김
              hanoi(N-1,start,via,to);
              //이후 옮길 원반을 to로 옮김
              count++;
              sb.append(start+" "+to).append("\n");
              //start를 경유하여 위로 옮김
              hanoi(N-1,via,to,start);
          }
    }
}
