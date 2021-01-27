import java.util.Stack;

public class MyBinaryTree {
    Node root;

    private Node insertElementsRecursive(Node current, int element) {
        if (current == null) {
            return new Node(element);
        }
        if (element < current.value) {
            current.left = insertElementsRecursive(current.left, element);
        } else if (element > current.value) {
            current.right = insertElementsRecursive(current.right, element);
        } else {
            return current;
        }
        return current;
    }

    public void add(int element) {
        root = insertElementsRecursive(root, element);
    }

    public void inorderWithStack() {

        if (root == null) {
            System.out.println("Stablo je prazno!");
        }

        Stack<Node> stack = new Stack<>();
        Node current = root;

        while (current != null || !stack.empty()) {

            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();

            System.out.println(" " + current.value);
            current = current.right;
        }
    }
}
