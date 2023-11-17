import java.awt.*;

public class TQuadrangle extends TFigure {
    //Variables
    protected int w,h = 0;
    protected Color color;
    protected boolean VISION = true;

    public TQuadrangle(int x1, int y1, int x2, int y2, int x3, int y3,int x4,int y4, Color color){
        super(x1,y1); //вызов родительского конструктора
        this.x2=x2;
        this.y2=y2;
        this.x3=x3;
        this.y3=y3;
        this.x4=x4;
        this.y4=y4;
        this.color=color;
        System.out.println("Объект TQuadrangle создан");
    }

    public TQuadrangle(int x1, int y1){
        super(x1,y1);
    }



    public void Show(boolean VISION) {
        this.VISION= VISION;
        if (this.VISION == false) this.color = Color.WHITE;
        else this.color = Color.black;
        this.VISION = true;
        this.repaint();
    }

    public void chSize(int dx, int dy) {
        Set(super.GetX()-dx, super.GetY()-dy);
        x2 -= dx;
        x3 += dx;
        x4 += dx;
        y2 -= dy;
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
