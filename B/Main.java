import java.util.List;

public class Main{
	public static void main(String[] args) {
        	BinarySearchTree<String> bst = new BinarySearchTree<>();

        	bst.insert("RECTOR");
        	bst.insert("INGENIERO");
        	bst.insert("ALUMNO");
        	bst.insert("CACHIMBO");

        	TreeNode<String> resultSearch = bst.search("RECTOR");
        	System.out.println(resultSearch.data);  // OUTPUT: "RECTOR"

        	TreeNode<String> resultMin = bst.getMin();
        	System.out.println(resultMin.data);  // OUTPUT: "ALUMNO"

        	TreeNode<String> resultMax = bst.getMax();
        	System.out.println(resultMax.data);  // OUTPUT: "RECTOR"

        	TreeNode<String> resultParent = bst.parent("ALUMNO");
        	System.out.println(resultParent.data);  // OUTPUT: "INGENIERO"

        	List<TreeNode<String>> resultSon = bst.son("RECTOR");
        	for (TreeNode<String> node : resultSon) {
            		System.out.println(node.data);  // OUTPUT: "INGENIERO"
        	}

        	bst.remove("CACHIMBO");

        	TreeNode<String> resultSearchAfterRemove = bst.search("CACHIMBO");
        	System.out.println(resultSearchAfterRemove);  // OUTPUT: null
    	}
}
