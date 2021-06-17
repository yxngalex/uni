public class Zadatak9 {
    public final static int d = 256;

    public static void main(String[] args) {
        String txt = "kadsuprelaziliprekopreprekenasmejaseprepredeno";
        String pat = "prepreden";
        int q = 101;

        search(pat, txt, q);
    }

    static void search(String pattern, String txt, int q)
    {
        int M = pattern.length();
        int N = txt.length();
        int i, j;
        int hashP = 0;
        int hashT = 0;
        int hash = 1;

        for (i = 0; i < M - 1; i++)
            hash = (hash * d) % q;

        for (i = 0; i < M; i++) {
            hashP = (d * hashP + pattern.charAt(i)) % q;
            hashT = (d * hashT + txt.charAt(i)) % q;
        }

        for (i = 0; i <= N - M; i++) {

            if (hashP == hashT) {
                for (j = 0; j < M; j++) {
                    if (txt.charAt(i + j) != pattern.charAt(j))
                        break;
                }

                if (j == M)
                    System.out.println("Pattern se pojavljuje na poziciji: " + i);
            }

            if (i < N - M) {
                hashT = (d * (hashT - txt.charAt(i) * hash) + txt.charAt(i + M)) % q;

                if (hashT < 0)
                    hashT = (hashT + q);
            }
        }
    }
}
