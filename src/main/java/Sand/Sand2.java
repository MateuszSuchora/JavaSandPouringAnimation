package Sand;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Surface extends JPanel {

    private int[][] tab;

    public void setTab(int[][] tab) {
        this.tab = tab;
    }

    public int[][] getTab() {
        doFall();
        return tab;
    }

    public void doFall() {
        int a, b, c, d;

        for (int i = 1; i < 13; i = i + 2) {
            for (int j = 1; j < 9; j = j + 2) {
                a = tab[i][j];
                c = tab[i][j + 1];
                b = tab[i + 1][j];
                d = tab[i + 1][j + 1];
                if (a == 1 && b == 0 && c == 0 && d == 0) {//1->3
                    tab[i][j] = 0;
                    tab[i][j + 1] = 1;
                } else if (a == 0 && b == 1 && c == 0 && d == 0) {//2->4
                    tab[i + 1][j] = 0;
                    tab[i + 1][j + 1] = 1;
                } else if ((a == 0 && b == 1 && c == 1 && d == 0) || (a == 1 && b == 0 && c == 0 && d == 1) || (a == 1 && b == 1 && c == 0 && d == 0) || (a == 0 && b == 1 && c == 0 && d == 1) || (a == 1 && b == 0 && c == 1 && d == 0)) {//4,5,6,7,9,10->8
                    tab[i][j] = 0;
                    tab[i + 1][j] = 0;
                    tab[i][j + 1] = 1;
                    tab[i + 1][j + 1] = 1;
                } else if (a == 1 && b == 1 && c == 0 && d == 1) {//13->12
                    tab[i][j] = 0;
                    tab[i][j + 1] = 1;
                } else if (a == 1 && b == 1 && c == 1 && d == 0) {//14->11
                    tab[i][j + 1] = 0;
                    tab[i + 1][j + 1] = 1;
                } else if (a == 2 && b == 1 && c == 0 && d == 0) {//A
                    tab[i + 1][j] = 0;
                    tab[i + 1][j + 1] = 1;
                } else if ((a == 2 && b == 1 && c == 0 && d == 0) || (a == 2 && b == 1 && c == 1 && d == 0) || (a == 0 && b == 1 && c == 2 && d == 0) || (a == 1 && b == 1 && c == 2 && d == 0) || (a == 2 && b == 1 && c == 2 && d == 0)) {//A, H, E, J, L
                    tab[i + 1][j] = 0;
                    tab[i + 1][j + 1] = 1;
                } else if ((a == 1 && b == 2 && c == 0 && d == 0) || (a == 1 && b == 2 && c == 0 && d == 1) || (a == 1 && b == 0 && c == 0 && d == 2) || (a == 1 && b == 1 && c == 0 && d == 2) || (a == 1 && b == 2 && c == 0 && d == 2)) {//C, I, F, K, G
                    tab[i][j] = 0;
                    tab[i][j + 1] = 1;
                } else if (a == 2 && b == 1 && c == 0 && d == 1) {//B
                    tab[i + 1][j] = 0;
                    tab[i][j + 1] = 1;
                } else if (a == 1 && b == 2 && c == 1 && d == 0) {//D
                    tab[i][j] = 0;
                    tab[i + 1][j + 1] = 1;
                }
                else if(a==1&&b==1&&c==0&&d==0){
                    tab[i][j]=0;
                    tab[i+1][j+1]=0;
                }
                else if(a==1&&d==2&&c==0&&b==0){
                    tab[i][j]=0;
                    tab[i][j+1]=1;
                }
                else if(a==1&&b==1&&c==1&&d==0){
                    tab[i+1][j]=0;
                    tab[i+1][j+1]=1;
                }
                    

            }
        }
        for (int k = 0; k < 10; k = k + 2) {
            if ((tab[0][k] == 1 && tab[10][k + 1] == 2) || (tab[0][k] == 1 && tab[0][k + 1] == 1)) {
                tab[0][k] = 0;
            } else if ((tab[0][k] == 1 && tab[0][k + 1] == 0)) {
                tab[0][k] = 0;
                tab[0][k] = 1;
            }
        }
        Random generator = new Random();
        for (int i = 3; i < 12; i++) {
            if (tab[i][0] == 0) {
                tab[i][0] = generator.nextInt(2);
                
            }
        }
        for(int i=0;i<15;i++){
            if(tab[i][9]==1)
            tab[i][9]=0;
        }
        System.out.println("DoFall2");
    }

    private void doSand(Graphics g) throws IOException {

        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setPaint(Color.YELLOW);
//        String s = " ";
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 10; j++) {
                        
//                s = s + tab[i][j];
            
                if (tab[i][j] == 1) {
                    g2d.fillRect(50 * (i + 1) - 50, 50*(j + 1) - 50, 50, 50);
                }
            }
//            System.out.println(s);
//            s = " ";
        }

    }

    private void doShape(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(Color.BLACK);
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 10; j++) {
                if (tab[i][j] == 2) {
                    g2d.fillRect(50 * (i + 1) - 50, (j + 1) * 50 - 50, 50, 50);
                }
            }
        }

    }

    private void doNet(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        g2d.setPaint(Color.WHITE);

        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);
        g2d.setColor(Color.BLACK);
        for (int i = 1; i <= 15; i++) {

            for (int j = 1; j <= 10; j++) {

                g2d.draw(new Rectangle2D.Double(50 * i - 50, j * 50 - 50, 50, 50));
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        
        doShape(g);

        try {
            doSand(g);
        } catch (IOException ex) {
            Logger.getLogger(Surface2.class.getName()).log(Level.SEVERE, null, ex);
        }
        doNet(g);
        
        
        System.out.println("DoPic2");
        

    }
}

public class Sand2 extends JFrame {

    private Surface surf;

    public Sand2(int[][] tab) {
        surf = new Surface();
        surf.setTab(tab);
        initUI();
    }

    private void initUI() {
        add(surf);

        setTitle("Piasek2D");
        setSize(765, 535);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public int[][] getTab() {
        
        return surf.getTab();
    }
    public void doFall(){
        surf.doFall();
    }

}
