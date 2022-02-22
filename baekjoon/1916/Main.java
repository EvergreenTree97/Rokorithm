import java.io.*;
import java.util.*;

public class Main {
    static List<Node> g[];
    static int dist[];
    static boolean visited[];
    static int N, M, S, E;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\evergreen\\Documents\\hello-spring\\untitled\\src\\input.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        StringTokenizer st;
        g = new ArrayList[N + 1];
        visited = new boolean[N+1];
        dist = new int[N+1];
        Arrays.fill(dist, INF);
        for (int i = 1; i <= N; i++) {
            g[i] = new ArrayList();
        }
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            g[s].add(new Node(e, v));
        }
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        dijkstra(S);
        bw.write(String.valueOf(dist[E]));
        bw.flush();
        bw.close();
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;
        while (!pq.isEmpty()) {
            Node n = pq.poll();
            int curNode = n.node;
            int curValue = n.value;
            if(dist[curNode] < curValue) continue;
            if(!visited[curNode]){
                visited[curNode] = true;

                for (Node next : g[curNode]) {
                    int nextNode = next.node;
                    int nextValue = next.value;
                    if (!visited[nextNode] && (dist[nextNode] > dist[curNode] + nextValue)){
                        dist[nextNode] = dist[curNode] + nextValue;
                        pq.add(new Node(nextNode,dist[nextNode]));

                    }
                }
            }
        }
    }
}

class Node implements Comparable<Node> {
    int node;
    int value;

    public Node(int node, int value) {
        this.node = node;
        this.value = value;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(value, o.value);
    }
}