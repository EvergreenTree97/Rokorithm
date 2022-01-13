import java.io.*;
import java.util.*;


public class Main {
    static boolean visited[];
    static int parent[];
    static ArrayList<Integer>[] list;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        for(int i = 1 ; i <= N ; i++){
            list[i] = new ArrayList();
        }
        /* 1차원 배열을 통해 부모를 구하려고 했을 때
        * 1 6 이 아닌 6 1 같은 경우로 입력이 들어오면 꼬여버린다.
        * 따라서 그래프에 삽입하여여 dfs로 각 노드의 부모를 구함*/
        visited = new boolean[N+1];
        parent = new int[N+1];
        for(int i = 0 ; i < N-1 ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            list[n1].add(n2); list[n2].add(n1);
        }
        dfs(1);
        StringBuilder sb = new StringBuilder();
        for(int i = 2; i <= N ;i++){
            sb.append(parent[i]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    static void dfs(int n){
        visited[n] = true;
        for(int i : list[n]){
            if(!visited[i]){
                parent[i] = n;
                dfs(i);
            }
        }
    }
}
