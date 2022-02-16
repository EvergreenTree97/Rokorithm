import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int res[];
    static int arr[][];
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\evergreen\\Documents\\hello-spring\\untitled\\src\\input.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        res = new int[3];
        divide(0,0,N);
        StringBuilder sb= new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            sb.append(res[i]+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    static void divide(int x, int y, int MAX){
        if(MAX == 1){
            res[arr[x][y]+1]++; //-1은 0 , 0은 0, 1는 2
            return;
        }
        int N = x+MAX;
        int M = y+MAX;
        if(isAvaiable(x,y,N,M)){
            res[arr[x][y]+1]++;
            return;
        }

        //N/3 씩 잘라서 분할해야함
        for (int i = x; i < x+MAX; i += MAX/3) {
            for (int j = y; j < y+MAX; j += MAX/3) {
                divide(i,j,MAX/3);
            }
        }
    }
    static boolean isAvaiable(int x, int y, int N, int M){
        int temp = arr[x][y];
        for (int i = x; i < N; i++) {
            for (int j = y; j < M; j++) {
                if(temp != arr[i][j]){
                   return false;
                }
            }
        }
        return true;
    }
}
