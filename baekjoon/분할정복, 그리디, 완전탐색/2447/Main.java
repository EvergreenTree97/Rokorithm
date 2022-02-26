import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb= new StringBuilder();
    static char arr[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        makeStar(N,0,0,false);
        for(int i = 0; i<N;i++){
            sb.append(arr[i]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    static void makeStar(int n, int x, int y, boolean blank){
        if(blank){
            for(int i = x ; i< x+n ; i++){
                for(int j = y; j< y+n;j++){
                    arr[i][j] = ' ';
                }
            }
            return;
        }
        if(n == 1){
            arr[x][y] = '*';
            return;
        }
        int size = n/3;
        int count = 0;
        for(int i = x ; i< x+n ; i += size){
            for(int j = y; j< y+n ; j+= size){
                count++;
                if(count == 5){
                    makeStar(size,i,j,true);
                }
                else{
                    makeStar(size,i,j,false);
                }
            }
        }
    }

}
