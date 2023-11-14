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

}
