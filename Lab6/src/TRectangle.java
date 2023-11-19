import javax.swing.*;
import java.awt.*;

public class TRectangle extends TQuadrangle {

    public TRectangle (int x, int y, int w, int h, Color color) {
        super(x,y);
        this.w=w;
        this.h=h;
        x2 = x3 = x + w;
        y2 = y;
        y3 = y4 = y + h;
        x4 = x;
        this.color = color;
        System.out.println("Объект Rectangle создан");
    }

    public TRectangle (int x, int y) { super(x,y); }

    public void Show(boolean VISION) {
        this.VISION= VISION;
        if (this.VISION == false) this.color = Color.WHITE;
        if (this.VISION == true) this.color = Color.BLACK;
        this.VISION = true;
        this.repaint();
    }

    public void chSize(int dx, int dy) {
        x2 += dx;
        x3 = x2;
        y3 += dy;
        y4 = y3;
        this.repaint();
    }

}
