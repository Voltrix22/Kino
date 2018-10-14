package Kino;

import Kino.controller.Controller;
import Kino.model.Bilety;
import Kino.model.Filmy;
import Kino.model.Kino;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {

        Scanner input = new Scanner(System.in);
        Controller uc = new Controller();

        boolean przerwanie = true;

        System.out.println("WITAMY W APLIKACJI KINo");
        System.out.println();
        while(przerwanie) {
            System.out.println("------------------------------------------------");
            System.out.println("F - Filmy | K - Kina  | B - Bilety | Q - Wyjście");
            System.out.println("------------------------------------------------");
            String wybor = input.nextLine().toUpperCase();

            switch (wybor) {
                case "F":
                    Filmy filmy = new Filmy();
                    filmy.menuF();
                    break;
                case "K":
                    Kino kino = new Kino();
                    kino.menuK();
                    break;
                case "B":
                    Bilety bilety = new Bilety();
                    bilety.menuB();
                    break;
                case "Q":
                    przerwanie = false;
                    System.out.println("DZIĘKUJEMY ZA SKORZYSTANIE Z NASZEJ APLIKACJI");
                    break;
            }
        }
    }
}
