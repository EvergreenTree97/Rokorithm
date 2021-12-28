import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        /* 이번 문제는 O(N)을 만족하는 정렬 알고리즘을 가지고 풀어야 한다
         * O(N) 정렬 알고리즘에 기수정렬과 계수정렬이 있는데, 양수 or 숫자 범위 작음의 조건이 있어야 한다.
         * 단순히 10000 크기의 배열을 선언해서, 해당하는 값의 인덱스에 집어넣고 수를 세는 방법도 있다.
         * 이 문제에서는 메모리가 빡빡하고 오히려 시간이 널널해서 그런지 누적합을 이용하게 되면 배열 하나의 메모리를 차지한다.
         * 따라서 10000 크기의 배열 하나만 이용해서 카운팅 정렬을 한다.
         * */

        int N = Integer.parseInt(br.readLine());
        final int MAX = 10000;
        int count[] = new int[MAX+1];
        for(int i = 0 ; i <N ; i++){
            count[Integer.parseInt(br.readLine())]++; //데이터가 몇번 등장 했는가
        }
        for(int i=1;i<= 10000;i++){
            for(int j = 0 ; j < count[i] ; j++){
                sb.append(i).append("\n");
            }
        }
        // 누적합 카운팅 정렬 이용방법 (메모리 문제로 더 느렸다.)
        /*
        for(int i = 1; i <= MAX ; i++){
            count[i] += count[i-1];
        }
        for(int i = N-1 ; i >= 0; i--){ //맨 뒤에서부터 순회
            int val = arr[i];
            ans[count[val]-1] = val;
            count[val]--;
        }
        for(int i : ans){
            sb.append(i).append("\n");
        }*/
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}