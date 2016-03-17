package tree;

/**
 * Created by jcohe_000 on 3/17/2016.
 */
public class Tree {
    public Node root;

    public void inOrderTraversal(Node node) {
        if( node != null ) {
            inOrderTraversal(node.left);
            visit(node);
            inOrderTraversal(node.right);
        }
    }

    public String visit(Node node) {
        System.out.println(node.name);
        return node.name;
    }


    public static void main(String[] args) {
        Tree t = new Tree();
        t.root = new Node("10");
        t.root.left = new Node("1");
        t.root.right = new Node("20");



        t.inOrderTraversal(t.root);
    }
}
