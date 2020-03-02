package com.company;

import java.awt.*;

class GraphicTimer {

    //координаты левого верхнего угла таймера
    private int x0;
    private int y0;

    //размер таймера в клетках
    private int size_x;
    private int size_y;

    //размер клетки таймера
    private int cell_size;

    //начальное значение таймера
    private int value;

    //текущее значение таймера
    private int counter;

    //шаг отсчета
    private int step;

    //цвет цифр
    private static Color color = new Color(0,255,0);

    GraphicTimer(int x0, int y0, int size_x, int size_y, int cell_size, int value, int step) {
        this.x0 = x0;
        this.y0 = y0;
        this.size_x = size_x;
        this.size_y = size_y;
        this.cell_size = cell_size;
        this.value = value;
        this.step = step;

        counter = value * 10;
    }

    //рисование таймера
    void paint(MainFrame mainFrame, Graphics g) {
        //рисование фона таймера
        g.setColor(mainFrame.getFrameColor());
        g.fillRect(x0, y0,size_x * cell_size + 1,size_y * cell_size + 1);

        /*g.setColor(new Color(255,255,255));
        //рисование горизонтальных линий таймера
        for(int i = 0; i <= size_y; i++) {
            g.drawLine(x0,y0 + i * cell_size,x0 + size_x * cell_size,y0 + i * cell_size);
        }
        //рисование вертикальных линий таймера
        for(int i = 0; i <= size_x; i++) {
            g.drawLine(x0 + i * cell_size, y0,x0 + i * cell_size,y0 + size_y * cell_size);
        }*/

        g.setColor(color);

        //рисование разделителя
        partDrawing(5,2, g);
        partDrawing(5,4, g);

        //рисование цифр
        numberDrawing(1,counter / 10, g);
        numberDrawing(2,counter % 10, g);
    }

    //рисование цифр
    private void numberDrawing(int digit, int number, Graphics g) {
        if(digit == 1) {
            switch(number) {
                case 0:
                    partDrawing(1,1, g);
                    partDrawing(2,1, g);
                    partDrawing(3,1, g);
                    partDrawing(1,2, g);
                    partDrawing(3,2, g);
                    partDrawing(1,3, g);
                    partDrawing(3,3, g);
                    partDrawing(1,4, g);
                    partDrawing(3,4, g);
                    partDrawing(1,5, g);
                    partDrawing(2,5, g);
                    partDrawing(3,5, g);
                    break;
                case 1:
                    partDrawing(1,1, g);
                    partDrawing(1,4, g);

                    partDrawing(2,1, g);
                    partDrawing(2,2, g);
                    partDrawing(2,3, g);
                    partDrawing(2,4, g);
                    partDrawing(2,5, g);

                    partDrawing(3,1, g);
                    break;
                case 2:
                    partDrawing(1,1, g);
                    partDrawing(2,1, g);
                    partDrawing(3,1, g);
                    partDrawing(1,2, g);
                    partDrawing(1,3, g);
                    partDrawing(2,3, g);
                    partDrawing(3,3, g);
                    partDrawing(3,4, g);
                    partDrawing(1,5, g);
                    partDrawing(2,5, g);
                    partDrawing(3,5, g);
                    break;
                case 3:
                    partDrawing(1,1, g);
                    partDrawing(2,1, g);
                    partDrawing(3,1, g);
                    partDrawing(3,2, g);
                    partDrawing(1,3, g);
                    partDrawing(2,3, g);
                    partDrawing(3,3, g);
                    partDrawing(3,4, g);
                    partDrawing(1,5, g);
                    partDrawing(2,5, g);
                    partDrawing(3,5, g);
                    break;
                case 4:
                    partDrawing(3,1, g);
                    partDrawing(3,2, g);
                    partDrawing(1,3, g);
                    partDrawing(2,3, g);
                    partDrawing(3,3, g);
                    partDrawing(1,4, g);
                    partDrawing(3,4, g);
                    partDrawing(1,5, g);
                    partDrawing(3,5, g);
                    break;
                case 5:
                    partDrawing(1,1, g);
                    partDrawing(2,1, g);
                    partDrawing(3,1, g);
                    partDrawing(3,2, g);
                    partDrawing(1,3, g);
                    partDrawing(2,3, g);
                    partDrawing(3,3, g);
                    partDrawing(1,4, g);
                    partDrawing(1,5, g);
                    partDrawing(2,5, g);
                    partDrawing(3,5, g);
                    break;
                case 6:
                    partDrawing(1,1, g);
                    partDrawing(2,1, g);
                    partDrawing(3,1, g);
                    partDrawing(1,2, g);
                    partDrawing(3,2, g);
                    partDrawing(1,3, g);
                    partDrawing(2,3, g);
                    partDrawing(3,3, g);
                    partDrawing(1,4, g);
                    partDrawing(1,5, g);
                    partDrawing(2,5, g);
                    partDrawing(3,5, g);
                    break;
                case 7:
                    partDrawing(3,1, g);
                    partDrawing(3,2, g);
                    partDrawing(3,3, g);
                    partDrawing(3,4, g);
                    partDrawing(1,5, g);
                    partDrawing(2,5, g);
                    partDrawing(3,5, g);
                    break;
                case 8:
                    partDrawing(1,1, g);
                    partDrawing(2,1, g);
                    partDrawing(3,1, g);
                    partDrawing(1,2, g);
                    partDrawing(3,2, g);
                    partDrawing(1,3, g);
                    partDrawing(2,3, g);
                    partDrawing(3,3, g);
                    partDrawing(1,4, g);
                    partDrawing(3,4, g);
                    partDrawing(1,5, g);
                    partDrawing(2,5, g);
                    partDrawing(3,5, g);
                    break;
                case 9:
                    partDrawing(1,1, g);
                    partDrawing(2,1, g);
                    partDrawing(3,1, g);
                    partDrawing(3,2, g);
                    partDrawing(1,3, g);
                    partDrawing(2,3, g);
                    partDrawing(3,3, g);
                    partDrawing(1,4, g);
                    partDrawing(3,4, g);
                    partDrawing(1,5, g);
                    partDrawing(2,5, g);
                    partDrawing(3,5, g);
                    break;
            }
        } else {
            int delta = 6;
            switch(number) {
                case 0:
                    partDrawing(1 + delta,1, g);
                    partDrawing(2 + delta,1, g);
                    partDrawing(3 + delta,1, g);
                    partDrawing(1 + delta,2, g);
                    partDrawing(3 + delta,2, g);
                    partDrawing(1 + delta,3, g);
                    partDrawing(3 + delta,3, g);
                    partDrawing(1 + delta,4, g);
                    partDrawing(3 + delta,4, g);
                    partDrawing(1 + delta,5, g);
                    partDrawing(2 + delta,5, g);
                    partDrawing(3 + delta,5, g);
                    break;
                case 1:
                    partDrawing(1 + delta,1, g);
                    partDrawing(1 + delta,4, g);

                    partDrawing(2 + delta,1, g);
                    partDrawing(2 + delta,2, g);
                    partDrawing(2 + delta,3, g);
                    partDrawing(2 + delta,4, g);
                    partDrawing(2 + delta,5, g);

                    partDrawing(3 + delta,1, g);
                    break;
                case 2:
                    partDrawing(1 + delta,1, g);
                    partDrawing(2 + delta,1, g);
                    partDrawing(3 + delta,1, g);
                    partDrawing(1 + delta,2, g);
                    partDrawing(1 + delta,3, g);
                    partDrawing(2 + delta,3, g);
                    partDrawing(3 + delta,3, g);
                    partDrawing(3 + delta,4, g);
                    partDrawing(1 + delta,5, g);
                    partDrawing(2 + delta,5, g);
                    partDrawing(3 + delta,5, g);
                    break;
                case 3:
                    partDrawing(1 + delta,1, g);
                    partDrawing(2 + delta,1, g);
                    partDrawing(3 + delta,1, g);
                    partDrawing(3 + delta,2, g);
                    partDrawing(1 + delta,3, g);
                    partDrawing(2 + delta,3, g);
                    partDrawing(3 + delta,3, g);
                    partDrawing(3 + delta,4, g);
                    partDrawing(1 + delta,5, g);
                    partDrawing(2 + delta,5, g);
                    partDrawing(3 + delta,5, g);
                    break;
                case 4:
                    partDrawing(3 + delta,1, g);
                    partDrawing(3 + delta,2, g);
                    partDrawing(1 + delta,3, g);
                    partDrawing(2 + delta,3, g);
                    partDrawing(3 + delta,3, g);
                    partDrawing(1 + delta,4, g);
                    partDrawing(3 + delta,4, g);
                    partDrawing(1 + delta,5, g);
                    partDrawing(3 + delta,5, g);
                    break;
                case 5:
                    partDrawing(1 + delta,1, g);
                    partDrawing(2 + delta,1, g);
                    partDrawing(3 + delta,1, g);
                    partDrawing(3 + delta,2, g);
                    partDrawing(1 + delta,3, g);
                    partDrawing(2 + delta,3, g);
                    partDrawing(3 + delta,3, g);
                    partDrawing(1 + delta,4, g);
                    partDrawing(1 + delta,5, g);
                    partDrawing(2 + delta,5, g);
                    partDrawing(3 + delta,5, g);
                    break;
                case 6:
                    partDrawing(1 + delta,1, g);
                    partDrawing(2 + delta,1, g);
                    partDrawing(3 + delta,1, g);
                    partDrawing(1 + delta,2, g);
                    partDrawing(3 + delta,2, g);
                    partDrawing(1 + delta,3, g);
                    partDrawing(2 + delta,3, g);
                    partDrawing(3 + delta,3, g);
                    partDrawing(1 + delta,4, g);
                    partDrawing(1 + delta,5, g);
                    partDrawing(2 + delta,5, g);
                    partDrawing(3 + delta,5, g);
                    break;
                case 7:
                    partDrawing(3 + delta,1, g);
                    partDrawing(3 + delta,2, g);
                    partDrawing(3 + delta,3, g);
                    partDrawing(3 + delta,4, g);
                    partDrawing(1 + delta,5, g);
                    partDrawing(2 + delta,5, g);
                    partDrawing(3 + delta,5, g);
                    break;
                case 8:
                    partDrawing(1 + delta,1, g);
                    partDrawing(2 + delta,1, g);
                    partDrawing(3 + delta,1, g);
                    partDrawing(1 + delta,2, g);
                    partDrawing(3 + delta,2, g);
                    partDrawing(1 + delta,3, g);
                    partDrawing(2 + delta,3, g);
                    partDrawing(3 + delta,3, g);
                    partDrawing(1 + delta,4, g);
                    partDrawing(3 + delta,4, g);
                    partDrawing(1 + delta,5, g);
                    partDrawing(2 + delta,5, g);
                    partDrawing(3 + delta,5, g);
                    break;
                case 9:
                    partDrawing(1 + delta,1, g);
                    partDrawing(2 + delta,1, g);
                    partDrawing(3 + delta,1, g);
                    partDrawing(3 + delta,2, g);
                    partDrawing(1 + delta,3, g);
                    partDrawing(2 + delta,3, g);
                    partDrawing(3 + delta,3, g);
                    partDrawing(1 + delta,4, g);
                    partDrawing(3 + delta,4, g);
                    partDrawing(1 + delta,5, g);
                    partDrawing(2 + delta,5, g);
                    partDrawing(3 + delta,5, g);
                    break;
            }
        }
    }

    //рисование частей цифр
    private void partDrawing(int part_location_x, int part_location_y, Graphics g) {
        int part_x = x0 + 1 + (part_location_x - 1) * cell_size;
        int part_y = y0 + 1 + (size_y - part_location_y) * cell_size;
        g.fillRect(part_x, part_y,cell_size - 1,cell_size - 1);
    }

    //получение шага отсчета
    int getStep() {
        return step;
    }

    //отсчет таймера
    void dec(MainFrame mainFrame, MainField mainField, AuxiliaryField auxiliaryField, Figure figure, GraphicTimer graphicTimer, Graphics g) {
        counter--;
        if(counter == 0) {
            counter = value * 10;
            figure.set(mainFrame, mainField, auxiliaryField, graphicTimer, g);
            mainField.layerDeletingChecking(mainFrame, figure, g);
            figure.launch(mainFrame, mainField, auxiliaryField, figure, g);
        }
        paint(mainFrame, g);
    }

    //перезапуск таймера
    void restart(MainFrame mainFrame, Graphics g) {
        counter = value * 10;
        paint(mainFrame, g);
    }
}