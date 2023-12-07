package TwoThree;
public class TwoThreeTree {
    public static class Node {
        int key;
        String value;
        Node left, right;
        boolean isTwoNode;

        Node(int key, String value) {
            this.key = key;
            this.value = value;
            left = right = null;
            isTwoNode = true;
        }
    }

    Node root;

    public TwoThreeTree() {
        root = null;
    }

    public Node rotateRight(Node node) {
        Node node2 = node.left;
        node.left = node2.right;
        node2.right = node;
        return node2;
    }

    public Node rotateLeft(Node node) {
        Node node2 = node.right;
        node.right = node2.left;
        node2.left = node;
        return node2;
    }

    public void insert(int key, String value) {
        root = insertUtil(root, key, value);
    }

    public Node insertUtil(Node node, int key, String value) {
        if (node == null) {
           return new Node(key, value);
       }

       if (node.isTwoNode) {
           if (key < node.key) {
               node.left = insertUtil(node.left, key, value);
           } else if (key > node.key) {
               node.right = insertUtil(node.right, key, value);
           } else {
               node.value = value;
           }

           if (node.left != null && node.right != null &&
                   node.left.key > node.key && node.right.key > node.key) {
               node = rotateLeft(node);
           } else if (node.left != null && node.right != null &&
                   node.left.key < node.key && node.right.key < node.key) {
               node = rotateRight(node);
           }
       } else {
           if (key < node.key) {
               node.left = insertUtil(node.left, key, value);
           } else if (key > node.key) {
               node.right = insertUtil(node.right, key, value);
           } else {
               node.value = value;
           }
       }

       return node;
    }

    public String search(int key) {
        return searchUtil(root, key);
    }

    public String searchUtil(Node node, int key) {
        if (node == null) {
            return null;
        }

        if (key < node.key) {
            return searchUtil(node.left, key);
        } else if (key > node.key) {
            return searchUtil(node.right, key);
        } else {
            return node.value;
        }
    }
}


