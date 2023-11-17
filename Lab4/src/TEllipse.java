import java.awt.*;

public class TEllipse extends TCircle {

    public  TEllipse(int x, int y, int r1, int r2, Color color) {
        super(x,y); //вызов родительского конструктора
        this.r1=r1;
        this.r2=r2;
        this.color=color;
        System.out.println("Объект TEllipse создан");
    }

    public  TEllipse(int x, int y) {
        super(x,y);
    }



    public void Turn() {
        int a = r1;
        r1=r2;
        r2= a;
        this.repaint();
    }

    public void Show(boolean VISION) {
        this.VISION= VISION;
        if (this.VISION == false) this.color = Color.WHITE;
        else this.color = Color.black;
        this.VISION = true;
        this.repaint();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if (VISION == true) {
            g.setColor(color);
            g.drawOval(super.GetX(),super.GetY(),r1*2,r2*2);
        }
    }
}
