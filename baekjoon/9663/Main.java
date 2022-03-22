import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int map[];// 인덱스는 열, 값은 행
    static int ans = 0;
    static int N;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N];
        dfs(0);
        System.out.print(ans);
    }
    static void dfs(int column){
        if(column >= N){
           ans++;
           return;
        }
        for(int i = 0 ; i < N ; i++){ //
            map[column] = i; // (row,column) == (row,i)
            if(isAvailable(column)){ //이전 열, 행과 겹치지 않는다면
               dfs(column+1); //탐색 on
            }else{
                map[column] = 0; //굳이 필요하지 않다. 겹치는 곳을 방문하지 않기 때문에
            }
        }
    }
    static boolean isAvailable(int column){ //해당 열에 대해 행, 대각선 체크
        for(int i = 0 ; i < column ; i++){
            if(map[column] == map[i]){ //이전 행들중에 퀸이 있었나?
                return false;
            }else if(Math.abs(column-i) == Math.abs(map[column]- map[i])){ //대각선 행들중에 퀸이 있었나?
                return false;
            }
        }
        return true;
    }
}
//row 행
//Column 열