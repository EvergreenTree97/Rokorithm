import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i; //각각의 노드들의 부모는 자기 자신으로 초기화
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            union(v1,v2);
        }
        int count = 0 ;
        for(int i = 1 ; i <= N ;i++){
            if(parent[i] == i) count++;
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
    /* 기존에 사용했던 방법 -> 모든 노드에 대해 연결 요소를 탐색하는 것
     * 유니온 파인드 알고리즘 학습 - 합집합 찾기 알고리즘
    /* union(a,b) a가 속한 집합과 b가 속한 집합을 합침 */
    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if(pa != pb){ //만약 부모가 같지 않다면 다른 파벌이니까 합쳐야함!
            parent[pb] = pa;
        }
    }

    /* find(a) a가 속한 집합의 루트 찾기 */
    private static int find(int a) {
       if(parent[a] == a) return a; //만약 자기 자신이 부모라면 해당 집합에 속함
       return parent[a] = find(parent[a]); //아니라면 부모를
    }
}