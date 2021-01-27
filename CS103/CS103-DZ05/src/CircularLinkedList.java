import java.util.LinkedList;

public class CircularLinkedList<E> extends LinkedList<E> {
    private Node<E> tail = null;
    private int size = 0;

    public CircularLinkedList() {
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void rotate() {
        if (tail != null)
            tail = tail.getNext();
    }

    public void addFirst(E e) {
        if (size == 0) {
            tail = new Node<>(e, null);
            tail.setNext(tail);
        } else {
            Node<E> newest = new Node<>(e, tail.getNext());
            tail.setNext(newest);
        }
        size++;
    }

    public void addLast(E e) {
        addFirst(e);
        tail = tail.getNext();
    }

    public E removeFirst() {
        if (isEmpty()) return null;
        Node<E> head = tail.getNext();
        if (head == tail) tail = null;
        else tail.setNext(head.getNext());
        size--;
        return head.getElement();
    }

    @Override
    public String toString() {
        return "CircularLinkedList{" +
                "tail=" + tail +
                ", size=" + size +
                '}';
    }

    @Override
    public boolean add(E e) {
        addFirst(e);
        return super.add(e);
    }

    public void display() {
        Node<E> current = tail;
        if(tail == null) {
            System.out.println("List is empty");
        }
        else {
            System.out.println("Nodes of the circular linked list: ");
            do{
                System.out.print(" "+ current.data);
                current = current.next;
            }while(current != tail);
            System.out.println();
        }
    }

    public E elementsByIndex(int index) {
        if(index > size) {
            System.out.println("List is empty");
        }
        Node<E> n = tail;
        int i = 0;
        while(i++ != index) {
            n = n.next;
        }
        return n.data;
    }

}
