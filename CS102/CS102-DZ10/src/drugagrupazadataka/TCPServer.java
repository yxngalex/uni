package drugagrupazadataka;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

    public static void main(String[] args) {
        String vrednost;
        try {
            ServerSocket server = new ServerSocket(7821);
            for (int i = 0; i < 1; i++) {
                Socket conn = server.accept();
                DataInputStream odKlijenta = new DataInputStream(conn.getInputStream());
                DataOutputStream zaKlijenta = new DataOutputStream(conn.getOutputStream());
                System.out.println("Ceka se da korisnik prosledi sekunde : ");
                int prosledjeneSekunde = Integer.parseInt(odKlijenta.readUTF());

                int sati = 0;
                int minuti = 0;
                int sekunde = 0;

                sati = prosledjeneSekunde / 3600;

                prosledjeneSekunde = prosledjeneSekunde - sati * 3600;

                minuti = prosledjeneSekunde / 60;

                sekunde = prosledjeneSekunde % 60;

                vrednost = sati + ":" + minuti + ":" + sekunde + "\n";
                System.out.println(vrednost);
                zaKlijenta.writeUTF(vrednost);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
