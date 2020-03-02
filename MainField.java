package com.company;

import java.awt.*;

class MainField extends AuxiliaryField {

    MainField(int x0, int y0, int size_x, int size_y, int cellSize) {
        super(x0, y0, size_x, size_y, cellSize);
    }

    //рисование поля
    @Override
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

        //рисование центра
        /*g.setColor(new Color(255,255,255));
        //рисование горизонтальных линий центра
        for(int i = 6; i <= 10; i++) {
            g.drawLine(x0 + 6 * cellSize,y0 + i * cellSize,x0 + 10 * cellSize,y0 + i * cellSize);
        }
        //рисование вертикальных линий центра
        for(int i = 6; i <= 10; i++) {
            g.drawLine(x0 + i * cellSize,y0 + 6 * cellSize,x0 + i * cellSize,y0 + 10 * cellSize);
        }*/
    }

    //проверка удаления слоя
    void layerDeletingChecking(MainFrame mainFrame, Figure figure, Graphics g) {
        //число одновременно удаленных слоев
        int deletedLayers = 0;

        //подсчет занятых клеток в 7-ом слое
        if(layerSettedCellsCalculation(7) == 12) {
            layerSettedCellsDeleting(figure,7, g);
            settedCellsMoving(figure,7, g);
            deletedLayers++;
        }

        //подсчет занятых клеток в 6-ом слое
        if(layerSettedCellsCalculation(6) == 20) {
            layerSettedCellsDeleting(figure,6, g);
            settedCellsMoving(figure,6, g);
            deletedLayers++;
        }

        //подсчет занятых клеток в 5-ом слое
        if(layerSettedCellsCalculation(5) == 28) {
            layerSettedCellsDeleting(figure,5, g);
            settedCellsMoving(figure,5, g);
            deletedLayers++;
        }

        //подсчет занятых клеток в 4-ом слое
        if(layerSettedCellsCalculation(4) == 36) {
            layerSettedCellsDeleting(figure,4, g);
            settedCellsMoving(figure,4, g);
            deletedLayers++;
        }

        //подсчет занятых клеток в 3-ем слое
        if(layerSettedCellsCalculation(3) == 44) {
            layerSettedCellsDeleting(figure,3, g);
            settedCellsMoving(figure,3, g);
            deletedLayers++;
        }

        //подсчет занятых клеток во 2-ом слое
        if(layerSettedCellsCalculation(2) == 52) {
            layerSettedCellsDeleting(figure,2, g);
            settedCellsMoving(figure,2, g);
            deletedLayers++;
        }

        //подсчет занятых клеток в 1-ом слое
        if(layerSettedCellsCalculation(1) == 60) {
            layerSettedCellsDeleting(figure,1, g);
            settedCellsMoving(figure,1, g);
            deletedLayers++;
        }

        switch(deletedLayers) {
            case 1:
                mainFrame.pointsIncrease(100);
                break;
            case 2:
                mainFrame.pointsIncrease(400);
                break;
            case 3:
                mainFrame.pointsIncrease(900);
                break;
            case 4:
                mainFrame.pointsIncrease(1600);
                break;
        }

        mainFrame.levelIncreasingChecking();
    }

    //подсчет занятых клеток слоя
    private int layerSettedCellsCalculation(int layer) {
        //число занятых клеток слоя
        int layerSettedCells = 0;

        //подсчет занятых клеток в слое
        //нижний ряд
        for(int i = layer - 1; i <= size_x - layer; i++) {
            if(fieldArray[i][layer - 1] != 0) layerSettedCells++;
        }
        //верхний ряд
        for(int i = layer - 1; i <= size_x - layer; i++) {
            if(fieldArray[i][size_y - layer] != 0) layerSettedCells++;
        }
        //левый ряд
        for(int j = layer; j <= size_y - layer - 1; j++) {
            if(fieldArray[layer - 1][j] != 0) layerSettedCells++;
        }
        //правый ряд
        for(int j = layer; j <= size_y - layer - 1; j++) {
            if(fieldArray[size_x - layer][j] != 0) layerSettedCells++;
        }

        return layerSettedCells;
    }

    //удаление занятых клеток слоя
    private void layerSettedCellsDeleting(Figure figure, int layer, Graphics g) {
        //вспомогательные переменные
        int part_x;
        int part_y;

        //установка цвета поля
        g.setColor(fieldColor);

        //удаление нижнего ряда
        for(int i = layer - 1; i <= size_x - layer; i++) {
            fieldArray[i][layer - 1] = 0;
            part_x = figure.getPart_x0() + i * cellSize;
            part_y = figure.getPart_y0() + (size_y - (layer - 1 + 1)) * cellSize;
            g.fillRect(part_x, part_y,cellSize - 1,cellSize - 1);
        }

        //удаление верхнего ряда
        for(int i = layer - 1; i <= size_x - layer; i++) {
            fieldArray[i][size_y - layer] = 0;
            part_x = figure.getPart_x0() + i * cellSize;
            part_y = figure.getPart_y0() + (size_y - (size_y - layer + 1)) * cellSize;
            g.fillRect(part_x, part_y,cellSize - 1,cellSize - 1);
        }

        //удаление левого ряда
        for(int j = layer; j <= size_y - layer - 1; j++) {
            fieldArray[layer - 1][j] = 0;
            part_x = figure.getPart_x0() + (layer - 1) * cellSize;
            part_y = figure.getPart_y0() + (size_y - (j + 1)) * cellSize;
            g.fillRect(part_x, part_y,cellSize - 1,cellSize - 1);
        }

        //удаление правого ряда
        for(int j = layer; j <= size_y - layer - 1; j++) {
            fieldArray[size_x - layer][j] = 0;
            part_x = figure.getPart_x0() + (size_x - layer) * cellSize;
            part_y = figure.getPart_y0() + (size_y - (j + 1)) * cellSize;
            g.fillRect(part_x, part_y,cellSize - 1,cellSize - 1);
        }
    }

    //перемещение занятых клеток
    private void settedCellsMoving(Figure figure, int layer, Graphics g) {
        //вспомогательные переменные
        int part_x;
        int part_y;

        //перемещение частей фигур левой нижней части поля
        for(int i = layer; i <= size_x / 2 - 1; i++) {
            for(int j = layer; j <= size_y / 2 - 1; j++) {
                if(fieldArray[i][j] != 0) {
                    fieldArray[i - 1][j - 1] = fieldArray[i][j];
                    fieldArray[i][j] = 0;
                    part_x = figure.getPart_x0() + i * cellSize;
                    part_y = figure.getPart_y0() + (size_y - j - 1) * cellSize;
                    g.setColor(fieldColor);
                    g.fillRect(part_x, part_y,cellSize - 1,cellSize - 1);
                    part_x = figure.getPart_x0() + (i - 1) * cellSize;
                    part_y = figure.getPart_y0() + (size_y - (j + 1 - 1)) * cellSize;
                    figure.colorSetting(fieldArray[i - 1][j - 1], g);
                    g.fillRect(part_x, part_y,cellSize - 1,cellSize - 1);
                }
            }
        }

        //перемещение частей фигур правой нижней части поля
        for(int i = size_x - layer - 1; i >= size_x / 2; i--) {
            for(int j = layer; j <= size_y / 2 - 1; j++) {
                if(fieldArray[i][j] != 0) {
                    fieldArray[i + 1][j - 1] = fieldArray[i][j];
                    fieldArray[i][j] = 0;
                    part_x = figure.getPart_x0() + i * cellSize;
                    part_y = figure.getPart_y0() + (size_y - j - 1) * cellSize;
                    g.setColor(fieldColor);
                    g.fillRect(part_x, part_y,cellSize - 1,cellSize - 1);
                    part_x = figure.getPart_x0() + (i + 1) * cellSize;
                    part_y = figure.getPart_y0() + (size_y - (j + 1 - 1)) * cellSize;
                    figure.colorSetting(fieldArray[i + 1][j - 1], g);
                    g.fillRect(part_x, part_y,cellSize - 1,cellSize - 1);
                }
            }
        }

        //перемещение частей фигур левой верхней части поля
        for(int i = layer; i <= size_x / 2 - 1; i++) {
            for(int j = size_y - layer - 1; j >= size_y / 2; j--) {
                if(fieldArray[i][j] != 0) {
                    fieldArray[i - 1][j + 1] = fieldArray[i][j];
                    fieldArray[i][j] = 0;
                    part_x = figure.getPart_x0() + i * cellSize;
                    part_y = figure.getPart_y0() + (size_y - j - 1) * cellSize;
                    g.setColor(fieldColor);
                    g.fillRect(part_x, part_y,cellSize - 1,cellSize - 1);
                    part_x = figure.getPart_x0() + (i - 1) * cellSize;
                    part_y = figure.getPart_y0() + (size_y - (j + 1 + 1)) * cellSize;
                    figure.colorSetting(fieldArray[i - 1][j + 1], g);
                    g.fillRect(part_x, part_y,cellSize - 1,cellSize - 1);
                }
            }
        }

        //перемещение частей фигур правой верхней части поля
        for(int i = size_x - layer - 1; i >= size_x / 2; i--) {
            for(int j = size_y - layer - 1; j >= size_y / 2; j--) {
                if(fieldArray[i][j] != 0) {
                    fieldArray[i + 1][j + 1] = fieldArray[i][j];
                    fieldArray[i][j] = 0;
                    part_x = figure.getPart_x0() + i * cellSize;
                    part_y = figure.getPart_y0() + (size_y - j - 1) * cellSize;
                    g.setColor(fieldColor);
                    g.fillRect(part_x, part_y,cellSize - 1,cellSize - 1);
                    part_x = figure.getPart_x0() + (i + 1) * cellSize;
                    part_y = figure.getPart_y0() + (size_y - (j + 1 + 1)) * cellSize;
                    figure.colorSetting(fieldArray[i + 1][j + 1], g);
                    g.fillRect(part_x, part_y,cellSize - 1,cellSize - 1);
                }
            }
        }
    }

    //получение координаты левого верхнего угла поля
    int getX0() {
        return x0;
    }

    //получение координаты левого верхнего угла поля
    int getY0() {
        return y0;
    }

    //получение размера поля в клетках
    /*int getSize_x() {
        return size_x;
    }*/

    //получение размера поля в клетках
    /*int getSize_y() {
        return size_y;
    }*/

    //получение размера клетки поля
    int getCellSize() {
        return cellSize;
    }

    //получение элемента массива поля
    int getFieldArray(int i, int j) {
        return fieldArray[i][j];
    }

    //получение цвета поля
    Color getFieldColor() {
        return fieldColor;
    }
}