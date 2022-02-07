import java.io.*;
import java.util.*;
import java.util.List;

public class Main {
    static int N, E;
    static List<Node>[] g;
    static int[] dist;
    static boolean[] check;
    static final int INF = 200000000; //결과가 INF를 넘을 수 있으므로, 최대 값은 Integer의 max가 아닌 간선 x 가중치 여야함
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\evergreen\\Documents\\hello-spring\\untitled\\src\\input.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        g = new ArrayList[N+1];
        dist = new int[N+1];
        for (int i = 1; i <= N; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            g[a].add(new Node(b, c));
            g[b].add(new Node(a, c));
        }
        st = new StringTokenizer(br.readLine());

        int answer = 0;
        //시작점 -> v1 -> v2 -> 도착점 구하기
        int V1 = Integer.parseInt(st.nextToken());
        int V2 = Integer.parseInt(st.nextToken());
        int startToV1 = dijkstra(1,V1);
        int v1ToV2 = dijkstra(V1,V2);
        int res = startToV1+v1ToV2+dijkstra(V2,N);

        //시작점 -> v2 -> v1 -> 도착점 구하기
        int startToV2 = dijkstra(1,V2);
        int v2ToV1 = dijkstra(V2,V1);
        int res2 = startToV2 + v2ToV1 +dijkstra(V1,N);


        if(res  >= INF && res2 >= INF){ //매번 다익스트라를 할 때마다 체크해 주는 것이 더 빠름.
                                        //왜? 매번 다익스트라에서 최단 거리를 못찾으면 INF가 반환되기 떄문이다.
            answer = -1;
        }else{
            answer = Math.min(res,res2);
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
    static int dijkstra(int start,int end){

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        Arrays.fill(dist,INF); //최단 거리를 저장할 변수 초기화
        dist[start] = 0;
        priorityQueue.add(new Node(start,0));
        while (!priorityQueue.isEmpty()){ //1 부터 N까지의 최단 거리 갱신
            Node cur = priorityQueue.poll();
            if(dist[cur.node] < cur.cost) continue; //최소 간선이랍시고 델고왔는데 더 크다? 뭘 더해도 dist보단 작을 것
            for(Node n : g[cur.node]){ //cur과 이어져 있는 간선들과 비교
                if(dist[n.node] > cur.cost + n.cost){ //현재 코스트에, 방금 뽑은거의 코스트가 원래 거리보다 작다면 바꿈
                    dist[n.node] = cur.cost + n.cost;
                    priorityQueue.add(new Node(n.node,dist[n.node]));
                }
            }
        }
        return dist[end];
    }
}
class Node implements Comparable<Node>{
    int node;
    int cost;

    public Node(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(cost,o.cost);
    }
}