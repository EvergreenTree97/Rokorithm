import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0 ; i < N ; i++){
            arr.add(Integer.parseInt(br.readLine()));
        }
        /*Arrays.sort(arr); Arrays의 sort는 Dual-Pivot Quicksort를 수행한다.
          평균 시간 복잡도는 O(nlogn)이지만 최악의 경우 O(n^2)이다.*/
        /*Collections.sort(); 오브젝트 타입 배열에 대해 Tim Sort를 수행한다.
          합병정렬의 최악 + 삽입정렬*/
        Collections.sort(arr);
        StringBuilder sb = new StringBuilder();
        for(int i : arr){
            sb.append(i).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}