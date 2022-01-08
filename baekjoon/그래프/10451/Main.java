import java.io.*;
import java.util.*;

public class Main {
    static int g[];
    static boolean[] visited;
    static int start;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < T ; i++){
            int N = Integer.parseInt(br.readLine());
            g = new int[N+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1 ; j <= N ; j++){
                g[j] = Integer.parseInt(st.nextToken());
            }
            sb.append(cycle(N)).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    static int cycle(int N){
        visited = new boolean[N+1];
        int count = 0;
        for(int i = 1 ; i <= N ; i++){
            if(!visited[i]) {
                start = i;
                if(i == find(i)) count++;
            }
        }
        return count;
    }
    static int find(int x){
        visited[x] = true;
        if(g[x] == x) return x;
        else if(g[x] == start) return start;
        else return find(g[x]);
    }
}