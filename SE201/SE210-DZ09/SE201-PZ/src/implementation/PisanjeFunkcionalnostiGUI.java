package implementation;

import java.awt.*;

public class PisanjeFunkcionalnostiGUI {
   private int kod;
   private Button sacuvajDugme;
   
   public int getkod() {
      return kod;
   }
   
   public void setkod(int newKod) {
      kod = newKod;
   }
   
   public PisanjeFunkcionalnostiGUI() {
   }
   
   public String sacuvajZapisanuFunkciju() {
      return "Uspesno ste sacuvali zapisanu funkciju";
   }
   
   public boolean odabraoJezik() {
      return false;
   }
   
   public String biraJezik() {
      return "Izaberite vas programski jezik";
   }

}