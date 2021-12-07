import java.io.*;
public class Main {
    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String n = br.readLine();
        int sum = 0;
        for(int i = 0 ; i < N; i++){
            sum += n.charAt(i)-'0';
        }
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}