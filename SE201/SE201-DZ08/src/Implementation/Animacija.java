package Implementation;

import Interface.IAnimacijaModela;
import Interface.IDizajniranjeModelaILikova;

public class Animacija implements IAnimacijaModela, IDizajniranjeModelaILikova {
   private String verzija;
   private String dimenzije;
   private String tehnologija;
   private String engine;
   
   public String getengine() {
      return engine;
   }
   
   public void setengine(String newEngine) {
      engine = newEngine;
   }
   
   public Animacija() {

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
   public void animirajModel() {

   }
}