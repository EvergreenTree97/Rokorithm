import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int count = 0;
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int i = 1;
        int val = 0;
        while(true){
            hashMap.put(i,A);
            String s = String.valueOf(A);
            A = 0;
            for(int j=0 ; j< s.length(); j++){
                int c =  s.charAt(j)-'0';
                A += Math.pow(c,P);
            }
            if(hashMap.containsValue(A)){
                val = A;
                break;
            }
            i++;
        }
        for(Map.Entry<Integer,Integer> entrySet : hashMap.entrySet()){
            if(entrySet.getValue() == val) break;
            count++;
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}