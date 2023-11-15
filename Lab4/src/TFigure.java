import javax.swing.*;

abstract class TFigure extends JPanel {
    protected int x1,y1,x2,y2,x3,y3,x4,y4;
    private Point TPoint = new Point();

    public void MoveTo(int dx, int dy)
    {
        this.Show(false);
        Set(TPoint.GetX()+dx,TPoint.GetY()+dy);
        x2 += dx;
        x3 += dx;
        x4 += dx;
        y2 += dy;
        y3 += dy;
        y4 += dy;
        this.Show(true);
    };

   /* Каждый нестатический метод по умолчанию является виртуальным методом.
    В Java нет виртуального ключевого слова, такого как C ++,
    но мы можем определить его и использовать для таких понятий, как полиморфизм во время выполнения.
    Каждый нестатический метод является виртуальной функцией, кроме финальных и закрытых методов.*/


    public void Show(boolean VISION)
    {

    };

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
