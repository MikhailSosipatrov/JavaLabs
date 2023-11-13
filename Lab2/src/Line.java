import javax.swing.*;
import java.awt.*;

public class Line extends JPanel {

    private Point O1 = new Point();
    private Point O2 = new Point();
    private Color color;
    private boolean VISION = true;

    public Line (int x1, int y1, int x2, int y2, Color c) {
        setLayout(null);
        setOpaque(false);
        O1.Set(x1,y1);
        O2.Set(x2,y2);
        color = c;
        System.out.println("Объект Line создан");
    }

    public Line (int x1, int y1, int x2, int y2) {
        setLayout(null);
        setOpaque(false);
        O1.Set(x1,y1);
        O2.Set(x2,y2);
        color = Color.BLACK;
        System.out.println("Объект Line создан");
    }

    public void MoveTo(int dx, int dy) {
        O1.Set(O1.GetX()+dx, O1.GetY()+dy);
        O2.Set(O2.GetX()+dx, O2.GetY()+dy);
        this.repaint();
    }

    public void Show(boolean VISION) {
        this.VISION= VISION;
        if (this.VISION == false) this.color = Color.WHITE;
        this.VISION = true;
        this.repaint();
    }

    public void Turn() {
        double c1, c2;
        c1 = (O2.GetX() - O1.GetX()) * Math.cos(Math.toRadians(45.0)) - (O2.GetY() - O1.GetY()) * Math.sin(Math.toRadians(45.0)) + O1.GetX();
        c2 = (O2.GetX() - O1.GetX()) * Math.sin(Math.toRadians(45.0)) + (O2.GetY() - O1.GetY()) * Math.cos(Math.toRadians(45.0)) + O1.GetY();
        O2.Set((int)c1,(int)c2);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (VISION == true) {
            g.setColor(color);
            g.drawLine(O1.GetX(), O1.GetY(), O2.GetX(), O2.GetY());
        }
    }
}