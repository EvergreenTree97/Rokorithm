import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int K= Integer.parseInt(br.readLine());
        for(int i = 0 ; i < K ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V= Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            ArrayList<Integer>[] g = new ArrayList[V+1];
            for(int j = 1 ; j <= V ;j++){
                g[j] = new ArrayList<>();
            }
            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());
                g[v1].add(v2); g[v2].add(v1);
            }
            bw.write(bfs(g,V));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
    static String bfs(ArrayList<Integer> g[], int V){
        Queue<Integer> q = new LinkedList<>();
        int visited[] = new int[V+1];
        int color = 1; //bfs에서 인접 정점을 탐색할 때 마다, color를 반전 해 가면서 칠해준다.
        for(int i = 1 ; i <= V ;i++){
             if(visited[i] == 0){
                 q.offer(i);//비연결그래프 일 수도 있기 때문에, 모든 정점에서 시작하여 확인 해주어야 한다.
                 visited[i] = color; //초기 color로 색칠 해 준다.
             }
             while(!q.isEmpty()){
                int v = q.poll();
                for(int j : g[v]){
                    if(visited[j] == 0){ //아직 방문하지 않은 정점이라면 반전 색깔 칠하고 큐에 삽입
                        visited[j] = -visited[v];
                        q.offer(j);
                    }else if(visited[j] == visited[v]){ //만약 인접 정점끼리의 색깔이 같다면 이분그래프가 아님
                        return "NO";
                    }
                }
            }
        }
        return "YES";
    }

}