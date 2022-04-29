import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("C:\\Users\\evergreen\\Documents\\hello-spring\\untitled\\src\\input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long T = Long.parseLong(br.readLine());
        int n = Integer.parseInt(br.readLine());
        long A[] = new long[n];
        StringTokenizer st =  new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
           A[i] = Long.parseLong(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        long B[] = new long[m];
        st =  new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            B[i] = Long.parseLong(st.nextToken());
        }
        ArrayList<Long> subA = new ArrayList();
        ArrayList<Long> subB = new ArrayList();
        long sumA = 0, sumB = 0;

        //A의 부배열 구하기
        for(int i = 0 ; i < n ; i++){
            sumA = A[i];
            subA.add(sumA);
            for (int j = i+1; j < n; j++) {
                sumA += A[j];
                subA.add(sumA);
            }
        }

        //B의 부배열 구하기
        for (int i = 0; i < m; i++) {
            sumB = B[i];
            subB.add(sumB);
            for (int j = i+1; j < m; j++) {
                sumB += B[j];
                subB.add(sumB);
            }
        }

        //subA, subB 정렬하기
        Collections.sort(subA);
        Collections.sort(subB, Comparator.reverseOrder());

        long result = 0;
        int ptA = 0 ,ptB = 0;

        //둘을 합해서 수를 만드는 것인데, 한쪽이 끝나면 끝이니까 탈출
        while (ptA < subA.size() && ptB < subB.size()){
            long curA = subA.get(ptA);
            long target = T - curA; //B에서 찾고싶은 타겟 (Sum으로 하면 인덱스 문제가 더 심함)
            // curB == target -> subA,subB 동률 체크 -> 답 도출 ptA++, ptB++
            if(subB.get(ptB) == target){
                long countA = 0;
                long countB = 0;
                while(ptA < subA.size() && subA.get(ptA) == curA){
                    countA++;
                    ptA++;
                }
                while(ptB < subB.size() && subB.get(ptB) == target){
                    countB++;
                    ptB++;
                }
                result += countA * countB;
            }
            // curB > target -> ptB++
            else if(subB.get(ptB) > target){
                ptB++;
            }
            // curB < target -> ptA++
            else{
                ptA++;
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
