package cs101.dz10;

public class Main {

    public static void main(String[] args) {
        Racunar r1 = new DesktopRacunar("Asus", "123", "1234", "12345");
        Racunar r2 = new LaptopRacunar("LG", "500");

        r1.racunajCenu();
        r2.racunajCenu();

        System.out.println(r1.toString() + "  kosta " + r1.racunajCenu() + " dinara.");
        System.out.println(r2.toString() + " kosta " + r2.racunajCenu() + " dinara");
    }
}
