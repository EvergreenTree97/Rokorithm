import java.io.*;
import java.util.*;

public class Main {
    static int[] card;
    static int N, M;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("C:\\Users\\evergreen\\Documents\\hello-spring\\untitled\\src\\input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        card = new int[N];
        for (int i = 0; i < N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(card); // nlogn
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int input = Integer.parseInt(st.nextToken());
            sb.append(binarySearch(input) + " ");
        }


        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    /* 집 간 최소 거리는 1, 최대 거리는 가장 먼 거리*/
    static int binarySearch(int target) {
        int start = 0;
        int end = N;
        //lower bound -> target이 나타나는 첫 번째 인덱스를 반환
        while (start < end) {
            int mid = (start + end) / 2;
            if (card[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        int lowerBound = start;
        if(card[lowerBound] != target) return 0;
        start = 0;
        end = N;
        //upper bound -> 중복 요소중 마지막 target 다음 값
        while (start < end) {
            int mid = (start + end) / 2;
            if (card[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        int upperBound = start;
        return upperBound - lowerBound;

    }

}
