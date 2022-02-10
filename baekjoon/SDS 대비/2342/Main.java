package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int[][][] dp;
	static int[] direction;
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		System.setIn(
				new FileInputStream("C:\\Users\\evergreen\\eclipse-workspace\\baekjoon\\src\\baekjoon\\input.txt"));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        direction = new int[100000+1];
        int a = 1, N;
        while(true) {
        	String s = st.nextToken();
        	if(s.equals("0")) {
        		N = a-1;
        		break;
        	}
        	direction[a++] = Integer.parseInt(s);
        }
        dp = new int[N+1][5][5]; //n��° ȭ��ǥ, �޹��� j, �������� k �� �� ��� �ּҰ�
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= 4; j++) {
                for (int k = 0; k <= 4; k++) {
                   dp[i][j][k] = INF; //���Ѵ�� �ʱ�ȭ
                }
            }
        }
        int next;
        dp[1][0][direction[1]] = 2; //ù ��° ȭ��ǥ�� �޹߷� ����
        dp[1][direction[1]][0] = 2; //ù ��° ȭ��ǥ�� �����߷� ����
        for(int i = 1; i <= N-1; i++) {
        	for(int j = 0; j <= 4 ;j++) {
        		for(int k = 0 ; k <= 4 ; k++) {
        			if(dp[i][j][k] != INF) { //������� ��� ����� ���� ��쿡�� ���
        				 next = direction[i+1];
        				 if(k != next){ //���� ��ġ�� �� ���� ������ �ȵǹǷ� �������� ��ġ�� �޹߷� ���
        					 dp[i+1][next][k] = Math.min(dp[i+1][next][k],dp[i][j][k] + getCost(j,next));
        				 }
        				 if(j != next) { // �����߷� ���
        				     dp[i+1][j][next] = Math.min(dp[i+1][j][next],dp[i][j][k] + getCost(k,next));
        				 }
        			}
        		}
        	}
        }
        int ans = INF;
        //������ ȭ��ǥ�� �������� �� ���� �޹�, ������ ��ġ�� ���� �ִ밪
        for(int j = 0 ; j <= 4; j++) {
        	for(int k = 0 ; k <= 4 ;k++) {
        		ans = Math.min(ans, dp[N][j][k]);
        	}
        }
        bw.write(ans+"\n");
		bw.flush();
		bw.close();
	}
	 static int getCost(int from, int to){
	        if(from == 0) return 2;
	        else if(from == to) return 1;
	        else if(Math.abs(from-to) == 2) return 4;
	        else return 3;
	    }

}
