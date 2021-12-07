import java.io.*;
public class Main {
    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        int q = s.length()/10;
        int d = s.length()%10;
        for(int i = 0,j = 0 ; i < q; i++,j += 10){
            sb.append(s, j, j+10).append("\n");
        }
        if(d >0){
            sb.append(s,s.length()-d,s.length());
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}