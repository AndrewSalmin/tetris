package com.company;

import java.awt.*;

class TetrisText {

    //координаты левого верхнего угла области рисования
    private int x0;
    private int y0;

    //размер области рисования в клетках
    private int size_x;
    private int size_y = 5;

    //размер клетки области рисования
    private int cellSize;

    //цвета фона и текста области рисования
    private static Color bgColor = new Color(0,0,200);
    private static Color textColor1 = new Color(0,255,0);
    private static Color textColor2 = new Color(255,255,0);
    private static Color textColor3 = new Color(255,255,255);
    private static Color textColor4 = new Color(255,0,0);

    //текст
    private String text;

    TetrisText(int x0, int y0, int cellSize, String text) {
        this.x0 = x0;
        this.y0 = y0;
        this.cellSize = cellSize;
        this.text = text;

        //вычисление ширины области рисования в клетках
        for(int i = 0; i < text.length(); i++) {
            switch(text.charAt(i)) {
                case 'A':
                    size_x += 3;
                    break;
                case 'B':
                    size_x += 3;
                    break;
                case 'C':
                    size_x += 3;
                    break;
                case 'D':
                    size_x += 3;
                    break;
                case 'E':
                    size_x += 3;
                    break;
                case 'F':
                    size_x += 3;
                    break;
                case 'G':
                    size_x += 3;
                    break;
                case 'H':
                    size_x += 3;
                    break;
                case 'I':
                    size_x += 1;
                    break;
                case 'J':
                    size_x += 3;
                    break;
                case 'K':
                    size_x += 3;
                    break;
                case 'L':
                    size_x += 3;
                    break;
                case 'M':
                    size_x += 5;
                    break;
                case 'N':
                    size_x += 4;
                    break;
                case 'O':
                    size_x += 3;
                    break;
                case 'P':
                    size_x += 3;
                    break;
                case 'Q':
                    size_x += 4;
                    break;
                case 'R':
                    size_x += 3;
                    break;
                case 'S':
                    size_x += 3;
                    break;
                case 'T':
                    size_x += 3;
                    break;
                case 'U':
                    size_x += 3;
                    break;
                case 'V':
                    size_x += 3;
                    break;
                case 'W':
                    size_x += 5;
                    break;
                case 'X':
                    size_x += 3;
                    break;
                case 'Y':
                    size_x += 3;
                    break;
                case 'Z':
                    size_x += 3;
                    break;
                case ' ':
                    size_x += 1;
                    break;
                case '0':
                    size_x += 3;
                    break;
                case '1':
                    size_x += 3;
                    break;
                case '2':
                    size_x += 3;
                    break;
                case '3':
                    size_x += 3;
                    break;
                case '4':
                    size_x += 3;
                    break;
                case '5':
                    size_x += 3;
                    break;
                case '6':
                    size_x += 3;
                    break;
                case '7':
                    size_x += 3;
                    break;
                case '8':
                    size_x += 3;
                    break;
                case '9':
                    size_x += 3;
                    break;
            }
        }

        //учет пробелов между буквами
        size_x = size_x + (text.length() - 1);
    }

    //рисование поля
    void paint(Color bgColor, Color textColor, Graphics g) {
        //рисование фона области рисования
        g.setColor(bgColor);
        g.fillRect(x0, y0,size_x * cellSize + 1,size_y * cellSize + 1);

        /*g.setColor(new Color(0,0,205));
        //рисование горизонтальных линий области рисования
        for(int i = 0; i <= size_y; i++) {
            g.drawLine(x0,y0 + i * cellSize,x0 + size_x * cellSize,y0 + i * cellSize);
        }
        //рисование вертикальных линий области рисования
        for(int i = 0; i <= size_x; i++) {
            g.drawLine(x0 + i * cellSize, y0,x0 + i * cellSize,y0 + size_y * cellSize);
        }*/

        //рисование текста
        g.setColor(textColor);
        int delta = 0;
        for(int i = 0; i < text.length(); i++) {
            switch(text.charAt(i)) {
                case 'A':
                    letter_A_drawing(delta, g);
                    delta += 3;
                    delta++;
                    break;
                case 'B':
                    letter_B_drawing(delta, g);
                    delta += 3;
                    delta++;
                    break;
                case 'C':
                    letter_C_drawing(delta, g);
                    delta += 3;
                    delta++;
                    break;
                case 'D':
                    letter_D_drawing(delta, g);
                    delta += 3;
                    delta++;
                    break;
                case 'E':
                    letter_E_drawing(delta, g);
                    delta += 3;
                    delta++;
                    break;
                case 'F':
                    letter_F_drawing(delta, g);
                    delta += 3;
                    delta++;
                    break;
                case 'G':
                    letter_G_drawing(delta, g);
                    delta += 3;
                    delta++;
                    break;
                case 'H':
                    letter_H_drawing(delta, g);
                    delta += 3;
                    delta++;
                    break;
                case 'I':
                    letter_I_drawing(delta, g);
                    delta += 1;
                    delta++;
                    break;
                case 'J':
                    letter_J_drawing(delta, g);
                    delta += 3;
                    delta++;
                    break;
                case 'K':
                    letter_K_drawing(delta, g);
                    delta += 3;
                    delta++;
                    break;
                case 'L':
                    letter_L_drawing(delta, g);
                    delta += 3;
                    delta++;
                    break;
                case 'M':
                    letter_M_drawing(delta, g);
                    delta += 5;
                    delta++;
                    break;
                case 'N':
                    letter_N_drawing(delta, g);
                    delta += 4;
                    delta++;
                    break;
                case 'O':
                    letter_O_drawing(delta, g);
                    delta += 3;
                    delta++;
                    break;
                case 'P':
                    letter_P_drawing(delta, g);
                    delta += 3;
                    delta++;
                    break;
                case 'Q':
                    letter_Q_drawing(delta, g);
                    delta += 4;
                    delta++;
                    break;
                case 'R':
                    letter_R_drawing(delta, g);
                    delta += 3;
                    delta++;
                    break;
                case 'S':
                    letter_S_drawing(delta, g);
                    delta += 3;
                    delta++;
                    break;
                case 'T':
                    letter_T_drawing(delta, g);
                    delta += 3;
                    delta++;
                    break;
                case 'U':
                    letter_U_drawing(delta, g);
                    delta += 3;
                    delta++;
                    break;
                case 'V':
                    letter_V_drawing(delta, g);
                    delta += 3;
                    delta++;
                    break;
                case 'W':
                    letter_W_drawing(delta, g);
                    delta += 5;
                    delta++;
                    break;
                case 'X':
                    letter_X_drawing(delta, g);
                    delta += 3;
                    delta++;
                    break;
                case 'Y':
                    letter_Y_drawing(delta, g);
                    delta += 3;
                    delta++;
                    break;
                case 'Z':
                    letter_Z_drawing(delta, g);
                    delta += 3;
                    delta++;
                    break;
                case ' ':
                    delta += 1;
                    delta++;
                    break;
                case '0':
                    digit_0_drawing(delta, g);
                    delta += 3;
                    delta++;
                    break;
                case '1':
                    digit_1_drawing(delta, g);
                    delta += 3;
                    delta++;
                    break;
                case '2':
                    digit_2_drawing(delta, g);
                    delta += 3;
                    delta++;
                    break;
                case '3':
                    digit_3_drawing(delta, g);
                    delta += 3;
                    delta++;
                    break;
                case '4':
                    digit_4_drawing(delta, g);
                    delta += 3;
                    delta++;
                    break;
                case '5':
                    digit_5_drawing(delta, g);
                    delta += 3;
                    delta++;
                    break;
                case '6':
                    digit_6_drawing(delta, g);
                    delta += 3;
                    delta++;
                    break;
                case '7':
                    digit_7_drawing(delta, g);
                    delta += 3;
                    delta++;
                    break;
                case '8':
                    digit_8_drawing(delta, g);
                    delta += 3;
                    delta++;
                    break;
                case '9':
                    digit_9_drawing(delta, g);
                    delta += 3;
                    delta++;
                    break;
            }
        }
    }

    //рисование поля
    void paint(Color bgColor, Color textColor, String text, Graphics g) {
        this.text = text;
        paint(bgColor, textColor, g);
    }

    //удаление текста
    void erase(MainFrame mainFrame, Graphics g) {
        g.setColor(mainFrame.getFrameColor());
        g.fillRect(x0, y0,size_x * cellSize + 1,size_y * cellSize + 1);
    }

    //рисование буквы "A"
    private void letter_A_drawing(int delta, Graphics g) {
        partDrawing(1 + delta,1, g);
        partDrawing(1 + delta,2, g);
        partDrawing(1 + delta,3, g);
        partDrawing(1 + delta,4, g);
        partDrawing(1 + delta,5, g);

        partDrawing(2 + delta,3, g);
        partDrawing(2 + delta,5, g);

        partDrawing(3 + delta,1, g);
        partDrawing(3 + delta,2, g);
        partDrawing(3 + delta,3, g);
        partDrawing(3 + delta,4, g);
        partDrawing(3 + delta,5, g);
    }

    //рисование буквы "B"
    private void letter_B_drawing(int delta, Graphics g) {
        partDrawing(1 + delta,1, g);
        partDrawing(1 + delta,2, g);
        partDrawing(1 + delta,3, g);
        partDrawing(1 + delta,4, g);
        partDrawing(1 + delta,5, g);

        partDrawing(2 + delta,1, g);
        partDrawing(2 + delta,3, g);
        partDrawing(2 + delta,5, g);

        partDrawing(3 + delta,1, g);
        partDrawing(3 + delta,2, g);
        partDrawing(3 + delta,3, g);
        partDrawing(3 + delta,4, g);
        partDrawing(3 + delta,5, g);
    }

    //рисование буквы "C"
    private void letter_C_drawing(int delta, Graphics g) {
        partDrawing(1 + delta,1, g);
        partDrawing(1 + delta,2, g);
        partDrawing(1 + delta,3, g);
        partDrawing(1 + delta,4, g);
        partDrawing(1 + delta,5, g);

        partDrawing(2 + delta,1, g);
        partDrawing(2 + delta,5, g);

        partDrawing(3 + delta,1, g);
        partDrawing(3 + delta,5, g);
    }

    //рисование буквы "D"
    private void letter_D_drawing(int delta, Graphics g) {
        partDrawing(1 + delta,1, g);
        partDrawing(1 + delta,2, g);
        partDrawing(1 + delta,3, g);
        partDrawing(1 + delta,4, g);
        partDrawing(1 + delta,5, g);

        partDrawing(2 + delta,1, g);
        partDrawing(2 + delta,5, g);

        partDrawing(3 + delta,2, g);
        partDrawing(3 + delta,3, g);
        partDrawing(3 + delta,4, g);
    }

    //рисование буквы "E"
    private void letter_E_drawing(int delta, Graphics g) {
        partDrawing(1 + delta,1, g);
        partDrawing(1 + delta,2, g);
        partDrawing(1 + delta,3, g);
        partDrawing(1 + delta,4, g);
        partDrawing(1 + delta,5, g);

        partDrawing(2 + delta,1, g);
        partDrawing(2 + delta,3, g);
        partDrawing(2 + delta,5, g);

        partDrawing(3 + delta,1, g);
        partDrawing(3 + delta,3, g);
        partDrawing(3 + delta,5, g);
    }

    //рисование буквы "F"
    private void letter_F_drawing(int delta, Graphics g) {
        partDrawing(1 + delta,1, g);
        partDrawing(1 + delta,2, g);
        partDrawing(1 + delta,3, g);
        partDrawing(1 + delta,4, g);
        partDrawing(1 + delta,5, g);

        partDrawing(2 + delta,3, g);
        partDrawing(2 + delta,5, g);

        partDrawing(3 + delta,3, g);
        partDrawing(3 + delta,5, g);
    }

    //рисование буквы "G"
    private void letter_G_drawing(int delta, Graphics g) {
        partDrawing(1 + delta, 1, g);
        partDrawing(1 + delta, 2, g);
        partDrawing(1 + delta, 3, g);
        partDrawing(1 + delta, 4, g);
        partDrawing(1 + delta, 5, g);

        partDrawing(2 + delta, 1, g);
        partDrawing(2 + delta, 5, g);

        partDrawing(3 + delta, 1, g);
        partDrawing(3 + delta, 2, g);
        partDrawing(3 + delta, 5, g);
    }

    //рисование буквы "H"
    private void letter_H_drawing(int delta, Graphics g) {
        partDrawing(1 + delta,1, g);
        partDrawing(1 + delta,2, g);
        partDrawing(1 + delta,3, g);
        partDrawing(1 + delta,4, g);
        partDrawing(1 + delta,5, g);

        partDrawing(2 + delta,3, g);

        partDrawing(3 + delta,1, g);
        partDrawing(3 + delta,2, g);
        partDrawing(3 + delta,3, g);
        partDrawing(3 + delta,4, g);
        partDrawing(3 + delta,5, g);
    }

    //рисование буквы "I"
    private void letter_I_drawing(int delta, Graphics g) {
        partDrawing(1 + delta,1, g);
        partDrawing(1 + delta,2, g);
        partDrawing(1 + delta,3, g);
        partDrawing(1 + delta,4, g);
        partDrawing(1 + delta,5, g);
    }

    //рисование буквы "J"
    private void letter_J_drawing(int delta, Graphics g) {
        partDrawing(1 + delta,1, g);
        partDrawing(1 + delta,2, g);

        partDrawing(2 + delta,1, g);

        partDrawing(3 + delta,1, g);
        partDrawing(3 + delta,2, g);
        partDrawing(3 + delta,3, g);
        partDrawing(3 + delta,4, g);
        partDrawing(3 + delta,5, g);
    }

    //рисование буквы "K"
    private void letter_K_drawing(int delta, Graphics g) {
        partDrawing(1 + delta,1, g);
        partDrawing(1 + delta,2, g);
        partDrawing(1 + delta,3, g);
        partDrawing(1 + delta,4, g);
        partDrawing(1 + delta,5, g);

        partDrawing(2 + delta,3, g);

        partDrawing(3 + delta,1, g);
        partDrawing(3 + delta,2, g);
        partDrawing(3 + delta,4, g);
        partDrawing(3 + delta,5, g);
    }

    //рисование буквы "L"
    private void letter_L_drawing(int delta, Graphics g) {
        partDrawing(1 + delta,1, g);
        partDrawing(1 + delta,2, g);
        partDrawing(1 + delta,3, g);
        partDrawing(1 + delta,4, g);
        partDrawing(1 + delta,5, g);

        partDrawing(2 + delta,1, g);

        partDrawing(3 + delta,1, g);
    }

    //рисование буквы "M"
    private void letter_M_drawing(int delta, Graphics g) {
        partDrawing(1 + delta,1, g);
        partDrawing(1 + delta,2, g);
        partDrawing(1 + delta,3, g);
        partDrawing(1 + delta,4, g);
        partDrawing(1 + delta,5, g);

        partDrawing(2 + delta,5, g);

        partDrawing(3 + delta,1, g);
        partDrawing(3 + delta,2, g);
        partDrawing(3 + delta,3, g);
        partDrawing(3 + delta,4, g);
        partDrawing(3 + delta,5, g);

        partDrawing(4 + delta,5, g);

        partDrawing(5 + delta,1, g);
        partDrawing(5 + delta,2, g);
        partDrawing(5 + delta,3, g);
        partDrawing(5 + delta,4, g);
        partDrawing(5 + delta,5, g);
    }

    //рисование буквы "N"
    private void letter_N_drawing(int delta, Graphics g) {
        partDrawing(1 + delta,1, g);
        partDrawing(1 + delta,2, g);
        partDrawing(1 + delta,3, g);
        partDrawing(1 + delta,4, g);
        partDrawing(1 + delta,5, g);

        partDrawing(2 + delta,4, g);

        partDrawing(3 + delta,3, g);

        partDrawing(4 + delta,1, g);
        partDrawing(4 + delta,2, g);
        partDrawing(4 + delta,3, g);
        partDrawing(4 + delta,4, g);
        partDrawing(4 + delta,5, g);
    }

    //рисование буквы "O"
    private void letter_O_drawing(int delta, Graphics g) {
        partDrawing(1 + delta,1, g);
        partDrawing(1 + delta,2, g);
        partDrawing(1 + delta,3, g);
        partDrawing(1 + delta,4, g);
        partDrawing(1 + delta,5, g);

        partDrawing(2 + delta,1, g);
        partDrawing(2 + delta,5, g);

        partDrawing(3 + delta,1, g);
        partDrawing(3 + delta,2, g);
        partDrawing(3 + delta,3, g);
        partDrawing(3 + delta,4, g);
        partDrawing(3 + delta,5, g);
    }

    //рисование буквы "P"
    private void letter_P_drawing(int delta, Graphics g) {
        partDrawing(1 + delta,1, g);
        partDrawing(1 + delta,2, g);
        partDrawing(1 + delta,3, g);
        partDrawing(1 + delta,4, g);
        partDrawing(1 + delta,5, g);

        partDrawing(2 + delta,3, g);
        partDrawing(2 + delta,5, g);

        partDrawing(3 + delta,3, g);
        partDrawing(3 + delta,4, g);
        partDrawing(3 + delta,5, g);
    }

    //рисование буквы "Q"
    private void letter_Q_drawing(int delta, Graphics g) {
        partDrawing(1 + delta,1, g);
        partDrawing(1 + delta,2, g);
        partDrawing(1 + delta,3, g);
        partDrawing(1 + delta,4, g);
        partDrawing(1 + delta,5, g);

        partDrawing(2 + delta,1, g);
        partDrawing(2 + delta,5, g);

        partDrawing(3 + delta,1, g);
        partDrawing(3 + delta,2, g);
        partDrawing(3 + delta,3, g);
        partDrawing(3 + delta,4, g);
        partDrawing(3 + delta,5, g);

        partDrawing(4 + delta,1, g);
    }

    //рисование буквы "R"
    private void letter_R_drawing(int delta, Graphics g) {
        partDrawing(1 + delta,1, g);
        partDrawing(1 + delta,2, g);
        partDrawing(1 + delta,3, g);
        partDrawing(1 + delta,4, g);
        partDrawing(1 + delta,5, g);

        partDrawing(2 + delta,3, g);
        partDrawing(2 + delta,5, g);

        partDrawing(3 + delta,1, g);
        partDrawing(3 + delta,2, g);
        partDrawing(3 + delta,4, g);
        partDrawing(3 + delta,5, g);
    }

    //рисование буквы "S"
    private void letter_S_drawing(int delta, Graphics g) {
        partDrawing(1 + delta,1, g);
        partDrawing(1 + delta,3, g);
        partDrawing(1 + delta,4, g);
        partDrawing(1 + delta,5, g);

        partDrawing(2 + delta,1, g);
        partDrawing(2 + delta,3, g);
        partDrawing(2 + delta,5, g);

        partDrawing(3 + delta,1, g);
        partDrawing(3 + delta,2, g);
        partDrawing(3 + delta,3, g);
        partDrawing(3 + delta,5, g);
    }

    //рисование буквы "T"
    private void letter_T_drawing(int delta, Graphics g) {
        partDrawing(1 + delta,5, g);

        partDrawing(2 + delta,1, g);
        partDrawing(2 + delta,2, g);
        partDrawing(2 + delta,3, g);
        partDrawing(2 + delta,4, g);
        partDrawing(2 + delta,5, g);

        partDrawing(3 + delta,5, g);
    }

    //рисование буквы "U"
    private void letter_U_drawing(int delta, Graphics g) {
        partDrawing(1 + delta,1, g);
        partDrawing(1 + delta,2, g);
        partDrawing(1 + delta,3, g);
        partDrawing(1 + delta,4, g);
        partDrawing(1 + delta,5, g);

        partDrawing(2 + delta,1, g);

        partDrawing(3 + delta,1, g);
        partDrawing(3 + delta,2, g);
        partDrawing(3 + delta,3, g);
        partDrawing(3 + delta,4, g);
        partDrawing(3 + delta,5, g);
    }

    //рисование буквы "V"
    private void letter_V_drawing(int delta, Graphics g) {
        partDrawing(1 + delta,2, g);
        partDrawing(1 + delta,3, g);
        partDrawing(1 + delta,4, g);
        partDrawing(1 + delta,5, g);

        partDrawing(2 + delta,1, g);

        partDrawing(3 + delta,2, g);
        partDrawing(3 + delta,3, g);
        partDrawing(3 + delta,4, g);
        partDrawing(3 + delta,5, g);
    }

    //рисование буквы "W"
    private void letter_W_drawing(int delta, Graphics g) {
        partDrawing(1 + delta,2, g);
        partDrawing(1 + delta,3, g);
        partDrawing(1 + delta,4, g);
        partDrawing(1 + delta,5, g);

        partDrawing(2 + delta,1, g);

        partDrawing(3 + delta,2, g);
        partDrawing(3 + delta,3, g);
        partDrawing(3 + delta,4, g);
        partDrawing(3 + delta,5, g);

        partDrawing(4 + delta,1, g);

        partDrawing(5 + delta,2, g);
        partDrawing(5 + delta,3, g);
        partDrawing(5 + delta,4, g);
        partDrawing(5 + delta,5, g);
    }

    //рисование буквы "X"
    private void letter_X_drawing(int delta, Graphics g) {
        partDrawing(1 + delta,1, g);
        partDrawing(1 + delta,2, g);
        partDrawing(1 + delta,4, g);
        partDrawing(1 + delta,5, g);

        partDrawing(2 + delta,3, g);

        partDrawing(3 + delta,1, g);
        partDrawing(3 + delta,2, g);
        partDrawing(3 + delta,4, g);
        partDrawing(3 + delta,5, g);
    }

    //рисование буквы "Y"
    private void letter_Y_drawing(int delta, Graphics g) {
        partDrawing(1 + delta,4, g);
        partDrawing(1 + delta,5, g);

        partDrawing(2 + delta,1, g);
        partDrawing(2 + delta,2, g);
        partDrawing(2 + delta,3, g);

        partDrawing(3 + delta,4, g);
        partDrawing(3 + delta,5, g);
    }

    //рисование буквы "Z"
    private void letter_Z_drawing(int delta, Graphics g) {
        partDrawing(1 + delta,1, g);
        partDrawing(1 + delta,2, g);
        partDrawing(1 + delta,5, g);

        partDrawing(2 + delta,1, g);
        partDrawing(2 + delta,3, g);
        partDrawing(2 + delta,5, g);

        partDrawing(3 + delta,1, g);
        partDrawing(3 + delta,4, g);
        partDrawing(3 + delta,5, g);
    }

    //рисование цифры "0"
    private void digit_0_drawing(int delta, Graphics g) {
        partDrawing(1 + delta,1, g);
        partDrawing(1 + delta,2, g);
        partDrawing(1 + delta,3, g);
        partDrawing(1 + delta,4, g);
        partDrawing(1 + delta,5, g);

        partDrawing(2 + delta,1, g);
        partDrawing(2 + delta,5, g);

        partDrawing(3 + delta,1, g);
        partDrawing(3 + delta,2, g);
        partDrawing(3 + delta,3, g);
        partDrawing(3 + delta,4, g);
        partDrawing(3 + delta,5, g);
    }

    //рисование цифры "1"
    private void digit_1_drawing(int delta, Graphics g) {
        partDrawing(1 + delta,1, g);
        partDrawing(1 + delta,4, g);

        partDrawing(2 + delta,1, g);
        partDrawing(2 + delta,2, g);
        partDrawing(2 + delta,3, g);
        partDrawing(2 + delta,4, g);
        partDrawing(2 + delta,5, g);

        partDrawing(3 + delta,1, g);
    }

    //рисование цифры "2"
    private void digit_2_drawing(int delta, Graphics g) {
        partDrawing(1 + delta,1, g);
        partDrawing(1 + delta,2, g);
        partDrawing(1 + delta,3, g);
        partDrawing(1 + delta,5, g);

        partDrawing(2 + delta,1, g);
        partDrawing(2 + delta,3, g);
        partDrawing(2 + delta,5, g);

        partDrawing(3 + delta,1, g);
        partDrawing(3 + delta,3, g);
        partDrawing(3 + delta,4, g);
        partDrawing(3 + delta,5, g);
    }

    //рисование цифры "3"
    private void digit_3_drawing(int delta, Graphics g) {
        partDrawing(1 + delta,1, g);
        partDrawing(1 + delta,3, g);
        partDrawing(1 + delta,5, g);

        partDrawing(2 + delta,1, g);
        partDrawing(2 + delta,3, g);
        partDrawing(2 + delta,5, g);

        partDrawing(3 + delta,1, g);
        partDrawing(3 + delta,2, g);
        partDrawing(3 + delta,3, g);
        partDrawing(3 + delta,4, g);
        partDrawing(3 + delta,5, g);
    }

    //рисование цифры "4"
    private void digit_4_drawing(int delta, Graphics g) {
        partDrawing(1 + delta,3, g);
        partDrawing(1 + delta,4, g);
        partDrawing(1 + delta,5, g);

        partDrawing(2 + delta,3, g);

        partDrawing(3 + delta,1, g);
        partDrawing(3 + delta,2, g);
        partDrawing(3 + delta,3, g);
        partDrawing(3 + delta,4, g);
        partDrawing(3 + delta,5, g);
    }

    //рисование цифры "5"
    private void digit_5_drawing(int delta, Graphics g) {
        partDrawing(1 + delta,1, g);
        partDrawing(1 + delta,3, g);
        partDrawing(1 + delta,4, g);
        partDrawing(1 + delta,5, g);

        partDrawing(2 + delta,1, g);
        partDrawing(2 + delta,3, g);
        partDrawing(2 + delta,5, g);

        partDrawing(3 + delta,1, g);
        partDrawing(3 + delta,2, g);
        partDrawing(3 + delta,3, g);
        partDrawing(3 + delta,5, g);
    }

    //рисование цифры "6"
    private void digit_6_drawing(int delta, Graphics g) {
        partDrawing(1 + delta,1, g);
        partDrawing(1 + delta,2, g);
        partDrawing(1 + delta,3, g);
        partDrawing(1 + delta,4, g);
        partDrawing(1 + delta,5, g);

        partDrawing(2 + delta,1, g);
        partDrawing(2 + delta,3, g);
        partDrawing(2 + delta,5, g);

        partDrawing(3 + delta,1, g);
        partDrawing(3 + delta,2, g);
        partDrawing(3 + delta,3, g);
        partDrawing(3 + delta,5, g);
    }

    //рисование цифры "7"
    private void digit_7_drawing(int delta, Graphics g) {
        partDrawing(1 + delta,5, g);

        partDrawing(2 + delta,5, g);

        partDrawing(3 + delta,1, g);
        partDrawing(3 + delta,2, g);
        partDrawing(3 + delta,3, g);
        partDrawing(3 + delta,4, g);
        partDrawing(3 + delta,5, g);
    }

    //рисование цифры "8"
    private void digit_8_drawing(int delta, Graphics g) {
        partDrawing(1 + delta,1, g);
        partDrawing(1 + delta,2, g);
        partDrawing(1 + delta,3, g);
        partDrawing(1 + delta,4, g);
        partDrawing(1 + delta,5, g);

        partDrawing(2 + delta,1, g);
        partDrawing(2 + delta,3, g);
        partDrawing(2 + delta,5, g);

        partDrawing(3 + delta,1, g);
        partDrawing(3 + delta,2, g);
        partDrawing(3 + delta,3, g);
        partDrawing(3 + delta,4, g);
        partDrawing(3 + delta,5, g);
    }

    //рисование цифры "9"
    private void digit_9_drawing(int delta, Graphics g) {
        partDrawing(1 + delta,1, g);
        partDrawing(1 + delta,3, g);
        partDrawing(1 + delta,4, g);
        partDrawing(1 + delta,5, g);

        partDrawing(2 + delta,1, g);
        partDrawing(2 + delta,3, g);
        partDrawing(2 + delta,5, g);

        partDrawing(3 + delta,1, g);
        partDrawing(3 + delta,2, g);
        partDrawing(3 + delta,3, g);
        partDrawing(3 + delta,4, g);
        partDrawing(3 + delta,5, g);
    }

    //рисование клетки
    private void partDrawing(int location_x, int location_y, Graphics g) {
        int x = x0 + 1 + (location_x - 1) * cellSize;
        int y = y0 + 1 + (size_y - location_y) * cellSize;
        g.fillRect(x, y,cellSize - 1,cellSize - 1);
    }

    //получение координаты левого верхнего угла области рисования
    int getX0() {
        return x0;
    }

    //получение координаты левого верхнего угла области рисования
    int getY0() {
        return y0;
    }

    //получение размера области рисования в клетках
    int getSize_x() {
        return size_x;
    }

    //получение размера области рисования в клетках
    int getSize_y() {
        return size_y;
    }

    //получение размера клетки области рисования
    int getCellSize() {
        return cellSize;
    }

    //получение цвета фона области рисования
    static Color getBgColor() {
        return bgColor;
    }

    //получение цвета текста
    static Color getTextColor1() {
        return textColor1;
    }

    //получение цвета текста
    static Color getTextColor2() {
        return textColor2;
    }

    //получение цвета текста
    static Color getTextColor3() {
        return textColor3;
    }

    //получение цвета текста
    static Color getTextColor4() {
        return textColor4;
    }
}