import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb= new StringBuilder();
    static char arr[][];
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\evergreen\\Documents\\hello-spring\\untitled\\src\\input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        arr = new char[N][N*2-1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N*2-1; j++) {
                arr[i][j] = ' ';
            }
        }
        makeStar(N,0,N-1);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N*2-1; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    static void makeStar(int n, int x, int y) {
        if(n == 3){
            arr[x][y] = '*';
            arr[x+1][y-1] = arr[x+1][y+1] = '*';
            arr[x+2][y-2] = arr[x+2][y-1] =
                    arr[x+2][y] = arr[x+2][y+1] = arr[x+2][y+2] = '*';
            return;
        }
        makeStar(n/2,x,y);
        makeStar(n/2,x+n/2,y-n/2);
        makeStar(n/2,x+n/2,y+n/2);
    }
}
