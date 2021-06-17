public class MyQueue {
    Node head;
    Node tail;
    int size = 0;

    public void dodajURed (int element) {
        Node temp = new Node(element);
        if (this.tail == null) {
            this.head = this.tail = temp;
        }
        this.tail.pointer = temp;
        this.tail = temp;
    }

    public int skiniIzReda() {

        if (this.head == null) {
            return -1;
        }

        Node temp = this.head;
        this.head = this.head.pointer;

        if(this.head == null) {
            this.tail = null;
        }
        return temp.data;
    }

    public void prikaziRed() {
        Node trenutni = head;
        if(head == null) {
            System.out.println("Red je prazan!");
        } else {
            while (trenutni != null) {
                System.out.println(trenutni.data + " ");
                trenutni = trenutni.pointer;
            }
            System.out.println();
        }
    }

}
