package cs101.dz06;

import java.util.Arrays;
import java.util.Scanner;

public class Zadatak13 {

    public static int[] noviNiz(int[] niz, int n, int poz, int x) {
        
        int[] noviniz = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            if (i < poz - 1) {
                noviniz[i] = niz[i];
            } else if (i == poz - 1) {
                noviniz[i] = x;
            } else {
                noviniz[i] = niz[i - 1];
            }
        }
        return noviniz;
    }

    public static void main(String[] args) {
        Scanner ulaz = new Scanner(System.in);
        System.out.println("Unesi velicinu niza: ");
        int n = ulaz.nextInt();

        int[] niz = new int[n];

        System.out.println("Ucitaj niz od " + niz.length + " elemenata");
        for (int i = 0; i < niz.length; i++) {
            System.out.println("niz[" + i + "] = ");
            niz[i] = ulaz.nextInt();
        }
        System.out.println("Nas niz izvleda ovako:\n" + Arrays.toString(niz));
        
        System.out.println("Unesi vrednost novog elemenata: ");
        int x = ulaz.nextInt();
        System.out.println("Unesi poziciju na kojoj ce se novi element nalaziti:");
        int poz = ulaz.nextInt();
        
        niz = noviNiz(niz, n, poz, x);
        
        System.out.println("\nNiz sa novim elementom " + x + " nalazi se na poziciji " + poz + ":\n" + Arrays.toString(niz));
    }

}
