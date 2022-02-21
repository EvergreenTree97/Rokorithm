import java.io.*;
import java.util.*;

public class Main {
    static int arr[][];
    static int T;
    static StringBuilder sb = new StringBuilder();
    public static void main(String args[]) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\tkdfh\\IdeaProjects\\Algorithm\\src\\input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        arr = new int[T][T];
        for (int i = 0; i < T; i++) {
            String s = br.readLine();
            for (int j = 0; j < T; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        recursion(0,0,T);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void recursion(int x, int y, int size) {
        if (size == 1) {
            sb.append(arr[x][y]);
            return;
        }
        int N = x + size;
        int M = y + size;
        if (isAvailable(x,y,N,M)){
            sb.append(arr[x][y]);
            return;
        }
        sb.append("(");
        for (int i = x; i < x+size; i += size/2) {
            for (int j = y; j < y+size; j += size/2) {
                recursion(i,j,size/2);
            }
        }
        sb.append(")");
    }
    static boolean isAvailable(int x, int y,int N, int M){
        int temp = arr[x][y];
        for (int i = x; i< N ;i++){
            for(int j = y; j< M ; j++){
                if(temp != arr[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}