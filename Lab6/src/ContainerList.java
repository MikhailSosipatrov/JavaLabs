import javax.swing.*;
import java.awt.*;

class Node
{
    private Node Next; 
    private TFigure Fig; 

    public Node (Node Next, TFigure Fig) { this.Next = Next; this.Fig = Fig; }
    public Node GetNext ()  { return Next; }
    public TFigure GetFig () { return Fig ; }
    public void SetNext (Node Next) { this.Next = Next; }
    public void SetFig (TFigure aFig) { Fig = aFig; }
}


class ContainerList
{
    private Node First; 
    private int indList, x,y,r,w,h,c, x2, y2, x3, y3, x4, y4;
    private int number;
    private int ListSize;

    public ContainerList() { First = null; } 

    public void Operation(int operation) {
        //  Создать
        if (operation == 1) {
            ListSize += 15 + (int) (Math.random()*10);
            System.out.println("ListSize = " + ListSize);
            for (int j = 0; j < ListSize; j++ ) {
                number = 1 + (int) (Math.random() * 6);
                this.Creator(number, ListSize-j-1);
            }
        }
        // operation == 2 -> Переместить
        else if (operation == 2){
            x = -30 + (int) (Math.random() * 100);
            y = -30 + (int) (Math.random() * 100);
            Node Current = First;
            int q = 0;
            while (Current != null) {
                Current.GetFig().MoveTo(x,y);
                q = q+1;
                Current = Iterator(q);
            }
        }
        // operation == 3 -> Показать
        else if (operation == 3){
            Node Current = First;
            int q = 0;
            while (Current != null) {
                Current.GetFig( ).Show(true);
                q = q+1;
                Current = Iterator(q);
            }
        }
        // operation == 4 -> Стереть
        else if (operation == 4){
            indList = 0;
        }
        // operation == 5 -> Уничтожить
        else if (operation == 5){
            indList = 0;
            First = null;
            ListSize = 0;
            Node Current = First;
            int q = 0;
            while (Current != null) {
                Current = null;
                q = q+1;
                Current = Current.GetNext( );
            }
        }
        // operation == 6 -> Добавить
        else if (operation == 6){
            number = 1 + (int) (Math.random() * 6);
            this.Creator(number, ListSize);
            ListSize++;
        }
    }


    public void Add(TFigure aFig) {
        First = new Node(First, aFig);
    }

    private void Creator(int number, int j){
        x = (int) (Math.random() * 500);
        y = (int) (Math.random() * 500);
        //Окружность
        if (number == 1) {
            r = (int) (Math.random() * 200);
            Add(new TCircle(x, y, r, Color.BLACK));
        }
        //Эллипс
        if (number == 2) {
            w = (int) (Math.random() * 200);
            h = (int) (Math.random() * 100);
            Add(new TEllipse(x, y, w, h, Color.BLACK));
        }
        //Четырехугольник
        if (number == 3) {
            x2 = (int) (Math.random() * 500);
            y2 = (int) (Math.random() * 500);
            x3 = (int) (Math.random() * 500);
            y3 = (int) (Math.random() * 500);
            x4 = (int) (Math.random() * 500);
            y4 = (int) (Math.random() * 500);
            Add(new TQuadrangle(x, y, x2, y2, x3, y3, x4, y4, Color.BLACK));
        }
        //Прямоугольник
        if (number == 4) {
            w = 100 + (int) (Math.random() * 500);
            h = 100 + (int) (Math.random() * 250);
            Add(new TRectangle(x, y, w, h, Color.BLACK));
        }
        //Ромб
        if (number == 5) {
            w = 100 + (int) (Math.random() * 500);
            h = 100 + (int) (Math.random() * 250);
            Add(new TRomb(x, y, w, h, Color.BLACK));
        }
        //Трапециия
        if (number == 6) {
            w = 100 + (int) (Math.random() * 500);
            h = 100 + (int) (Math.random() * 250);
            c = 10 + (int) (Math.random() * 50);
            Add(new TTrapeze(x, y, w, h, c, Color.BLACK));
        }
    }

    int GetCount() { return this.ListSize; }

    int GetIList() { return this.indList; }

    void SetIList(int indList) { this.indList = indList;}

    private Node Iterator(int i) {
        if (i<=ListSize) {
            Node a = First;
            for (int j=0; j<i; j++) {
                a = a.GetNext();
            }
            return a;
        }
        else { return null; }
    }

    TFigure getFigureFromContList(int i) {
        Node a = Iterator(i);
        return a.GetFig();
    }

}

