public class Main {

    public static void main(String[] args) {
        MyBinaryTree stablo = new MyBinaryTree();

        stablo.add(2);
        stablo.add(5);
        stablo.add(1);
        stablo.add(7);
        stablo.add(3);


        stablo.inorderWithStack();
    }
}
