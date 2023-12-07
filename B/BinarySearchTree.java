import java.util.ArrayList;
import java.util.List;
public class BinarySearchTree<T extends Comparable<T>> {
	private TreeNode<T> root;

    	public BinarySearchTree() {
        	this.root = null;
    	}
	public TreeNode<T> search(T data) {
        	return searchHelper(root, data);
    	}

    	private TreeNode<T> searchHelper(TreeNode<T> node, T data) {
        	if (node == null || node.data.equals(data)) {
            	return node;
        	}

        	if (data.compareTo(node.data) < 0) {
            		return searchHelper(node.left, data);
        	} else {
            		return searchHelper(node.right, data);
        	}
   	}

	public TreeNode<T> getMin() {
        	if (root == null) {
            		return null;
        	}

        	TreeNode<T> node = root;
        	while (node.left != null) {
            		node = node.left;
        	}

        	return node;
    	}

	public TreeNode<T> getMax() {
        	if (root == null) {
        		return null;
        	}

        	TreeNode<T> node = root;
        	while (node.right != null) {
            		node = node.right;
        	}

        	return node;
    	}
	
	public TreeNode<T> parent(T data) {
        	if (root == null || root.data.equals(data)) {
            		return null;
        	}

        	return parentHelper(root, data);
    	}

    	private TreeNode<T> parentHelper(TreeNode<T> node, T data) {
    		if ((node.left != null && node.left.data.equals(data)) || (node.right != null && node.right.data.equals(data))) {
            		return node;
        	}

        	if (data.compareTo(node.data) < 0) {
            		return parentHelper(node.left, data);
        	} else {
            		return parentHelper(node.right, data);
        	}
    	}
	
	public List<TreeNode<T>> son(T data) {
        	TreeNode<T> node = search(data);
        	List<TreeNode<T>> sonList = new ArrayList<>();

        	if (node == null) {
        	    	return sonList;
        	}

        	if (node.left != null) {
        	    	sonList.add(node.left);
        	}

        	if (node.right != null) {
            		sonList.add(node.right);
        	}

        	return sonList;
	}
	
	public void insert(T data) {
        	int asciiValue = (int) data.toString().charAt(0);

        	if (root == null) {
         	   	root = new TreeNode<>(data, asciiValue);
        	} else {
            		insertHelper(root, data, asciiValue);
        	}
    	}

    	private void insertHelper(TreeNode<T> node, T data, int asciiValue) {
        	if (asciiValue < node.asciiValue) {
            		if (node.left == null) {
                		node.left = new TreeNode<>(data, asciiValue);
            		} else {
                		insertHelper(node.left, data, asciiValue);
            		}
        	} else {
        	    	if (node.right == null) {
                		node.right = new TreeNode<>(data, asciiValue);
            		} else {
                		insertHelper(node.right, data, asciiValue);
            		}
        	}
    
	}

	public void remove(T data) {
        	root = removeHelper(root, data);
    	}

    	private TreeNode<T> removeHelper(TreeNode<T> node, T data) {
        	if (node == null) {
        		return null;
        	}

        	if (data.compareTo(node.data) < 0) {
            		node.left = removeHelper(node.left, data);
        	} else if (data.compareTo(node.data) > 0) {
            		node.right = removeHelper(node.right, data);
        	} else {
            		if (node.left == null) {
                		return node.right;
            		} else if (node.right == null) {
                		return node.left;
            		} else {
                		TreeNode<T> successor = findMin(node.right);
                		node.data = successor.data;
                		node.asciiValue = successor.asciiValue;
                		node.right = removeHelper(node.right, successor.data);
            		}
        	}

        	return node;
    	}
    	private TreeNode<T> findMin(TreeNode<T> node) {
        	while (node.left != null) {
        	    	node = node.left;
        	}

        	return node;
    	}
}
