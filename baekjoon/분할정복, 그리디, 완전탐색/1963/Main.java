import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static final int MAX = 100001;
    static boolean visited[] = new boolean[MAX];

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(N, 0));
        visited[N] = true;
        int count = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node.n == K) {
                count = Math.min(node.count, count);
            }
            if (node.n - 1 >= 0 && !visited[node.n - 1]) {
                q.offer(new Node(node.n - 1, node.count + 1));
                visited[node.n-1] = true;
            }
            if (node.n + 1 < MAX && !visited[node.n + 1]) {
                q.offer(new Node(node.n + 1, node.count + 1));
                visited[node.n+1] = true;
            }
            if (node.n * 2 < MAX && !visited[node.n * 2]) {
                q.offer(new Node(node.n * 2, node.count + 1));
                visited[node.n*2] = true;
            }
        }
        System.out.print(count);
    }
}

class Node {
    int n;
    int count;

    public Node(int n, int count) {
        this.n = n;
        this.count = count;
    }
}
