import java.io.*;
import java.util.*;

class Node{
        char val;
        Node left;
        Node right;
        Node(char val){
        this.val =  val;
        }
        }
class Tree{
    Node head;
    void insert(char a,char b, char c){
        if(head == null){
            if(a != '.') head = new Node(a);
            if(b != '.') head.left = new Node(b);
            if(c != '.') head.right = new Node(c);
        }
        else{
            search(head,a,b,c);
        }
    }
    void search(Node head,char val, char left, char right){
        if(head == null) return;
        else if(head.val == val){
            if(left != '.') head.left = new Node(left);
            if(right != '.') head.right = new Node(right);
        }
        else{
            search(head.left,val,left,right);
            search(head.right,val,left,right);
        }
    }
    void preorder(Node head){
        System.out.print(head.val);
        if(head.left != null) preorder(head.left);
        if(head.right != null) preorder(head.right);
    }
    void inorder(Node head){
        if(head.left != null) inorder(head.left);
        System.out.print(head.val);
        if(head.right != null) inorder(head.right);
    }
    void postorder(Node head){
        if(head.left != null) postorder(head.left);
        if(head.right != null) postorder(head.right);
        System.out.print(head.val);
    }

}
public class Main {
    public static void main(String args[]) throws IOException {
        int i,j;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Tree t = new Tree();
        for (i = 0; i< N; i++){
            st = new StringTokenizer(br.readLine()," ");
            char a = st.nextToken().charAt(0);
            char b = st.nextToken().charAt(0);
            char c = st.nextToken().charAt(0);
            t.insert(a,b,c);
        }
        t.preorder(t.head);
        System.out.print("\n");
        t.inorder(t.head);
        System.out.print("\n");
        t.postorder(t.head);
    }
}
