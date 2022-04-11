import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Rect[] rects;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        visited = new boolean[N+1];
        rects = new Rect[N+1]; //단위는 사각형
        rects[0] = new Rect(0,0,0,0); //맨처음 좌표가 0에서 시작하니까 넣어주기
        for (int n = 1; n <= N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            rects[n] = new Rect(x1,x2,y1,y2);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i <= N; i++) {
            if(visited[i]) continue; //만약 방문했다면
            visited[i] = true; //방문완료
            q.add(i); //q에 삽입
            while (!q.isEmpty()){
                int cur = q.poll();
                for (int j = 0 ; j <= N ; j++){
                    if(cur == j || !check(cur,j) || visited[j]){ //동일 사각형이거나, 방문했거나,  선을 공유하지 않는다면
                        continue;
                    }
                    visited[j] = true;
                    q.add(j);
                }
            }
            count++;

        }
        System.out.print(count-1);
    }
    static boolean check(int cur, int next) {
        Rect c = rects[cur];
        Rect n = rects[next];
        if((c.x1 < n.x1 && n.x2 < c.x2 && c.y1 < n.y1 && n.y2 < c.y2)	// C가 N을 내포하는 경우
                || (c.x1 > n.x1 && n.x2 > c.x2 && c.y1 > n.y1 && n.y2 > c.y2) // N이 C를 내포하는 경우
                || c.x2 < n.x1 || c.x1 > n.x2 || c.y2 < n.y1 || c.y1 > n.y2)	// 아예 접점이 없는 경우
        {
            return false;}


        // C와 N이 공유하는 부분이 있는 경우

        return true;
    }

}
class Rect{
    int x1,x2,y1,y2;
    public Rect(int x1, int x2, int y1, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

}