import javax.swing.*;
import java.awt.*;


    public class Canvas {

        //Кнопки и переменные
        private JFrame f = new JFrame("Лабораторная работа №1");

        private JButton ButBack = new JButton("Назад");
        private JButton ButLine = new JButton("Линия");
        private JButton ButCircle = new JButton("Окружность");
        private JButton ButRectangle = new JButton("Прямоугольник");
        private JButton ButTriangle = new JButton("Треугольник");
        private JButton ButRing = new JButton("Кольцо");
        private JButton ButCreate = new JButton("Создать");
        private JButton ButRemove = new JButton("Переместить");
        private JButton ButDelete = new JButton("Удалить");
        private JButton ButTurn = new JButton("Повернуть на 45");
        private JButton ButChangeRadius = new JButton("Изменить радиус");
        private JButton ButChangeSize = new JButton("Изменить размер");
        private JButton ButArray = new JButton("Массив");

        private JPanel CP = CenterPanel();
        private JPanel SP = SouthPanel();
        private Line line = null;
        private Line [] lines = null;
        private Circle circle = null;
        private Circle [] circles = null;
        private Rectangle rectangle = null;
        private Rectangle [] rectangles = null;
        private Triangle triangle = null;
        private Triangle [] triangles = null;
        private Ring ring = null;
        private Ring [] rings = null;
        private int ch1, ch2, ch3, ch4, ch5, ch6= 0;
        private String PressedBut;
        private boolean VISION = false, VISION2 = false, VISION3 = false, VISION4 = false, VISION5 = false;

        //Поле для рисования и панель с кнопками
        private Canvas() {
            f.setLayout(new BorderLayout());
            f.setSize(1280,680);
            f.add(CP, BorderLayout.CENTER);
            f.add(SP, BorderLayout.EAST);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setVisible(true);
        }
        private JPanel CenterPanel () {
            JPanel p = new JPanel();
            p.setLayout(new BorderLayout());
            p.setBackground(Color.white);
            return p;
        }


        private JPanel SouthPanel () {
            JPanel p = new JPanel();
            p.setLayout(new GridLayout(6, 1, 10, 10));
            p.setBackground(Color.BLUE);
            p.add(ButLine);
            p.add(ButCircle);
            p.add(ButRectangle);
            p.add(ButTriangle);
            p.add(ButRing);




            //"Back" button
            ButBack.addActionListener(e -> {
                if (PressedBut.equals("PressedLine") || PressedBut.equals("PressedCircle") || PressedBut.equals("PressedRectangle") || PressedBut.equals("PressedTriangle") || PressedBut.equals("PressedRing")) {
                    SP.removeAll();
                    SP.add(ButLine);
                    SP.add(ButCircle);
                    SP.add(ButRectangle);
                    SP.add(ButTriangle);
                    SP.add(ButRing);
                }
                if (PressedBut.equals("PressedArrayLines") || PressedBut.equals("PressedArrayCircles") || PressedBut.equals("PressedArrayRectangles") || PressedBut.equals("PressedArrayTriangles") || PressedBut.equals("PressedArrayRings")) {

                    if (PressedBut.equals("PressedArrayLines")) { SP.add(ButTurn); PressedBut = "PressedLine";}
                    if (PressedBut.equals("PressedArrayCircles")) { SP.add(ButChangeRadius); PressedBut = "PressedCircle";}
                    if (PressedBut.equals("PressedArrayRectangles")) { SP.add(ButChangeSize);PressedBut = "PressedRectangle";}
                    if (PressedBut.equals("PressedArrayTriangles")) { SP.add(ButChangeSize);PressedBut = "PressedTriangle";}
                    if (PressedBut.equals("PressedArrayRings")) { SP.add(ButChangeRadius); PressedBut = "PressedRing";}
                    SP.add(ButArray);
                }
                SP.revalidate();
                SP.repaint();
            });





            ButLine.addActionListener(e -> {
                SP.removeAll();
                SP.add(ButBack);
                SP.add(ButCreate);
                SP.add(ButRemove);
                SP.add(ButDelete);
                SP.add(ButTurn);
                SP.add(ButArray);
                SP.revalidate();
                SP.repaint();
                PressedBut = "PressedLine";
            });

            ButRing.addActionListener(e -> {
                SP.removeAll();
                SP.add(ButBack);
                SP.add(ButCreate);
                SP.add(ButRemove);
                SP.add(ButDelete);
                SP.add(ButChangeRadius);
                SP.add(ButArray);
                SP.revalidate();
                SP.repaint();
                PressedBut = "PressedRing";
            });

            ButCircle.addActionListener(e -> {
                SP.removeAll();
                SP.add(ButBack);
                SP.add(ButCreate);
                SP.add(ButRemove);
                SP.add(ButDelete);
                SP.add(ButChangeRadius);
                SP.add(ButArray);
                SP.revalidate();
                SP.repaint();
                PressedBut = "PressedCircle";
            });


            ButRectangle.addActionListener(e -> {
                SP.removeAll();
                SP.add(ButBack);
                SP.add(ButCreate);
                SP.add(ButRemove);
                SP.add(ButDelete);
                SP.add(ButChangeSize);
                SP.add(ButArray);
                SP.revalidate();
                SP.repaint();
                PressedBut = "PressedRectangle";
            });



            ButTriangle.addActionListener(e -> {
                SP.removeAll();
                SP.add(ButBack);
                SP.add(ButCreate);
                SP.add(ButRemove);
                SP.add(ButDelete);
                SP.add(ButChangeSize);
                SP.add(ButArray);
                SP.revalidate();
                SP.repaint();
                PressedBut = "PressedTriangle";
            });



            ButCreate.addActionListener(e -> {
                ch1 = (int) (Math.random() * 500);
                ch2 = (int) (Math.random() * 500);
                ch3 = (int) (Math.random() * 500);
                ch4 = (int) (Math.random() * 500);
                if (PressedBut.equals("PressedLine")) {
                    if (line == null) {
                        VISION = true;
                        line = new Line (ch1, ch2, ch3, ch4, Color.MAGENTA);
                        line.Show(VISION);
                        CP.add(line, BorderLayout.CENTER);
                        CP.revalidate();
                    }
                    else {
                        line.Show(false);
                        CP.remove(line);
                        ch1 = (int) (Math.random() * 500);
                        ch2 = (int) (Math.random() * 500);
                        ch3 = (int) (Math.random() * 500);
                        ch4 = (int) (Math.random() * 500);
                        line = new Line (ch1, ch2, ch3, ch4, Color.MAGENTA);
                        line.Show(VISION);
                        CP.add(line, BorderLayout.CENTER);
                        CP.revalidate();
                    }
                }


                else if (PressedBut.equals("PressedArrayLines")) {
                    if (lines == null) {
                        lines = new Line[5];
                        VISION = true;
                        for (int i=0; i<5; i++) {
                            ch1 = (int) (Math.random() * 500);
                            ch2 = (int) (Math.random() * 500);
                            ch3 = (int) (Math.random() * 500);
                            ch4 = (int) (Math.random() * 500);
                            lines[i] = new Line (ch1, ch2, ch3, ch4, Color.MAGENTA);
                            lines[i].Show(VISION);
                            CP.add(lines[i], BorderLayout.CENTER);
                            CP.validate();
                            CP.repaint();
                        }
                        CP.revalidate();
                    }
                    else {
                        for (int i=0; i<5; i++) {
                            lines[i].Show(false);
                            CP.remove(lines[i]);
                        }
                        for(int i=0; i<5; i++)
                        {
                            ch1 = (int) (Math.random() * 500);
                            ch2 = (int) (Math.random() * 500);
                            ch3 = (int) (Math.random() * 500);
                            ch4 = (int) (Math.random() * 500);
                            lines[i] = new Line (ch1, ch2, ch3, ch4, Color.MAGENTA);
                            lines[i].Show(VISION);
                            CP.add(lines[i], BorderLayout.CENTER);
                            CP.validate();
                            CP.repaint();
                        }

                    }
                }


                else if (PressedBut.equals("PressedRing")) {
                    if (ring == null) {
                        VISION5 = true;
                        ring = new Ring (ch1, ch2, ch3, Color.RED);
                        (ring).Show(VISION5);
                        CP.add(ring, BorderLayout.CENTER);
                        CP.revalidate();
                    } else {
                        ring.Show(false);
                        CP.remove(ring);
                        ch1 = (int) (Math.random() * 500);
                        ch2 = (int) (Math.random() * 500);
                        ch3 = (int) (Math.random() * 500);

                        ring= new Ring (ch1, ch2, ch3, Color.RED);
                        ring.Show(VISION5);
                        CP.add(ring, BorderLayout.CENTER);
                        CP.revalidate();
                    }
                }

                else if (PressedBut.equals("PressedArrayRings")) {
                    if (rings == null) {
                        rings = new Ring[5];
                        VISION5 = true;
                        for (int i=0; i<5; i++) {
                            ch1 = (int) (Math.random() * 500);
                            ch2 = (int) (Math.random() * 500);
                            ch3 = (int) (Math.random() * 500);
                            rings[i] = new Ring (ch1, ch2, ch3, Color.RED);
                            rings[i].Show(VISION5);
                            CP.add(rings[i], BorderLayout.CENTER);
                            CP.validate();
                            CP.repaint();
                        }
                        CP.revalidate();
                    }
                    else {
                        for (int i = 0; i < 5; i++) {
                            rings[i].Show(false);
                            CP.remove(rings[i]);
                        }
                        for (int i=0; i<5; i++) {
                            ch1 = (int) (Math.random() * 500);
                            ch2 = (int) (Math.random() * 500);
                            ch3 = (int) (Math.random() * 500);
                            rings[i] = new Ring (ch1, ch2, ch3, Color.RED);
                            rings[i].Show(VISION5);
                            CP.add(rings[i], BorderLayout.CENTER);
                            CP.validate();
                            CP.repaint();
                        }
                    }
                }

                else if (PressedBut.equals("PressedCircle")) {
                    if (circle == null) {
                        VISION2 = true;
                        circle = new Circle (ch1, ch2, ch3, Color.RED);
                        (circle).Show(VISION2);
                        CP.add(circle, BorderLayout.CENTER);
                        CP.revalidate();
                    } else {
                        circle.Show(false);
                        CP.remove(circle);
                        ch1 = (int) (Math.random() * 500);
                        ch2 = (int) (Math.random() * 500);
                        ch3 = (int) (Math.random() * 500);

                        circle = new Circle (ch1, ch2, ch3, Color.RED);
                        circle.Show(VISION2);
                        CP.add(circle, BorderLayout.CENTER);
                        CP.revalidate();
                    }
                }

                else if (PressedBut.equals("PressedArrayCircles")) {
                    if (circles == null) {
                        circles = new Circle[5];
                        VISION2 = true;
                        for (int i=0; i<5; i++) {
                            ch1 = (int) (Math.random() * 500);
                            ch2 = (int) (Math.random() * 500);
                            ch3 = (int) (Math.random() * 500);
                            circles[i] = new Circle (ch1, ch2, ch3, Color.RED);
                            circles[i].Show(VISION2);
                            CP.add(circles[i], BorderLayout.CENTER);
                            CP.validate();
                            CP.repaint();
                        }
                        CP.revalidate();
                    }
                    else {
                        for (int i = 0; i < 5; i++) {
                            circles[i].Show(false);
                        }
                        for (int i=0; i<5; i++) {
                            ch1 = (int) (Math.random() * 500);
                            ch2 = (int) (Math.random() * 500);
                            ch3 = (int) (Math.random() * 500);
                            circles[i] = new Circle (ch1, ch2, ch3, Color.RED);
                            circles[i].Show(VISION2);
                            CP.add(circles[i], BorderLayout.CENTER);
                            CP.validate();
                            CP.repaint();
                        }
                    }
                }

                else if (PressedBut.equals("PressedRectangle")) {
                    if (rectangle == null) {
                        VISION3 = true;
                        rectangle = new Rectangle (ch1, ch2, ch3, ch4, Color.BLUE);
                        (rectangle).Show(VISION3);
                        CP.add(rectangle, BorderLayout.CENTER);
                        CP.revalidate();
                    } else {
                        rectangle.Show(false);
                        CP.remove(rectangle);
                        rectangle = new Rectangle (ch1, ch2, ch3, ch4, Color.BLUE);
                        ( rectangle).Show(VISION3);
                        CP.add(rectangle, BorderLayout.CENTER);
                        CP.revalidate();
                    }
                }


                else if (PressedBut.equals("PressedArrayRectangles")) {
                    if (rectangles == null) {
                        rectangles = new Rectangle[5];
                        VISION3 = true;
                        for (int i=0; i<5; i++) {
                            ch1 = (int) (Math.random() * 500);
                            ch2 = (int) (Math.random() * 500);
                            ch3 = (int) (Math.random() * 500);
                            ch4 = (int) (Math.random() * 500);
                            rectangles[i] = new Rectangle (ch1, ch2, ch3, ch4, Color.BLUE);
                            rectangles[i].Show(VISION3);
                            CP.add(rectangles[i], BorderLayout.CENTER);
                            CP.validate();
                            CP.repaint();
                        }
                        CP.revalidate();
                    }
                    else {
                        for (int i=0; i<5; i++) {
                            rectangles[i].Show(false);
                            CP.remove(rectangles[i]);
                        }
                        for (int i=0; i<5; i++) {
                            ch1 = (int) (Math.random() * 500);
                            ch2 = (int) (Math.random() * 500);
                            ch3 = (int) (Math.random() * 500);
                            ch4 = (int) (Math.random() * 500);
                            rectangles[i] = new Rectangle(ch1, ch2, ch3, ch4, Color.BLUE);
                            rectangles[i].Show(VISION3);
                            CP.add(rectangles[i], BorderLayout.CENTER);
                            CP.validate();
                            CP.repaint();
                        }

                    }
                }


                else if (PressedBut.equals("PressedTriangle")) {
                    if (triangle == null) {
                        VISION4 = true;
                        triangle = new Triangle(ch1, ch2, ch3, ch4, ch5, ch6, Color.BLACK);
                        (triangle).Show(VISION4);
                        CP.add(triangle, BorderLayout.CENTER);
                        CP.revalidate();
                    } else {
                        triangle.Show(false);
                        CP.remove(triangle);

                        triangle = new Triangle(ch1, ch2, ch3, ch4, ch5, ch6,  Color.BLACK);
                        ( triangle).Show(VISION4);
                        CP.add(triangle, BorderLayout.CENTER);
                        CP.revalidate();

                    }
                }


                else if (PressedBut.equals("PressedArrayTriangles")) {
                    if (triangles == null) {
                        triangles = new Triangle[5];
                        VISION4 = true;
                        for (int i=0; i<5; i++) {
                            ch1 = (int) (Math.random() * 500);
                            ch2 = (int) (Math.random() * 500);
                            ch3 = (int) (Math.random() * 500);
                            ch4 = (int) (Math.random() * 500);
                            ch5 = (int) (Math.random() * 500);
                            ch6 = (int) (Math.random() * 500);
                            triangles[i] = new Triangle(ch1, ch2, ch3, ch4, ch5, ch6, Color.BLACK);
                            triangles[i].Show(VISION4);
                            CP.add(triangles[i], BorderLayout.CENTER);
                            CP.validate();
                            CP.repaint();
                        }
                        CP.revalidate();
                    }
                    else {
                        for (int i = 0; i < 5; i++)
                        {
                            triangles[i].Show(false);
                            CP.remove(triangles[i]);
                        }
                        for (int i=0; i<5; i++) {
                            ch1 = (int) (Math.random() * 500);
                            ch2 = (int) (Math.random() * 500);
                            ch3 = (int) (Math.random() * 500);
                            ch4 = (int) (Math.random() * 500);
                            ch5 = (int) (Math.random() * 500);
                            ch6 = (int) (Math.random() * 500);
                            triangles[i] = new Triangle(ch1, ch2, ch3, ch4, ch5, ch6, Color.BLACK);
                            triangles[i].Show(VISION4);
                            CP.add(triangles[i], BorderLayout.CENTER);
                            CP.validate();
                            CP.repaint();
                        }

                    }
                }
                ch1 = ch2 = ch3 = ch4 = ch5 = ch6= 0;
            });












            ButRemove.addActionListener(e -> {
                ch1 = -50 + (int) (Math.random() * 100);
                ch2 = -50 + (int) (Math.random() * 100);
                if (PressedBut.equals("PressedLine")) {
                    if (line != null) {
                        line.MoveTo(ch1, ch2);
                        line.Show(VISION);
                        CP.repaint();
                    }
                    else {
                        JOptionPane.showMessageDialog(f, "Линия не найдена");
                    }
                }







                else if (PressedBut.equals("PressedArrayLines")) {
                    if (lines != null) {
                        for (int i=0; i<5; i++) {
                            lines[i].MoveTo(ch1, ch2);
                            lines[i].Show(VISION);
                            CP.repaint();
                        }
                        CP.revalidate();
                    }
                    else {
                        JOptionPane.showMessageDialog(f, "Массив линий не найден");
                    }
                }






                else if (PressedBut.equals("PressedCircle")) {
                    if (circle != null) {
                        ( circle).MoveTo(ch1, ch2);
                        ( circle).Show(VISION2);
                        CP.repaint();
                    }
                    else {
                        JOptionPane.showMessageDialog(f, "Окружность не найдена");
                    }
                }







                else if (PressedBut.equals("PressedArrayCircles")) {
                    if (circles != null) {
                        for (int i=0; i<5; i++) {
                            circles[i].MoveTo(ch1, ch2);
                            circles[i].Show(VISION2);
                            CP.repaint();
                        }
                        CP.revalidate();
                    }
                    else {
                        JOptionPane.showMessageDialog(f, "Массив окружностей не найден");
                    }
                }


                else if (PressedBut.equals("PressedRing")) {
                    if (ring != null) {
                        ( ring).MoveTo(ch1, ch2);
                        ( ring).Show(VISION5);
                        CP.repaint();
                    }
                    else {
                        JOptionPane.showMessageDialog(f, "Кольцо не найдено");
                    }
                }







                else if (PressedBut.equals("PressedArrayRings")) {
                    if (rings != null) {
                        for (int i=0; i<5; i++) {
                            rings[i].MoveTo(ch1, ch2);
                            rings[i].Show(VISION5);
                            CP.repaint();
                        }
                        CP.revalidate();
                    }
                    else {
                        JOptionPane.showMessageDialog(f, "Массив колец не найден");
                    }
                }



                else if (PressedBut.equals("PressedRectangle")) {
                    if (rectangle != null) {
                        ( rectangle).MoveTo(ch1, ch2);
                        ( rectangle).Show(VISION3);
                        CP.repaint();
                    }
                    else {
                        JOptionPane.showMessageDialog(f, "Прямоугольник не найден");
                    }
                }






                else if (PressedBut.equals("PressedArrayRectangles")) {
                    if (rectangles != null) {
                        for (int i=0; i<5; i++) {
                            rectangles[i].MoveTo(ch1, ch2);
                            rectangles[i].Show(VISION3);
                            CP.repaint();
                        }
                        CP.revalidate();
                    }
                    else {
                        JOptionPane.showMessageDialog(f, "Массив Прямоугольников не найден");
                    }
                }






                else if (PressedBut.equals("PressedTriangle")) {
                    if (triangle != null) {
                        ( triangle).MoveTo(ch1, ch2);
                        ( triangle).Show(VISION4);
                        CP.repaint();
                        CP.revalidate();
                    }
                    else {
                        JOptionPane.showMessageDialog(f, "Треугольник не найден");
                    }
                }







                else if (PressedBut.equals("PressedArrayTriangles")) {
                    if (triangles != null) {
                        for (int i=0; i<5; i++) {
                            triangles[i].MoveTo(ch1, ch2);
                            triangles[i].Show(VISION3);
                            CP.repaint();
                        }
                        CP.revalidate();
                    }
                    else {
                        JOptionPane.showMessageDialog(f, "Массив Треугольников не найден");
                    }
                }
                ch1 = ch2 = 0;
            });









            ButDelete.addActionListener(e -> {
                if (PressedBut.equals("PressedLine")) {
                    if (line != null && VISION!=false) {
                        CP.remove(line);
                        (line).Show(false);
                        line = null;
                        CP.revalidate();
                        CP.repaint();
                    }
                    else {
                        JOptionPane.showMessageDialog(f, "Линия не найдена");
                    }
                }








                else if (PressedBut.equals("PressedArrayLines")) {
                    if (lines != null && VISION!=false) {
                        for (int i=0; i<5; i++) {
                            CP.remove(lines[i]);
                            lines[i].Show(false);
                        }
                        lines = null;
                        CP.revalidate();
                        CP.repaint();
                    }
                    else {
                        JOptionPane.showMessageDialog(f, "Массив линий не найден");
                    }
                }







                else if (PressedBut.equals("PressedRing")) {
                    if (ring != null && VISION5!=false) {
                        CP.remove(ring);
                        (ring).Show(false);
                        ring = null;
                        CP.revalidate();
                        CP.repaint();
                    }
                    else {
                        JOptionPane.showMessageDialog(f, "Кольцо не найдено");
                    }
                }


                else if (PressedBut.equals("PressedArrayRings")) {
                    if (rings != null && VISION5!=false) {
                        for (int i=0; i<5; i++) {
                            CP.remove(rings[i]);
                            rings[i].Show(false);
                        }
                        rings = null;
                        CP.revalidate();
                        CP.repaint();
                    }
                    else {
                        JOptionPane.showMessageDialog(f, "Массив колец не найден");
                    }
                }

                else if (PressedBut.equals("PressedCircle")) {
                    if (circle != null && VISION2!=false) {
                        CP.remove(circle);
                        (circle).Show(false);
                        circle = null;
                        CP.revalidate();
                        CP.repaint();
                    }
                    else {
                        JOptionPane.showMessageDialog(f, "Окружность не найдена");
                    }
                }








                else if (PressedBut.equals("PressedArrayCircles")) {
                    if (circles != null && VISION2!=false) {
                        for (int i=0; i<5; i++) {
                            CP.remove(circles[i]);
                            circles[i].Show(false);
                        }
                        circles = null;
                        CP.revalidate();
                        CP.repaint();
                    }
                    else {
                        JOptionPane.showMessageDialog(f, "Массив окружностей не найден");
                    }
                }








                else if (PressedBut.equals("PressedRectangle")) {
                    if (rectangle != null && VISION3!=false) {
                        CP.remove(rectangle);
                        ( rectangle).Show(false);
                        rectangle = null;
                        CP.revalidate();
                        CP.repaint();
                    }
                    else {
                        JOptionPane.showMessageDialog(f, "Прямоугольник не найден");
                    }
                }








                else if (PressedBut.equals("PressedArrayRectangles")) {
                    if (rectangles != null && VISION3!=false) {
                        for (int i=0; i<5; i++) {
                            CP.remove(rectangles[i]);
                            rectangles[i].Show(false);
                        }
                        rectangles = null;
                        CP.revalidate();
                        CP.repaint();
                    }
                    else {
                        JOptionPane.showMessageDialog(f, "Массив прямоугольников не найден");
                    }
                }









                else if (PressedBut.equals("PressedTriangle")) {
                    if (triangle != null && VISION4!=false) {
                        CP.remove(triangle);
                        ( triangle).Show(false);
                        triangle = null;
                        CP.revalidate();
                        CP.repaint();
                    }
                    else {
                        JOptionPane.showMessageDialog(f, "Треугольник не найден");
                    }
                }









                else if (PressedBut.equals("PressedArrayTriangles")) {
                    if (triangles != null && VISION4!=false) {
                        for (int i=0; i<5; i++) {
                            CP.remove(triangles[i]);
                            triangles[i].Show(false);
                        }
                        triangles = null;
                        CP.revalidate();
                        CP.repaint();
                    }
                    else {
                        JOptionPane.showMessageDialog(f, "Массив треугольников не найден");
                    }
                }
            });









            ButTurn.addActionListener(e -> {
                if (PressedBut.equals("PressedLine")){
                    if (line != null) {
                        ( line).Turn();
                        ( line).Show(VISION);
                        CP.revalidate();
                        CP.repaint();
                    } else {
                        JOptionPane.showMessageDialog(f, "Линия не найдена");
                    }
                }







                else if (PressedBut.equals("PressedArrayLines")) {
                    if (lines != null) {
                        for (int i = 0; i < 5; i++) {
                            lines[i].Turn();
                            lines[i].Show(VISION);
                        }
                        CP.revalidate();
                        CP.repaint();
                    } else {
                        JOptionPane.showMessageDialog(f, "Массив не создан");
                    }
                }
            });









            ButChangeRadius.addActionListener(e -> {
                if (PressedBut.equals("PressedCircle")) {
                    ch1 = 100 + (int) (Math.random() * 500);
                    if (circle != null) {
                        ( circle).chRad(ch1);
                        (circle).Show(VISION2);
                        ch1 = 0;
                        CP.revalidate();
                        CP.repaint();
                    } else {
                        JOptionPane.showMessageDialog(f, "Окружность не найдена");
                    }
                }




                else if (PressedBut.equals("PressedArrayCircles")) {
                    if (circles != null) {
                        for (int i = 0; i < 5; i++) {
                            ch1 = 100 + (int) (Math.random() * 500);
                            circles[i].chRad(ch1);
                            circles[i].Show(VISION2);
                        }
                        CP.revalidate();
                        CP.repaint();
                    } else {
                        JOptionPane.showMessageDialog(f, "Массив Окружностей не создан");
                    }
                }

                else if (PressedBut.equals("PressedRing")) {
                    ch1 = 100 + (int) (Math.random() * 500);
                    if (ring != null) {
                        ( ring).chRad(ch1);
                        (ring).Show(VISION5);
                        ch1 = 0;
                        CP.revalidate();
                        CP.repaint();
                    } else {
                        JOptionPane.showMessageDialog(f, "Кольцо не найдена");
                    }
                }




                else if (PressedBut.equals("PressedArrayRings")) {
                    if (rings != null) {
                        for (int i = 0; i < 5; i++) {
                            ch1 = 100 + (int) (Math.random() * 500);
                            rings[i].chRad(ch1);
                            rings[i].Show(VISION5);
                        }
                        CP.revalidate();
                        CP.repaint();
                    } else {
                        JOptionPane.showMessageDialog(f, "Массив колец не создан");
                    }
                }

            });









            ButChangeSize.addActionListener(e -> {
                ch1 = -100 + (int) (Math.random() * 500);
                ch2 = -100 + (int) (Math.random() * 500);
                if (PressedBut.equals("PressedRectangle")) {
                    if (rectangle != null) {
                        ( rectangle).chSize(ch1, ch2);
                        (rectangle).Show(VISION3);
                        CP.revalidate();
                        CP.repaint();
                    } else {
                        JOptionPane.showMessageDialog(f, "Прямоугольник не найден");
                    }
                }





                else if (PressedBut.equals("PressedArrayRectangles")) {
                    if (rectangles != null) {
                        for (int i = 0; i < 5; i++) {
                            rectangles[i].chSize(ch1, ch2);
                            rectangles[i].Show(VISION3);
                        }
                        CP.revalidate();
                        CP.repaint();
                    } else {
                        JOptionPane.showMessageDialog(f, "Массив прямоугольников не создан");
                    }
                }






                else if (PressedBut.equals("PressedTriangle")) {
                    if (triangle != null) {
                        ( triangle).chSize(ch1, ch2);
                        ( triangle).Show(VISION4);
                        CP.revalidate();
                        CP.repaint();
                    }
                    else {
                        JOptionPane.showMessageDialog(f, "Треугольник не найден");
                    }
                }







                else if (PressedBut.equals("PressedArrayTriangles")) {
                    if (triangles != null) {
                        for (int i = 0; i < 5; i++) {
                            triangles[i].chSize(ch1, ch2);
                            triangles[i].Show(VISION4);
                        }
                        CP.revalidate();
                        CP.repaint();
                    } else {
                        JOptionPane.showMessageDialog(f, "Массив треугольников не создан");
                    }
                }
                ch1 = ch2 = 0;
            });







            
            ButArray.addActionListener(e -> {
                SP.removeAll();
                SP.add(ButBack);
                SP.add(ButCreate);
                SP.add(ButRemove);
                SP.add(ButDelete);
                if (PressedBut.equals("PressedLine" )) {
                    SP.add(ButTurn); PressedBut = "PressedArrayLines";
                    JOptionPane.showMessageDialog(f, "Следующие действия будут выполнены для массива линий");
                }
                if (PressedBut.equals("PressedCircle" )) {
                    SP.add(ButChangeRadius); PressedBut = "PressedArrayCircles";
                    JOptionPane.showMessageDialog(f, "Следующие действия будут выполнены для массива окружностей");
                }
                if (PressedBut.equals("PressedRectangle" )) {
                    SP.add(ButChangeSize); PressedBut = "PressedArrayRectangles";
                    JOptionPane.showMessageDialog(f, "Следующие действия будут выполнены для массива прямоугольников");
                }
                if (PressedBut.equals("PressedTriangle" )) {
                    SP.add(ButChangeSize); PressedBut = "PressedArrayTriangles";
                    JOptionPane.showMessageDialog(f, "Следующие действия будут выполнены для массива треугольников");
                }
                if (PressedBut.equals("PressedRing" )) {
                    SP.add(ButChangeRadius); PressedBut = "PressedArrayRings";
                    JOptionPane.showMessageDialog(f, "Следующие действия будут выполнены для массива колец");
                }
                SP.revalidate();
                SP.repaint(); 
            });

            return p;
        }

        public static void main (String[] argc) {
            SwingUtilities.invokeLater(Canvas::new);
        }
    }