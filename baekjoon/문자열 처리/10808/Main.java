import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        int a[] = new int[26];
        for(int i = 0 ; i < s.length() ; i++){
             a[s.charAt(i)-'a']++;  //'a'는 97이니까 굳이 아스키코드 숫자를 알 필요가 없다.
        }
        for(int i : a){
            sb.append(i).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}