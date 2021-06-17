public class MyBinaryTree {
    Node root;
    int size;

    public MyBinaryTree() {
    }

    public void dodajUStablo(int element) {
       root = dodajRekurzivno(root, element);
    }

    private Node dodajRekurzivno(Node trenutni, int vrednost) {
        if (trenutni == null) {
            return new Node(vrednost);
        }
        if (vrednost < trenutni.getData()) {
            trenutni.setLeft(dodajRekurzivno(trenutni.left, vrednost));
        } else if (vrednost > trenutni.getData()) {
            trenutni.setRight(dodajRekurzivno(trenutni.right, vrednost));
        } else {
            return trenutni;
        }
        return trenutni;
    }

    private boolean sadrziRekurzivno(Node trenutni, int vrednost) {
        if (trenutni == null) {
            return false;
        }
        if (vrednost == trenutni.data) {
            return true;
        }
        return vrednost < trenutni.data ? sadrziRekurzivno(trenutni.getLeft(), vrednost) : sadrziRekurzivno(trenutni.getRight(), vrednost);
    }

    public boolean sadrzi(int vrednost) {
        return sadrziRekurzivno(root, vrednost);
    }

    private int prebrojavaElementeRekurzivno(Node trenutni, int vrednost) {
        if (trenutni == null) return 0;

        int countLeft = prebrojavaElementeRekurzivno(trenutni.right, vrednost);
        int countRight = prebrojavaElementeRekurzivno(trenutni.right, vrednost);

        return (trenutni.data > vrednost ? 1 : 0) + countLeft + countRight;
    }

    public int prebrojavanjeElemenata(int vrednost) {
        return prebrojavaElementeRekurzivno(root, vrednost);
    }

    @Override
    public String toString() {
        return "MyBinaryTree{" +
                "root=" + root +
                ", size=" + size +
                '}';
    }
}
