import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


class ContainerArray {

    private static ArrayList<TFigure> Figures = new ArrayList();
    private int indArray, x,y,r,w,h,c, x2, y2, x3, y3, x4, y4;
    private int number;
    private int MassiveSize;

    void Operation(int operation){
        //Создать
        if (operation == 1) {
            MassiveSize += 15 + (int) (Math.random()*10);
            System.out.println("MassiveSize = " + MassiveSize);
            for (int j = 0; j < MassiveSize; j++ ) {
                number = 1 + (int) (Math.random() * 6);
                this.Creator(number, j);
            }
        }
        //Переместить
        else if (operation == 2){
            x = -30 + (int) (Math.random() * 100);
            y = -30 + (int) (Math.random() * 100);
            for (int j = 0; j < indArray; j++) {
                Figures.get(j).MoveTo(x, y);
            }
        }
        //Показать
        else if (operation == 3){
            for (indArray=0; indArray<MassiveSize; indArray++) {
                Figures.get(indArray).Show(true);
            }
        }
        //Стереть
        else if (operation == 4){
            indArray = 0;
        }
        //Уничтожить
        else if (operation == 5){
            indArray = 0;
            Figures = null;
            MassiveSize = 0;
        }
        //Добавить
        else if (operation == 6){
            number = 1 + (int) (Math.random() * 6);
            this.Creator(number, MassiveSize);
            MassiveSize++;
        }
    }

    private void Creator(int number, int j){
        x = (int) (Math.random() * 500);
        y = (int) (Math.random() * 500);
        //Окружность
        if (number == 1) {
            r = (int) (Math.random() * 200);
            Figures.add(j, new TCircle(x, y, r, Color.BLACK));
        }
        //Эллипс
        if (number == 2) {
            w = (int) (Math.random() * 200);
            h = (int) (Math.random() * 100);
            Figures.add(j, new TEllipse(x, y, w, h, Color.BLACK));
        }
        //Четырехугольник
        if (number == 3) {
            x2 = (int) (Math.random() * 500);
            y2 = (int) (Math.random() * 500);
            x3 = (int) (Math.random() * 500);
            y3 = (int) (Math.random() * 500);
            x4 = (int) (Math.random() * 500);
            y4 = (int) (Math.random() * 500);
            Figures.add(j, new TQuadrangle(x, y, x2, y2, x3, y3, x4, y4, Color.BLACK));
        }
        //Прямоугольник
        if (number == 4) {
            w = 100 + (int) (Math.random() * 500);
            h = 100 + (int) (Math.random() * 250);
            Figures.add(j, new TRectangle(x, y, w, h, Color.BLACK));
        }
        //Ромб
        if (number == 5) {
            w = 100 + (int) (Math.random() * 500);
            h = 100 + (int) (Math.random() * 250);
            Figures.add(j, new TRomb(x, y, w, h, Color.BLACK));
        }
        //Трапециия
        if (number == 6) {
            w = 100 + (int) (Math.random() * 500);
            h = 100 + (int) (Math.random() * 250);
            c = 10 + (int) (Math.random() * 50);
            Figures.add(j, new TTrapeze(x, y, w, h, c, Color.BLACK));
        }
    }

    int GetCount() { return this.MassiveSize; }

    int GetIMass() { return this.indArray; }

    void SetIMass(int indArray) { this.indArray = indArray;}

    TFigure getFigureFromContMass(int indArray) { return Figures.get(indArray); }

}
