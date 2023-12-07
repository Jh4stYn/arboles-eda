public class TreeNode<T> {
	T data;
    	int asciiValue;
	TreeNode<T> left;
    	TreeNode<T> right;

    	public TreeNode(T data, int asciiValue) {
        	this.data = data;
        	this.asciiValue = asciiValue;
        	this.left = null;
        	this.right = null;
    	}
}
