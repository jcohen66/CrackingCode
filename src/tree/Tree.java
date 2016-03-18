package tree;

/**
 * Created by jcohe_000 on 3/17/2016.
 */
public class Tree {
    public Node root;


    public Node walk(Node ptr, Node node) {
        if (node.key <= ptr.key) {
            if (ptr.left != null)
                walk(ptr.left, node);
        } else if (ptr.right != null)
            if (node.key > ptr.key) {
                walk(ptr.right, node);
            }

        return ptr;
    }


    public Node insertNode(Node currentParent, Node newNode) {

        if (currentParent == null) {
            return newNode;
        } else if (newNode.key > currentParent.key) {
            currentParent.right = insertNode(currentParent.right, newNode);
        } else if (newNode.key < currentParent.key) {
            currentParent.left = insertNode(currentParent.left, newNode);
        }

        return currentParent;
    }


    public void addNode(int key) {

        // Create a new Node and initialize it

        Node newNode = new Node(key);

        // If there is no root this becomes root

        if (root == null) {

            root = newNode;

        } else {

            // Set root as the Node we will start
            // with as we traverse the tree

            Node focusNode = root;

            // Future parent for our new Node

            Node parent;

            while (true) {

                // root is the top parent so we start
                // there

                parent = focusNode;

                // Check if the new node should go on
                // the left side of the parent node

                if (key < focusNode.key) {

                    // Switch focus to the left child

                    focusNode = focusNode.left;

                    // If the left child has no children

                    if (focusNode == null) {

                        // then place the new node on the left of it

                        parent.left = newNode;
                        return; // All Done

                    }

                } else { // If we get here put the node on the right

                    focusNode = focusNode.right;

                    // If the right child has no children

                    if (focusNode == null) {

                        // then place the new node on the right of it

                        parent.right = newNode;
                        return; // All Done

                    }

                }

            }
        }

    }

    public Node findNode(int key) {

        // Start at the top of the tree

        Node focusNode = root;

        // While we haven't found the Node
        // keep looking

        while (focusNode.key != key) {

            // If we should search to the left

            if (key < focusNode.key) {

                // Shift the focus Node to the left child

                focusNode = focusNode.left;

            } else {

                // Shift the focus Node to the right child

                focusNode = focusNode.right;

            }

            // The node wasn't found

            if (focusNode == null)
                return null;

        }

        return focusNode;

    }

    public void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            visit(node);
            inOrderTraversal(node.right);
        }
    }

    public void preOrderTraversal(Node node) {
        if (node != null) {
            visit(node);
            inOrderTraversal(node.left);
            inOrderTraversal(node.right);
        }
    }

    public void postOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            inOrderTraversal(node.right);
            visit(node);
        }
    }

    public int visit(Node node) {
        System.out.println(node.key);
        return node.key;
    }


    public static void main(String[] args) {
        Tree t = new Tree();

        t.addNode(10);
        t.addNode(40);
        t.addNode(3);

        t.addNode(20);



        Node last = t.walk(t.root, new Node(23));
        System.out.println(last.key);

        t.inOrderTraversal(t.root);
        System.out.println();

        t.preOrderTraversal(t.root);
        System.out.println();

        t.postOrderTraversal(t.root);
        System.out.println();

        System.out.println("Find 40: " + t.findNode(40));
        System.out.println("Find 140: " + t.findNode(140));

    }
}
