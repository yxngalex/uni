package cs102.dz06;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Integer> lista = new ArrayList<>();
        List<String> lista2 = new ArrayList<>();
        
        lista.add(5);
        lista.add(20);
        lista.add(3);
        lista.add(2);
        lista.add(15);
        
        lista2.add("Ivan");
        lista2.add("Aleksa");
        lista2.add("Marko");
        lista2.add("Aleksandar");

        System.out.println("Opadajuci sort za Int izgleda ovako: ");
        GenericUtil.sort(lista);
        
        System.out.println("Opadajuci sort za String izgleda ovako:");
        GenericUtil.sort(lista2);

        //Keiram dva celobrojna nizova
        
        Integer[] a = {new Integer(3), new Integer(4), new Integer(5)};
        Integer[] b = null;
        
        b = GenericUtil.nizovi(a, b, 1);

        System.out.println("\nOstatak na kraju u drugom nizu je: ");
        for (Integer b1 : b) {
            System.out.print(b1 + " ");
        }
        System.out.println("");

        //Kreiram dva tekstualna nizova
        
        String[] c = {"Ivan", "Aleksa", "Marko", "Aleksandar"};
        String[] d = null;
        
        d = GenericUtil.nizovi(c, d, 2);

        System.out.println("\nOstatak na kraju u drugom nizu je: ");
        for (String d1 : d) {
            System.out.print(d1 + " ");
        }
        System.out.println("");
    }
}
