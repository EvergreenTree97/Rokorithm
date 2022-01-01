import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        String newS = "";
        for(int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);
            if((c>= 'a' && c < 'a'+13) || (c>= 'A' && c < 'A'+13)) newS += (char)(c+13); //a부터 a+13까지는 더하면 됨
            else if((c>= 'a'+13 && c < 'a'+26) || (c>= 'A'+13 && c < 'A'+26)) newS += (char)(c-13); //그 이후는 끝부분에서 a로 돌아옴
            else newS += c; 
        }
        bw.write(newS);
        bw.flush();
        bw.close();
    }
}