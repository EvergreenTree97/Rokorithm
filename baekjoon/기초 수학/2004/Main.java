import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long m = Integer.parseInt(st.nextToken());
        long n_m =  n-m;
        long fiveCnt= 0;
        long twoCnt = 0;
        if(n == m);
        /* 이 문제에서는 조합이라는 특성 때문에 팩토리얼 뒷부분이 사라질 수 있다
        * 특히, 5C1 에서 5만 남게 되는데 5만 카운트 하게되면 1로 결과값이 나와
        * 원래 결과값인 0과 다르게 나오게 된다.*/
        else {
            fiveCnt += zeroCnt(5,n);
            fiveCnt -= zeroCnt(5,n_m);
            fiveCnt -= zeroCnt(5,m);
            twoCnt += zeroCnt(2,n);
            twoCnt -= zeroCnt(2,n_m);
            twoCnt -= zeroCnt(2,m);
        }
        bw.write(String.valueOf(Math.min(fiveCnt, twoCnt)));
        bw.flush();
        bw.close();
    }
    static long zeroCnt(int iter ,long max){
        long count = 0;
        for(long i = iter; i<= max ; i = i* iter){
            count += max/i;
        }
        return count;
    }
}

