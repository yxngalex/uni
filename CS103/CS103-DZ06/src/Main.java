public class Main {
    public static void main(String[] args) {
        MyStack stek = new MyStack();

        stek.dodajNaStek(5);
        stek.dodajNaStek(2);
        stek.dodajNaStek(4);
        stek.dodajNaStek(6);
        stek.dodajNaStek(9);
        stek.dodajNaStek(3);

        MyQueue red = new MyQueue();

        red.dodajURed(1);
        red.dodajURed(3);
        red.dodajURed(5);
        red.dodajURed(6);
        red.dodajURed(2);

        red.prikaziRed();

        red.skiniIzReda();

        red.prikaziRed();

    }
}
