import javax.swing.*;
import java.awt.*;

public class Circle extends JPanel {
    private Point O = new Point();
    private int D;
    private Color color;
    private boolean VISION = true;

    public Circle (int x, int y, int r, Color color) {
        setLayout(null);
        setOpaque(false);
        if ((x+r) >= 900) { r = 900 - x;}
        if ((y+r) >= 400) { r = 400 - y;}
        if (r>x) { r = x; }
        if (r>=y) { r= y; }
        O.Set(x,y);
        D = r*2;
        this.color = color;
        System.out.println("Объект Circle создан");
    }

    public Circle (int x, int y, int r) {
        setLayout(null);
        setOpaque(false);
        O.Set(x,y); D = r*2; color= Color.BLACK;
        System.out.println("Объект Circle создан");
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
        }
    }
}
