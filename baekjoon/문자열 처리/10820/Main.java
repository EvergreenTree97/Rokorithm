import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String line = "";
        while((line = br.readLine()) != null){
            int small = 0, big = 0, space = 0, num = 0;
            for(int i = 0 ; i< line.length();i++){
                char c = line.charAt(i);
                if(c-'a' >=0 && c-'a' < 26) small++; // c > 'a' c< 'z' 가 더 효율적일듯?
                else if(c-'A' >=0 && c-'A' < 26) big++;
                else if(c-'0' >=0 && c-'0' < 10) num++;
                else space++;
            }
            sb.append(small).append(" ").append(big).append(" ");
            sb.append(num).append(" ").append(space).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}