package com.company;

import java.awt.*;

class AuxiliaryField {

    //координаты левого верхнего угла поля
    int x0;
    int y0;

    //размер поля в клетках
    int size_x;
    int size_y;

    //размер клетки поля
    int cellSize;

    //массив поля
    int[][] fieldArray;

    //цвет поля
    Color fieldColor = new Color(0,0,139);
    //цвет сетки поля
    Color gridColor = new Color(0,0,175);

    AuxiliaryField(int x0, int y0, int size_x, int size_y, int cellSize) {
        this.x0 = x0;
        this.y0 = y0;
        this.size_x = size_x;
        this.size_y = size_y;
        this.cellSize = cellSize;

        fieldArray = new int[size_x][size_y];

        //заполнение массива поля
        for(int i = 0; i <= size_x - 1; i++) {
            for(int j = 0; j <= size_y - 1; j++) {
                fieldArray[i][j] = 0;
            }
        }
    }

    //рисование поля
    void paint(Graphics g) {
        //рисование фона поля
        g.setColor(fieldColor);
        g.fillRect(x0, y0,size_x * cellSize + 1,size_y * cellSize + 1);

        g.setColor(gridColor);
        //рисование горизонтальных линий поля
        for(int i = 0; i <= size_y; i++) {
            g.drawLine(x0,y0 + i * cellSize,x0 + size_x * cellSize,y0 + i * cellSize);
        }
        //рисование вертикальных линий поля
        for(int i = 0; i <= size_x; i++) {
            g.drawLine(x0 + i * cellSize, y0,x0 + i * cellSize,y0 + size_y * cellSize);
        }
    }

    //рисование фигуры
    void figuresDrawing(Figure figure, Graphics g) {
        //вспомогательные переменные
        int x;
        int y;

        for(int i = 0; i <= size_x - 1; i++) {
            for(int j = 0; j <= size_y - 1; j++) {
                if(fieldArray[i][j] != 0) {
                    x = x0 + 1 + i * cellSize;
                    y = y0 + 1 + (size_y - j - 1) * cellSize;
                    switch(fieldArray[i][j]) {
                        case 1:
                            g.setColor(figure.getColor1());
                            g.fillRect(x, y,cellSize - 1,cellSize - 1);
                            break;
                        case 2:
                            g.setColor(figure.getColor2());
                            g.fillRect(x, y,cellSize - 1,cellSize - 1);
                            break;
                        case 3:
                            g.setColor(figure.getColor3());
                            g.fillRect(x, y,cellSize - 1,cellSize - 1);
                            break;
                        case 4:
                            g.setColor(figure.getColor4());
                            g.fillRect(x, y,cellSize - 1,cellSize - 1);
                            break;
                        case 5:
                            g.setColor(figure.getColor5());
                            g.fillRect(x, y,cellSize - 1,cellSize - 1);
                            break;
                        case 6:
                            g.setColor(figure.getColor6());
                            g.fillRect(x, y,cellSize - 1,cellSize - 1);
                            break;
                        case 7:
                            g.setColor(figure.getColor7());
                            g.fillRect(x, y,cellSize - 1,cellSize - 1);
                            break;
                        case 8:
                            g.setColor(figure.getColor8());
                            g.fillRect(x, y,cellSize - 1,cellSize - 1);
                            break;
                    }
                }
            }
        }
    }

    //установка элемента массива поля
    void setFieldArray(int i, int j, int figureNumber) {
        fieldArray[i][j] = figureNumber;
    }

    //получение размера поля в клетках
    int getSize_x() {
        return size_x;
    }

    //получение размера поля в клетках
    int getSize_y() {
        return size_y;
    }
}