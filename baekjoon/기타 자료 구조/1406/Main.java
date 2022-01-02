import java.io.*;
import java.util.*;

public class Main {
    /* 삽입 삭제 시 해당 인덱스를 매번 찾아가지 않기 위해
    * listIterator을 사용한다. 시간제한으로 인해 O(N)이 아닌 O(1) 사용해야했다.
    * + 스택 두개를 사용하여 구현도 가능하다.
    */
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        LinkedList<Character> ll = new LinkedList();
        String S = br.readLine();
        for(int i = 0 ; i < S.length() ;i++){
            ll.add(S.charAt(i));
        }
        int N = Integer.parseInt(br.readLine());
        ListIterator li = ll.listIterator(ll.size()); //반복자의 커서는 맨 뒤
        for(int i = 0 ; i <N ;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()){
                case "L" :
                    if(li.hasPrevious()) {
                        li.previous();
                    }
                    break;
                case "D":
                    if(li.hasNext()) {
                        li.next();
                    }
                    break;
                case "B" :
                    if(li.hasPrevious()) {
                        li.previous();
                        li.remove();
                    }
                    break;
                case "P":
                    li.add(st.nextToken().charAt(0));
            }
        }
        for(Character c : ll){
            sb.append(c);
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}