import java.awt.*;

public class TEllipse extends TCircle {
    private int a;

    public  TEllipse(int x, int y, int r1, int r2, Color color) {
        super(x,y);
        this.r1=r1;
        this.r2=r2;
        this.color=color;
        System.out.println("Объект TEllipse создан");
    }

    public  TEllipse(int x, int y) {
        super(x,y);
    }

    public void Show(boolean VISION) {
        this.VISION= VISION;
        if (this.VISION == false) this.color = Color.WHITE;
        if (this.VISION == true) this.color = Color.BLACK;
        this.VISION = true;
        this.repaint();
    }

    public void Turn() {
        a=r1;
        r1=r2;
        r2=a;
        this.repaint();
    }

}
