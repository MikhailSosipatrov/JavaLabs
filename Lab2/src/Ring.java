import javax.swing.*;
import java.awt.*;

public class Ring extends JPanel {

    private Point O = new Point();
    private int D;
    private Color color;
    private Circle One, Two;
    private boolean VISION = true;

    public Ring (int x, int y, int r, Color c) {
        setLayout(null);
        setOpaque(false);
        if ((x+r) >= 900) { r = 900 - x;}
        if ((y+r) >= 400) { r = 400 - y;}
        if (r > x) { r = x; }
        if (r >= y) { r = y; }
        One = new Circle(x,y,r, c);
        Two = new Circle(x,y,r*2/3, c);
        D = r*2;
        O.Set(x,y);
        System.out.println("Объект Ring создан");
    }

    public Ring (int x, int y, int r) {
        setLayout(null);
        setOpaque(false);
        One = new Circle(x,y,r, Color.RED);
        Two = new Circle(x,y,r*2/3, Color.RED);
        O.Set(x,y); D=r*2;
        System.out.println("Объект Ring создан");
    }

    public void MoveTo(int dx, int dy) {
        O.Set(O.GetX()+dx, O.GetY()+dy);
        this.repaint();
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
            g.drawOval(O.GetX()-D/2, O.GetY()-D/2, D, D);
            g.drawOval(O.GetX()-D/4, O.GetY()-D/4, D/2, D/2);

        }
    }
}

