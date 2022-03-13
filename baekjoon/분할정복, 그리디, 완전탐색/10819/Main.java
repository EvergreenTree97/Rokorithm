import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(arr,0,N);
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }
    static int calculation(int arr[],int n){
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res += Math.abs(arr[i-2] - arr[i-1]);
        }
        return res;
    }
    static void dfs(int arr[],int depth,int n){
        if(depth == n){
            int s = calculation(arr,n);
            if(max < s){
                max = s;
            }
        }
        for (int i = depth; i < n; i++) {
            swap(arr,depth,i);
            dfs(arr,depth+1,n);
            swap(arr,depth,i);
        }
    }
    static void swap(int[] arr, int depth, int n) {
        int temp = arr[depth];
        arr[depth] = arr[n];
        arr[n] = temp;
    }
}
