import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int g[][];
    static boolean visited[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        g = new int[N+1][N+1];
        visited = new boolean[N+1];
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            g[v1][v2] = 1; g[v2][v1] = 1;
        }
        dfs(N,V);
        visited = new boolean[N+1];
        sb.append("\n");
        bfs(N,V);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    static void dfs(int N,int start){
        Stack<Integer> s = new Stack<>();
        s.push(start);
        while(!s.isEmpty()){
            int v = s.pop();
            if(!visited[v]){
                visited[v] = true;
                sb.append(v+" ");
                for(int i = N; i>= 1 ;i--){
                    if(g[v][i] == 1 && !visited[i]){
                         s.push(i);
                    }
                }
            }
        }
    }
    static void bfs(int N,int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        while(!q.isEmpty()){
            int v = q.poll();
            if(!visited[v]){
                visited[v] = true;
                sb.append(v+" ");
                for(int i = 1 ; i <= N ; i++){
                   if(g[v][i] == 1 && !visited[i]){
                       q.offer(i);
                   }
                }
            }
        }
    }
}

