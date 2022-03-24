import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc = 0 ; tc < T ; tc++){
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine(),"[,]");
            for(int i = 0; i < n; i++){
                arr[i] = (Integer.parseInt(st.nextToken()));
            }
            boolean isError = false;
            boolean reverse = false;
            int s = 0;
            int e = arr.length-1;
            for (int i = 0; i < p.length(); i++) {
                char command = p.charAt(i);
                if(command == 'R'){
                    reverse = !reverse;
                }else{
                    if(e < s){
                        isError = true;
                        break;
                    }
                    if(!reverse){
                        s++;
                    }else{
                        e--;
                    }
                }
            }
            if(isError){
                sb.append("error");
            }else{
                sb.append("[");
                if(!reverse){
                    for(int i = s ; i <= e; i++){
                        sb.append(arr[i]).append(",");
                    }
                }else{
                    for(int i = e ; i >= s; i--){
                        sb.append(arr[i]).append(",");
                    }
                }
                if(s > e){
                    sb.append("]");
                }else{
                    sb.deleteCharAt(sb.length()-1).append("]");
                }

            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

}
