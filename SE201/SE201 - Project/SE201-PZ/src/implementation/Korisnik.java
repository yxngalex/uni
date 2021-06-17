package implementation;

import interfaceClasses.ILogin;

import java.util.*;

public class Korisnik extends Osoba implements ILogin {
   private Date datumRegistracije;
   
   public java.util.Collection<Model> model;
   public Jezik jezik;
   
   public Korisnik(Date datumRegistracije) {
      this.datumRegistracije = datumRegistracije;
   }
   
   public Korisnik() {
   }


   public java.util.Collection<Model> getModel() {
      if (model == null)
         model = new java.util.HashSet<Model>();
      return model;
   }

   public java.util.Iterator getIteratorModel() {
      if (model == null)
         model = new java.util.HashSet<Model>();
      return model.iterator();
   }

   public void setModel(java.util.Collection<Model> newModel) {
      removeAllModel();
      for (java.util.Iterator iter = newModel.iterator(); iter.hasNext();)
         addModel((Model)iter.next());
   }

   public void addModel(Model newModel) {
      if (newModel == null)
         return;
      if (this.model == null)
         this.model = new java.util.HashSet<Model>();
      if (!this.model.contains(newModel))
         this.model.add(newModel);
   }
   
   public void removeModel(Model oldModel) {
      if (oldModel == null)
         return;
      if (this.model != null)
         if (this.model.contains(oldModel))
            this.model.remove(oldModel);
   }

   public void removeAllModel() {
      if (model != null)
         model.clear();
   }

   @Override
   public boolean verifikacijaKorisnika(String ime, String sifra) {
      System.out.println("Uspesno ste se ulogovali!");
      return true;
   }

   @Override
   public boolean proveraPodataka() {
      return false;
   }
}