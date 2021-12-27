import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        bw.write(String.valueOf(solve(s)));
        bw.flush();
        bw.close();
    }

    static int solve(String s) {
        int length =s.length();
        int dp[] = new int[length+1];
        dp[0] = dp[1] = 1; //0자리수 , 1자리수는 1일테니 초기화
        if(s.charAt(0) == '0') return 0;
        //30, 40 ... 90 이 마지막에 나올경우 에러가 나기 때문에 미리 처리
        else if(s.charAt(length-1) == '0' && s.charAt(length-2) != '1' && s.charAt(length-2) != '2') return 0;
        else {
            for(int i = 2; i <= length; i++) {
                int tmp = s.charAt(i-1)-'0';
                if(tmp > 0) dp[i] = dp[i-1] % 1000000; // 0이 아니라면 이전 dp값 가져옴

                tmp += (s.charAt(i-2)-'0') * 10; //이 이전값과 이전값을 합쳐서 판별
                if(10 <= tmp && tmp <= 26) dp[i] = (dp[i] + dp[i-2]) % 1000000;
                //유효 문자라면 그 이전 디피값도 추가
            }
        }
        return dp[length];
    }
}