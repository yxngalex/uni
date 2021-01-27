package zadatak3;

public class Main {

    public static int brojParnihCifara(int n) {
        if (n == 0) {
            return 0;
        } else if (n < 0) {
            return brojParnihCifara(Math.abs(n));
        } else if (n % 2 == 0) {
            return 1 + brojParnihCifara(n - 1);
        }
        return brojParnihCifara(n - 1);
    }
}
