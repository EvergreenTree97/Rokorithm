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
        //이전 문제랑 같았으나, 비교자를 y에 대해 먼저 체크하고 x에 체크하였다.
        Arrays.sort(arr, (o1,o2)-> {
            if(o1[1] == o2[1]){
                return o1[0]- o2[0];
            }else{
                return o1[1] - o2[1];
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