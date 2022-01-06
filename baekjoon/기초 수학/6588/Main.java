import java.io.*;

public class Main {
    final static int MAX = 1000000;
    static boolean[] prime = new boolean[MAX+1];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        setPrime();
        String s;
        int a = 0,b = 0;
        StringBuilder sb= new StringBuilder();
        while(!(s = br.readLine()).equals("0")){
            int n = Integer.parseInt(s);
            for(int i = 0 ; i <= n/2 ; i++){  //n/2번 반복하면 됨 그래도 다 탐색
                if(!prime[i] && !prime[n-i]){
                    a = i; b = n-i; //시작부터 체크하고, 맞다면 멈춤 어차피 차이가 제일 큰 값임
                    break; 
                }
            }
            if(a == 0 && b == 0) sb.append("Goldbach's conjecture is wrong.").append("\n");
            else{sb.append(n+" = ").append(a+" + "+b).append("\n");;}
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    static void setPrime(){
        prime[0] = prime[1] = true;
        for(int i = 2 ; i * i<= MAX; i++){ //i의 제곱이 N보다 커지면 지울 필요가 없음
            if(!prime[i]){
                for(int j = i * i ; j <= MAX ; j += i){
                    prime[j] = true;
                }
            }
        }
    }
}

