import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] g;
    static int count;
    static boolean[] finished;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < T ; i++){
            count= 0;
            n = Integer.parseInt(br.readLine());
            g = new int[n+1];
            visited = new boolean[n+1];
            finished = new boolean[n+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1 ; j <= n ;j++){
                g[j] = Integer.parseInt(st.nextToken());
            }
            for(int j = 1; j <= n ;j++){
                dfs(j);
            }
            sb.append(n-count).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void dfs(int node){
        // 사이클을 이룬 노드에대해서는 다시 방문할 필요가 없다.
        if(visited[node]) return;

        visited[node] = true;
        int nextNode = g[node];

        //아직 방문하지 않은 노드에 대해서는 스택에 삽입
        if(!visited[nextNode]){
            dfs(nextNode);
        }else{
            // 다음 노드가 방문했던 노드다? 다음 노드부터 사이클을 시작하면 사이클을 찾을 수 있다.
            if(!finished[nextNode]){
                count++;
                while(nextNode != node){
                    count++;
                    nextNode = g[nextNode];
                }
            }
        }
        finished[node] = true;

    }

}