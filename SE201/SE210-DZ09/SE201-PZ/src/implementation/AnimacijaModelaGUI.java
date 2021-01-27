package implementation;

import java.util.Scanner;

public class AnimacijaModelaGUI {
    private Model model;
    private Animacija animacija;

    public Model odabirModela() {
        if (!this.model.exists()) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Izaberite model koji zelite: ");
            int num = sc.nextInt();
            System.out.println("Model 1");
            System.out.println("Model 2");
            System.out.println("Model 3");
            System.out.println("Model 4");
            System.out.println("Nijedan (0)");
            System.out.println(">");
            switch (num) {
                case 1:
                    System.out.println("Izabrali ste model 1");
                    break;
                case 2:
                    System.out.println("Izabrali ste model 2");
                    break;
                case 3:
                    System.out.println("Izabrali ste model 3");
                    break;
                case 4:
                    System.out.println("Izabrali ste model 4");
                    break;
                default:
                    System.out.println("Niste izabrali ni jedan model");
                    break;
            }
        }
        return this.model;
    }

    public void odabirTehnologije() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Izaberite tehnologiju koji zelite: ");
        int num = sc.nextInt();
        System.out.println("Tehnologija 1");
        System.out.println("Tehnologija 2");
        System.out.println("Tehnologija 3");
        System.out.println("Tehnologija 4");
        System.out.println("Nijedna (0)");
        System.out.println(">");
        switch (num) {
            case 1:
                System.out.println("Izabrali ste tehnologiju 1");
                break;
            case 2:
                System.out.println("Izabrali ste tehnologiju 2");
                break;
            case 3:
                System.out.println("Izabrali ste tehnologiju 3");
                break;
            case 4:
                System.out.println("Izabrali ste tehnologiju 4");
                break;
            default:
                System.out.println("Niste izabrali ni jednu tehnologiju");
                break;
        }
        sc.close();
    }

}