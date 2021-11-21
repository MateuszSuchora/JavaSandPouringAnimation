package Sand;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) throws java.lang.Exception {

        Base base = new Base();
        base.setVisible(true);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex1) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex1);
        }
        int tab[][] = base.getTab();
        String s = " ";

        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 15; i++) {
                s = s + tab[i][j];
            }
            System.out.println(s);
            s = " ";
        }

        Sand sand = new Sand(tab);

        base.setVisible(false);

        try {
            Thread.sleep(500);
        } catch (InterruptedException ex1) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex1);
        }

        tab = sand.getTab();
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex1) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex1);
        }
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 15; i++) {
                s = s + tab[i][j];
            }
            System.out.println(s);
            s = " ";
        }

        Sand2 sand2 = new Sand2(tab);

        sand.setVisible(false);

        while (true) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex1) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex1);
            }
            tab = sand2.getTab();
            for (int j = 0; j < 10; j++) {
                for (int i = 0; i < 15; i++) {
                    s = s + tab[i][j];
                }
                System.out.println(s);
                s = " ";
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex1) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex1);
            }

            sand = new Sand(tab);

            sand2.setVisible(false);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex1) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex1);
            }
            tab = sand.getTab();
            for (int j = 0; j < 10; j++) {
                for (int i = 0; i < 15; i++) {
                    s = s + tab[i][j];
                }
                System.out.println(s);
                s = " ";
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex1) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex1);
            }
            sand2 = new Sand2(tab);

            sand.setVisible(false);

        }

    }

}
