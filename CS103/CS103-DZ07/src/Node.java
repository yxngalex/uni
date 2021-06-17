import java.util.ArrayList;

public class Node {
    int data;
    Node left;
    Node right;
    ArrayList<Node> child;

    public Node() {
    }

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public ArrayList<Node> getChild() {
        return child;
    }


    public void setChild(ArrayList<Node> child) {
        this.child = child;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

}
