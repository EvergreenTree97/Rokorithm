import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\evergreen\\Documents\\hello-spring\\untitled\\src\\input.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[] arr = new int[A+B];
        int[] a = new int[A];
        int[] b= new int [B];
        st = new StringTokenizer(br.readLine());
        for(int i  = 0; i < A ; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(b);
        int aPointer = 0 , bPointer = 0;
        int arrPointer = 0;
        while(aPointer < A && bPointer < B){
            int aVal = a[aPointer];
            int bVal = b[bPointer];
            if(aVal > bVal){
                arr[arrPointer++] = bVal;
                bPointer++;
            }else{
                arr[arrPointer++] = aVal;
                aPointer++;
            }
            if(aPointer == A){
                while(bPointer < B){
                    arr[arrPointer++] = b[bPointer++];
                }
            }else if(bPointer == B){
                while(aPointer < A){
                    arr[arrPointer++] = a[aPointer++];
                }
            }
        }
        StringBuilder sb= new StringBuilder();
        for (int v : arr){
            sb.append(v).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }


}
