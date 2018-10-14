package Kino.controller;

import Kino.dataBase.DBConnect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Controller {

    DBConnect dao = new DBConnect();


    //KONTROLA MENU FILMÓW

    //POKAZANIE FILMÓW
    public void showFilms() throws SQLException {
        Statement st = dao.getCon().createStatement();
        ResultSet rs = st.executeQuery("select * from filmy");

        while(rs.next()){
            System.out.println(rs.getInt("ID")+" "+rs.getString("nazwa"));
        }
        st.close();
    }
    //DODAWANIE FILMU
    public void addFilm(String tytul, int kino) throws SQLException {
        String insertSQL = "INSERT INTO filmy(nazwa, kino_ID) VALUES (? ,?)";
        PreparedStatement st = dao.getCon().prepareStatement(insertSQL);
        st.setString(1, tytul);
        st.setInt(2, kino);
        st.execute();
        st.close();

        System.out.println("Chcesz zatwierdzić wprowadzone zmiany?");
        System.out.println("T - tak");
        System.out.println("N - nie");
        Scanner addInput = new Scanner(System.in);
        String decyzja = addInput.nextLine().toUpperCase();
        if(decyzja.equals("T")){
            dao.getCon().commit();
            System.out.println("DODANO FILM DO LISTY");
        }
        else{
            dao.getCon().rollback();
        }

    }
    //USUWANIE FILMU
    public void deleteFilm(int ID) throws SQLException {

        String usunSQL = "delete from filmy where ID = "+ID+"";
        PreparedStatement st = dao.getCon().prepareStatement(usunSQL);
        st.execute();
        st.close();

        System.out.println("Chcesz zatwierdzić wprowadzone zmiany?");
        System.out.println("T - tak");
        System.out.println("N - nie");
        Scanner addInput = new Scanner(System.in);
        String decyzja = addInput.nextLine().toUpperCase();
        if(decyzja.equals("T")){
            dao.getCon().commit();
            System.out.println("FILM ZOSTAŁ USUNIĘTY");
        }
        else{
            dao.getCon().rollback();
        }
    }


    //KONTROLA KIN

    //POKAZANIE LISTY KIN
    public void showCinemas() throws SQLException {
        Statement st = dao.getCon().createStatement();
        ResultSet rs = st.executeQuery("select * from kino");

        while(rs.next()){
            System.out.println(rs.getInt("ID")+" "+rs.getString("nazwa"));
        }
        st.close();
    }
    //DODANIE KINA
    public void addCinema(String nazwaK) throws SQLException {

        String insertSQL = "INSERT INTO kino(nazwa) VALUES (?)";
        PreparedStatement st = dao.getCon().prepareStatement(insertSQL);
        st.setString(1, nazwaK);
        st.execute();
        st.close();

        System.out.println("Chcesz zatwierdzić wprowadzone zmiany?");
        System.out.println("T - tak");
        System.out.println("N - nie");
        Scanner addInput = new Scanner(System.in);
        String decyzja = addInput.nextLine().toUpperCase();
        if(decyzja.equals("T")){
            dao.getCon().commit();
            System.out.println("KINO ZOSTAŁO DODANE DO LISTY");
        }
        else{
            dao.getCon().rollback();
        }

    }
    //USUWANIE KINA
    public void deleteCinema(int numerK) throws SQLException {

        String usunSQL = "delete from kino where ID = "+numerK+"";
        PreparedStatement st = dao.getCon().prepareStatement(usunSQL);
        st.execute();
        st.close();

        System.out.println("Chcesz zatwierdzić wprowadzone zmiany?");
        System.out.println("T - tak");
        System.out.println("N - nie");
        Scanner addInput = new Scanner(System.in);
        String decyzja = addInput.nextLine().toUpperCase();
        if(decyzja.equals("T")){
            dao.getCon().commit();
            System.out.println("KINO ZOSTAŁO USUNIĘTE");
        }
        else{
            dao.getCon().rollback();
        }
    }


    //MENU BILETÓW

    //POKAZANIE DOKŁADNEJ LISTY FILMOW W DANYCH KINACH
    public void showCorrectFilms(int nrKina) throws SQLException {
        Statement st = dao.getCon().createStatement();
        ResultSet rs = st.executeQuery("select f.ID, f.nazwa from filmy as f inner join kino as k on f.kino_ID=k.ID where f.kino_ID="+nrKina+"");

        while(rs.next()){
            System.out.println(rs.getInt("f.ID")+" "+rs.getString("f.nazwa"));
        }
        st.close();
    }
    //KUPOWANIE BILETU
    public void buyTicket(int nrFilmu, int ileBil) throws SQLException {

        String insertSQL = "INSERT INTO bilety(ilosc, filmy_ID) VALUES (?, ?)";
        PreparedStatement st = dao.getCon().prepareStatement(insertSQL);
        st.setInt(1, ileBil);
        st.setInt(2, nrFilmu);
        st.execute();
        st.close();

        System.out.println("Chcesz zatwierdzić wprowadzone zmiany?");
        System.out.println("T - tak");
        System.out.println("N - nie");
        Scanner addInput = new Scanner(System.in);
        String decyzja = addInput.nextLine().toUpperCase();
        if(decyzja.equals("T")){
            dao.getCon().commit();
            System.out.println("BILETY ZOSTAŁY ZAKUPIONE");
        }
        else{
            dao.getCon().rollback();
        }
    }
    //LISTA BILETOW
    public void showTickets() throws SQLException {
        Statement st = dao.getCon().createStatement();
        ResultSet rs = st.executeQuery("select b.ID, b.ilosc, f.nazwa, k.nazwa from bilety as b inner join filmy as f on b.filmy_ID = f.ID inner join kino as k on f.kino_ID=k.ID;");

        while(rs.next()){
            System.out.println(rs.getInt("b.ID")+" | "+rs.getInt("b.ilosc")+" | "+rs.getString("f.nazwa")+" | "+rs.getString("k.nazwa"));
        }
        st.close();
    }
    //USUWANIE BILETOW
    public void deleteTickets(int numerB) throws SQLException {
        String usunSQL = "delete from bilety where ID = "+numerB+"";
        PreparedStatement st = dao.getCon().prepareStatement(usunSQL);
        st.execute();
        st.close();

        System.out.println("Chcesz zatwierdzić wprowadzone zmiany?");
        System.out.println("T - tak");
        System.out.println("N - nie");
        Scanner addInput = new Scanner(System.in);
        String decyzja = addInput.nextLine().toUpperCase();
        if(decyzja.equals("T")){
            dao.getCon().commit();
            System.out.println("BILETY ZOSTAŁY USUNIĘTE");
        }
        else{
            dao.getCon().rollback();
        }
    }
}
