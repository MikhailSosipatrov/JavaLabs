import javax.swing.*;
import java.awt.*;

public class Triangle extends JPanel {
    private int x1, x2, x3, y1, y2, y3;
    private Color color;
    private boolean VISION = true;

    public Triangle (int c1, int c2, int c3, int c4, int c5, int c6, Color c) {
        setLayout(null);
        setOpaque(false);
        x1 = c1;
        x2 = c2;
        x3 = c3;
        y1 = c4;
        y2 = c5;
        y3 = c6;
        color = c;
    }


    public void MoveTo(int c1, int c2) {
        x1 += c1;
        x2 += c1;
        x3 += c1;
        y1 += c2;
        y2 += c2;
        y3 += c2;

    }

    public void Show(boolean VISION) {
        this.VISION= VISION;
        if (this.VISION == false) this.color = Color.WHITE;
        this.VISION = true;
        this.repaint();
    }

    public void chSize(int c1, int c2) {
        x1 -= c1;
        x3 += c1;
        y1 -= c2;
        y3 -=c2;
    }


    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (VISION == true) {
            g.setColor(color);
            g.drawPolygon(new int[] {x1, x2, x3}, new int[] {y1, y2, y3},3);
        }
    }

}



