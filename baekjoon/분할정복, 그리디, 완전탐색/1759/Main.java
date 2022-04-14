import java.io.*;
import java.util.*;

public class Main {
    static char[] data;
    static ArrayList<String> res;
    static int L, C;
    static StringBuilder sb= new StringBuilder();
    public static void main(String args[]) throws IOException {
        //System.setIn(new FileInputStream("C:\\Users\\evergreen\\Documents\\hello-spring\\untitled\\src\\input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        res =new ArrayList<>();
        data = new char[C];
        st= new StringTokenizer(br.readLine());
        for(int i = 0 ; i < C ; i++){
            data[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(data);
        dfs(0,0,0,-1,"");
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < res.size() ;i++){
            sb.append(res.get(i)+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    // 순회에 들어갔을때, 전역변수는 공통이고 매개변수에 필요한 정보를 제공해야 한다.
    static void dfs(int length, int ja, int mo, int current, String pwd){
//    1. 체크인 - 정렬로 인해 생략 가능
//    2. 목적지인가? - 길이가 + 자음,모음 개수
        if(length == L){
            if(ja >=2 && mo >= 1) res.add((pwd));
        } else{
            //    3. 연결된 곳을 순회 - 나보다 높은 알파벳
            for (int i = current + 1; i < data.length; i++) {
                char next = data[i];
                //    4.   갈 수 있는가? - 정렬로 인해 생략
                //    5.   간다 - dfs(next) -> 자음, 모음 두가지일때
                if(!isJaeum(next)){
                    dfs(length+1,ja,mo+1,i, pwd+next);
                }else{
                    dfs(length+1,ja+1,mo,i,pwd+next);
                }
            }
        }

//    6. 체크아웃 - 정렬로 인해 생략 가능

    }
    static boolean isJaeum(char c){
        if(c == 'a' || c== 'e' || c == 'i' || c == 'o' || c == 'u'){
            return false;
        }else{
            return true;
        }
    }
}
