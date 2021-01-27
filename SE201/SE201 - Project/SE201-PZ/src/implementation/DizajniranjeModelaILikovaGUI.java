package implementation;

import java.awt.*;
import java.util.Scanner;

public class DizajniranjeModelaILikovaGUI {
   private Model model;
   private Button dugmici;

   public Model getModel() {
      return model;
   }

   public void setModel(Model model) {
      this.model = model;
   }

   public Button getDugmici() {
      return dugmici;
   }

   public void setDugmici(Button dugmici) {
      this.dugmici = dugmici;
   }

   public DizajniranjeModelaILikovaGUI() {
   }
   
   public Model izaberiModel() {
      if (!this.model.exists()) {
         Scanner sc = new Scanner(System.in);
         System.out.println("Izaberite model koji zelite: ");
         int num = sc.nextInt();
         System.out.println("Model 1");
         System.out.println("Model 2");
         System.out.println("Model 3");
         System.out.println("Model 4");
         System.out.println("Nijedan (0)");
         System.out.println(">");
         switch (num) {
            case 1:
               System.out.println("Izabrali ste model 1");
               break;
            case 2:
               System.out.println("Izabrali ste model 2");
               break;
            case 3:
               System.out.println("Izabrali ste model 3");
               break;
            case 4:
               System.out.println("Izabrali ste model 4");
               break;
            default:
               System.out.println("Niste izabrali ni jedan model");
               break;
         }
         sc.close();
      }

      return this.model;
   }

}