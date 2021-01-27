public class Main {
    public static void main(String[] args) {
        CircularLinkedList<Integer> myList = new CircularLinkedList<>();
        int n = 10;
        int k = 2;

        for (int i = 1; i <= n; i++) {
            myList.addFirst(i);
        }

        System.out.println("Elementi unutar liste");
        myList.display();


        System.out.println("K-ti elementi: ");
        for (int i = 0; i <= myList.size(); i += k) {
            System.out.print(" " + myList.elementsByIndex(i));
        }


    }
}
