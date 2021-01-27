package Implementation; /***********************************************************************
 * Module:  Enum.AlertType.java
 * Author:  User
 * Purpose: Defines the Class Enum.AlertType
 ***********************************************************************/

public class AlertType {
   private String SUCCESS;
   private String ERROR;

   public String getERROR() {
      return ERROR;
   }
   
   public void setERROR(String newERROR) {
      ERROR = newERROR;
   }
   
   public AlertType() {
   }

   public class LoginGUI {
      private String username;
      private String passoword;
      
      public String getpassoword() {
         return passoword;
      }
      
      public void setpassoword(String newPassoword) {
         passoword = newPassoword;
      }
      
      public void proveriPodatke() {
         // TODO: implement
      }
      
      public LoginGUI(String username, String password) {
         // TODO: implement
      }
      
      public String getusername() {
         return username;
      }
      
      public void setusername(String newUsername) {
         username = newUsername;
      }
      
      public LoginGUI() {
         System.out.println("Uspesno ste se ulogovali na sistem");
      }
      
      public void prikaziGui() {
         System.out.println("***Prikazujem gui***");
      }
   
   }

}