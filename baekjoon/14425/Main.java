import java.io.*;
import java.util.*;

public class Main {
    static int tree[];
    static int N, M;
    static Node root;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\evergreen\\Documents\\hello-spring\\untitled\\src\\input.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        root = new Node();
        for (int i = 0; i < N; i++) {
            addTrie(br.readLine(),root);
        }
        int count = 0;
        for (int i = 0; i < M; i++) {
            if(findString(br.readLine(),root)){
                count++;
            }
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
    static boolean findString(String s,Node n){
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(n.hasChild(c)){
                n = n.getChild(c);
            }else{
                return false;
            }
        }
        if(n.isEnd) return true;
        else return false;
    }
    static void addTrie(String s,Node n){
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!n.hasChild(c)){
                n.children[c-'a'] = new Node();
                n = n.getChild(c);
            }else{
                n = n.getChild(c);
            }
        }
        n.isEnd = true;
    }
}
class Node{
    Node children[] = new Node[26];
    boolean isEnd = false;

    boolean hasChild(char c){
        return children[c-'a'] != null;
    }
    Node getChild(char c){
        return children[c-'a'];
    }
}

