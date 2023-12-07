package TwoThree;
public class Main  {
    public static void main(String[] args) {
        TwoThreeTree tree = new TwoThreeTree();
        tree.insert(50, "fifty");
        tree.insert(40, "forty");
        tree.insert(60, "sixty");
        tree.insert(30, "thirty");
        tree.insert(70, "seventy");
        tree.insert(20, "twenty");
        tree.insert(80, "eighty");
        tree.insert(10, "ten");
        tree.insert(90, "ninety");

        System.out.println(tree.search(40)); 
        System.out.println(tree.search(100)); 
    }
}