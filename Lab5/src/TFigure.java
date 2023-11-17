import javax.swing.*;

abstract class TFigure extends JPanel {
    private Point TPoint = new Point();
    protected int fig;
    protected int x1,y1,x2,y2,x3,y3,x4,y4;

    public TFigure(int x, int y) {
        TPoint.Set(x,y);
        setLayout(null);
        setOpaque(false);
        System.out.println("Координаты инициализированы");
    }

    abstract void Show(boolean VISION);

    abstract void MoveTo(int dx, int dy);

    public void Set(int x, int y) {
        TPoint.Set(x,y);
    }

    public int GetX() {return TPoint.GetX();}
    public int GetY() {return TPoint.GetY();}


}
