package Implementation;

public class Sistem {
   private String poruka;
   private Sistem sistem;
   
   private String getporuka() {
      return poruka;
   }
   
   private void setporuka(String newPoruka) {
      poruka = newPoruka;
   }
   
   private Sistem() {

   }
   
   private Sistem getsistem() {
      return sistem;
   }
   
   private void setsistem(Sistem newSistem) {
      sistem = newSistem;
   }
   
   public Sistem sistemB;
   
   public void prikazGui() {
      // TODO: implement
   }

}