package dbutil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojo.Predmet;
import pojo.Profesor;

public class DbUtil {

    private static String url = "jdbc:mysql://localhost/cs102dz11";
    private static String username = "root";
    private static String password = "";

    public static void unosUbazuProfesor(Profesor prof) {
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            String sql = "INSERT INTO `profesor`(`id`, `ime`, `prezime`, `godina_izbora_u_zvanje`, `naslov_doktorata`)"
                    + " VALUES(?,?,?,?,?);";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, prof.getId());
            stmt.setString(2, prof.getIme());
            stmt.setString(3, prof.getPrezime());
            stmt.setInt(4, prof.getGodina_izbora_u_zvanje());
            stmt.setString(5, prof.getNaslov_doktorata());
            stmt.executeUpdate();
            System.out.println("PROFESOR JE UNET U BAZU PODATAKA!");
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static Profesor findProfesorById(int id){
        Profesor p = null;
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            String sql = "SELECT * FROM profesor WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.last();
            if(rs.getRow() > 1){
                throw new SQLException("ID nije jedninstven");
            }            
            rs.beforeFirst();
            
            rs.next();
            p = new Profesor();
            p.setId(rs.getInt(1));
            p.setIme(rs.getString(2));
            p.setPrezime(rs.getString(3));
            p.setGodina_izbora_u_zvanje(rs.getInt(4));
            p.setNaslov_doktorata(rs.getString(5));

            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return p;
    }
    public static Profesor findProfesorByImePrezimeGodinaZvanja(String ime, String prezime, int godina){
        Profesor p = null;
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            String sql = "SELECT * FROM profesor WHERE ime = ? AND prezime = ? AND godina_izbora_u_zvanje = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, ime);
            stmt.setString(2, prezime);
            stmt.setInt(3, godina);
            ResultSet rs = stmt.executeQuery();
            rs.last();
            if(rs.getRow() > 1){
                throw new SQLException("ID nije jedninstven");
            }            
            rs.beforeFirst();
            
            rs.next();
            p = new Profesor();
            p.setIme(rs.getString(2));
            p.setPrezime(rs.getString(3));
            p.setGodina_izbora_u_zvanje(rs.getInt(4));
            p.setNaslov_doktorata(rs.getString(5));

            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return p;
    }
    
    public static void unosUbazuPredmet(Predmet pred) {
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            String sql = "INSERT INTO `predmet`(`id`,`sifra_predmeta`,`naziv_predmeta`, `id_profesora`)"
                    + "VALUES(?,?,?,?);";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, pred.getId());
            stmt.setString(2, pred.getSifra_predmeta());
            stmt.setString(3, pred.getNaziv_predmeta());
            stmt.setInt(4, pred.getId_profesora());
            //1. Proveriti da li profesor postoji u bazi, ako postoji izvuci njegov id iz baze
            //2. Kreiraj novog profesora
            //3. Ispisi poruku da upis ne moze da se uradi iz razloga da treba da se unese profesor
            /*if(pred.getProf() == null){
                stmt.setNull(4, 1);
            } else if(pred.getProf() != null && pred.getProf().getId() > 0){
                Profesor p = findProfesorById(pred.getProf().getId());
                if(p != null){
                stmt.setInt(4, pred.getProf().getId());
                } else {
                    stmt.setNull(4, 1);
                    System.out.println("Greska kod Profesora");
                }
            } else if(pred.getProf() != null && pred.getProf().getId() == 0){
                Profesor p = findProfesorByImePrezimeGodinaZvanja(pred.getProf().getIme(), pred.getProf().getPrezime(), pred.getProf().getGodina_izbora_u_zvanje());
                if(p != null){
                     stmt.setInt(4, p.getId());
                } else {
                    Profesor prof1 = new Profesor(pred.getProf().getIme(), pred.getProf().getPrezime(), pred.getProf().getGodina_izbora_u_zvanje(), pred.getProf().getNaslov_doktorata());
                    unosUbazuProfesor(prof1);
                    prof1 = findProfesorByImePrezimeGodinaZvanja(pred.getProf().getIme(), pred.getProf().getPrezime(), pred.getProf().getGodina_izbora_u_zvanje());
                    stmt.setInt(4, prof1.getId());
                }
            }
*/
            stmt.executeUpdate();
            System.out.println("PREDMET JE UNET U BAZU PODATAKA!");
            
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static int deleteProfesor(Profesor p) {
        return deleteProfesorById(p.getId());
    }

    public static int deleteProfesorById(int id) {
        int result = 0;
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            String sql = "DELETE from profesor WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            System.out.println("USPESNO STE IZBRISALI PROFESORA IZ BAZE!");
            result = stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public static int deletePredmet(Predmet p) {
        return deletePredmetById(p.getId());
    }

    public static int deletePredmetById(int id) {
        int result = 0;
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            String sql = "DELETE from predmet WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            System.out.println("USPESNO STE IZBRISALI PREDMET IZ BAZE");
            result = stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public static int izmeniProfesora(Profesor p) {
        int res = 0;
        if (p == null) {
            System.out.println("NE SME BITI PRAZAN!");
            return -1;
        }

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            String sql = "UPDATE `profesor`"
                    + "SET `ime` = ?, `prezime` = ?, `godina_izbora_u_zvanje` = ?, `naslov_doktorata` = ?"
                    + "WHERE `id` = ?;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, p.getIme());
            stmt.setString(2, p.getPrezime());
            stmt.setInt(3, p.getGodina_izbora_u_zvanje());
            stmt.setString(4, p.getNaslov_doktorata());
            stmt.setInt(5, p.getId());
            res = stmt.executeUpdate();
            System.out.println("USPESNO STE PROMENILI " + res + " REDOVA U TABELI PROFESORI!");

            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return res;
    }

    public static int izmeniPredmet(Predmet p) {
        int res = 0;
        if (p == null) {
            System.out.println("NE SME BITI PRAZAN!");
            return -1;
        }
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            String sql = "UPDATE `predmet`"
                    + "SET `sifra_predmeta` = ?, `naziv_predmeta` = ?, `id_profesora` = ? "
                    + "WHERE `id` = ?;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, p.getSifra_predmeta());
            stmt.setString(2, p.getNaziv_predmeta());
            stmt.setInt(3, p.getId_profesora());
            stmt.setInt(4, p.getId());
            res = stmt.executeUpdate();
            System.out.println("USPESNO STE IZMENILI PREDMET NA " + res + " REDOVA");

            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return res;
    }

    public static List<Profesor> sviProfesori() {
        ArrayList<Profesor> lista = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            String sql = "SELECT * FROM profesor";
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Profesor p = new Profesor();
                p.setId(rs.getInt(1));
                p.setIme(rs.getString(2));
                p.setPrezime(rs.getString(3));
                p.setGodina_izbora_u_zvanje(rs.getInt(4));
                p.setNaslov_doktorata(rs.getString(5));
                lista.add(p);
            }
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return lista;
    }

    public static List<Predmet> sviPredmeti() {
        ArrayList<Predmet> lista = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            String sql = "SELECT * FROM predmet";
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Predmet p = new Predmet();
                p.setSifra_predmeta(rs.getString(2));
                p.setNaziv_predmeta(rs.getString("naziv_predmeta"));
                //p.setId_profesora(rs.getInt(4));
                //Za id profesora iz predmeta, izvuci objekat profesor
                p.setId_profesora(rs.getInt(4));
                lista.add(p);

            }
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return lista;
    }
}
    