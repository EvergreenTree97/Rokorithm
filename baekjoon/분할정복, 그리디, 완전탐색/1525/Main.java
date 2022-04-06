import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int dir[] = {-1, -3, 1, 3};
    static String map = "";
    static String ans = "123456780";
    static HashMap<String,Integer> hashMap = new HashMap<>();

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int idx = 0;
        int start = 0;
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                String s = st.nextToken();
                map += s;
                if(s.equals("0")) {
                    start = idx;
                }
                idx++;
            }
        }
        System.out.print(bfs(start));
    }

    static int bfs(int start) {
        Queue<Node> q = new LinkedList();
        hashMap.put(map,1);
        q.offer(new Node(start,map,0));
        int res = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.s.equals(ans)) {
                res = Math.min(cur.count,res);
            }
            for (int i = 0; i < 4; i++) {
                int nextIdx = cur.idx+dir[i];
                if (nextIdx >= 0 && nextIdx < 9 && isChangeAvailable(cur.idx,nextIdx)) {
                        StringBuilder sb = new StringBuilder(cur.s);
                        char temp = cur.s.charAt(nextIdx);
                        sb.setCharAt(nextIdx,'0');
                        sb.setCharAt(cur.idx,temp);
                        if(!hashMap.containsKey(sb.toString())){
                            hashMap.put(sb.toString(),1);
                            q.offer(new Node(nextIdx,sb.toString(),cur.count+1));
                        }

                }
            }
        }
        if(res == Integer.MAX_VALUE){
            return -1;
        }else{
            return res;
        }
    }
    static boolean isChangeAvailable(int a, int b){
        if((a == 2 && b== 3) || (a == 3 && b == 2) || (a == 5 && b== 6) || (a == 6 && b == 5))  {
            return  false;
        }
        return true;
    }
}

class Node {
    int idx;
    String s;
    int count;
    public Node(int idx, String s,int count) {
        this.idx = idx;
        this.s = s;
        this.count = count;
    }
}
