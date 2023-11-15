import java.awt.*;

public class TTrapeze extends TQuadrangle {

    public TTrapeze(int x, int y, int w, int h, int c, Color color) {
        super(x,y);
        x2 = x + w; y2 = y;
        x3 = x2 - c; y3 = y - h;
        x4 = x + c; y4 = y3;
        this.color = color;
        System.out.println("Объект TTrapeze создан");
    }

    public TTrapeze(int x, int y) { super(x,y); }

    public void chSize(int dx, int dy) {
        Set(super.GetX()-dx, super.GetY()-dy);
        x2 -= dx;
        x3 += dx;
        x4 += dx;
        y2 -= dy;
        y3 += dy;
        y4 += dy;
    }

    public void Show(boolean VISION) {
        this.VISION= VISION;
        if (this.VISION == false) this.color = Color.WHITE;
        this.VISION = true;
        this.repaint();
    }

    public void MoveTo(int dx, int dy){
        int x1 = super.GetX()+dx;
        int y1 = super.GetY()+dy;
        super.Set(x1,y1);
        x2 += dx;
        x3 += dx;
        x4 += dx;
        y2 += dy;
        y3 += dy;
        y4 += dy;
        this.repaint();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if (VISION == true) {
            int x1 = super.GetX();
            int y1 = super.GetY();
            g.setColor(color);
            g.drawLine(x1,y1,x2,y2);
            g.drawLine(x2,y2,x3,y3);
            g.drawLine(x3,y3,x4,y4);
            g.drawLine(x4,y4,x1,y1);
        }

    }

}
