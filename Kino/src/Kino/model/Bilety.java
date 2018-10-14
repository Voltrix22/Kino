package Kino.model;

import Kino.controller.Controller;

import java.sql.SQLException;
import java.util.Scanner;

public class Bilety {

    Scanner bInput = new Scanner(System.in);
    Controller ucb = new Controller();

    public void menuB() throws SQLException {

        boolean bKoniec = true;
        while (bKoniec) {
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println("K - Kup Bilet | P - Pokaż Kupione Bilety | U - Usuń Bilety | Q - Wyjście do Głównego Menu");
            System.out.println("-----------------------------------------------------------------------------------------");
            String bWybor = bInput.nextLine().toUpperCase();

            switch (bWybor) {
                case "K":
                    ucb.showCinemas();
                    System.out.println("Wybierz kino: ");
                    int nrKina = bInput.nextInt();

                    ucb.showCorrectFilms(nrKina);
                    bInput.nextLine();
                    System.out.println("Wybierz film: ");
                    int nrFilmu = bInput.nextInt();
                    bInput.nextLine();
                    System.out.println("Podaj ilość biletów: ");
                    int ileBil = bInput.nextInt();
                    bInput.nextLine();
                    ucb.buyTicket(nrFilmu, ileBil);
                    break;
                case "P":
                    ucb.showTickets();
                    break;
                case "U":
                    System.out.println("Podaj numer pozycji jaką chcesz usunąć: ");
                    int nrBiletu = bInput.nextInt();
                    bInput.nextLine();
                    ucb.deleteTickets(nrBiletu);
                    break;
                case "Q":
                    bKoniec = false;
                    break;
            }
        }
    }
}
