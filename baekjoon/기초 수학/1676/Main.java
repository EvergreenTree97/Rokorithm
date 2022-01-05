import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int count = 0;

        /* 최대치인 500!은 엄청나게 큰 수이기 때문에 일반 반복으로는 안됨
        * 10이 곱해질 때 마다 0의 개수가 늘어나게 된다. 10 뿐만이 아니라 2와 5가 곱해져도 0이 늘어난다.
        * 그렇다면 곱해지는 수들의 모든 소인수들 중 2와 5의 개수를 구하면 되는데, 5의 개수가 더 적을테니 5의 개수만 구하면 2의 개수쌍과 맞을것이다.
        * 5의 배수를 세면서 전체 5를 카운트 하고, 25배수는 원래는 두번 세줘야 하지만 5에서 한번 세 줬으므로 한번만
        * 이런식으로 결국 한번 씩만 세주면 된다. */
        if(N >= 0 && N <=4) count = 0;
        else {
            while(N > 0){
                count += N /5; //5가 있는 수, 25가 있는 수, 125가 있는 수를 반복 구하기
                N /= 5;
            }
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}

