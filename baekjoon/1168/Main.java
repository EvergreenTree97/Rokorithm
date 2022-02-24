import java.io.*;
import java.util.*;

public class Main {
    static int tree[];
    static int N,K,S = 1;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\evergreen\\Documents\\hello-spring\\untitled\\src\\input.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        while(S < N) {
            S <<= 1;
        }
        tree = new int[S*2];
        int x = K; //시작은 K번째 사람
        StringBuilder sb= new StringBuilder();
        sb.append("<");
        init(1,N,1); //N번째 사람에 대해 1씩 초기화 해주고, 부분합을 초기화해줌
        //인덱스트리는 a~b번까지의사람이 몇명 앉아있는지를 의미함
        for (int i = 0; i < N-1; i++) {
            sb.append(query(1,N,1,x)).append(", "); //x번째 사람을 찾고 제거
            x += K-1; //다음 사람을 찾기
            if(x% tree[1] == 0) x = tree[1]; //tree[1]은 남은 사람 수, 같다면 나머지 연산 안됨
            else x %= tree[1]; //남은 사람수를 넘어가면 원형 큐처럼 % 연산
        }
        sb.append(query(1,N,1,x)).append(">");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    static int init(int left, int right, int node){
        if(left == right) return tree[node] = 1;
        int mid = (left+right)/2;
        return tree[node] = init(left,mid,node * 2) + init(mid+1,right,node * 2 + 1);
    }
    static int query(int left, int right, int node,int target){
        tree[node]--; //사람 수를 감소
        if(left==right) return left; //만약 리프노드에 도착했다면 target번째 사람을 리턴
        int mid = (left+right)/2;
        if(tree[2 * node] >= target){ //왼쪽 트리에 찾는 사람이 존재한다면
            return query(left,mid,node * 2,target); //왼쪽으로 이동
        }else{ //그게 아니라면 target에서 왼쪽에 남아있는 사람을 제거한 target 번째 사람을 찾기
            return query(mid+1,right,node*2+1,target-tree[2*node]);
        }
    }
}

