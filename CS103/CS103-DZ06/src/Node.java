public class Node {

    int data;
    Node pointer;

    public Node() {
    }

    public Node(int data) {
        this.data = data;
    }

    public Node(int data, Node pointer) {
        this.data = data;
        this.pointer = pointer;
    }

    public Node getNext() {
        return pointer;
    }

    public void setNext(Node next) {
        this.pointer = next;
    }

}
