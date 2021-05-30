import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] n = addElementsInArray();

        System.out.println("Niz pre bubble sort: " + Arrays.toString(n));

        bubbleSortArray(n);

        System.out.println("Niz nakon bubble sorta: ");

        for (int j : n) {
            System.out.print(j + " ");
        }
    }

    public static int[] addElementsInArray() {
        Scanner sc = new Scanner(System.in);

        int n = 0;

        try {
            System.out.println("Unesite koliko elemenata zelite da unesete u nizu: ");
            n = sc.nextInt();
        } catch (Exception ex) {
            System.err.println("Uneli ste neki simbol koji nije broj");
        }

        int[] arr = new int[n];
        boolean flag = true;
        int i = 0;

        checkArray(arr);

        System.out.println("Unesite nekoliko cela broja u nizu");

        while (flag) {
            try {
                System.out.println("Broj na poziciji: " + i);
                arr[i] = sc.nextInt();

                i++;

                if (i == n) {
                    flag = false;
                }
            } catch (InputMismatchException e) {
                System.err.println("Uneli ste neki simbol koji nije broj, morate uneti ceo broj");
                sc.next();
            }
        }

        sc.close();

        return arr;
    }

    private static void checkArray(int[] arr) {
        if (arr.length > 10 || arr.length < 2) {
            throw new ArrayStoreException("Morate uneti  od 2 do 10 elemenata u nizu");
        }
    }

    public static void bubbleSortArray(int[] arr) {
        int n = arr.length;
        int temp = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
