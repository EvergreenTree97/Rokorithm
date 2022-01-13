import java.io.*;
import java.util.*;

public class Main {
    static boolean visited[];
    static ArrayList<int[]>[] g;
    static int V;
    static int node=0, max = 0;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        V = Integer.parseInt(br.readLine());
        g = new ArrayList[V+1];
        for(int i = 0 ; i <= V ;i++){
            g[i] = new ArrayList<>();
        }
        for(int i = 1 ; i < V ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            g[p].add(new int[]{c,w});
            g[c].add(new int[]{p,w});
        }
        visited = new boolean[V+1];
        dfs(1,0); //어느 노드에서도 상관없이 가장 먼 거리의 노드를 찾는다
        visited = new boolean[V+1];
        dfs(node,0); //그 노드에서 가장 먼 거리에서 있는 노드가 서로 가장 먼 거리이다.
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }
    static void dfs(int x,int len){
        if(len > max){ //가장 멀리 있는 노드의 길이와 노드를 찾는다.
            max = len;
            node = x;
        }
        visited[x] = true;
        for(int i[] : g[x]){
            int v = i[0]; int w = i[1];
            if(!visited[v]){
                dfs(v,w+len);
                visited[v] = true;
            }
        }
    }

}
