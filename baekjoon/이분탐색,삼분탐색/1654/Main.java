import java.io.*;
import java.util.*;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        long[] arr = new long[K];
        long min = 0, max = 0, mid;
        for(int i = 0 ; i < K ; i++){
           arr[i] = Long.parseLong(br.readLine());
           max = Math.max(max,arr[i]);
        }
        /* 이분 탐색의 범위는 인덱스가 아니라, 길이가 될 수도 있다
        * 이 문제에선 key가 만들고자 하는 랜선의 개수이다.
        * 즉, 배열에서는 원소 값의 비교였다면 여기서는 개수 비교이다.
        * 범위나, key를 적절하게 바꿔 쓰는것이 핵심이다. 기존의 방법을 고수하는게 아니라*/

        max++;//최대길이 +1 해줘야 mid가 0이 되지 않는다.

        while(min < max){
            mid = (max+min) / 2;
            long count = 0;
            for(int i = 0; i < arr.length; i++){ //개수 구하기
                count += arr[i] / mid;
            }
            /* upper bound
            * mid 길이로 잘랐을 때 개수가, 만들고자 하는 랜선의 개수보다 작다면?
            * 자르고자 하는 길이를 줄이기 위해 최대 길이를 줄인다. 필요로 하는게 적으므로
            * 그 외에는 늘린다.*/
            if(count < N) max = mid; //아직 count가 원하는 개수보다 적다면
            else{
                min = mid+1;
            }
        }
        bw.write(String.valueOf(min -1));
        bw.flush();
        bw.close();
    }


}
