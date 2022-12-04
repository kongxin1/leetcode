public class Connect {
    public static void main(String argv[]){
        Node n1=new Node();
        Node n2=new Node();
        Node n3=new Node();
        Node n4=new Node();
        Node n5=new Node();
        Node n6=new Node();
        Node n7=new Node();

        n1.left=n2;
        n1.right=n3;
        n2.left=n4;n2.right=n5;
        n3.left=n6;n3.right=n7;

        Connect c=new Connect();
        c.connect(n1);
    }

    public Node connect(Node root) {
        recur(null,root);
        return root;
    }
    public void recur(Node root,Node child){
        if(child==null){
            return;
        }
        if(root==null){
            child.next=null;
        }else if(child==root.left){
            child.next=root.right;
        }else{
            if(root.next!=null)
            child.next=root.next.left;
        }
        if(child.left!=null) {
            recur(child, child.left);
            recur(child, child.right);
        }
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
