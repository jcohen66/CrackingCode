package tree;

/**
 * Created by jcohe_000 on 3/17/2016.
 */
public class Node {
    public int key;
    public Node left = null;
    public Node right = null;

    public Node(int key) {
        this.key = key;
    }

    public Node(int key, Node left, Node right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
