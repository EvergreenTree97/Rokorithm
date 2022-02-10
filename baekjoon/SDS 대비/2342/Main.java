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
        dp = new int[N+1][5][5]; //n번째 화살표, 왼발은 j, 오른발은 k 일 때 드는 최소값
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= 4; j++) {
                for (int k = 0; k <= 4; k++) {
                   dp[i][j][k] = INF; //무한대로 초기화
                }
            }
        }
        int next;
        dp[1][0][direction[1]] = 2; //첫 번째 화살표를 왼발로 밟음
        dp[1][direction[1]][0] = 2; //첫 번째 화살표를 오른발로 밟음
        for(int i = 1; i <= N-1; i++) {
        	for(int j = 0; j <= 4 ;j++) {
        		for(int k = 0 ; k <= 4 ; k++) {
        			if(dp[i][j][k] != INF) { //현재까지 밟는 방법이 있을 경우에만 계산
        				 next = direction[i+1];
        				 if(k != next){ //같은 위치에 두 발이 있으면 안되므로 오른발이 겹치면 왼발로 밟기
        					 dp[i+1][next][k] = Math.min(dp[i+1][next][k],dp[i][j][k] + getCost(j,next));
        				 }
        				 if(j != next) { // 오른발로 밟기
        				     dp[i+1][j][next] = Math.min(dp[i+1][j][next],dp[i][j][k] + getCost(k,next));
        				 }
        			}
        		}
        	}
        }
        int ans = INF;
        //마지막 화살표에 도달했을 때 현재 왼발, 오른발 위치에 따른 최대값
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
