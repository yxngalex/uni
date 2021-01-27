package zadatak3;

import dbutil.DbUtil;
import java.util.List;
import pojo.Predmet;
import pojo.Profesor;

public class Main {

    public static void main(String[] args) {
        
        Profesor profesor = new Profesor("Aleksa", "Cekic", 2020, "Softversko inzinjerstvo");
        Predmet predmet = new Predmet("NT111", "Engleski", 25);
        
        //DbUtil.unosUbazuProfesor(profesor);
        //DbUtil.unosUbazuPredmet(predmet);
        
        godina(2006);
        
        //DbUtil.deletePredmetById(22);
        /* 
        Profesor p = new Profesor(25, "Marko", "Milisevic", 2005, "Informacioni Sistemi");
        DbUtil.izmeniProfesora(p);
        
        Predmet p2 = new Predmet(30, "NT112", "Engleski 2", 25);
        DbUtil.izmeniPredmet(p2);
        */
    }
    public static void godina(int godina){
        List<Profesor> listaProfesora = DbUtil.sviProfesori();
        List<Predmet> listaPredmeta = DbUtil.sviPredmeti();
        System.out.println("Svi predmeti profesora su:");
        for(Profesor temp : listaProfesora){
            if(temp.getPrezime().charAt(1) == 'e' && temp.getGodina_izbora_u_zvanje() < godina){
                for(Predmet e : listaPredmeta){
                    if(e.getId_profesora() == temp.getId()){
                        System.out.println("Profesor: " +  temp.getIme() + " ima predmet: " + e.getNaziv_predmeta());
                    }
                }
            }
            
        }
    }  

}
