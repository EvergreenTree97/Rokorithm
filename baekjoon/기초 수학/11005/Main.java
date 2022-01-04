import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        bw.write(trans(N,B));
        bw.flush();
        bw.close();
    }
    static String trans(int N, int B){
        StringBuilder sb= new StringBuilder();
        ArrayList<Character> arr =new ArrayList<>();
        while(N >= B){
            arr.add(transAlpabet(N%B));
            N /= B;
        }
        arr.add(transAlpabet(N));
        for(int i = arr.size()-1; i >=0 ;i--){
           sb.append(arr.get(i));
        }
        return sb.toString();
    }
    static char transAlpabet(int a){
        if(a>= 0 && a< 10) return (char) (a+'0');
        else{
            return (char)(a-10+'A');
        }
    }
}