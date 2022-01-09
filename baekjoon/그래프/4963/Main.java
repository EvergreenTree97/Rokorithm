import java.io.*;
import java.util.*;

public class Main {
    static int g[][];
    static boolean visited[][];
    static int dx[] = {1, 1, 1, 0,-1,-1,-1, 0};
    static int dy[] = {0, 1,-1,-1,-1, 0, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb= new StringBuilder();
        while(true){
            StringTokenizer st= new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            if(w == 0 && h== 0) break;
            g = new int[w][h];
            visited = new boolean[w][h];
            for(int i = 0; i < h ;i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0 ; j < w ;j++){
                    g[j][i] = Integer.parseInt(st.nextToken());
                }
            }
            int count = 0;
            for(int i = 0; i < h ;i++){
                for(int j = 0 ; j < w ;j++){
                    if(g[j][i] == 1 && !visited[j][i]){
                        dfs(j,i,w,h);
                        count++;
                    }
                }
            }
            sb.append(count+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    /*
    * dfs
    * */
    static void dfs(int x, int y,int w, int h) {
        Stack<int[]> s = new Stack();
        s.push(new int[]{x,y});
        visited[x][y] = true;
        while (!s.isEmpty()) {
            int p[] = s.pop();
            int curX = p[0];
            int curY = p[1];
            for (int i = 0; i < 8; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                if (nextX >= 0 && nextX < w && nextY >= 0 && nextY < h) {
                    if (g[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                        visited[nextX][nextY] = true;
                        s.push(new int[]{nextX, nextY});
                    }
                }
            }
        }
    }
}