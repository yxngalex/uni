public class Node<E> {
    E data;
    Node<E> next;

    public Node(E data, Node<E> next) {
        this.data = data;
        this.next = next;
    }

    public E getElement() {
        return data;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> n) {
        this.next = n;
    }

}
