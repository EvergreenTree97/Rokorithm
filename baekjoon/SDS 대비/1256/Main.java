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
        //������ ����� ���ڿ��� ������ K���� ���� ��
        if(K > combination(N+M,M)) {
        	sb.append(-1);
        }else {
        	query(N,M,K);
        }
        bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	//O(N^2)�� �ð����⵵
	static void query(int n, int m,int k) {
		//��� ���ڸ� �� ��ٸ� ����
		if(n + m == 0) {
			return;
		//n�� 0�̶�� ���� a�� �ٽ�ٴ� ��
		}else if(n == 0) {
			sb.append("z");
			query(n,m-1,k);
		//m�� 0�̶�� ���� z�� �� ��ٴ� ��	
		}else if(m == 0) {
			sb.append("a");
			query(n-1,m,k);
		}else {
			//4c3 ���� Ȯ��
			int leftCount = combination(n+m-1,m);
			if(leftCount >= k) { //a�� �����Ѵٴ� ��
				sb.append("a");
				query(n-1,m,k);
			}else { //z�� ������
				sb.append("z");
				// z�� �����Ѵٸ� ���� ���ڿ��� (k-leftCount) ���ڿ��� ã���� �ȴ�. 
				query(n,m-1,k-leftCount);
			}
		}
	}
	
    static int combination(int n,int r) {
    	if(n == r || r ==0 ) { //n�� r�� ���ų�, 
    		return 1;
    	}else if(dp[n][r] != 0){ //���ÿ��� ���ϵ� ��
    		return dp[n][r];
    	}else { //�ִ밪�� �Ѿ�� 10������ ġȯ
     		return dp[n][r] = Math.min((int) 1e9, combination(n-1,r-1)+combination(n-1,r));
    	}
    }
}
