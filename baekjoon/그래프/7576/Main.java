import java.io.*;
import java.util.*;

public class Main {
    static int g[][];
    static boolean visited[][];
    static int dx[] = {1,0,-1,0};
    static int dy[] = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        g = new int[w][h];
        visited = new boolean[w][h];
        boolean allRipe = true;

        //조건문을 심기보다 단순히 카운트를 증가시켜서 카운트 >0 이면 모두 익은것으로 하는게 빠를듯
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                g[j][i] = Integer.parseInt(st.nextToken());
                if(g[j][i] != 1) allRipe = false;
            }
        }
        if(allRipe){
            sb.append(0);
        }else{
            int max = 0;
            bfs(w,h);
            boolean isAllRipe = true;
            //체크 부분도 함수에 넣어서, 0이 하나라도 나왔다면 리턴하는 식으로 해서
            //전체 연산을 줄이는 방법도 있다.
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if(g[j][i] == 0) isAllRipe = false;
                    if(max < g[j][i]) max = g[j][i];
                }
            }
            if (isAllRipe) {
                sb.append(max-1);
            } else {
                sb.append(-1);
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
}

    /*
     * 주변 토마토를 익어가게 해야 하니 bfs
     * */
    static void bfs(int w, int h) {
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (g[j][i] == 1) {
                    q.offer(new int[]{j, i});
                    visited[j][i] = true;
                }
            }
        }
        while (!q.isEmpty()) {
            int p[] = q.poll();
            int curX = p[0];
            int curY = p[1];
            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                if (nextX >= 0 && nextX < w && nextY >= 0 && nextY < h) {
                    if (g[nextX][nextY] == 0 && !visited[nextX][nextY]) {
                        visited[nextX][nextY] = true;
                        g[nextX][nextY] = g[curX][curY]+1;
                        q.offer(new int[]{nextX, nextY});
                    }else {
                        continue;
                    }
                }
            }
        }
    }
}