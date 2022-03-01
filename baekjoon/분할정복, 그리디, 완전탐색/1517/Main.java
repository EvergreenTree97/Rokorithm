import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static long swap = 0;
    static int temp[],arr[];
    static int N;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\evergreen\\Documents\\hello-spring\\untitled\\src\\input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        temp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        divideAndConquer(0,N-1);
        bw.write(String.valueOf(swap));
        bw.flush();
        bw.close();
    }
    static void divideAndConquer(int left, int right){
        if(left == right) return;
        int mid = (left+right) / 2;
        divideAndConquer(left,mid);
        divideAndConquer(mid+1,right);
        merge(left,right);
    }
    static void merge(int left, int right){
        int L, R, k, a;
        int mid = (left+right)/2;
        L = left;
        R = mid+1;
        k = left;
        while(L <= mid && R <= right){
            if(arr[L] <= arr[R]){
                temp[k++] = arr[L++];
            }else{
                swap += mid-L +1; //왼쪽 배열에 남아있는 숫자 만큼 swap 발생
                temp[k++] = arr[R++];

            }
        }
        if(L > mid){
            for(a = R; a<= right; a++){
                temp[k++] = arr[a];
            }

        }else{
            for(a = L; a<= mid; a++){
                temp[k++] = arr[a];
            }
        }
        for(a = left ; a<= right; a++){
            arr[a] = temp[a];
        }
    }

}
