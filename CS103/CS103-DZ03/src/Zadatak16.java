public class Zadatak16 {

    public static void main(String[] args) {
        System.out.println(counting(124));
    }

    public static int counting(int n) {
        if (n == 1) return n;
        return (n % 10) + counting(n / 10);
    }
}
