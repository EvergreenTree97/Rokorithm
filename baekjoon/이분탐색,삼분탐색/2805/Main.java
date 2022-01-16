import java.io.*;
import java.util.*;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[K];
        int min = 0, max = 0, mid;
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < K ; i++){
           arr[i] = Integer.parseInt(st.nextToken());
           max = Math.max(max,arr[i]);
        }

        while(min < max){
            mid = (max+min) / 2;
            long count = 0; //잘린 부분이 int를 넘을 수가 있음..
            for(int i = 0; i < arr.length; i++){ //잘린 윗부분 개수 구하기
                if(arr[i] - mid > 0 ){
                    count += (arr[i]- mid);
                }
            }

            if(count < N) max = mid; //나무조각이 부족하다면 상한선을 내려야 한다.
            else{
                min = mid + 1; //나무조각이 충분하거나 ,같다면 하한선을 더 올려본다.
            }
        }
        //upper bound 형식은 원하는 탐색값 +1 되어서 -1 해줘야함
        bw.write(String.valueOf(min-1));
        bw.flush();
        bw.close();
    }


}
