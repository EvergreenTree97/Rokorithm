package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	 static int S;
	 static long tree[];
	 static final int MOD = 1000000007;
     public static void main(String[] args) throws IOException{
    	 System.setIn(new FileInputStream("C:\\Users\\evergreen\\eclipse-workspace\\baekjoon\\src\\baekjoon\\input.txt"));
    	 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	 StringTokenizer st = new StringTokenizer(br.readLine());
    	 int N = Integer.parseInt(st.nextToken());
    	 int M = Integer.parseInt(st.nextToken());
    	 int K = Integer.parseInt(st.nextToken());
    	 S = 1;
    	 while(S < N) {
    		 S = S << 1;
    	 }
    	 
    	 tree = new long[S * 2];
    	 for(int i = 1 ; i < S*2 ; i++) {
    		 tree[i] = 1;
    	 }
    	 for(int i = S ; i < S+N ; i++) {
    		 tree[i] = Long.parseLong(br.readLine());
    	 }
    	 init(1,S,1);
    	 StringBuilder sb = new StringBuilder();
    	 for(int i = 0 ; i < M+K ;i++) {
    		 st = new StringTokenizer(br.readLine());
             int a = Integer.parseInt(st.nextToken());
             int b = Integer.parseInt(st.nextToken());
             long c = Long.parseLong(st.nextToken());
             if(a == 1){
                 update(1,S,1,b,c);
             }else{
                 sb.append(query(1,S,1,b,(int)c)).append("\n");
             }
    	 }
    	 bw.write(sb.toString());
    	 bw.flush();
    	 bw.close();
     }
     static long init(int left, int right,int node){
    	 if(node < S) {
    		 int mid = (left+right)/2;
        	 long l = init(left, mid,node * 2);
        	 long r = init(mid + 1, right, node * 2 + 1);
        	 tree[node] = (l * r) % MOD;
        	 return tree[node];
    	 }else {
    		 return tree[node];
    	 } 
     }
     static long query(int left, int right, int node, int leftQuery, int rightQuery) {
         if(leftQuery > right || rightQuery < left) return 1;
         else if(left >= leftQuery && right <= rightQuery) {
        	 return tree[node];
         }else {
        	 int mid = (left+right)/2;
        	 long l = query(left,mid,node * 2,leftQuery,rightQuery);
        	 long r = query(mid+1,right,node * 2 + 1,leftQuery,rightQuery);
        	 return (l*r) % MOD;
         }
     }
     static void update(int left, int right, int node,int target, long diff) {
    	 if(target < left || target >right) {
    		 return;
    	 }else {
    		 if(node < S) {
        		 int mid = (left+right)/2;
            	 update(left, mid,node * 2,target,diff);
            	 update(mid+1, right, node * 2 +1, target, diff);
            	 tree[node] = (tree[node*2] * tree[node*2+1]) % MOD;
        	 }else {
        		 tree[node] = diff;
        	 } 
    		 
    	 }
     }
}
