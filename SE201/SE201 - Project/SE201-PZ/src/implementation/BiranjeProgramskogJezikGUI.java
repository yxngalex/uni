package implementation;

import java.util.*;

public class BiranjeProgramskogJezikGUI {
    private int izbor;

    public int getIzbor() {
        return izbor;
    }

    public void setIzbor(int izbor) {
        this.izbor = izbor;
    }

    public BiranjeProgramskogJezikGUI() {
    }

    public void biraJezik() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Izaberite programski jezik koji zelite: ");
        int num = sc.nextInt();
        System.out.println("C");
        System.out.println("C++");
        System.out.println("C#");
        System.out.println("Java");
        System.out.println("Python");
        System.out.println(">");
        switch (num) {
            case 1:
                System.out.println("Uspesno ste izabrali C kao vas jezik!");
                izbor++;
                break;
            case 2:
                System.out.println("Uspesno ste izabrali C++ kao vas jezik!");
                izbor++;
                break;
            case 3:
                System.out.println("Uspesno ste izabrali C# kao vas jezik!");
                izbor++;
                break;
            case 4:
                System.out.println("Uspesno ste izabrali Java kao vas jezik!");
                izbor++;
                break;
            case 5:
                System.out.println("Uspesno ste izabrali Python kao vas jezik!");
                izbor++;
                break;
            default:
                System.out.println("Niste izabrali ni jedan jezik");
                break;
        }
        sc.close();
    }

}