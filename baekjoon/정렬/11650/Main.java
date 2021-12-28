import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb= new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for(int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        /* 이차원 배열(다른 객체도 가능)을 비교하는 방법
        * 기존 자료형이 아닌 이상, 비교 인자를 지정해주지 않으면 방법이 없다.
        * Arrays.sort의 Comparator 인터페이스를 구현하여 이를 해결 가능하다.
        * 특히 이 문제에선, x 좌표를 먼저 비교하교 x좌표가 같다면 y좌표를 비교해야한다.
        * Comparator을 람다식으로 구현하여 이를 해결하였다.
        * */
        Arrays.sort(arr, (o1,o2)-> {
            if(o1[0] == o2[0]){
                return o1[1]- o2[1];
            }else{
                return o1[0] - o2[0];
            }
        });
        for(int[] i : arr){
            sb.append(i[0]).append(" ").append(i[1]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}