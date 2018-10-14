package Kino.model;

import Kino.controller.Controller;
import java.sql.SQLException;
import java.util.Scanner;

public class Filmy {

    Scanner fInput = new Scanner(System.in);
    Controller ucf = new Controller();

    public void menuF() throws SQLException {

        boolean fKoniec = true;

        while(fKoniec) {
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("P - Pokaż Filmy | D - Dodaj Film | U - Usuń Film | Q - Wyjście do Głównego Menu");
            System.out.println("-------------------------------------------------------------------------------");
            String fWybor = fInput.nextLine().toUpperCase();

            switch (fWybor) {
                case "P":
                    ucf.showFilms();
                    break;
                case "D":
                    System.out.println("Napisz tytuł nowego filmu: ");
                    String tytul = fInput.nextLine();
                    System.out.println("-----------------------------");
                    ucf.showCinemas();
                    System.out.println("-----------------------------");
                    System.out.println("W którym kinie ma zostać wyświetlony film: ");
                    int kCinema = fInput.nextInt();
                    fInput.nextLine();
                    ucf.addFilm(tytul, kCinema);
                    break;
                case "U":
                    System.out.println("-----------------");
                    ucf.showFilms();
                    System.out.println("-----------------");
                    System.out.println("Podaj numer filmu, który chcesz usunąć: ");
                    int uFilm = fInput.nextInt();
                    fInput.nextLine();
                    ucf.deleteFilm(uFilm);
                    break;
                case "Q":
                    fKoniec = false;
                    break;
            }
        }
    }
}
