import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb= new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Member[] members = new Member[N];
        for(int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            members[i] = new Member(Integer.parseInt(st.nextToken()),st.nextToken(),i);
        }
        //이전 문제와 조금 다른 것은, 클래스를 선언하였다는 점 이다.
        //비교자를 Member 클래스에 구현해도 된다.
        Arrays.sort(members,(m1,m2)->{
           if(m1.age == m2.age){
               return m1.order-m2.order;
           }else{
               return m1.age-m2.age;
           }
        });
        for(Member m : members){
            sb.append(m.age).append(" ").append(m.name).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
class Member{
    int age;
    String name;
    int order;
    Member(int age, String name, int order){
        this.age = age;
        this.name = name;
        this.order = order;
    }
}