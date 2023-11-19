import java.awt.*;

public class TCircle extends TFigure {
    protected int r1, r2;
    protected Color color;
    protected boolean VISION = false;

    public TCircle(int x, int y, int r, Color color) {
        super(x,y);
        r1 = r2 = r;
        this.color = color;
        System.out.println("Объект TCircle создан");
    }

    public TCircle(int x, int y) { super(x,y); }

    public void Show(boolean VISION) {
        this.VISION= VISION;
        if (this.VISION == false) this.color = Color.WHITE;
        if (this.VISION == true) this.color = Color.BLACK;
        this.VISION = true;
        this.repaint();
    }


    public void MoveTo(int dx, int dy) {
//        this.Show(false);
        x1 = super.GetX() + dx;
        y1 = super.GetY() + dy;
        super.Set(x1, y1);
//        this.Show(true);
    }

    public void chRad(int r) {
        if (r1 == r2) {
            r1 = r2 = r;
        } else {
            r1 = r;
        }
        this.repaint();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if (VISION==true) {
            g.setColor(color);
            g.drawOval(super.GetX(),super.GetY(),r1*2,r2*2);
        }
    }


}
