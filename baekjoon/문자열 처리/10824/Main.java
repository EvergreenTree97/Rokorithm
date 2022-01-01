import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st= new StringTokenizer(br.readLine());
        long AB = Long.parseLong(st.nextToken()+st.nextToken()); //Long해야함 21억이 남어감
        long CD = Long.parseLong(st.nextToken()+st.nextToken());
        bw.write(String.valueOf(AB+CD));
        bw.flush();
        bw.close();
    }
}