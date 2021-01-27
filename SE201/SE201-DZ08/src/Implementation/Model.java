package Implementation;

import Interface.IDizajniranjeModelaILikova;
import Interface.IGraficko3dModelovanje;
import Interface.IPravljenjeNivoa;

public class Model implements IPravljenjeNivoa, IGraficko3dModelovanje, IDizajniranjeModelaILikova {
   private String naziv;
   private String oblik;
   private String boja;
   private String dimenzije;
   
   public java.util.Collection<Animacija> animacija;
   
   public String getnaziv() {
      return naziv;
   }
   
   public void setnaziv(String newNaziv) {
      naziv = newNaziv;
   }
   
   public Model() {
      // TODO: implement
   }
   
   
   public java.util.Collection<Animacija> getAnimacija() {
      if (animacija == null)
         animacija = new java.util.HashSet<Animacija>();
      return animacija;
   }
   
   public java.util.Iterator getIteratorAnimacija() {
      if (animacija == null)
         animacija = new java.util.HashSet<Animacija>();
      return animacija.iterator();
   }
   
   public void setAnimacija(java.util.Collection<Animacija> newAnimacija) {
      removeAllAnimacija();
      for (java.util.Iterator iter = newAnimacija.iterator(); iter.hasNext();)
         addAnimacija((Animacija)iter.next());
   }
   
   public void addAnimacija(Animacija newAnimacija) {
      if (newAnimacija == null)
         return;
      if (this.animacija == null)
         this.animacija = new java.util.HashSet<Animacija>();
      if (!this.animacija.contains(newAnimacija))
         this.animacija.add(newAnimacija);
   }
   
   public void removeAnimacija(Animacija oldAnimacija) {
      if (oldAnimacija == null)
         return;
      if (this.animacija != null)
         if (this.animacija.contains(oldAnimacija))
            this.animacija.remove(oldAnimacija);
   }
   
   public void removeAllAnimacija() {
      if (animacija != null)
         animacija.clear();
   }

   @Override
   public boolean postojanjeModela() {
      return false;
   }

   @Override
   public void kreirajNoviModel() {

   }

   @Override
   public void izborAnimacija() {

   }

   @Override
   public void animiraj() {

   }

   @Override
   public void odabirModela() {

   }

   @Override
   public boolean modelPostoji() {
      return false;
   }

   @Override
   public void sacuvaj() {

   }

   @Override
   public void preuzmiNoveRekvizite() {

   }

   @Override
   public void pokreniSkidanjeRekvizita() {

   }
}