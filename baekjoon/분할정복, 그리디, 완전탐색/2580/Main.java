import java.io.*;
import java.util.*;

public class Main {
    static int map[][];
    static ArrayList<int[]> arrayList;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arrayList = new ArrayList();
        map= new int[9][9];
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0) arrayList.add(new int[]{i,j});
            }
        }
        solve(0);
    }

    static void solve(int idx) {
        if(idx == arrayList.size()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(map[i][j] + " ");
                }
                sb.append("\n");
            }
            System.out.print(sb);
            System.exit(0);
        }
        int p[] = arrayList.get(idx);
        for (int k = 1; k <= 9; k++) {
            if (check(p[0],p[1],k)) { //1~9 까지의 값을 넣어서 성립한다면
                map[p[0]][p[1]] = k; //그 값이 map의 값이 됨
                solve(idx+1); //다음으로 넘어감
                map[p[0]][p[1]] = 0;
            }
        }
    }

    static boolean check(int row, int col, int value) {
        // 행열 검사
        for (int i = 0; i < 9; i++) {
            if (map[row][i] == value) {
                return false;
            }
            if (map[i][col] == value) {
                return false;
            }
        }

        //박스 검사
        int start_row = (row / 3) * 3;
        int start_col = (col / 3) * 3;
        for (int i = start_row; i < start_row + 3; i++) {
            for (int j = start_col; j < start_col + 3; j++) {
                if (map[i][j] == value) {
                    return false;
                }
            }
        }
        return true;
    }

}
