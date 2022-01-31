import java.io.*;
import java.util.*;

public class Main {
    static long x[];
    static int N, C;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("C:\\Users\\evergreen\\Documents\\hello-spring\\untitled\\src\\input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        x = new long[N];
        for (int i = 0; i < N; i++) {
            x[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(x); // nlogn
        bw.write(String.valueOf(binarySearch(1,x[N-1])));
        bw.flush();
        bw.close();
    }
    /* 집 간 최소 거리는 1, 최대 거리는 가장 먼 거리*/
    static long binarySearch(long minDist, long maxDist){
        //거리를 매개변수로 하여, C가 얼마나 나오는지 체크한다.
        while(minDist < maxDist){
           //시작 mid는 중간 거리
           long mid = (minDist+maxDist)/2;
           int count = 0;
           //간선끼리 거리를 구해서 카운트
           for (int i = 0; i < N-1;) {
               long current = x[i];
               for (int j = i+1; j < N; j++) {
                   long next = x[j];
                   if(next - current >= mid) {
                       count++;
                       i = j;
                       break;
                   }
                   i++;
               }
           }
           //와이파이 설치할 개수가 부족하다면 -> 거리를 줄인다
           if(count < C-1){
               maxDist = mid;
           }else{ //충분히 설치가 가능하다면 -> 거리를 늘려본다
               minDist = mid+1;
           }
        }
        //3에서 내가 원하는 min을 찾아냈고, 다음 탐색을 4로 하게 되는데
        //4에서 조건을 만족하지 못한다면 내가 원하는 값은 3이다. 따라서 -1해줘야한다.
        return minDist-1;
    }

}
