package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[][] dp;
	static int N,M,K;
    static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		System.setIn(
				new FileInputStream("C:\\Users\\evergreen\\eclipse-workspace\\baekjoon\\src\\baekjoon\\input.txt"));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    K = Integer.parseInt(st.nextToken());
        dp = new int[201][101];
        sb =new StringBuilder();
        //사전에 등재된 문자열의 개수가 K보다 작을 떄
        if(K > combination(N+M,M)) {
        	sb.append(-1);
        }else {
        	query(N,M,K);
        }
        bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	//O(N^2)의 시간복잡도
	static void query(int n, int m,int k) {
		//모든 문자를 다 썼다면 리턴
		if(n + m == 0) {
			return;
		//n이 0이라는 것은 a를 다썼다는 것
		}else if(n == 0) {
			sb.append("z");
			query(n,m-1,k);
		//m이 0이라는 것은 z를 다 썼다는 것	
		}else if(m == 0) {
			sb.append("a");
			query(n-1,m,k);
		}else {
			//4c3 먼저 확인
			int leftCount = combination(n+m-1,m);
			if(leftCount >= k) { //a로 시작한다는 뜻
				sb.append("a");
				query(n-1,m,k);
			}else { //z로 시작함
				sb.append("z");
				// z로 시작한다면 다음 문자열은 (k-leftCount) 문자열을 찾으면 된다. 
				query(n,m-1,k-leftCount);
			}
		}
	}
	
    static int combination(int n,int r) {
    	if(n == r || r ==0 ) { //n과 r이 같거나, 
    		return 1;
    	}else if(dp[n][r] != 0){ //스택에서 리턴될 떄
    		return dp[n][r];
    	}else { //최대값을 넘어가면 10억으로 치환
     		return dp[n][r] = Math.min((int) 1e9, combination(n-1,r-1)+combination(n-1,r));
    	}
    }
}
