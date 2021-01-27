import java.util.Arrays;
import java.util.Scanner;

public class Zadatak13 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Unesite duzinu niza:");
        int n = sc.nextInt();

        int[] a = new int[n];

        System.out.println("Unesite elemente u nizu:");
        for (int i = 0; i < a.length; i++) {
            System.out.println(i + " - ");
            a[i] = sc.nextInt();
        }

        System.out.println("Unesite broj koji zelite da ubacite u nizu: ");
        int x = sc.nextInt();

        System.out.println(Arrays.toString(method(a, x)));
    }

    public static int[] method(int[] arr, int x) {

        int[] newArr = new int[arr.length + 1];

        if (arr.length < 20) {

            for (int i = 0; i < arr.length; i++) {
                newArr[i] += arr[i];
            }

            newArr[arr.length] = x;

            selectionSort(newArr);

        } else {
            System.out.println("Niz je izvan opsega!");
        }

        return newArr;
    }

    public static void selectionSort(int[] a) {
        int n = a.length;

        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++)
                if (a[j] < a[min_idx])
                    min_idx = j;

            int temp = a[min_idx];
            a[min_idx] = a[i];
            a[i] = temp;
        }
    }

}
