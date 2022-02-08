import java.io.*;
import java.util.*;
import java.util.List;

public class Main {
    static int n, m, t, s, g, h;
    static List<Node>[] map;
    static int[] dist;
    static final int INF = 2000 * 50000; //결과가 INF를 넘을 수 있으므로, 최대 값은 Integer의 max가 아닌 간선 x 가중치 여야함
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\evergreen\\Documents\\hello-spring\\untitled\\src\\input.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            PriorityQueue result = new PriorityQueue();
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); //교차로
            m = Integer.parseInt(st.nextToken()); //도로
            t = Integer.parseInt(st.nextToken()); //목적지 후보
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken()); //출발지
            g = Integer.parseInt(st.nextToken()); //지나간 도로의 정점2
            h = Integer.parseInt(st.nextToken()); //지나간 도로의 정점2
            dist = new int[n + 1];
            map = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                map[i] = new ArrayList<>();
            }
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                if((a == g && b == h) || (a == h && b == g)){
                    d = d*2-1;
                }else{
                    d = d*2;
                }
                map[a].add(new Node(b, d));
                map[b].add(new Node(a, d));
            }
            for (int i = 0; i < t; i++) {
                int predictT = Integer.parseInt(br.readLine());
                if(dijkstra(s, predictT) % 2 == 1){
                     result.add(predictT);
                }
            }
            while (!result.isEmpty()){
                sb.append(result.poll()).append(" ");
            }
            sb.append("\n");

        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static int dijkstra(int start, int end) {

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        Arrays.fill(dist, INF); //최단 거리를 저장할 변수 초기화
        dist[start] = 0;
        priorityQueue.add(new Node(start, 0));
        while (!priorityQueue.isEmpty()) { //1 부터 N까지의 최단 거리 갱신
            Node cur = priorityQueue.poll();
            if (dist[cur.node] < cur.cost) continue; //최소 간선이랍시고 델고왔는데 더 크다? 뭘 더해도 dist보단 작을 것
            for (Node n : map[cur.node]) { //cur과 이어져 있는 간선들과 비교
                if (dist[n.node] > cur.cost + n.cost) { //현재 코스트에, 방금 뽑은거의 코스트가 원래 거리보다 작다면 바꿈
                    dist[n.node] = cur.cost + n.cost;
                    priorityQueue.add(new Node(n.node, dist[n.node]));
                }
            }
        }
        return dist[end];
    }
}

class Node implements Comparable<Node> {
    int node;
    int cost;

    public Node(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(cost, o.cost);
    }
}