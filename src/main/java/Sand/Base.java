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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Surface2 extends JPanel {

    private int[][] tab = new int[15][10];

    public Surface2() throws FileNotFoundException, IOException {
        BufferedReader br = null;

//        br = new BufferedReader(new FileReader("Matrix.txt"));
        br = new BufferedReader(new FileReader("Matrix2.txt"));

        String str;
        String[] splitedArray = null;
        for (int i = 0; i < 10; i++) {
            str = br.readLine();

            splitedArray = str.split(",");
            for (int j = 0; j < 15; j++) {
//                System.out.println(Integer.parseInt(splitedArray[j]));
                tab[j][i] = Integer.parseInt(splitedArray[j]);
            }
        }
    }

    public void setTab(int[][] tab) {
        this.tab = tab;
    }

    public int[][] getTab() {
        return tab;
    }

    private void doShape(Graphics g) throws IOException {

        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(Color.BLACK);
        BufferedReader br = null;

        br = new BufferedReader(new FileReader("Matrix.txt"));
//        br = new BufferedReader(new FileReader("Matrix2.txt"));
//        br = new BufferedReader(new FileReader("Matrix3.txt"));
//        br = new BufferedReader(new FileReader("Matrix4.txt"));

        int tab[][] = new int[15][10];
        String str;
        String[] splitedArray = null;
        for (int i = 0; i < 10; i++) {
            str = br.readLine();

            splitedArray = str.split(",");
            for (int j = 0; j < 15; j++) {
//                System.out.println(Integer.parseInt(splitedArray[j]));
                tab[j][i] = Integer.parseInt(splitedArray[j]);
            }
        }
        setTab(tab);
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 10; j++) {
                if (tab[i][j] == 2) {
//                    System.out.println(tab[i][j]);
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
        doNet(g);

        try {
            doShape(g);
        } catch (IOException ex) {
            Logger.getLogger(Surface.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}

public class Base extends JFrame {

    private Surface2 surf;

    public Base() throws IOException {
        surf = new Surface2();
        initUI();
    }

    private void initUI() {
        add(surf);

        setTitle("Piasek2D");
        setSize(765, 535);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public int[][] getTab() {
        return surf.getTab();
    }

}
