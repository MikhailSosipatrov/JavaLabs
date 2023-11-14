import javax.swing.*;

abstract class TFigure extends JPanel {
    private Point TPoint = new Point();

    abstract void MoveTo(int x, int y);
    abstract void Show(boolean VISION);

    public TFigure(int x, int y) {
        TPoint.Set(x,y);
        setLayout(null);
        setOpaque(false);
        System.out.println("Координаты TFigure инициализированы");
    }

    public void Set(int x, int y) {
        TPoint.Set(x,y);
    }

    public int GetX() {return TPoint.GetX();}
    public int GetY() {return TPoint.GetY();}


}
