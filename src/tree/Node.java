package tree;

/**
 * Created by jcohe_000 on 3/17/2016.
 */
public class Node {
    public String name;
    public Node left = null;
    public Node right = null;

    public Node(String name) {
        this.name = name;
    }

    public Node(String name, Node left, Node right) {
        this.name = name;
        this.left = left;
        this.right = right;
    }
}
