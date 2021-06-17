package Implementation;

import Interface.IBiranjeProgramskogJezika;
import Interface.IPisanjeFunkcionalnosti;

public class Jezik implements IBiranjeProgramskogJezika, IPisanjeFunkcionalnosti {
   private int redniBrojJezika;
   private String imeJezika;
   
   public int getredniBrojJezika() {
      return redniBrojJezika;
   }
   
   public void setredniBrojJezika(int newRedniBrojJezika) {
      redniBrojJezika = newRedniBrojJezika;
   }
   
   public Jezik() {
      // TODO: implement
   }

   @Override
   public void biranjeJezika() {

   }

   @Override
   public void sacuvaj() {

   }
}