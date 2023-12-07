package B_asterisco;
public class Main {
    public static void main(String[] args) {
        BTree tree = new BTree();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(5);
        tree.insert(15);
        tree.insert(25);
        tree.insert(35);
        tree.traverse();
        System.out.println();
        tree.remove(20);
        tree.traverse();
    }
}