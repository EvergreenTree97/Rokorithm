import java.awt.*;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static String str;
    static int N, M, K;
    static boolean visited[][];
    static int MAX = 1000000;
    static int res = -1;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\evergreen\\Documents\\hello-spring\\untitled\\src\\input.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        str = st.nextToken();
        N = Integer.parseInt(str);
        M = str.length();
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[MAX + 1][K + 1]; // visited[최대숫자][변경횟수]
        bfs();
        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
    }

    static void bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(N, 0));
        visited[N][0] = true;
        while (!queue.isEmpty()) {
            //1. 큐에서 꺼냄
            Point p = queue.poll();
            //2. 목적지인가?
            if (p.y == K) {
                res = Math.max(res,p.x);
                break;
            }
            //3. 연결된 곳을 순회
            for (int i = 0; i < M - 1; i++) {
                for (int j = i + 1; j < M; j++) {
                    //4.   갈 수 있는가?
                    String curStr = String.valueOf(p.x);
                    if(curStr.charAt(j) == '0' && i == 0){ //바꿔서 앞이 0 이된다면
                        continue;
                    }
                    int next = swap(curStr,i,j);

                    // 같은 순서에, 이미 방문했던 문자열이라면,
                    //  그 이후는 똑같으니까 다시 방문하지 않아도 된다. 가지치기
                    if(!visited[next][p.y+1]){
                        //5.       체크인
                        visited[next][p.y+1] = true;
                        //6.       enqueue
                        queue.add(new Point(next,p.y+1));
                    }

                }
            }
        }
        while (!queue.isEmpty()){
            res = Math.max(res,queue.poll().x);
        }
    }
    static int swap(String s,int i,int j){
        //s의 i와 j를 스왑
        StringBuilder sb = new StringBuilder(s);
        char temp = sb.charAt(i);
        sb.setCharAt(i,sb.charAt(j));
        sb.setCharAt(j,temp);
        return Integer.parseInt(sb.toString());
    }

}