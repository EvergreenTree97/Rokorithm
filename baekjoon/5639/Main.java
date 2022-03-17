import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        BinarySearchTree bst = new BinarySearchTree();
        String s;
        while((s = br.readLine()) != null){
            bst.insert(Integer.parseInt(s));
        }
        bst.postOrder(bst.root);
        bw.write(bst.sb.toString());
        bw.flush();
        bw.close();
    }


}
class BinarySearchTree{
    Node root = null;
    StringBuilder sb = new StringBuilder();
    void insert(int val){
       if(root == null){
           root = new Node(val);
       }else{
           find(val,root);
       }
    }
    void find(int val, Node node){
        if(val < node.val){
           if(node.left == null){
               node.left = new Node(val);
               return;
           }else{
               find(val,node.left);
           }
        }else{
            if(node.right == null){
                node.right = new Node(val);
                return;
            }
            else{
                find(val,node.right);
            }
        }
    }
    void postOrder(Node node){
        if(node != null){
           postOrder(node.left);
           postOrder(node.right);
           sb.append(node.val).append("\n");
        }
    }
}
class Node{
    Node left;
    Node right;
    int val;
    Node(int val){
        this.left = null;
        this.right = null;
        this.val = val;
    }
}