import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        sb.append(recursion(N));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    static int recursion(int i){
        if(i <= 1) return 1;
        return  i * recursion(i-1);
    }
}
