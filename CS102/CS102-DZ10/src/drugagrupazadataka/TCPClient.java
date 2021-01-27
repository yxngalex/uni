package drugagrupazadataka;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String odgovor;
        try {
            Socket conn = new Socket("localhost", 7821);
            DataOutputStream zaServer = new DataOutputStream(conn.getOutputStream());
            BufferedReader odServera = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            System.out.println("Unesite koliko sekundi zelite: ");
            String broj = sc.next();
            
            zaServer.writeUTF(broj);

            odgovor = odServera.readLine();
            System.out.println("Odgovor od servera : " + odgovor);
            conn.close();
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
