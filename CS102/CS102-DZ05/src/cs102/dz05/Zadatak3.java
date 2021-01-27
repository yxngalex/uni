package cs102.dz05;

public class Zadatak3 {

    /*
    Primenom rekurzivne metode, za dati prirodan broj ispisati broj koji ima iste cifre, ali u obrnutom
    poretku.
     */
    public static void main(String[] args) {
        okrenutBroj(1234);
        okrenutBroj(4321);
        okrenutBroj(-568);
        okrenutBroj(-2468);

    }

    public static void okrenutBroj(int n) {
        if (n < 0) {
            okrenutBroj(Math.abs(n));
            return;
        }
        if (n < 10) {
            System.out.print(n);
            return;
        } else {
            System.out.print(n % 10);
            okrenutBroj(n / 10);
        }
        System.out.println("");
    }
}
