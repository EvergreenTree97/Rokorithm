import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\evergreen\\Documents\\hello-spring\\untitled\\src\\input.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int visit = 1;
        if(N == 1){
            visit = 1;
        }else if(N == 2){
            if(M == 3 || M==4) visit += 1;
            else if(M >= 5 && M < 7){
                visit += 2;
            }else if(M >= 7){
                visit += 3; //3번 부터는 반복할 수 없음
            }
        }else {
            if(M > 6) {	// 이동 횟수가 4번 이상이 되는 최소 가로의 길이
                visit += 4;	// 이동 횟수 4번
                M -= 7;	// 4가지 방법을 사용한 후 최대 개수 구하기
                visit += M;	// 나머지는 오른쪽으로 1칸씩 가면 되므로 남은 가로길이만큼 더한다.
            }
            else {	// 이동 횟수가 4번이 안되는 가로의 길이 => 최대 갈 수 있는 칸의 개수 판별.
                if(M>=4 && M<=6)	// 오른쪽으로 3번 갈 수 있음.
                    visit += 3;
                else if(M == 3)	// 오른쪽으로 2번 갈 수 있음.
                    visit += 2;
                else if(M == 2)			// 오른쪽으로 1번 갈 수 있음.
                    visit += 1;
            }
        }
        bw.write(String.valueOf(visit));
        bw.flush();
        bw.close();
    }
}

