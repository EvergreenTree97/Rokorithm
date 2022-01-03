import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Integer> arr = new ArrayList<>();

        for(int i = 1 ; i <= N ;i++){
            arr.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int idx = K-1;
        /* 이전 문제에서 큐를 삽입 및 삭제하는 과정에 시간을 할애했다.
        * 인덱스만 가지고 어레이 리스트를 사용한다.*/
        for(int i = 0 ; i< N -1; i++){ //마지막 요소가 남을 때 까지 반복한다
            sb.append(arr.remove(idx)+", ");
            idx += K-1;
            idx %= arr.size();
        }
        sb.append(arr.remove(0)).append(">");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}