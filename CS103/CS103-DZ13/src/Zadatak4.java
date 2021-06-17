import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Zadatak4 {
    public static void main(String[] args) {
        String regex = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
        String text = "https://google.com";
        String text2 = "https://www.metropolitan.ac.rs/";
        String text3 = "https://www.geeksforgeeks.org/";
        String text4 = "test://test.test";

        // Testiranje url-ove, detaljnije testove mozete videti kod JUnit testova sto sam odradio.
        System.out.println("Text 1: " + isMatch(text, regex));
        System.out.println("Text 2: " + isMatch(text2, regex));
        System.out.println("Text 3: " + isMatch(text3, regex));
        System.out.println("Text 4: " + isMatch(text4, regex));
    }

    public static boolean isMatch(String s, String pattern) {
        try {
            Pattern p = Pattern.compile(pattern);
            Matcher m = p.matcher(s);
            return m.matches();
        } catch (RuntimeException ex) {
            return false;
        }
    }
}
