import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Unesite koliko fajlova zelite da kreirate: ");
        System.out.print(">");
        int num = sc.nextInt();

        MyTreeNode<File> root = null;

        for (int i = 1; i <= num; i++) {
            System.out.println("Unesite putanju vaseg " + i + ". direktorijuma: ");
            System.out.print(">");
            String path = sc.next();
            File newFile = new File(path);
            if (!newFile.exists()) {
                boolean mkdir = newFile.mkdir();
                if (mkdir) {
                    System.out.println("Uspesno ste kreirali novi fajl pod imenom: " + newFile.getName());
                    if (root == null) {
                        root = new MyTreeNode<>(newFile);
                    } else {
                        MyTreeNode<File> newNode = new MyTreeNode<>(newFile);
                        root.addChildren(Collections.singletonList(newNode));
                    }
                } else {
                    System.out.println("Direktorijum ne moze biti kreiran!");
                }
            } else {
                System.out.println("Fajl vec postoji!");
            }
        }

        System.out.println();

        // Deca unutar root fajla
        if (root != null) {
            System.out.println("Deca fajla " + root.getData() + " su:");
            for (MyTreeNode<File> node : root.getChildren()) {
                System.out.println(node.getData());
            }
        } else {
            System.out.println("Vase stablo je prazno!");
        }
    }
}