import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static List<Integer> res;
    static int N;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("C:\\Users\\evergreen\\Documents\\hello-spring\\untitled\\src\\input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        res = new ArrayList();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        res.add(0);
        for (int i = 0; i < N; i++) {

            if(res.get(res.size()-1) < arr[i]){
                res.add(arr[i]);
            }//arr[i] 값이 더 작다면, 결과배열에 어느 곳에 들어갈지 탐색
            else{
                // 0부터, 결과배열의 인덱스까지 탐색하면서 들어갈 수 있는 위치 반환
               int search = binaryserach(1,res.size()-1,arr[i]);
               res.set(search,arr[i]);
            }
        }
        bw.write(String.valueOf(res.size()-1));
        bw.flush();
        bw.close();
    }
    static int binaryserach(int left, int right, int target){
        while(left < right){
            int mid = (left+right)/2;
            if(res.get(mid) < target){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return right;
    }

}
