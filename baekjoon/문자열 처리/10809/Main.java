import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        int a[] = new int[26];
        Arrays.fill(a,-1);
        for(int i = 0 ; i < s.length() ; i++) {
            char c = s.charAt(i);
            if (a[c - 'a'] < 0) a[c - 'a'] = i; //처음 등장했을 때의 인덱스스
        }
        for(int i : a){
            sb.append(i).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}