import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int map[][];// 인덱스는 열, 값은 행
    static int N;
    static int min = Integer.MAX_VALUE;
    static boolean visited[];
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        visited = new boolean[N+1];
        for(int i = 1; i<= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1 ; j <= N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 1 ; i <= N ; i++){
            dfs(i,i,0);
        }
        System.out.print(min);
    }
    static void dfs(int start,int node, int weight){
        visited[node] = true;
        if(allVisited() && map[node][start] != 0){
            min = Math.min(min,weight+map[node][start]);
            visited[node] = false;
            return;
        }
        for (int i = 1; i <= N; i++) {
            if(map[node][i] != 0 && !visited[i]){
                dfs(start,i,weight+map[node][i]);
            }
        }
        visited[node] = false;
    }
    static boolean allVisited(){
        for(int i = 1; i <= N ; i++){
            if(!visited[i]){
                return false;
            }
        }
        return true;
    }
}
