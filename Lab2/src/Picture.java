import javax.swing.*;
import java.awt.*;

public class Picture extends JPanel {

    private Point O = new Point();
    private int w, h;
    private Triangle roof;
    private Rectangle sides, window;
    private Line line1, line2;
    private Circle sun;
    private Color roof_color = Color.BLUE;
    private Color sides_color = Color.BLACK;
    private Color sun_color = Color.YELLOW;
    private boolean VISION = true;

    public Picture (int x, int y, int w, int h) {
        setLayout(null);
        setOpaque(false);
        O.Set(x,y);
        this.w = w;
        this.h = h;
        sides = new Rectangle(O.GetX(), O.GetY(), w, h, sides_color);
        window = new Rectangle(O.GetX(), O.GetY(), w, h, sides_color);
        line1 = new Line(O.GetX(), O.GetY(), w, h);
        line2 = new Line(O.GetX(), O.GetY(), w, h);
        roof = new Triangle(O.GetX(), O.GetY(), w, h, w , h);
        sun = new Circle(w, h, h);
        System.out.println("Объект Picture создан");
    }

    public void MoveTo(int dx, int dy) {
        O.Set(O.GetX()+dx, O.GetY()+dy);
        this.repaint();
    }

    public void Show(boolean VISION) {
        this.VISION= VISION;
        if (this.VISION == false) {
            this.roof_color = Color.WHITE;
            this.sides_color = Color.WHITE;
            this.sun_color = Color.WHITE;
        }
        this.VISION = true;
        this.repaint();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (VISION == true) {
            g.setColor(sides_color);
            g.drawRect(O.GetX(), O.GetY(), w, h);
            g.drawRect(O.GetX() + w/3, O.GetY()+h/3, w/3, h/3);
            g.drawLine(O.GetX() + w/3, O.GetY()+h/2, O.GetX()+2*w/3, O.GetY()+h/2);
            g.drawLine(O.GetX() + w/2, O.GetY()+h/3, O.GetX()+w/2, O.GetY()+2*h/3);
            g.setColor(roof_color);
            g.fillPolygon(new int[] {O.GetX(),O.GetX()+w/2,O.GetX()+w}, new int[] {O.GetY(),O.GetY()-(2*h/3),O.GetY()}, 3);
            g.setColor(sun_color);
            g.fillOval(O.GetX()-150, O.GetY()-150, h/5, h/5);

        }
    }

}
