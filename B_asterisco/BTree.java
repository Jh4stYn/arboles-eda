package B_asterisco;
public class BTree {
    public class Node {
        int data;
        Node left;
        Node right;
        Node parent;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.parent = null;
        }
    }

    private Node root;

    public void insert(int data) {
        if (root == null) {
            root = new Node(data);
        } else {
            insert(root, data);
        }
    }

    private void insert(Node node, int data) {
        if (data < node.data) {
            if (node.left != null) {
                insert(node.left, data);
            } else {
                node.left = new Node(data);
                node.left.parent = node;
            }
        } else {
            if (node.right != null) {
                insert(node.right, data);
            } else {
                node.right = new Node(data);
                node.right.parent = node;
            }
        }
    }

    public void remove(int data) {
        if (root == null) {
            return;
        }
        Node node = find(root, data);
        if (node == null) {
            return;
        }
        remove(node);
    }

    private Node find(Node node, int data) {
        if (node == null) {
            return null;
        }
        if (data == node.data) {
            return node;
        }
        if (data < node.data) {
            return find(node.left, data);
        } else {
            return find(node.right, data);
        }
    }

    private void remove(Node node) {
        if (node.left != null && node.right != null) {
            Node successor = findMin(node.right);
            node.data = successor.data;
            remove(successor);
        } else if (node.left != null) {
            removeLeftNode(node);
        } else if (node.right != null) {
            removeRightNode(node);
        } else {
            removeNode(node);
        }
    }

    private void removeLeftNode(Node node) {
        Node parent = node.parent;
        Node left = node.left;
        if (parent == null) {
            root = left;
        } else {
            if (parent.left == node) {
                parent.left = left;
            } else {
                parent.right = left;
            }
        }
        left.parent = parent;
        node.left = null;
        node.right = null;
        node.parent = null;
    }

    private void removeRightNode(Node node) {
        Node parent = node.parent;
        Node right = node.right;
        if (parent == null) {
            root = right;
        } else {
            if (parent.left == node) {
                parent.left = right;
            } else {
                parent.right = right;
            }
        }
        right.parent = parent;
        node.left = null;
        node.right = null;
        node.parent = null;
    }

    private void removeNode(Node node) {
        Node parent = node.parent;
        if (parent == null) {
            root = null;
        } else {
            if (parent.left == node) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
        node.parent = null;
    }

    private Node findMin(Node node) {
        if (node == null) {
            return null;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // private Node findMax(Node node) {
    //     if (node == null) {
    //         return null;
    //     }
    //     while (node.right != null) {
    //         node = node.right;
    //     }
    //     return node;
    // }

    public void traverse() {
        if (root != null) {
            traverse(root);
        }
    }

    private void traverse(Node node) {
        if (node != null) {
            traverse(node.left);
            System.out.print(node.data + " ");
            traverse(node.right);
        }
    }
}