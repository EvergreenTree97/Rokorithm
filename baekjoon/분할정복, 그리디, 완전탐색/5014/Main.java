import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int F,S,G,U,D;
    static boolean visited[];
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        visited = new boolean[F+1];
        int res = bfs();
        if(res == INF){
            System.out.print("use the stairs");
        }else{
            System.out.print(res);
        }
    }
    static int bfs(){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(S,0));
        int count = INF;
        visited[S] = true;
        while(!q.isEmpty()){
            Node cur = q.poll();
            if(cur.floor == G){
                count = Math.min(cur.count,count);
                //visited[cur.floor] = false;
                //bfs이기 때문에 맨 처음 도착한 값이 최소가 될 것이므로 필요 없는 코드였다.. 괜히 시간초과
            }
            if(cur.floor+U <= F && !visited[cur.floor+U]){
                visited[cur.floor+U] = true;
                q.add(new Node(cur.floor+U,cur.count+1));
            }
            if(cur.floor-D >=1 && !visited[cur.floor-D]){
                visited[cur.floor-D] = true;
                q.add(new Node(cur.floor-D,cur.count+1));
            }

        }
        return count;
    }

}
class Node{
    int floor, count;

    public Node(int floor, int count) {
        this.floor = floor;
        this.count = count;
    }
}
