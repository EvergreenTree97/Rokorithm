import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
    int num;
    String s;
    Node(int num, String s){
        this.num = num;
        this.s = s;
    }
}
public class Main {
    static int a,b;
    static boolean visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            visited = new boolean[10000];
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            sb.append(bfs()).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static String bfs() {
        Queue<Node> q = new LinkedList();
        q.offer(new Node(a,""));
        visited[a] = true;
        String res = "";
        while (!q.isEmpty()) {
//      1. 큐에서 꺼냄
            Node cur = q.poll();
//      2. 목적지인가
            if (cur.num == b){
                res = cur.s;
                break;
            }
//      3. 연결된 곳을 순회
            for(int i = 0 ; i < 4 ; i++){
                int next = 0;
                String nextStr = "";
                switch(i){
                    case 0:
                        next = D(cur.num);
                        nextStr = "D";
                        break;
                    case 1:
                        next = S(cur.num);
                        nextStr = "S";
                        break;
                    case 2:
                        next = L(cur.num);
                        nextStr = "L";
                        break;
                    case 3:
                        next = R(cur.num);
                        nextStr = "R";
                        break;
                }
//              4. 갈 수 있는가
//                   5. 체크인
//                   6. 큐에 넣는다
                if(!visited[next]){
                    visited[next] = true;
                    q.offer(new Node(next,cur.s+nextStr));
                }
            }
        }
        return res;
    }
    static int D(int d){
        d = (d * 2) % 10000;
        return d;
    }
    static int S(int s){
        if(s == 0){
            s = 9999;
        }else{
            s = s-1;
        }
        return s;
    }
    static int L(int l){
        return (l % 1000) * 10 + l/1000;
    }
    static int R(int r){
        return (r % 10) * 1000 + (r / 10);
    }


}
