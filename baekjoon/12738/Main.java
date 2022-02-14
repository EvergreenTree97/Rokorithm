import java.io.*;
import java.util.*;

public class Main {
    static int N, S = 1;
    static int input[],num[], tree[];
    static final int MAX = 1000000;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\evergreen\\Documents\\hello-spring\\untitled\\src\\input.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        input = new int[N];
        num = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
            num[i] = input[i];
        }
        Arrays.sort(input);
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        hashMap.put(input[0],1);
        int dup = input[0];
        for(int i = 1, pos = 2; i < N ;i++){
            if(input[i] == dup){
                continue;
            }else{
                hashMap.put(input[i],pos);
                pos++;
                dup = input[i];
            }
        }
        int idx = 0;
        for (int i : num) {
            num[idx] = hashMap.get(i);
            idx++;
        }

        while(S < MAX){
            S = S << 1;
        }
        tree = new int[S * 2];
        int ans = 0;
        for(int i = 0 ; i < N ;i++){
            int cur = query(1,MAX,1,1,num[i]-1);
            if(ans < cur+1){
                ans = cur+1;
            }
            update(1,MAX,1,num[i],cur+1);
        }
        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
    //최대값을 찾는 쿼리
    static int query(int left, int right, int node, int leftQuery, int rightQuery){
       if(leftQuery > right || rightQuery < left) return 0; //범위에 속하지 않음
       if(leftQuery <= left && rightQuery >= right) return tree[node];
       int mid = (left+right)/2;
       int l = query(left,mid,node * 2, leftQuery,rightQuery);
       int r = query(mid+1,right,node * 2 + 1, leftQuery, rightQuery);
       return Math.max(l,r);
    }
    static void update(int left,int right,int node, int target, int value){
        if(target > right || target < left) return; //범위에 없음
        tree[node] = Math.max(tree[node],value);
        if(left != right){
            int mid = (left+right)/2;
            update(left,mid,node * 2,target,value);
            update(mid+1,right, node * 2 + 1, target,value);
        }
    }


}
