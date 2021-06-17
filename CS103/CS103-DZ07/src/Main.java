public class Main {
    public static void main(String[] args) {
        MyBinaryTree stablo = new MyBinaryTree();

        stablo.dodajUStablo(2);
        stablo.dodajUStablo(4);
        stablo.dodajUStablo(6);
        stablo.dodajUStablo(8);
        stablo.dodajUStablo(10);
        stablo.dodajUStablo(12);

        System.out.println(stablo.prebrojavanjeElemenata(5));
    }
}
