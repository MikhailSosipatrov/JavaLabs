import javax.swing.*;
import java.awt.*;

public class Canvas {

    private JFrame f = new JFrame("Лабораторная работа №3");

    private JButton ButBack = new JButton("Назад");
    private JButton ButCircles = new JButton("Окружности");
    private JButton ButQuadrilaterals = new JButton("Четырехугольники");
    private JButton ButCircle = new JButton("Окружность");
    private JButton ButEllipse = new JButton("Эллипс");
    private JButton ButQuadrilateral = new JButton("Четырехугольник");
    private JButton ButRectangular = new JButton("Прямоугольник");
    private JButton ButRhombus = new JButton("Ромб");
    private JButton ButTrapeze = new JButton("Трапециия");
    private JButton ButCreate = new JButton("Создать");
    private JButton ButRemove = new JButton("Переместить");
    private JButton ButDelete = new JButton("Удалить");
    private JButton ButChangeRadius = new JButton("Изменить радиус");
    private JButton ButRotate = new JButton("Повернуть на 90");
    private JButton ButChangeSize = new JButton("Изменить размер");
    private JButton ButArray = new JButton("Массив");

    private JPanel cP = centerPanel();
    private JPanel sP = southPanel();
    private JPanel circle = null;
    private TCircle [] circles = null;
    private JPanel ellipse = null;
    private JPanel quadrangle = null;
    private JPanel rectangle = null;
    private TRectangle [] rectangles = null;
    private JPanel rhombus = null;
    private JPanel trapeze = null;

    private int ch1, ch2, ch3, ch4, ch5, ch6, ch7, ch8 = 0;
    private String PressedFigureType, PressedFigure = ""; 
    private boolean VISION1 = true, VISION2 = true, VISION3 = true, VISION4 = true, VISION5 = true, VISION6 = true;

    private Canvas() {                                   //создаем основное окно
        f.setLayout(new BorderLayout());
        f.setSize(1280,680);
        f.add(cP, BorderLayout.CENTER);
        f.add(sP, BorderLayout.SOUTH);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    //панель с рисунками
    private JPanel centerPanel () {
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        p.setBackground(Color.white);
        return p;
    }

    //панель с кнопками
    private JPanel southPanel () {
        JPanel p = new JPanel();
        p.setLayout(new FlowLayout());
        p.setBackground(Color.GRAY);
        p.add(ButCircles);
        p.add(ButQuadrilaterals);

        //кнопка "Назад"
        ButBack.addActionListener(e -> {
            sP.removeAll();
            if (PressedFigureType.equals("PressedCirclesOrRectangles")) {
                sP.add(ButCircles);
                sP.add(ButQuadrilaterals);
                PressedFigureType = "NoFigureType";
            }
            if (PressedFigureType.equals("PressedCircles")) {
                sP.add(ButBack);
                sP.add(ButCircle);
                sP.add(ButEllipse);
                PressedFigureType = "PressedCirclesOrRectangles";
            }
            if (PressedFigureType.equals("PressedRectangles")) {
                sP.add(ButBack);
                sP.add(ButQuadrilateral);
                sP.add(ButRectangular);
                sP.add(ButRhombus);
                sP.add(ButTrapeze);
                PressedFigureType = "PressedCirclesOrRectangles";
            }
            /*if (numbut2 == 21) {
                sP.add(ButBack);
                sP.add(ButCreate);
                sP.add(ButRemove);
                sP.add(ButDelete);
                sP.add(ButChangeRadius);
                sP.add(ButArray);
                PressedFigure = "PressedCircle";
                PressedFigureType = "PressedCircles";
            }
            if (numbut2 == 24) {
                sP.add(ButBack);
                sP.add(ButCreate);
                sP.add(ButRemove);
                sP.add(ButDelete);
                sP.add(ButChangeSize);
                sP.add(ButArray);
                PressedFigure = "PressedRectangular";
                PressedFigureType = "PressedRectangles";
            }
            */

            sP.revalidate();
            sP.repaint();
        });
        //кнопка "Окружности"
        ButCircles.addActionListener(e -> {
            sP.removeAll();
            sP.add(ButBack);
            sP.add(ButCircle);
            sP.add(ButEllipse);
            PressedFigureType = "PressedCirclesOrRectangles";
            sP.revalidate();
            sP.repaint();
        });
        //кнопка "Четырехугольники"
        ButQuadrilaterals.addActionListener(e -> {
            sP.removeAll();
            sP.add(ButBack);
            sP.add(ButQuadrilateral);
            sP.add(ButRectangular);
            sP.add(ButRhombus);
            sP.add(ButTrapeze);
            PressedFigureType = "PressedCirclesOrRectangles";
            sP.revalidate();
            sP.repaint();
        });
        //кнопка "Окружность"
        ButCircle.addActionListener(e -> {
            sP.removeAll();
            sP.add(ButBack);
            sP.add(ButCreate);
            sP.add(ButRemove);
            sP.add(ButDelete);
            sP.add(ButChangeRadius);
            sP.add(ButArray);
            PressedFigure = "PressedCircle";
            PressedFigureType = "PressedCircles";
            sP.revalidate();
            sP.repaint();
        });
        //кнопка "Эллипс"
        ButEllipse.addActionListener(e -> {
            sP.removeAll();
            sP.add(ButBack);
            sP.add(ButCreate);
            sP.add(ButRemove);
            sP.add(ButDelete);
            sP.add(ButRotate);
            PressedFigure = "PressedEllipse";
            PressedFigureType = "PressedCircles";
            sP.revalidate();
            sP.repaint();
        });
        //кнопка "Четырехугольник"
        ButQuadrilateral.addActionListener(e -> {
            sP.removeAll();
            sP.add(ButBack);
            sP.add(ButCreate);
            sP.add(ButRemove);
            sP.add(ButDelete);
            sP.add(ButChangeSize);
            PressedFigure = "PressedQuadrilateral";
            PressedFigureType = "PressedRectangles";
            sP.revalidate();
            sP.repaint();
        });
        //кнопка "Прямоугольник"
        ButRectangular.addActionListener(e -> {
            sP.removeAll();
            sP.add(ButBack);
            sP.add(ButCreate);
            sP.add(ButRemove);
            sP.add(ButDelete);
            sP.add(ButChangeSize);
            sP.add(ButArray);
            PressedFigure = "PressedRectangular";
            PressedFigureType = "PressedRectangles";
            sP.revalidate();
            sP.repaint();
        });
        //кнопка "Ромб"
        ButRhombus.addActionListener(e -> {
            sP.removeAll();
            sP.add(ButBack);
            sP.add(ButCreate);
            sP.add(ButRemove);
            sP.add(ButDelete);
            sP.add(ButChangeSize);
            PressedFigure = "PressedRhombus";
            PressedFigureType = "PressedRectangles";
            sP.revalidate();
            sP.repaint();
        });
        //кнопка "Трапециия"
        ButTrapeze.addActionListener(e -> {
            sP.removeAll();
            sP.add(ButBack);
            sP.add(ButCreate);
            sP.add(ButRemove);
            sP.add(ButDelete);
            sP.add(ButChangeSize);
            PressedFigure = "PressedTrapeze";
            PressedFigureType = "PressedRectangles";
            sP.revalidate();
            sP.repaint();
        });

        /*кнопка "Массив"
        ButArray.addActionListener(e -> {
            sP.removeAll();
            sP.add(ButBack);
            sP.add(ButCreate);
            sP.add(ButRemove);
            sP.add(ButDelete);

            if (PressedFigure.equals("PressedCircle")) {
                sP.add(ButChangeRadius); numbut = 11; numbut2 = 21;
                JOptionPane.showMessageDialog(f, "Следующие действия будут выполнены для массива окружностей");
            }
            if (PressedFigure.equals("PressedRectangle")) {
                sP.add(ButChangeSize); numbut = 14; numbut2 = 24;
                JOptionPane.showMessageDialog(f, "Следующие действия будут выполнены для массива прямоугольников");
            }
            sP.revalidate();
            sP.repaint();
        });
        */


        //кнопка "Создать"
        ButCreate.addActionListener(e -> {
            if (PressedFigure.equals("PressedCircle")) {
                if (circle == null) {
                    ch1 = (int) (Math.random() * 500);
                    ch2 = (int) (Math.random() * 300);
                    ch3 = (int) (Math.random() * 200);
                    VISION1 = true;
                    circle = new TCircle(ch1, ch2, ch3, Color.BLACK);
                    ((TCircle) circle).Show(VISION1);
                    cP.add(circle, BorderLayout.CENTER);
                    cP.revalidate();
                } else {
                    JOptionPane.showMessageDialog(f, "Окружность уже нарисована");
                }
            }
            /*else if (numbut == 11) {
                if (circles == null) {
                    circles = new TCircle[10];
                    VISION2 = true;
                    for (int i=0; i<10; i++) {
                        ch1 = (int) (Math.random() * 300);
                        ch2 = (int) (Math.random() * 300);
                        ch3 = (int) (Math.random() * 300);
                        circles[i] = new TCircle (ch1, ch2, ch3, Color.GREEN);
                        System.out.println("Circle №" + (i+1) + " координаты центра:: " + ch1 +", "+ ch2 +", диаметр:"+ ch3);
                        circles[i].Show(VISION2);
                        cP.add(circles[i], BorderLayout.CENTER);
                        cP.validate();
                        cP.repaint();
                    }
                    cP.revalidate();
                }
                else {
                    JOptionPane.showMessageDialog(f, "Массив Окружностей уже создан");
                }
            }
             */
            else if (PressedFigure.equals("PressedEllipse")) {
                if (ellipse == null) {
                    ch1 = (int) (Math.random() * 500);
                    ch2 = (int) (Math.random() * 300);
                    ch3 = (int) (Math.random() * 200);
                    ch4 = (int) (Math.random() * 100);
                    VISION2 = true;
                    ellipse = new TEllipse(ch1, ch2, ch3, ch4, Color.RED);
                    ((TEllipse) ellipse).Show(VISION2);
                    cP.add(ellipse, BorderLayout.CENTER);
                    cP.revalidate();
                } else {
                    JOptionPane.showMessageDialog(f, "Эллипс уже нарисован");
                }
            }
            else if (PressedFigure.equals("PressedQuadrangle")) {
                if (quadrangle == null) {
                    ch1 = (int) (Math.random() * 500);
                    ch2 = (int) (Math.random() * 500);
                    ch3 = (int) (Math.random() * 500);
                    ch4 = (int) (Math.random() * 500);
                    ch5 = (int) (Math.random() * 500);
                    ch6 = (int) (Math.random() * 500);
                    ch7 = (int) (Math.random() * 500);
                    ch8 = (int) (Math.random() * 500);
                    VISION3 = true;
                    quadrangle = new TQuadrangle(ch1,ch2,ch3,ch4,ch5,ch6,ch7,ch8, Color.BLACK);
                    ((TQuadrangle) quadrangle).Show(VISION3);
                    cP.add(quadrangle, BorderLayout.CENTER);
                    cP.revalidate();
                }
                else {
                    JOptionPane.showMessageDialog(f, "Четырехугольник уже нарисован");
                }
            }
            else if (PressedFigure.equals("PressedRectangle")) {
                if (rectangle == null) {
                    ch1 = (int) (Math.random() * 500);
                    ch2 = (int) (Math.random() * 500);
                    ch3 = 100 + (int) (Math.random() * 500);
                    ch4 = 100 + (int) (Math.random() * 250);
                    VISION4 = true;
                    rectangle = new TRectangle(ch1, ch2, ch3, ch4, Color.BLUE);
                    ((TRectangle) rectangle).Show(VISION4);
                    cP.add(rectangle, BorderLayout.CENTER);
                    cP.revalidate();
                } else {
                    JOptionPane.showMessageDialog(f, "Прямоугольник уже нарисован");
                }
            }
            else if (numbut == 14) {
                if (rectangles == null) {
                    rectangles = new TRectangle[10];
                    VISION3 = true;
                    for (int i=0; i<10; i++) {
                        ch1 = (int) (Math.random() * 300);
                        ch2 = (int) (Math.random() * 300);
                        ch3 = (int) (Math.random() * 300);
                        ch4 = (int) (Math.random() * 300);
                        rectangles[i] = new TRectangle (ch1, ch2, ch3, ch4, Color.RED);
                        System.out.println("Rectangle №" + (i+1));
                        rectangles[i].Show(VISION3);
                        cP.add(rectangles[i], BorderLayout.CENTER);
                        cP.validate();
                        cP.repaint();
                    }
                    cP.revalidate();
                }
            }
            else if (PressedFigure.equals("PressedRhombus")) {
                if (rhombus == null) {
                    ch1 = (int) (Math.random() * 500);
                    ch2 = (int) (Math.random() * 500);
                    ch3 = 100 + (int) (Math.random() * 500);
                    ch4 = 100 + (int) (Math.random() * 250);
                    VISION5 = true;
                    rhombus = new TRomb(ch1, ch2, ch3, ch4, Color.CYAN);
                    ((TRomb) rhombus).Show(VISION5);
                    cP.add(rhombus, BorderLayout.CENTER);
                    cP.revalidate();
                }
                else {
                    JOptionPane.showMessageDialog(f, "Ромб уже нарисован");
                }
            }
            else if (PressedFigure.equals("PressedTrapeze")) {
                if (trapeze == null) {
                    ch1 = (int) (Math.random() * 500);
                    ch2 = (int) (Math.random() * 500);
                    ch3 = 100 + (int) (Math.random() * 500);
                    ch4 = 100 + (int) (Math.random() * 250);
                    ch5 = 10 + (int) (Math.random() * 50);
                    VISION6 = true;
                    trapeze = new TTrapeze(ch1, ch2, ch3, ch4, ch5, Color.GREEN);
                    ((TTrapeze) trapeze).Show(VISION6);
                    cP.add(trapeze, BorderLayout.CENTER);
                    cP.revalidate();
                }
                else {
                    JOptionPane.showMessageDialog(f, "Трапеция уже нарисована");
                }
            }
            ch1 = ch2 = ch3 = ch4 = ch5 = ch6 = ch7 = ch8 = 0;
        });
        //кнопка "Переместить"
        ButRemove.addActionListener(e -> {
            ch1 = -30 + (int) (Math.random() * 100);
            ch2 = -30 + (int) (Math.random() * 100);
            if (PressedFigure.equals("PressedCircle")) {
                if (circle != null) {
                    ((TCircle) circle).MoveTo(ch1, ch2);
                    cP.add(circle, BorderLayout.CENTER);
                    cP.revalidate();
                    cP.repaint();
                }
                else {
                    JOptionPane.showMessageDialog(f, "Окружность не найдена");
                }
            }
            else if (numbut == 11) {
                if (circles != null) {
                    for (int i=0; i<10; i++) {
                        circles[i].MoveTo(ch1, ch2);
                        circles[i].Show(VISION2);
                        cP.repaint();
                        System.out.println("перемещение Окружности №" + (i+1));
                    }
                    cP.revalidate();
                }
                else {
                    JOptionPane.showMessageDialog(f, "Массив окружностей не найден");
                }
            }
            else if (PressedFigure.equals("PressedEllipse")) {
                if (ellipse  != null) {
                    ((TEllipse) ellipse ).MoveTo(ch1, ch2);
                    cP.add(ellipse , BorderLayout.CENTER);
                    cP.repaint();
                }
                else {
                    JOptionPane.showMessageDialog(f, "Эллипс не найден");
                }
            }
            else if (PressedFigure.equals("PressedQuadrangle")) {
                if (quadrangle != null) {
                    ((TQuadrangle) quadrangle).MoveTo(ch1,ch2);
                    cP.add(quadrangle, BorderLayout.CENTER);
                    cP.revalidate();
                }
                else {
                    JOptionPane.showMessageDialog(f, "Четырехугольник не найден");
                }
            }
            else if (PressedFigure.equals("PressedRectangle")) {
                if (rectangle != null) {
                    ((TRectangle) rectangle).MoveTo(ch1, ch2);
                    cP.add(rectangle, BorderLayout.CENTER);
                    cP.repaint();
                }
                else {
                    JOptionPane.showMessageDialog(f, "Прямоугольник не найден");
                }
            }
            else if (numbut == 14) {
                if (rectangles != null) {
                    for (int i=0; i<10; i++) {
                        rectangles[i].MoveTo(ch1, ch2);
                        rectangles[i].Show(VISION3);
                        cP.repaint();
                        System.out.println("перемещение Прямоугольника №" + (i+1));
                    }
                    cP.revalidate();
                }
                else {
                    JOptionPane.showMessageDialog(f, "Массив Прямоугольников не найден");
                }
            }
            else if (PressedFigure.equals("PressedRhombus")) {
                if (rhombus != null) {
                    ((TRomb) rhombus).MoveTo(ch1,ch2);
                    cP.add(rhombus, BorderLayout.CENTER);
                    cP.repaint();
                }
                else {
                    JOptionPane.showMessageDialog(f, "Ромб не найден");
                }
            }
            else if (PressedFigure.equals("PressedTrapeze")) {
                if (trapeze != null) {
                    ((TTrapeze) trapeze).MoveTo(ch1,ch2);
                    cP.add(trapeze, BorderLayout.CENTER);
                    cP.repaint();
                }
                else {
                    JOptionPane.showMessageDialog(f, "Трапеция не найдена");
                }
            }
            ch1 = ch2 = 0;
        });
        //кнопка "Удалить"
        ButDelete.addActionListener(e -> {
            if (PressedFigure.equals("PressedCircle")) {
                if (circle != null) {
                    cP.remove(circle);
                    ((TCircle) circle).Show(false);
                    circle = null;
                    cP.revalidate();
                    cP.repaint();
                }
                else {
                    JOptionPane.showMessageDialog(f, "Окружность не найдена");
                }
            }
            else if (numbut == 11) {
                if (circles != null) {
                    for (int i=0; i<10; i++) {
                        cP.remove(circles[i]);
                        circles[i].Show(false);
                    }
                    circles = null;
                    cP.revalidate();
                    cP.repaint();
                }
                else {
                    JOptionPane.showMessageDialog(f, "Массив Окружностей не найден");
                }
            }
            else if (PressedFigure.equals("PressedEllipse")) {
                if (ellipse  != null) {
                    cP.remove(ellipse);
                    ((TEllipse) ellipse ).Show(false);
                    ellipse  = null;
                    cP.revalidate();
                    cP.repaint();
                }
                else {
                    JOptionPane.showMessageDialog(f, "Эллипс не найден");
                }
            }
            else if (PressedFigure.equals("PressedQuadrangle")) {
                if (quadrangle != null) {
                    cP.remove(quadrangle);
                    ((TQuadrangle) quadrangle).Show(false);
                    quadrangle = null;
                    cP.revalidate();
                    cP.repaint();
                }
                else {
                    JOptionPane.showMessageDialog(f, "Четырехугольник не найден");
                }
            }
            else if (PressedFigure.equals("PressedRectangle")) {
                if (rectangle != null) {
                    cP.remove(rectangle);
                    ((TRectangle) rectangle).Show(false);
                    rectangle = null;
                    cP.revalidate();
                    cP.repaint();
                }
                else {
                    JOptionPane.showMessageDialog(f, "Прямоугольник не найден");
                }
            }
            else if (numbut == 14) {
                if (rectangles != null) {
                    for (int i=0; i<10; i++) {
                        cP.remove(rectangles[i]);
                        rectangles[i].Show(false);
                    }
                    rectangles = null;
                    cP.revalidate();
                    cP.repaint();
                }
                else {
                    JOptionPane.showMessageDialog(f, "Массив Прямоугольников не найден");
                }
            }
            else if (PressedFigure.equals("PressedRhombus")) {
                if (rhombus != null) {
                    cP.remove(rhombus);
                    ((TRomb) rhombus).Show(false);
                    rhombus = null;
                    cP.revalidate();
                    cP.repaint();
                }
                else {
                    JOptionPane.showMessageDialog(f, "Ромб не найден");
                }
            }
            else if (PressedFigure.equals("PressedTrapeze")) {
                if (trapeze != null) {
                    cP.remove(trapeze);
                    ((TTrapeze) trapeze).Show(false);
                    trapeze = null;
                    cP.revalidate();
                    cP.repaint();
                }
                else {
                    JOptionPane.showMessageDialog(f, "Трапеция не найдена");
                }
            }
        });
       

        //кнопка "Изменить радиус"
        ButChangeRadius.addActionListener(e -> {
            if (PressedFigure.equals("PressedCircle")) {
                ch1 = 50 + (int) (Math.random() * 150);
                if (circle != null) {
                    ((TCircle) circle).chRad(ch1);
                    ((TCircle) circle).Show(VISION1);
                    cP.add(circle, BorderLayout.CENTER);
                    cP.revalidate();
                    cP.repaint();
                } else {
                    JOptionPane.showMessageDialog(f, "Окружность не найдена");
                }
            }
            else if (numbut == 11) {
                if (circles != null) {
                    for (int i = 0; i < 10; i++) {
                        ch1 = 50 + (int) (Math.random() * 150);
                        circles[i].chRad(ch1);
                        circles[i].Show(VISION2);
                    }
                    cP.revalidate();
                    cP.repaint();
                } else {
                    JOptionPane.showMessageDialog(f, "Массив Окружностей не создан");
                }
            }
            ch1 = 0;
        });
        //кнопка "Повернуть на 90"
        ButRotate.addActionListener(e -> {
            if (ellipse  != null) {
                ((TEllipse) ellipse ).Turn();
                ((TEllipse) ellipse ).Show(VISION2);
                cP.add(ellipse , BorderLayout.CENTER);
                cP.revalidate();
                cP.repaint();
            } else {
                JOptionPane.showMessageDialog(f, "Эллипс не найден");
            }
        });
        //кнопка "Изменить размер"
        ButChangeSize.addActionListener(e -> {
            ch1 = -25 + (int) (Math.random() * 50);
            ch2 = -25 + (int) (Math.random() * 50);
            if (PressedFigure.equals("PressedQuadrangle")) {
                if (quadrangle != null) {
                    ((TQuadrangle) quadrangle).chSize(ch1,ch2);
                    ((TQuadrangle) quadrangle).Show(VISION3);
                    cP.add(quadrangle, BorderLayout.CENTER);
                    cP.revalidate();
                    cP.repaint();
                } else {
                    JOptionPane.showMessageDialog(f, "Четырехугольник не найден");
                }
            }
            else if (PressedFigure.equals("PressedRectangle")) {
                if (rectangle != null) {
                    ((TRectangle) rectangle).chSize(ch1, ch2);
                    ((TRectangle) rectangle).Show(VISION4);
                    cP.add(rectangle, BorderLayout.CENTER);
                    cP.revalidate();
                    cP.repaint();
                } else {
                    JOptionPane.showMessageDialog(f, "Прямоугольник не найден");
                }
            }
            else if (numbut == 14) {
                if (rectangles != null) {
                    for (int i = 0; i < 10; i++) {
                        rectangles[i].chSize(ch1, ch2);
                        rectangles[i].Show(VISION3);
                    }
                    cP.revalidate();
                    cP.repaint();
                } else {
                    JOptionPane.showMessageDialog(f, "Массив Окружностей не создан");
                }
            }
            else if (PressedFigure.equals("PressedRhombus")) {
                if (rhombus != null) {
                    ((TRomb) rhombus).chSize(ch1, ch2);
                    ((TRomb) rhombus).Show(VISION5);
                    cP.add(rhombus, BorderLayout.CENTER);
                    cP.revalidate();
                    cP.repaint();
                }
                else {
                    JOptionPane.showMessageDialog(f, "Ромб не найден");
                }
            }
            else if (PressedFigure.equals("PressedTrapeze")) {
                if (trapeze != null) {
                    ((TTrapeze) trapeze).chSize(ch1, ch2);
                    ((TTrapeze) trapeze).Show(VISION6);
                    cP.add(trapeze, BorderLayout.CENTER);
                    cP.revalidate();
                    cP.repaint();
                }
                else {
                    JOptionPane.showMessageDialog(f, "Трапеция не найдена");
                }
            }
            ch1 = ch2 = 0;
        });

        return p;
    }

    public static void main (String[] argc) {
        SwingUtilities.invokeLater(Canvas::new);
    }
}
