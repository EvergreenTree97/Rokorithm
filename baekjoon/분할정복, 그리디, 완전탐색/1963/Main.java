import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static boolean prime[];
    static final int MAX = 10000;
    static int count[];
    static boolean visited[];
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        prime = new boolean[MAX];
        prime[0] = prime[1] = true;
        for(int i = 2 ; i < Math.sqrt(MAX) ; i++){
            if(!prime[i]){
                for (int j = i * i; j < MAX; j = j + i) {
                    prime[j] = true;
                }
            }
        }

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            visited = new boolean[MAX];
            count = new int[MAX];
            bfs(a);
            sb.append(count[b]+"\n");
        }


        System.out.print(sb.toString());

    }
    static void bfs(int start){
        Queue<Integer> q = new LinkedList();
        q.offer(start);
        visited[start] = true;
        while(!q.isEmpty()){
            int cur = q.poll();
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j <= 9; j++) {
                    if(i == 0 && j == 0){
                        continue;
                    }
                    int k = change(cur,i,j);
                    if(!prime[k] && !visited[k]){
                        count[k] = count[cur]+1;
                        visited[k] = true;
                        q.add(k);
                    }
                }
            }

        }
    }
    static int change(int num, int i, int v){
        StringBuilder sb = new StringBuilder(String.valueOf(num));
        sb.setCharAt(i,(char)(v+'0'));
        return Integer.parseInt(sb.toString());
    }
}
