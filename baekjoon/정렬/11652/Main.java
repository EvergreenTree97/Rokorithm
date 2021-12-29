import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        HashMap<Long, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            long a = Long.parseLong(br.readLine());
            if (!hashMap.containsKey(a)) {
                hashMap.put(a, 1);
            } else {
                hashMap.replace(a, hashMap.get(a) + 1);
            }
        }
        int max = Integer.MIN_VALUE;
        long res = 0;
        for(Long key : hashMap.keySet()){
            int val = hashMap.get(key);
            if(val > max){
                max = val;
                res = key;
            }else if(max == val){
                res = res > key ? key : res ;
            }
        }
        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
    }
}