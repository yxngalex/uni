package implementation;

import java.util.ArrayList;
import java.util.Scanner;

public class Graficko3dModelovanjeGUI {
   private Model modeli;
   private int rekviziti;

   public Model getModeli() {
      return modeli;
   }

   public void setModeli(Model modeli) {
      this.modeli = modeli;
   }

   public int getRekviziti() {
      return rekviziti;
   }

   public void setRekviziti(int rekviziti) {
      this.rekviziti = rekviziti;
   }

   public Graficko3dModelovanjeGUI() {
   }
   
   public void sacuvajNoviModel() {
      System.out.println("Model je uspesno sacuvan!");
   }
   
   public void sviModeli() {
      ArrayList<Model> listaModela = new ArrayList<>();
      listaModela.add(modeli);
      for (Model model : listaModela) {
         System.out.println(model);
      }
   }
   
   public void kreirajModel() {
      Scanner sc = new Scanner(System.in);
      Model model = new Model();
      System.out.println("Nazovite vaseg modela: ");
      model.setNaziv(sc.next());
      System.out.println("Koje boje zelite da bude vas model: ");
      model.setBoja(sc.next());
      System.out.println("Koje dimenzije zelite da vas model bude: ");
      model.setDimenzije(sc.next());
      System.out.println("Kog oblika zelite da vas model bude: ");
      model.setOblik(sc.next());

      sc.close();

      System.out.println("Vas model je uspesno kreiran!");
   }

}