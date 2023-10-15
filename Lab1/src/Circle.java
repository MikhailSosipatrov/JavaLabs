import javax.swing.*;
import java.awt.*;

public class Circle extends JPanel {
    private int x, y, D;
    private Color color;
    private boolean VISION = true;

    public Circle (int x, int y, int D, Color c) {
        setLayout(null);
        setOpaque(false);
        this.x = x;
        this.y = y;
        this.D = D;
        color = c;
    }



    public void MoveTo(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public void Show(boolean VISION) {
        this.VISION= VISION;
        if (this.VISION == false) this.color = Color.WHITE;
        this.VISION = true;
        this.repaint();
    }

    public void chRad(int D) {
        this.D = D;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (VISION == true) {
            g.setColor(color);
            g.drawOval(x-D/2, y-D/2, D, D);

        }
    }
}
