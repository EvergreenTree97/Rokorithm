import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String S = br.readLine();
        ArrayList<String> arr = new ArrayList<>();
        for(int i = 0 ; i < S.length(); i++){
            arr.add(S.substring(i));
        }
        Collections.sort(arr);
        for(String s : arr){
            sb.append(s).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}