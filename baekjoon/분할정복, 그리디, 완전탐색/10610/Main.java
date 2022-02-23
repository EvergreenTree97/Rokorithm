import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\evergreen\\Documents\\hello-spring\\untitled\\src\\input.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int length = s.length();
        char[] number = s.toCharArray();
        Arrays.sort(number);
        s = new StringBuilder(new String(number)).reverse().toString();
        bw.write(isAvailable(s,length));
        bw.flush();
        bw.close();
    }
    static String isAvailable(String number,int length){
        int transNum;
        if(length == 1){
            return "-1";
        }else if(length == 2){
            transNum = Integer.parseInt(number);
            if(transNum % 30 == 0){
                return number;
            }else{
                return "-1";
            }
        }
        int d = divide(Integer.parseInt(String.valueOf(number.charAt(0)+number.charAt(1))));
        for (int i = 2; i < length; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(d).append(number.charAt(i));
            transNum = Integer.parseInt(sb.toString());
            d = divide(transNum);
        }
        if(d == 0){
            return number;
        }else{
            return "-1";
        }

    }
    static int divide(int a){
        if(a < 30){
            return a;
        }else{
            return a % 30;
        }
    }


}

