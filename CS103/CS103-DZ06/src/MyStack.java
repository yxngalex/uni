import java.util.EmptyStackException;

public class MyStack {
    Node top;
    int size = 0;

    public MyStack() {
    }

    public boolean empty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void dodajNaStek(int element) {
        Node oldtop = this.top;
        this.top = new Node();
        this.top.data = element;
        this.top.pointer = oldtop;
        size++;
    }

    public int skiniSaSteka() {
        int data = 0;
        if(empty()) throw new EmptyStackException();
        else {
            data = top.data;
            Node temp = top;
            top = top.getNext();
            temp.setNext(null);
            size--;
        }
        return data;
    }

    public void prikazi() {
        Node trenutni = top;
        if (top == null) {
            System.out.println("Stek je prazan!");
        } else {
            System.out.println("Cvorovi u steku su: ");
            do {
                System.out.print(" " + trenutni.data);
                trenutni = trenutni.pointer;
            } while (trenutni != top);
            System.out.println();
        }
    }

}
