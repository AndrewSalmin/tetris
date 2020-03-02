package com.company;

import java.awt.*;

class Figure {

    //номер текущей фигуры
    private int currentFigure;
    //номер следующей фигуры
    private int nextFigure;
    //начальное положение фигуры
    private int position;
    //начальная ориентация фигуры
    private int orientation;
    //направление движения фигуры
    private String direction;

    //координаты частей фигуры на координатной плоскости
    private int part1_location_x;
    private int part1_location_y;
    private int part2_location_x;
    private int part2_location_y;
    private int part3_location_x;
    private int part3_location_y;
    private int part4_location_x;
    private int part4_location_y;
    private int part5_location_x;
    private int part5_location_y;

    //вспомогательные координаты (точка отсчета для построения фигур)
    private int part_x0;
    private int part_y0;

    //цвета поля и фигур
    private static Color color1 = new Color(255,0,0);
    private static Color color2 = new Color(0,255,255);
    private static Color color3 = new Color(0,255,0);
    private static Color color4 = new Color(255,255,0);
    private static Color color5 = new Color(255,20,147);
    private static Color color6 = new Color(255,69,0);
    private static Color color7 = new Color(210,105,30);
    private static Color color8 = new Color(0,128,0);

    Figure (MainField mainField) {
        part_x0 = mainField.getX0() + 1;
        part_y0 = mainField.getY0() + 1;
    }

    //запуск фигуры
    void launch(MainFrame mainFrame, MainField mainField, AuxiliaryField auxiliaryField, Figure figure, Graphics g) {
        //определение текущей фигуры
        if(mainFrame.isStartPosition()) currentFigure = choose(mainFrame, mainField);
        else currentFigure = nextFigure;

        //определение координат частей текущей фигуры на координатной плоскости

        //фигура "Палка (4 части)"
        if(currentFigure == 1)
        {
            if(mainFrame.isStartPosition()) position = (int) (Math.random()*4 + 1);
            switch(position)
            {
                case 1:
                    part1_location_x = 9; part1_location_y = 7;
                    part2_location_x = 9; part2_location_y = 8;
                    part3_location_x = 9; part3_location_y = 9;
                    part4_location_x = 9; part4_location_y = 10;
                    orientation = 2;
                    break;
                case 2:
                    part1_location_x = 7; part1_location_y = 9;
                    part2_location_x = 8; part2_location_y = 9;
                    part3_location_x = 9; part3_location_y = 9;
                    part4_location_x = 10; part4_location_y = 9;
                    orientation = 1;
                    break;
                case 3:
                    part1_location_x = 8; part1_location_y = 7;
                    part2_location_x = 8; part2_location_y = 8;
                    part3_location_x = 8; part3_location_y = 9;
                    part4_location_x = 8; part4_location_y = 10;
                    orientation = 2;
                    break;
                case 4:
                    part1_location_x = 7; part1_location_y = 8;
                    part2_location_x = 8; part2_location_y = 8;
                    part3_location_x = 9; part3_location_y = 8;
                    part4_location_x = 10; part4_location_y = 8;
                    orientation = 1;
                    break;
            }
        }

        //фигура "Буква Т"
        if(currentFigure == 2)
        {
            if(mainFrame.isStartPosition()) position = (int) (Math.random()*8 + 1);
            switch(position)
            {
                case 1:
                    part1_location_x = 8; part1_location_y = 9;
                    part2_location_x = 9; part2_location_y = 8;
                    part3_location_x = 9; part3_location_y = 9;
                    part4_location_x = 10; part4_location_y = 9;
                    orientation = 1;
                    break;
                case 2:
                    part1_location_x = 8; part1_location_y = 9;
                    part2_location_x = 9; part2_location_y = 8;
                    part3_location_x = 9; part3_location_y = 9;
                    part4_location_x = 9; part4_location_y = 10;
                    orientation = 2;
                    break;
                case 3:
                    part1_location_x = 8; part1_location_y = 8;
                    part2_location_x = 8; part2_location_y = 9;
                    part3_location_x = 8; part3_location_y = 10;
                    part4_location_x = 9; part4_location_y = 9;
                    orientation = 4;
                    break;
                case 4:
                    part1_location_x = 7; part1_location_y = 9;
                    part2_location_x = 8; part2_location_y = 8;
                    part3_location_x = 8; part3_location_y = 9;
                    part4_location_x = 9; part4_location_y = 9;
                    orientation = 1;
                    break;
                case 5:
                    part1_location_x = 7; part1_location_y = 8;
                    part2_location_x = 8; part2_location_y = 8;
                    part3_location_x = 8; part3_location_y = 9;
                    part4_location_x = 9; part4_location_y = 8;
                    orientation = 3;
                    break;
                case 6:
                    part1_location_x = 8; part1_location_y = 7;
                    part2_location_x = 8; part2_location_y = 8;
                    part3_location_x = 8; part3_location_y = 9;
                    part4_location_x = 9; part4_location_y = 8;
                    orientation = 4;
                    break;
                case 7:
                    part1_location_x = 8; part1_location_y = 8;
                    part2_location_x = 9; part2_location_y = 7;
                    part3_location_x = 9; part3_location_y = 8;
                    part4_location_x = 9; part4_location_y = 9;
                    orientation = 2;
                    break;
                case 8:
                    part1_location_x = 8; part1_location_y = 8;
                    part2_location_x = 9; part2_location_y = 8;
                    part3_location_x = 9; part3_location_y = 9;
                    part4_location_x = 10; part4_location_y = 8;
                    orientation = 3;
                    break;
            }
        }

        //фигура "Зигзаг"
        if(currentFigure == 3)
        {
            if(mainFrame.isStartPosition()) position = (int) (Math.random()*8 + 1);
            switch(position)
            {
                case 1:
                    part1_location_x = 8; part1_location_y = 8;
                    part2_location_x = 9; part2_location_y = 8;
                    part3_location_x = 9; part3_location_y = 9;
                    part4_location_x = 10; part4_location_y = 9;
                    orientation = 1;
                    break;
                case 2:
                    part1_location_x = 8; part1_location_y = 8;
                    part2_location_x = 8; part2_location_y = 9;
                    part3_location_x = 9; part3_location_y = 9;
                    part4_location_x = 9; part4_location_y = 10;
                    orientation = 3;
                    break;
                case 3:
                    part1_location_x = 8; part1_location_y = 9;
                    part2_location_x = 8; part2_location_y = 10;
                    part3_location_x = 9; part3_location_y = 8;
                    part4_location_x = 9; part4_location_y = 9;
                    orientation = 2;
                    break;
                case 4:
                    part1_location_x = 7; part1_location_y = 9;
                    part2_location_x = 8; part2_location_y = 8;
                    part3_location_x = 8; part3_location_y = 9;
                    part4_location_x = 9; part4_location_y = 8;
                    orientation = 4;
                    break;
                case 5:
                    part1_location_x = 7; part1_location_y = 8;
                    part2_location_x = 8; part2_location_y = 8;
                    part3_location_x = 8; part3_location_y = 9;
                    part4_location_x = 9; part4_location_y = 9;
                    orientation = 1;
                    break;
                case 6:
                    part1_location_x = 8; part1_location_y = 7;
                    part2_location_x = 8; part2_location_y = 8;
                    part3_location_x = 9; part3_location_y = 8;
                    part4_location_x = 9; part4_location_y = 9;
                    orientation = 3;
                    break;
                case 7:
                    part1_location_x = 8; part1_location_y = 8;
                    part2_location_x = 8; part2_location_y = 9;
                    part3_location_x = 9; part3_location_y = 7;
                    part4_location_x = 9; part4_location_y = 8;
                    orientation = 2;
                    break;
                case 8:
                    part1_location_x = 8; part1_location_y = 9;
                    part2_location_x = 9; part2_location_y = 8;
                    part3_location_x = 9; part3_location_y = 9;
                    part4_location_x = 10; part4_location_y = 8;
                    orientation = 4;
                    break;
            }
        }

        //фигура "Буква Г"
        if(currentFigure == 4)
        {
            if(mainFrame.isStartPosition()) position = (int) (Math.random()*8 + 1);
            switch(position)
            {
                case 1:
                    part1_location_x = 8; part1_location_y = 8;
                    part2_location_x = 8; part2_location_y = 9;
                    part3_location_x = 9; part3_location_y = 9;
                    part4_location_x = 10; part4_location_y = 9;
                    orientation = 1;
                    break;
                case 2:
                    part1_location_x = 8; part1_location_y = 8;
                    part2_location_x = 9; part2_location_y = 8;
                    part3_location_x = 9; part3_location_y = 9;
                    part4_location_x = 9; part4_location_y = 10;
                    orientation = 5;
                    break;
                case 3:
                    part1_location_x = 8; part1_location_y = 8;
                    part2_location_x = 8; part2_location_y = 9;
                    part3_location_x = 8; part3_location_y = 10;
                    part4_location_x = 9; part4_location_y = 8;
                    orientation = 2;
                    break;
                case 4:
                    part1_location_x = 7; part1_location_y = 9;
                    part2_location_x = 8; part2_location_y = 9;
                    part3_location_x = 9; part3_location_y = 8;
                    part4_location_x = 9; part4_location_y = 9;
                    orientation = 6;
                    break;
                case 5:
                    part1_location_x = 7; part1_location_y = 8;
                    part2_location_x = 8; part2_location_y = 8;
                    part3_location_x = 9; part3_location_y = 8;
                    part4_location_x = 9; part4_location_y = 9;
                    orientation = 3;
                    break;
                case 6:
                    part1_location_x = 8; part1_location_y = 7;
                    part2_location_x = 8; part2_location_y = 8;
                    part3_location_x = 8; part3_location_y = 9;
                    part4_location_x = 9; part4_location_y = 9;
                    orientation = 7;
                    break;
                case 7:
                    part1_location_x = 8; part1_location_y = 9;
                    part2_location_x = 9; part2_location_y = 7;
                    part3_location_x = 9; part3_location_y = 8;
                    part4_location_x = 9; part4_location_y = 9;
                    orientation = 4;
                    break;
                case 8:
                    part1_location_x = 8; part1_location_y = 8;
                    part2_location_x = 8; part2_location_y = 9;
                    part3_location_x = 9; part3_location_y = 8;
                    part4_location_x = 10; part4_location_y = 8;
                    orientation = 8;
                    break;
            }
        }

        //фигура "Куб"
        if(currentFigure == 5)
        {
            part1_location_x = 8; part1_location_y = 8;
            part2_location_x = 8; part2_location_y = 9;
            part3_location_x = 9; part3_location_y = 8;
            part4_location_x = 9; part4_location_y = 9;
        }

        //фигура "Палка (3 части)"
        if(currentFigure == 6)
        {
            if(mainFrame.isStartPosition()) position = (int) (Math.random()*8 + 1);
            switch(position)
            {
                case 1:
                    part1_location_x = 8; part1_location_y = 9;
                    part2_location_x = 9; part2_location_y = 9;
                    part3_location_x = 10; part3_location_y = 9;
                    orientation = 1;
                    break;
                case 2:
                    part1_location_x = 9; part1_location_y = 8;
                    part2_location_x = 9; part2_location_y = 9;
                    part3_location_x = 9; part3_location_y = 10;
                    orientation = 2;
                    break;
                case 3:
                    part1_location_x = 8; part1_location_y = 8;
                    part2_location_x = 8; part2_location_y = 9;
                    part3_location_x = 8; part3_location_y = 10;
                    orientation = 2;
                    break;
                case 4:
                    part1_location_x = 7; part1_location_y = 9;
                    part2_location_x = 8; part2_location_y = 9;
                    part3_location_x = 9; part3_location_y = 9;
                    orientation = 1;
                    break;
                case 5:
                    part1_location_x = 7; part1_location_y = 8;
                    part2_location_x = 8; part2_location_y = 8;
                    part3_location_x = 9; part3_location_y = 8;
                    orientation = 1;
                    break;
                case 6:
                    part1_location_x = 8; part1_location_y = 7;
                    part2_location_x = 8; part2_location_y = 8;
                    part3_location_x = 8; part3_location_y = 9;
                    orientation = 2;
                    break;
                case 7:
                    part1_location_x = 9; part1_location_y = 7;
                    part2_location_x = 9; part2_location_y = 8;
                    part3_location_x = 9; part3_location_y = 9;
                    orientation = 2;
                    break;
                case 8:
                    part1_location_x = 8; part1_location_y = 8;
                    part2_location_x = 9; part2_location_y = 8;
                    part3_location_x = 10; part3_location_y = 8;
                    orientation = 1;
                    break;
            }
        }

        //фигура "Угол"
        if(currentFigure == 7)
        {
            if(mainFrame.isStartPosition()) position = (int) (Math.random()*4 + 1);
            switch(position)
            {
                case 1:
                    part1_location_x = 8; part1_location_y = 9;
                    part2_location_x = 9; part2_location_y = 8;
                    part3_location_x = 9; part3_location_y = 9;
                    orientation = 1;
                    break;
                case 2:
                    part1_location_x = 8; part1_location_y = 8;
                    part2_location_x = 8; part2_location_y = 9;
                    part3_location_x = 9; part3_location_y = 9;
                    orientation = 2;
                    break;
                case 3:
                    part1_location_x = 8; part1_location_y = 8;
                    part2_location_x = 8; part2_location_y = 9;
                    part3_location_x = 9; part3_location_y = 8;
                    orientation = 3;
                    break;
                case 4:
                    part1_location_x = 8; part1_location_y = 8;
                    part2_location_x = 9; part2_location_y = 8;
                    part3_location_x = 9; part3_location_y = 9;
                    orientation = 4;
                    break;
            }
        }

        //фигура "Плюс"
        if(currentFigure == 8)
        {
            if(mainFrame.isStartPosition()) position = (int) (Math.random()*4 + 1);
            switch(position)
            {
                case 1:
                    part1_location_x = 8; part1_location_y = 9;
                    part2_location_x = 9; part2_location_y = 8;
                    part3_location_x = 9; part3_location_y = 9;
                    part4_location_x = 9; part4_location_y = 10;
                    part5_location_x = 10; part5_location_y = 9;
                    break;
                case 2:
                    part1_location_x = 7; part1_location_y = 9;
                    part2_location_x = 8; part2_location_y = 8;
                    part3_location_x = 8; part3_location_y = 9;
                    part4_location_x = 8; part4_location_y = 10;
                    part5_location_x = 9; part5_location_y = 9;
                    break;
                case 3:
                    part1_location_x = 7; part1_location_y = 8;
                    part2_location_x = 8; part2_location_y = 7;
                    part3_location_x = 8; part3_location_y = 8;
                    part4_location_x = 8; part4_location_y = 9;
                    part5_location_x = 9; part5_location_y = 8;
                    break;
                case 4:
                    part1_location_x = 8; part1_location_y = 8;
                    part2_location_x = 9; part2_location_y = 7;
                    part3_location_x = 9; part3_location_y = 8;
                    part4_location_x = 9; part4_location_y = 9;
                    part5_location_x = 10; part5_location_y = 8;
                    break;
            }
        }

        //выбор цвета для рисования текущей фигуры
        colorSetting(currentFigure, g);

        //рисование текущей фигуры
        draw(mainField, g);

        //определение направления движения текущей фигуры
        directionDefinition();

        //определение следующей фигуры
        nextFigure = choose(mainFrame, mainField);

        //определение массива вспомогательного поля для рисования следующей фигуры

        //фигура "Палка (4 части)"
        if(nextFigure == 1)
        {
            position = (int) (Math.random()*4 + 1);
            switch(position)
            {
                case 1:
                    auxiliaryField.setFieldArray(3 - 1,1 - 1,1);
                    auxiliaryField.setFieldArray(3 - 1,2 - 1,1);
                    auxiliaryField.setFieldArray(3 - 1,3 - 1,1);
                    auxiliaryField.setFieldArray(3 - 1,4 - 1,1);
                    break;
                case 2:
                    auxiliaryField.setFieldArray(1 - 1,3 - 1,1);
                    auxiliaryField.setFieldArray(2 - 1,3 - 1,1);
                    auxiliaryField.setFieldArray(3 - 1,3 - 1,1);
                    auxiliaryField.setFieldArray(4 - 1,3 - 1,1);
                    break;
                case 3:
                    auxiliaryField.setFieldArray(2 - 1,1 - 1,1);
                    auxiliaryField.setFieldArray(2 - 1,2 - 1,1);
                    auxiliaryField.setFieldArray(2 - 1,3 - 1,1);
                    auxiliaryField.setFieldArray(2 - 1,4 - 1,1);
                    break;
                case 4:
                    auxiliaryField.setFieldArray(1 - 1,2 - 1,1);
                    auxiliaryField.setFieldArray(2 - 1,2 - 1,1);
                    auxiliaryField.setFieldArray(3 - 1,2 - 1,1);
                    auxiliaryField.setFieldArray(4 - 1,2 - 1,1);
                    break;
            }
        }

        //фигура "Буква Т"
        if(nextFigure == 2)
        {
            position = (int) (Math.random()*8 + 1);
            switch(position)
            {
                case 1:
                    auxiliaryField.setFieldArray(2 - 1,3 - 1,2);
                    auxiliaryField.setFieldArray(3 - 1,2 - 1,2);
                    auxiliaryField.setFieldArray(3 - 1,3 - 1,2);
                    auxiliaryField.setFieldArray(4 - 1,3 - 1,2);
                    break;
                case 2:
                    auxiliaryField.setFieldArray(2 - 1,3 - 1,2);
                    auxiliaryField.setFieldArray(3 - 1,2 - 1,2);
                    auxiliaryField.setFieldArray(3 - 1,3 - 1,2);
                    auxiliaryField.setFieldArray(3 - 1,4 - 1,2);
                    break;
                case 3:
                    auxiliaryField.setFieldArray(2 - 1,2 - 1,2);
                    auxiliaryField.setFieldArray(2 - 1,3 - 1,2);
                    auxiliaryField.setFieldArray(2 - 1,4 - 1,2);
                    auxiliaryField.setFieldArray(3 - 1,3 - 1,2);
                    break;
                case 4:
                    auxiliaryField.setFieldArray(1 - 1,3 - 1,2);
                    auxiliaryField.setFieldArray(2 - 1,2 - 1,2);
                    auxiliaryField.setFieldArray(2 - 1,3 - 1,2);
                    auxiliaryField.setFieldArray(3 - 1,3 - 1,2);
                    break;
                case 5:
                    auxiliaryField.setFieldArray(1 - 1,2 - 1,2);
                    auxiliaryField.setFieldArray(2 - 1,2 - 1,2);
                    auxiliaryField.setFieldArray(2 - 1,3 - 1,2);
                    auxiliaryField.setFieldArray(3 - 1,2 - 1,2);
                    break;
                case 6:
                    auxiliaryField.setFieldArray(2 - 1,1 - 1,2);
                    auxiliaryField.setFieldArray(2 - 1,2 - 1,2);
                    auxiliaryField.setFieldArray(2 - 1,3 - 1,2);
                    auxiliaryField.setFieldArray(3 - 1,2 - 1,2);
                    break;
                case 7:
                    auxiliaryField.setFieldArray(2 - 1,2 - 1,2);
                    auxiliaryField.setFieldArray(3 - 1,1 - 1,2);
                    auxiliaryField.setFieldArray(3 - 1,2 - 1,2);
                    auxiliaryField.setFieldArray(3 - 1,3 - 1,2);
                    break;
                case 8:
                    auxiliaryField.setFieldArray(2 - 1,2 - 1,2);
                    auxiliaryField.setFieldArray(3 - 1,2 - 1,2);
                    auxiliaryField.setFieldArray(3 - 1,3 - 1,2);
                    auxiliaryField.setFieldArray(4 - 1,2 - 1,2);
                    break;
            }
        }

        //фигура "Зигзаг"
        if(nextFigure == 3)
        {
            position = (int) (Math.random()*8 + 1);
            switch(position)
            {
                case 1:
                    auxiliaryField.setFieldArray(2 - 1,2 - 1,3);
                    auxiliaryField.setFieldArray(3 - 1,2 - 1,3);
                    auxiliaryField.setFieldArray(3 - 1,3 - 1,3);
                    auxiliaryField.setFieldArray(4 - 1,3 - 1,3);
                    break;
                case 2:
                    auxiliaryField.setFieldArray(2 - 1,2 - 1,3);
                    auxiliaryField.setFieldArray(2 - 1,3 - 1,3);
                    auxiliaryField.setFieldArray(3 - 1,3 - 1,3);
                    auxiliaryField.setFieldArray(3 - 1,4 - 1,3);
                    break;
                case 3:
                    auxiliaryField.setFieldArray(2 - 1,3 - 1,3);
                    auxiliaryField.setFieldArray(2 - 1,4 - 1,3);
                    auxiliaryField.setFieldArray(3 - 1,2 - 1,3);
                    auxiliaryField.setFieldArray(3 - 1,3 - 1,3);
                    break;
                case 4:
                    auxiliaryField.setFieldArray(1 - 1,3 - 1,3);
                    auxiliaryField.setFieldArray(2 - 1,2 - 1,3);
                    auxiliaryField.setFieldArray(2 - 1,3 - 1,3);
                    auxiliaryField.setFieldArray(3 - 1,2 - 1,3);
                    break;
                case 5:
                    auxiliaryField.setFieldArray(1 - 1,2 - 1,3);
                    auxiliaryField.setFieldArray(2 - 1,2 - 1,3);
                    auxiliaryField.setFieldArray(2 - 1,3 - 1,3);
                    auxiliaryField.setFieldArray(3 - 1,3 - 1,3);
                    break;
                case 6:
                    auxiliaryField.setFieldArray(2 - 1,1 - 1,3);
                    auxiliaryField.setFieldArray(2 - 1,2 - 1,3);
                    auxiliaryField.setFieldArray(3 - 1,2 - 1,3);
                    auxiliaryField.setFieldArray(3 - 1,3 - 1,3);
                    break;
                case 7:
                    auxiliaryField.setFieldArray(2 - 1,2 - 1,3);
                    auxiliaryField.setFieldArray(2 - 1,3 - 1,3);
                    auxiliaryField.setFieldArray(3 - 1,1 - 1,3);
                    auxiliaryField.setFieldArray(3 - 1,2 - 1,3);
                    break;
                case 8:
                    auxiliaryField.setFieldArray(2 - 1,3 - 1,3);
                    auxiliaryField.setFieldArray(3 - 1,2 - 1,3);
                    auxiliaryField.setFieldArray(3 - 1,3 - 1,3);
                    auxiliaryField.setFieldArray(4 - 1,2 - 1,3);
                    break;
            }
        }

        //фигура "Буква Г"
        if(nextFigure == 4)
        {
            position = (int) (Math.random()*8 + 1);
            switch(position)
            {
                case 1:
                    auxiliaryField.setFieldArray(2 - 1,2 - 1,4);
                    auxiliaryField.setFieldArray(2 - 1,3 - 1,4);
                    auxiliaryField.setFieldArray(3 - 1,3 - 1,4);
                    auxiliaryField.setFieldArray(4 - 1,3 - 1,4);
                    break;
                case 2:
                    auxiliaryField.setFieldArray(2 - 1,2 - 1,4);
                    auxiliaryField.setFieldArray(3 - 1,2 - 1,4);
                    auxiliaryField.setFieldArray(3 - 1,3 - 1,4);
                    auxiliaryField.setFieldArray(3 - 1,4 - 1,4);
                    break;
                case 3:
                    auxiliaryField.setFieldArray(2 - 1,2 - 1,4);
                    auxiliaryField.setFieldArray(2 - 1,3 - 1,4);
                    auxiliaryField.setFieldArray(2 - 1,4 - 1,4);
                    auxiliaryField.setFieldArray(3 - 1,2 - 1,4);
                    break;
                case 4:
                    auxiliaryField.setFieldArray(1 - 1,3 - 1,4);
                    auxiliaryField.setFieldArray(2 - 1,3 - 1,4);
                    auxiliaryField.setFieldArray(3 - 1,2 - 1,4);
                    auxiliaryField.setFieldArray(3 - 1,3 - 1,4);
                    break;
                case 5:
                    auxiliaryField.setFieldArray(1 - 1,2 - 1,4);
                    auxiliaryField.setFieldArray(2 - 1,2 - 1,4);
                    auxiliaryField.setFieldArray(3 - 1,2 - 1,4);
                    auxiliaryField.setFieldArray(3 - 1,3 - 1,4);
                    break;
                case 6:
                    auxiliaryField.setFieldArray(2 - 1,1 - 1,4);
                    auxiliaryField.setFieldArray(2 - 1,2 - 1,4);
                    auxiliaryField.setFieldArray(2 - 1,3 - 1,4);
                    auxiliaryField.setFieldArray(3 - 1,3 - 1,4);
                    break;
                case 7:
                    auxiliaryField.setFieldArray(2 - 1,3 - 1,4);
                    auxiliaryField.setFieldArray(3 - 1,1 - 1,4);
                    auxiliaryField.setFieldArray(3 - 1,2 - 1,4);
                    auxiliaryField.setFieldArray(3 - 1,3 - 1,4);
                    break;
                case 8:
                    auxiliaryField.setFieldArray(2 - 1,2 - 1,4);
                    auxiliaryField.setFieldArray(2 - 1,3 - 1,4);
                    auxiliaryField.setFieldArray(3 - 1,2 - 1,4);
                    auxiliaryField.setFieldArray(4 - 1,2 - 1,4);
                    break;
            }
        }

        //фигура "Куб"
        if(nextFigure == 5)
        {
            auxiliaryField.setFieldArray(2 - 1,2 - 1,5);
            auxiliaryField.setFieldArray(2 - 1,3 - 1,5);
            auxiliaryField.setFieldArray(3 - 1,2 - 1,5);
            auxiliaryField.setFieldArray(3 - 1,3 - 1,5);
        }

        //фигура "Палка (3 части)"
        if(nextFigure == 6)
        {
            position = (int) (Math.random()*8 + 1);
            switch(position)
            {
                case 1:
                    auxiliaryField.setFieldArray(2 - 1,3 - 1,6);
                    auxiliaryField.setFieldArray(3 - 1,3 - 1,6);
                    auxiliaryField.setFieldArray(4 - 1,3 - 1,6);
                    break;
                case 2:
                    auxiliaryField.setFieldArray(3 - 1,2 - 1,6);
                    auxiliaryField.setFieldArray(3 - 1,3 - 1,6);
                    auxiliaryField.setFieldArray(3 - 1,4 - 1,6);
                    break;
                case 3:
                    auxiliaryField.setFieldArray(2 - 1,2 - 1,6);
                    auxiliaryField.setFieldArray(2 - 1,3 - 1,6);
                    auxiliaryField.setFieldArray(2 - 1,4 - 1,6);
                    break;
                case 4:
                    auxiliaryField.setFieldArray(1 - 1,3 - 1,6);
                    auxiliaryField.setFieldArray(2 - 1,3 - 1,6);
                    auxiliaryField.setFieldArray(3 - 1,3 - 1,6);
                    break;
                case 5:
                    auxiliaryField.setFieldArray(1 - 1,2 - 1,6);
                    auxiliaryField.setFieldArray(2 - 1,2 - 1,6);
                    auxiliaryField.setFieldArray(3 - 1,2 - 1,6);
                    break;
                case 6:
                    auxiliaryField.setFieldArray(2 - 1,1 - 1,6);
                    auxiliaryField.setFieldArray(2 - 1,2 - 1,6);
                    auxiliaryField.setFieldArray(2 - 1,3 - 1,6);
                    break;
                case 7:
                    auxiliaryField.setFieldArray(3 - 1,1 - 1,6);
                    auxiliaryField.setFieldArray(3 - 1,2 - 1,6);
                    auxiliaryField.setFieldArray(3 - 1,3 - 1,6);
                    break;
                case 8:
                    auxiliaryField.setFieldArray(2 - 1,2 - 1,6);
                    auxiliaryField.setFieldArray(3 - 1,2 - 1,6);
                    auxiliaryField.setFieldArray(4 - 1,2 - 1,6);
                    break;
            }
        }

        //фигура "Угол"
        if(nextFigure == 7)
        {
            position = (int) (Math.random()*4 + 1);
            switch(position)
            {
                case 1:
                    auxiliaryField.setFieldArray(2 - 1,3 - 1,7);
                    auxiliaryField.setFieldArray(3 - 1,2 - 1,7);
                    auxiliaryField.setFieldArray(3 - 1,3 - 1,7);
                    break;
                case 2:
                    auxiliaryField.setFieldArray(2 - 1,2 - 1,7);
                    auxiliaryField.setFieldArray(2 - 1,3 - 1,7);
                    auxiliaryField.setFieldArray(3 - 1,3 - 1,7);
                    break;
                case 3:
                    auxiliaryField.setFieldArray(2 - 1,2 - 1,7);
                    auxiliaryField.setFieldArray(2 - 1,3 - 1,7);
                    auxiliaryField.setFieldArray(3 - 1,2 - 1,7);
                    break;
                case 4:
                    auxiliaryField.setFieldArray(2 - 1,2 - 1,7);
                    auxiliaryField.setFieldArray(3 - 1,2 - 1,7);
                    auxiliaryField.setFieldArray(3 - 1,3 - 1,7);
                    break;
            }
        }

        //фигура "Плюс"
        if(nextFigure == 8)
        {
            position = (int) (Math.random()*4 + 1);
            switch(position)
            {
                case 1:
                    auxiliaryField.setFieldArray(2 - 1,3 - 1,8);
                    auxiliaryField.setFieldArray(3 - 1,2 - 1,8);
                    auxiliaryField.setFieldArray(3 - 1,3 - 1,8);
                    auxiliaryField.setFieldArray(3 - 1,4 - 1,8);
                    auxiliaryField.setFieldArray(4 - 1,3 - 1,8);
                    break;
                case 2:
                    auxiliaryField.setFieldArray(1 - 1,3 - 1,8);
                    auxiliaryField.setFieldArray(2 - 1,2 - 1,8);
                    auxiliaryField.setFieldArray(2 - 1,3 - 1,8);
                    auxiliaryField.setFieldArray(2 - 1,4 - 1,8);
                    auxiliaryField.setFieldArray(3 - 1,3 - 1,8);
                    break;
                case 3:
                    auxiliaryField.setFieldArray(1 - 1,2 - 1,8);
                    auxiliaryField.setFieldArray(2 - 1,1 - 1,8);
                    auxiliaryField.setFieldArray(2 - 1,2 - 1,8);
                    auxiliaryField.setFieldArray(2 - 1,3 - 1,8);
                    auxiliaryField.setFieldArray(3 - 1,2 - 1,8);
                    break;
                case 4:
                    auxiliaryField.setFieldArray(2 - 1,2 - 1,8);
                    auxiliaryField.setFieldArray(3 - 1,1 - 1,8);
                    auxiliaryField.setFieldArray(3 - 1,2 - 1,8);
                    auxiliaryField.setFieldArray(3 - 1,3 - 1,8);
                    auxiliaryField.setFieldArray(4 - 1,2 - 1,8);
                    break;
            }
        }

        //рисование следующей фигуры
        auxiliaryField.figuresDrawing(figure, g);

        if(mainFrame.isStartPosition()) mainFrame.setStartPosition(false);

        //проверка конца игры
        mainFrame.gameOverChecking();
    }

    //выбор фигуры
    private int choose(MainFrame mainFrame, MainField mainField) {
        if(mainFrame.getMode() == "classic") return (int) (Math.random()*5 + 1);
        else {
            //в режиме "modern" выбор фигуры зависит от числа занятых клеток поля
            //подсчет занятых клеток поля
            int field_setted_cells = 0;
            for(int i = 0; i <= 15; i++) {
                for(int j = 0; j <= 15; j++) {
                    if(mainField.getFieldArray(i, j) != 0) field_setted_cells++;
                }
            }

            //если число занятых клеток поля меньше либо равно половине общего числа клеток,
            //тогда число возможных фигур - 6, если наоборот, то 7
            int n;
            if(field_setted_cells <= 128) {
                n = (int) (Math.random()*11 + 1);
                if(n >= 1 && n <= 2) return 1;
                if(n >= 3 && n <= 4) return 2;
                if(n >= 5 && n <= 6) return 3;
                if(n >= 7 && n <= 8) return 4;
                if(n >= 9 && n <= 10) return 5;
                else return 8;
            } else {
                n = (int) (Math.random()*14 + 1);
                if(n >= 1 && n <= 2) return 1;
                if(n >= 3 && n <= 4) return 2;
                if(n >= 5 && n <= 6) return 3;
                if(n >= 7 && n <= 8) return 4;
                if(n >= 9 && n <= 10) return 5;
                if(n >= 11 && n <= 12) return 6;
                else return 7;
            }
        }
    }

    //установка цвета для рисования фигуры
    void colorSetting(int figureNumber, Graphics g) {
        switch(figureNumber)
        {
            case 1:
                g.setColor(color1);
                break;
            case 2:
                g.setColor(color2);
                break;
            case 3:
                g.setColor(color3);
                break;
            case 4:
                g.setColor(color4);
                break;
            case 5:
                g.setColor(color5);
                break;
            case 6:
                g.setColor(color6);
                break;
            case 7:
                g.setColor(color7);
                break;
            case 8:
                g.setColor(color8);
                break;
        }
    }

    //рисование фигуры
    void draw(MainField mainField, Graphics g) {
        int part1_x;
        int part2_x;
        int part3_x;
        int part4_x = 0; //необходимо инициализировать, чтобы компилятор не выдавал ошибку
        int part5_x = 0; //необходимо инициализировать, чтобы компилятор не выдавал ошибку

        int part1_y;
        int part2_y;
        int part3_y;
        int part4_y = 0; //необходимо инициализировать, чтобы компилятор не выдавал ошибку
        int part5_y = 0; //необходимо инициализировать, чтобы компилятор не выдавал ошибку

        part1_x = part_x0 + (part1_location_x - 1) * mainField.getCellSize();
        part2_x = part_x0 + (part2_location_x - 1) * mainField.getCellSize();
        part3_x = part_x0 + (part3_location_x - 1) * mainField.getCellSize();
        if(currentFigure != 6 && currentFigure != 7) part4_x = part_x0 + (part4_location_x - 1) * mainField.getCellSize();
        if(currentFigure == 8) part5_x = part_x0 + (part5_location_x - 1) * mainField.getCellSize();

        part1_y = part_y0 + (mainField.getSize_y() - part1_location_y) * mainField.getCellSize();
        part2_y = part_y0 + (mainField.getSize_y() - part2_location_y) * mainField.getCellSize();
        part3_y = part_y0 + (mainField.getSize_y() - part3_location_y) * mainField.getCellSize();
        if(currentFigure != 6 && currentFigure != 7) part4_y = part_y0 + (mainField.getSize_y() - part4_location_y) * mainField.getCellSize();
        if(currentFigure == 8) part5_y = part_y0 + (mainField.getSize_y() - part5_location_y) * mainField.getCellSize();

        g.fillRect(part1_x, part1_y,mainField.getCellSize() - 1,mainField.getCellSize() - 1);
        g.fillRect(part2_x, part2_y,mainField.getCellSize() - 1,mainField.getCellSize() - 1);
        g.fillRect(part3_x, part3_y,mainField.getCellSize() - 1,mainField.getCellSize() - 1);
        if(currentFigure != 6 && currentFigure != 7) g.fillRect(part4_x, part4_y,mainField.getCellSize() - 1,mainField.getCellSize() - 1);
        if(currentFigure == 8) g.fillRect(part5_x, part5_y,mainField.getCellSize() - 1,mainField.getCellSize() - 1);
    }

    //определение направления движения фигуры
    private void directionDefinition() {
        int n = (int) (Math.random()*4 + 1);
        switch(n) {
            case 1:
                direction = "RIGHT";
                break;
            case 2:
                direction = "UP";
                break;
            case 3:
                direction = "LEFT";
                break;
            case 4:
                direction = "DOWN";
                break;
        }
    }

    //движения фигуры
    void move(MainFrame mainFrame, MainField mainField, AuxiliaryField auxiliaryField, Figure figure, GraphicTimer graphicTimer, Graphics g) {
        switch(direction) {
            case "RIGHT":
                if(part1_location_x == mainField.getSize_x() ||
                   part2_location_x == mainField.getSize_x() ||
                   part3_location_x == mainField.getSize_x() ||
                   (currentFigure != 6 && currentFigure != 7 && part4_location_x == mainField.getSize_x()) ||
                   (currentFigure == 8 && part5_location_x == mainField.getSize_x()) ||
                   mainField.getFieldArray(part1_location_x + 1 - 1,part1_location_y - 1) != 0 ||
                   mainField.getFieldArray(part2_location_x + 1 - 1,part2_location_y - 1) != 0 ||
                   mainField.getFieldArray(part3_location_x + 1 - 1,part3_location_y - 1) != 0 ||
                   (currentFigure != 6 && currentFigure != 7 && mainField.getFieldArray(part4_location_x + 1 - 1,part4_location_y - 1) != 0) ||
                   (currentFigure == 8 && mainField.getFieldArray(part5_location_x + 1 - 1,part5_location_y - 1) != 0)) {
                    set(mainFrame, mainField, auxiliaryField, graphicTimer, g);
                    mainField.layerDeletingChecking(mainFrame, figure, g);
                    launch(mainFrame, mainField, auxiliaryField, figure, g);
                } else {
                    g.setColor(mainField.getFieldColor());
                    draw(mainField, g);
                    part1_location_x++;
                    part2_location_x++;
                    part3_location_x++;
                    if(currentFigure != 6 && currentFigure != 7) part4_location_x++;
                    if(currentFigure == 8) part5_location_x++;
                    colorSetting(currentFigure, g);
                    draw(mainField, g);
                }
                break;

            case "UP":
                if(part1_location_y == mainField.getSize_y() ||
                   part2_location_y == mainField.getSize_y() ||
                   part3_location_y == mainField.getSize_y() ||
                   (currentFigure != 6 && currentFigure != 7 && part4_location_y == mainField.getSize_y()) ||
                   (currentFigure == 8 && part5_location_y == mainField.getSize_y()) ||
                   mainField.getFieldArray(part1_location_x - 1,part1_location_y + 1 - 1) != 0 ||
                   mainField.getFieldArray(part2_location_x - 1,part2_location_y + 1 - 1) != 0 ||
                   mainField.getFieldArray(part3_location_x - 1,part3_location_y + 1 - 1) != 0 ||
                   (currentFigure != 6 && currentFigure != 7 && mainField.getFieldArray(part4_location_x - 1,part4_location_y + 1 - 1) != 0) ||
                   (currentFigure == 8 && mainField.getFieldArray(part5_location_x - 1,part5_location_y + 1 - 1) != 0)) {
                    set(mainFrame, mainField, auxiliaryField, graphicTimer, g);
                    mainField.layerDeletingChecking(mainFrame, figure, g);
                    launch(mainFrame, mainField, auxiliaryField, figure, g);
                } else {
                    g.setColor(mainField.getFieldColor());
                    draw(mainField, g);
                    part1_location_y++;
                    part2_location_y++;
                    part3_location_y++;
                    if(currentFigure != 6 && currentFigure != 7) part4_location_y++;
                    if(currentFigure == 8) part5_location_y++;
                    colorSetting(currentFigure, g);
                    draw(mainField, g);
                }
                break;

            case "LEFT":
                if(part1_location_x == 1 ||
                   part2_location_x == 1 ||
                   part3_location_x == 1 ||
                   (currentFigure != 6 && currentFigure != 7 && part4_location_x == 1) ||
                   (currentFigure == 8 && part5_location_x == 1) ||
                   mainField.getFieldArray(part1_location_x - 1 - 1,part1_location_y - 1) != 0 ||
                   mainField.getFieldArray(part2_location_x - 1 - 1,part2_location_y - 1) != 0 ||
                   mainField.getFieldArray(part3_location_x - 1 - 1,part3_location_y - 1) != 0 ||
                   (currentFigure != 6 && currentFigure != 7 && mainField.getFieldArray(part4_location_x - 1 - 1,part4_location_y - 1) != 0) ||
                   (currentFigure == 8 && mainField.getFieldArray(part5_location_x - 1 - 1,part5_location_y - 1) != 0)) {
                    set(mainFrame, mainField, auxiliaryField, graphicTimer, g);
                    mainField.layerDeletingChecking(mainFrame, figure, g);
                    launch(mainFrame, mainField, auxiliaryField, figure, g);
                } else {
                    g.setColor(mainField.getFieldColor());
                    draw(mainField, g);
                    part1_location_x--;
                    part2_location_x--;
                    part3_location_x--;
                    if(currentFigure != 6 && currentFigure != 7) part4_location_x--;
                    if(currentFigure == 8) part5_location_x--;
                    colorSetting(currentFigure, g);
                    draw(mainField, g);
                }
                break;

            case "DOWN":
                if(part1_location_y == 1 ||
                   part2_location_y == 1 ||
                   part3_location_y == 1 ||
                   (currentFigure != 6 && currentFigure != 7 && part4_location_y == 1) ||
                   (currentFigure == 8 && part5_location_y == 1) ||
                   mainField.getFieldArray(part1_location_x - 1,part1_location_y - 1 - 1) != 0 ||
                   mainField.getFieldArray(part2_location_x - 1,part2_location_y - 1 - 1) != 0 ||
                   mainField.getFieldArray(part3_location_x - 1,part3_location_y - 1 - 1) != 0 ||
                   (currentFigure != 6 && currentFigure != 7 && mainField.getFieldArray(part4_location_x - 1,part4_location_y - 1 - 1) != 0) ||
                   (currentFigure == 8 && mainField.getFieldArray(part5_location_x - 1,part5_location_y - 1 - 1) != 0)) {
                    set(mainFrame, mainField, auxiliaryField, graphicTimer, g);
                    mainField.layerDeletingChecking(mainFrame, figure, g);
                    launch(mainFrame, mainField, auxiliaryField, figure, g);
                } else {
                    g.setColor(mainField.getFieldColor());
                    draw(mainField, g);
                    part1_location_y--;
                    part2_location_y--;
                    part3_location_y--;
                    if(currentFigure != 6 && currentFigure != 7) part4_location_y--;
                    if(currentFigure == 8) part5_location_y--;
                    colorSetting(currentFigure, g);
                    draw(mainField, g);
                }
                break;
        }
    }

    //вращение фигуры
    void rotate(MainField mainField, Graphics g) {
        //стирание текущей фигуры
        g.setColor(mainField.getFieldColor());
        draw(mainField, g);

        //поворот фигуры

        //фигура "Палка (4 части)"
        if(currentFigure == 1) {
            switch(orientation) {
                case 1:
                    if(part1_location_y - 1 >= 1 && part4_location_y + 2 <= mainField.getSize_y() &&
                       mainField.getFieldArray(part1_location_x + 1 - 1,part1_location_y - 1 - 1) == 0 &&
                       mainField.getFieldArray(part3_location_x - 1 - 1,part3_location_y + 1 - 1) == 0 &&
                       mainField.getFieldArray(part4_location_x - 2 - 1,part4_location_y + 2 - 1) == 0) {
                        //перемещение первой части
                        part1_location_x++;
                        part1_location_y--;
                        //перемещение третьей части
                        part3_location_x--;
                        part3_location_y++;
                        //перемещение четвертой части
                        part4_location_x = part4_location_x - 2;
                        part4_location_y = part4_location_y + 2;
                        //изменение ориентации
                        orientation = 2;
                    }
                    break;
                case 2:
                    if(part1_location_x - 1 >= 1 && part4_location_x + 2 <= mainField.getSize_x() &&
                       mainField.getFieldArray(part1_location_x - 1 - 1,part1_location_y + 1 - 1) == 0 &&
                       mainField.getFieldArray(part3_location_x + 1 - 1,part3_location_y - 1 - 1) == 0 &&
                       mainField.getFieldArray(part4_location_x + 2 - 1,part4_location_y - 2 - 1) == 0) {
                        //перемещение первой части
                        part1_location_x--;
                        part1_location_y++;
                        //перемещение третьей части
                        part3_location_x++;
                        part3_location_y--;
                        //перемещение четвертой части
                        part4_location_x = part4_location_x + 2;
                        part4_location_y = part4_location_y - 2;
                        //изменение ориентации
                        orientation = 1;
                    }
                    break;
            }
        }

        //фигура "Буква Т"
        if(currentFigure == 2) {
            switch(orientation) {
                case 1:
                    if(part4_location_y + 1 <= mainField.getSize_y() &&
                       mainField.getFieldArray(part4_location_x - 1 - 1,part4_location_y + 1 - 1) == 0) {
                        //перемещение четвертой части
                        part4_location_x--;
                        part4_location_y++;
                        //изменение ориентации
                        orientation = 2;
                    }
                    break;
                case 2:
                    if(part4_location_x + 1 <= mainField.getSize_x() &&
                       mainField.getFieldArray(part4_location_x + 1 - 1,part4_location_y - 1 - 1) == 0) {
                        //перемещение второй части
                        part2_location_y++;
                        //перемещение третьей части
                        part3_location_y++;
                        //перемещение четвертой части
                        part4_location_x++;
                        part4_location_y--;
                        //изменение ориентации
                        orientation = 3;
                    }
                    break;
                case 3:
                    if(part1_location_y - 1 >= 1 &&
                       mainField.getFieldArray(part1_location_x + 1 - 1,part1_location_y - 1 - 1) == 0) {
                        //перемещение первой части
                        part1_location_x++;
                        part1_location_y--;
                        //изменение ориентации
                        orientation = 4;
                    }
                    break;
                case 4:
                    if(part1_location_x - 1 >= 1 &&
                       mainField.getFieldArray(part1_location_x - 1 - 1,part1_location_y + 1 - 1) == 0) {
                        //перемещение первой части
                        part1_location_x--;
                        part1_location_y++;
                        //перемещение второй части
                        part2_location_y--;
                        //перемещение третьей части
                        part3_location_y--;
                        //изменение ориентации
                        orientation = 1;
                    }
                    break;
            }
        }

        //фигура "Зигзаг"
        if(currentFigure == 3) {
            switch(orientation) {
                case 1:
                    if(part2_location_y + 2 <= mainField.getSize_y() &&
                       mainField.getFieldArray(part1_location_x - 1,part1_location_y + 1 - 1) == 0 &&
                       mainField.getFieldArray(part2_location_x - 1 - 1,part2_location_y + 2 - 1) == 0) {
                        //перемещение первой части
                        part1_location_y++;
                        //перемещение второй части
                        part2_location_x--;
                        part2_location_y = part2_location_y + 2;
                        //перемещение третьей части
                        part3_location_y--;
                        //перемещение четвертой части
                        part4_location_x--;
                        //изменение ориентации
                        orientation = 2;
                    }
                    break;
                case 2:
                    if(part4_location_x + 1 <= mainField.getSize_x() &&
                       mainField.getFieldArray(part1_location_x - 1,part1_location_y - 1 - 1) == 0 &&
                       mainField.getFieldArray(part4_location_x + 1 - 1,part4_location_y - 1) == 0) {
                        //перемещение первой части
                        part1_location_y--;
                        //перемещение второй части
                        part2_location_x++;
                        part2_location_y = part2_location_y - 2;
                        //перемещение третьей части
                        part3_location_y++;
                        //перемещение четвертой части
                        part4_location_x++;
                        //изменение ориентации
                        orientation = 1;
                    }
                    break;
                case 3:
                    if(part1_location_x - 1 >= 1 &&
                       mainField.getFieldArray(part1_location_x - 1 - 1,part1_location_y + 1 - 1) == 0 &&
                       mainField.getFieldArray(part4_location_x - 1,part4_location_y - 2 - 1) == 0) {
                        //перемещение первой части
                        part1_location_x--;
                        part1_location_y++;
                        //перемещение второй части
                        part2_location_y--;
                        //перемещение третьей части
                        part3_location_x--;
                        //перемещение четвертой части
                        part4_location_y = part4_location_y - 2;
                        //изменение ориентации
                        orientation = 4;
                    }
                    break;
                case 4:
                    if(part4_location_y + 2 <= mainField.getSize_y() &&
                       mainField.getFieldArray(part3_location_x + 1 - 1,part3_location_y - 1) == 0 &&
                       mainField.getFieldArray(part4_location_x - 1,part4_location_y + 2 - 1) == 0) {
                        //перемещение первой части
                        part1_location_x++;
                        part1_location_y--;
                        //перемещение второй части
                        part2_location_y++;
                        //перемещение третьей части
                        part3_location_x++;
                        //перемещение четвертой части
                        part4_location_y = part4_location_y + 2;
                        //изменение ориентации
                        orientation = 3;
                    }
                    break;
            }
        }

        //фигура "Буква Г"
        if(currentFigure == 4) {
            switch(orientation) {
                case 1:
                    if(part3_location_y + 1 <= mainField.getSize_y() &&
                       mainField.getFieldArray(part1_location_x + 1 - 1,part1_location_y - 1) == 0 &&
                       mainField.getFieldArray(part3_location_x - 1,part3_location_y + 1 - 1) == 0 &&
                       mainField.getFieldArray(part4_location_x - 1,part4_location_y - 1 - 1) == 0) {
                        //перемещение первой части
                        part1_location_x++;
                        //перемещение второй части
                        part2_location_x++;
                        //перемещение третьей части
                        part3_location_y++;
                        //перемещение четвертой части
                        part4_location_y--;
                        //изменение ориентации
                        orientation = 2;
                    }
                    break;
                case 2:
                    if(part1_location_x - 1 >= 1 &&
                       mainField.getFieldArray(part1_location_x - 1 - 1,part1_location_y + 1 - 1) == 0 &&
                       mainField.getFieldArray(part3_location_x + 1 - 1,part3_location_y - 1 - 1) == 0 &&
                       mainField.getFieldArray(part4_location_x - 1,part4_location_y + 2 - 1) == 0) {
                        //перемещение первой части
                        part1_location_x--;
                        part1_location_y++;
                        //перемещение третьей части
                        part3_location_x++;
                        part3_location_y--;
                        //перемещение четвертой части
                        part4_location_y = part4_location_y + 2;
                        //изменение ориентации
                        orientation = 3;
                    }
                    break;
                case 3:
                    if(part2_location_y - 1 >= 1 &&
                       mainField.getFieldArray(part1_location_x - 1,part1_location_y + 1 - 1) == 0 &&
                       mainField.getFieldArray(part2_location_x - 1,part2_location_y - 1 - 1) == 0 &&
                       mainField.getFieldArray(part4_location_x - 1 - 1,part4_location_y - 1) == 0) {
                        //перемещение первой части
                        part1_location_y++;
                        //перемещение второй части
                        part2_location_y--;
                        //перемещение третьей части
                        part3_location_x--;
                        //перемещение четвертой части
                        part4_location_x--;
                        //изменение ориентации
                        orientation = 4;
                    }
                    break;
                case 4:
                    if(part4_location_x + 1 <= mainField.getSize_x() &&
                       mainField.getFieldArray(part1_location_x - 1,part1_location_y - 2 - 1) == 0 &&
                       mainField.getFieldArray(part2_location_x - 1 - 1,part2_location_y + 1 - 1) == 0 &&
                       mainField.getFieldArray(part4_location_x + 1 - 1,part4_location_y - 1 - 1) == 0) {
                        //перемещение первой части
                        part1_location_y = part1_location_y - 2;
                        //перемещение второй части
                        part2_location_x--;
                        part2_location_y++;
                        //перемещение четвертой части
                        part4_location_x++;
                        part4_location_y--;
                        //изменение ориентации
                        orientation = 1;
                    }
                    break;
                case 5:
                    if(part3_location_x + 1 <= mainField.getSize_x() &&
                       mainField.getFieldArray(part1_location_x - 1,part1_location_y + 1 - 1) == 0 &&
                       mainField.getFieldArray(part3_location_x + 1 - 1,part3_location_y - 1 - 1) == 0 &&
                       mainField.getFieldArray(part4_location_x + 1 - 1,part4_location_y - 1 - 1) == 0) {
                        //перемещение первой части
                        part1_location_y++;
                        //перемещение второй части
                        part2_location_y++;
                        //перемещение третьей части
                        part3_location_x++;
                        part3_location_y--;
                        //перемещение четвертой части
                        part4_location_x++;
                        part4_location_y--;
                        //изменение ориентации
                        orientation = 6;
                    }
                    break;
                case 6:
                    if(part3_location_y + 2 <= mainField.getSize_y() &&
                       mainField.getFieldArray(part1_location_x + 1 - 1,part1_location_y - 1 - 1) == 0 &&
                       mainField.getFieldArray(part3_location_x - 1 - 1,part3_location_y + 2 - 1) == 0 &&
                       mainField.getFieldArray(part4_location_x - 1,part4_location_y + 1 - 1) == 0) {
                        //перемещение первой части
                        part1_location_x++;
                        part1_location_y--;
                        //перемещение третьей части
                        part3_location_x--;
                        part3_location_y = part3_location_y + 2;
                        //перемещение четвертой части
                        part4_location_y++;
                        //изменение ориентации
                        orientation = 7;
                    }
                    break;
                case 7:
                    if(part1_location_x - 1 >= 1 &&
                       mainField.getFieldArray(part1_location_x - 1 - 1,part1_location_y + 1 - 1) == 0 &&
                       mainField.getFieldArray(part2_location_x - 1 - 1,part2_location_y + 1 - 1) == 0 &&
                       mainField.getFieldArray(part4_location_x - 1,part4_location_y - 1 - 1) == 0) {
                        //перемещение первой части
                        part1_location_x--;
                        part1_location_y++;
                        //перемещение второй части
                        part2_location_x--;
                        part2_location_y++;
                        //перемещение третьей части
                        part3_location_y--;
                        //перемещение четвертой части
                        part4_location_y--;
                        //изменение ориентации
                        orientation = 8;
                    }
                    break;
                case 8:
                    if(part1_location_y - 1 >= 1 &&
                       mainField.getFieldArray(part1_location_x - 1,part1_location_y - 1 - 1) == 0 &&
                       mainField.getFieldArray(part2_location_x + 1 - 1,part2_location_y - 2 - 1) == 0 &&
                       mainField.getFieldArray(part4_location_x - 1 - 1,part4_location_y + 1 - 1) == 0) {
                        //перемещение первой части
                        part1_location_y--;
                        //перемещение второй части
                        part2_location_x++;
                        part2_location_y = part2_location_y - 2;
                        //перемещение четвертой части
                        part4_location_x--;
                        part4_location_y++;
                        //изменение ориентации
                        orientation = 5;
                    }
                    break;
            }
        }

        //фигура "Палка (3 части)"
        if(currentFigure == 6) {
            switch(orientation) {
                case 1:
                    if(part1_location_y - 1 >= 1 &&
                       part1_location_y + 1 <= mainField.getSize_y() &&
                       mainField.getFieldArray(part1_location_x + 1 - 1,part1_location_y - 1 - 1) == 0 &&
                       mainField.getFieldArray(part3_location_x - 1 - 1,part3_location_y + 1 - 1) == 0) {
                        //перемещение первой части
                        part1_location_x++;
                        part1_location_y--;
                        //перемещение третьей части
                        part3_location_x--;
                        part3_location_y++;
                        //изменение ориентации
                        orientation = 2;
                    }
                    break;
                case 2:
                    if(part1_location_x - 1 >= 1 &&
                       part1_location_x + 1 <= mainField.getSize_x() &&
                       mainField.getFieldArray(part1_location_x - 1 - 1,part1_location_y + 1 - 1) == 0 &&
                       mainField.getFieldArray(part3_location_x + 1 - 1,part3_location_y - 1 - 1) == 0) {
                        //перемещение первой части
                        part1_location_x--;
                        part1_location_y++;
                        //перемещение третьей части
                        part3_location_x++;
                        part3_location_y--;
                        //изменение ориентации
                        orientation = 1;
                    }
                    break;
            }
        }

        //фигура "Угол"
        if(currentFigure == 7) {
            switch(orientation) {
                case 1:
                    if(mainField.getFieldArray(part1_location_x - 1,part1_location_y - 1 - 1) == 0) {
                        //перемещение первой части
                        part1_location_y--;
                        //перемещение второй части
                        part2_location_x--;
                        part2_location_y++;
                        //изменение ориентации
                        orientation = 2;
                    }
                    break;
                case 2:
                    if(mainField.getFieldArray(part3_location_x - 1,part3_location_y - 1 - 1) == 0) {
                        //перемещение третьей части
                        part3_location_y--;
                        //изменение ориентации
                        orientation = 3;
                    }
                    break;
                case 3:
                    if(mainField.getFieldArray(part3_location_x - 1,part3_location_y + 1 - 1) == 0) {
                        //перемещение второй части
                        part2_location_x++;
                        part2_location_y--;
                        //перемещение третьей части
                        part3_location_y++;
                        //изменение ориентации
                        orientation = 4;
                    }
                    break;
                case 4:
                    if(mainField.getFieldArray(part1_location_x - 1,part1_location_y + 1 - 1) == 0) {
                        //перемещение первой части
                        part1_location_y++;
                        //изменение ориентации
                        orientation = 1;
                    }
                    break;
            }
        }

        colorSetting(currentFigure, g);
        draw(mainField, g);
    }

    //установка фигуры на поле
    void set(MainFrame mainFrame, MainField mainField, AuxiliaryField auxiliaryField, GraphicTimer graphicTimer, Graphics g) {
        //обновление массива игрового поля
        switch(currentFigure) {
            case 1:
                mainField.setFieldArray(part1_location_x - 1,part1_location_y - 1,1);
                mainField.setFieldArray(part2_location_x - 1,part2_location_y - 1,1);
                mainField.setFieldArray(part3_location_x - 1,part3_location_y - 1,1);
                mainField.setFieldArray(part4_location_x - 1,part4_location_y - 1,1);
                break;
            case 2:
                mainField.setFieldArray(part1_location_x - 1,part1_location_y - 1,2);
                mainField.setFieldArray(part2_location_x - 1,part2_location_y - 1,2);
                mainField.setFieldArray(part3_location_x - 1,part3_location_y - 1,2);
                mainField.setFieldArray(part4_location_x - 1,part4_location_y - 1,2);
                break;
            case 3:
                mainField.setFieldArray(part1_location_x - 1,part1_location_y - 1,3);
                mainField.setFieldArray(part2_location_x - 1,part2_location_y - 1,3);
                mainField.setFieldArray(part3_location_x - 1,part3_location_y - 1,3);
                mainField.setFieldArray(part4_location_x - 1,part4_location_y - 1,3);
                break;
            case 4:
                mainField.setFieldArray(part1_location_x - 1,part1_location_y - 1,4);
                mainField.setFieldArray(part2_location_x - 1,part2_location_y - 1,4);
                mainField.setFieldArray(part3_location_x - 1,part3_location_y - 1,4);
                mainField.setFieldArray(part4_location_x - 1,part4_location_y - 1,4);
                break;
            case 5:
                mainField.setFieldArray(part1_location_x - 1,part1_location_y - 1,5);
                mainField.setFieldArray(part2_location_x - 1,part2_location_y - 1,5);
                mainField.setFieldArray(part3_location_x - 1,part3_location_y - 1,5);
                mainField.setFieldArray(part4_location_x - 1,part4_location_y - 1,5);
                break;
            case 6:
                mainField.setFieldArray(part1_location_x - 1,part1_location_y - 1,6);
                mainField.setFieldArray(part2_location_x - 1,part2_location_y - 1,6);
                mainField.setFieldArray(part3_location_x - 1,part3_location_y - 1,6);
                break;
            case 7:
                mainField.setFieldArray(part1_location_x - 1,part1_location_y - 1,7);
                mainField.setFieldArray(part2_location_x - 1,part2_location_y - 1,7);
                mainField.setFieldArray(part3_location_x - 1,part3_location_y - 1,7);
                break;
            case 8:
                mainField.setFieldArray(part1_location_x - 1,part1_location_y - 1,8);
                mainField.setFieldArray(part2_location_x - 1,part2_location_y - 1,8);
                mainField.setFieldArray(part3_location_x - 1,part3_location_y - 1,8);
                mainField.setFieldArray(part4_location_x - 1,part4_location_y - 1,8);
                mainField.setFieldArray(part5_location_x - 1,part5_location_y - 1,8);
                break;
        }

        //увеличение очков
        mainFrame.pointsIncrease(10);
        //вычисление уровня
        mainFrame.levelIncreasingChecking();

        //рисование вспомогательного поля
        auxiliaryField.paint(g);
        //обнуление массива вспомогательного поля
        for(int i = 0; i <= 3; i++) {
            for(int j = 0; j <= 3; j++) {
                auxiliaryField.setFieldArray(i, j,0);
            }
        }

        //перезапуск графического таймера
        graphicTimer.restart(mainFrame, g);

        //озвучка установки фигуры
        mainFrame.playSound();
    }

    //получение номера текущей фигуры
    int getCurrentFigure() {
        return currentFigure;
    }

    //получение направления движения фигуры
    String getDirection() {
        return direction;
    }

    //установка направления движения фигуры
    void setDirection(String direction) {
        this.direction = direction;
    }

    //получение координаты части фигуры на координатной плоскости
    int getPart1_location_x() {
        return part1_location_x;
    }

    //получение координаты части фигуры на координатной плоскости
    int getPart1_location_y() {
        return part1_location_y;
    }

    //получение координаты части фигуры на координатной плоскости
    int getPart2_location_x() {
        return part2_location_x;
    }

    //получение координаты части фигуры на координатной плоскости
    int getPart2_location_y() {
        return part2_location_y;
    }

    //получение координаты части фигуры на координатной плоскости
    int getPart3_location_x() {
        return part3_location_x;
    }

    //получение координаты части фигуры на координатной плоскости
    int getPart3_location_y() {
        return part3_location_y;
    }

    //получение координаты части фигуры на координатной плоскости
    int getPart4_location_x() {
        return part4_location_x;
    }

    //получение координаты части фигуры на координатной плоскости
    int getPart4_location_y() {
        return part4_location_y;
    }

    //получение координаты части фигуры на координатной плоскости
    int getPart5_location_x() {
        return part5_location_x;
    }

    //получение координаты части фигуры на координатной плоскости
    int getPart5_location_y() {
        return part5_location_y;
    }

    //получение координаты точки отсчета для построения фигур
    int getPart_x0() {
        return part_x0;
    }

    //получение координаты точки отсчета для построения фигур
    int getPart_y0() {
        return part_y0;
    }

    //получение цвета фигуры
    Color getColor1() {
        return color1;
    }

    //получение цвета фигуры
    Color getColor2() {
        return color2;
    }

    //получение цвета фигуры
    Color getColor3() {
        return color3;
    }

    //получение цвета фигуры
    Color getColor4() {
        return color4;
    }

    //получение цвета фигуры
    Color getColor5() {
        return color5;
    }

    //получение цвета фигуры
    Color getColor6() {
        return color6;
    }

    //получение цвета фигуры
    Color getColor7() {
        return color7;
    }

    //получение цвета фигуры
    Color getColor8() {
        return color8;
    }
}