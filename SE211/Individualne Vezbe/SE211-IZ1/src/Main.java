import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * Ova aplikacija prima datume kao string i konvertuje ih u LocalDate, koji formatira taj string po patternu dd/MM/yyyy
 *
 * @author Aleksa
 * @version 1.0
 * @since 2020-02-20
 */
public class Main {
    public static void main(String[] args) {

        // Korisnik unosi datum kao dan/mesec/godina
        Scanner input = new Scanner(System.in);
        System.out.println("Unesite datum: ");

        String strDate = input.next();

        LocalDate date = LocalDate.parse(strDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.println(proveriDoba(date));
    }

    /**
     * Metoda proveriDoba() prima kao parametar taj localdate i ispituje da li su meseci i dani u odredjenom opsegu gde
     * odlucuje koje je godisnje doba.
     *
     * @param date
     * @return String
     */
    public static String proveriDoba(LocalDate date) {
        int day = date.getDayOfMonth();
        int month = date.getMonthValue();

        if ((month == 12 && day >= 21 && day <= 31) || (month == 1 && day >= 1 && day <= 31) || (month == 2 && day >= 1 && day <= 28) || (month == 3 && day >= 1 && day <= 20)) {
            return "Zima";
        } else if ((month == 3 && day >= 21 && day <= 31) || (month == 4 && day >= 1 && day <= 30) || (month == 5 && day >= 1 && day <= 31) || (month == 6 && day >= 1 && day <= 20)) {
            return "Prolece";
        } else if ((month == 6 && day >= 21 && day <= 30) || (month == 7 && day >= 1 && day <= 31) || (month == 8 && day >= 1 && day <= 31) || (month == 9 && day >= 1 && day <= 22)) {
            return "Leto";
        } else if ((month == 9 && day >= 23 && day <= 30) || (month == 10 && day >= 1 && day <= 31) || (month == 11 && day >= 1 && day <= 30) || (month == 12 && day >= 1 && day <= 21)) {
            return "Jesen";
        }
        return null;
    }

}
