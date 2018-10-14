package Kino.model;

import Kino.controller.Controller;

import java.sql.SQLException;
import java.util.Scanner;

public class Kino {

    Scanner kInput = new Scanner(System.in);
    Controller uck = new Controller();

    public void menuK() throws SQLException {
        boolean kKoniec = true;

        while (kKoniec) {
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("P - Pokaż Kina | D - Dodaj Kino | U - Usuń Kino | Q - Wyjście do Głównego Menu");
            System.out.println("------------------------------------------------------------------------------");
            String kWybor = kInput.nextLine().toUpperCase();

            switch (kWybor) {
                case "P":
                    uck.showCinemas();
                    break;
                case "D":
                    System.out.println("Podaj nazwę nowego kina: ");
                    String nazwaK = kInput.nextLine();
                    uck.addCinema(nazwaK);
                    break;
                case "U":
                    System.out.println("Podaj numer kina, które chcesz usunąć: ");
                    int numerK = kInput.nextInt();
                    kInput.nextLine();
                    uck.deleteCinema(numerK);
                    break;
                case "Q":
                    kKoniec = false;
                    break;
            }
        }
    }
}
