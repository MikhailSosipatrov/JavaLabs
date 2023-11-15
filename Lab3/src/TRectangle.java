import java.awt.*;

public class TRectangle extends TQuadrangle {

    public TRectangle (int x, int y, int w, int h, Color color) {
        super(x,y); //вызов родительского конструктора
        this.w=w;
        this.h=h;
        x2 = x3 = x + w;
        y2 = y;
        y3 = y4 = y + h;
        x4 = x;
        this.color = color;
        System.out.println("Объект TRectangle создан");
    }

    public TRectangle (int x, int y) { super(x,y); }

    public void chSize(int dx, int dy) {
        x2 += dx;
        x3 = x2;
        y3 += dy;
        y4 = y3;
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
