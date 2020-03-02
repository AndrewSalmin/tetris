package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MainFrame extends JFrame implements ActionListener, KeyListener, MouseListener, MouseMotionListener {

    //игровое поле
    private MainField mainField = new MainField(16,40,16,16,30);
    //вспомогательное поле, на котором показывается следующая фигура
    private AuxiliaryField auxiliaryField = new AuxiliaryField(520,40,4,4,30);
    //фигура
    private Figure figure = new Figure(mainField);
    //графический таймер, отсчитывающий время, выделенное на ход
    private GraphicTimer graphicTimer = new GraphicTimer(536,180,9,5,10,5,100);

    //таймер, определяющий скорость перемещения фигуры
    private Timer timerMoving = new Timer(1000,this);
    //таймер, отсчитывающий время, выделенное на ход
    private Timer timerMove = new Timer(graphicTimer.getStep(),this);

    //надпись "NEW GAME"
    private TetrisText newGameText = new TetrisText(512,255,4,"NEW GAME");
    //надпись "POINTS"
    private TetrisText pointsCapture = new TetrisText(537,300,4,"POINTS");
    //надпись с числом очков
    private TetrisText pointsText = new TetrisText(541,330,4,"00000");
    //надпись "LEVEL"
    private TetrisText levelCapture = new TetrisText(541,365,4,"LEVEL");
    //надпись с уровнем
    private TetrisText levelText = new TetrisText(565,395,4,"01");
    //надпись режима игры "modern"
    private TetrisText modernText = new TetrisText(539,430,3,"MODERN");
    //надпись режима игры "classic"
    private TetrisText classicText = new TetrisText(540,455,3,"CLASSIC");
    //надпись "PAUSE"
    private TetrisText pauseText = new TetrisText(540,490,4,"PAUSE");
    //надпись "GAME OVER"
    private TetrisText gameOverText = new TetrisText(510,490,4,"GAME OVER");

    //режим игры
    private String mode = "modern";
    //переменная, показывающая начало игры
    private boolean startPosition = true;
    //переменная, показывающая паузу
    private boolean pause = false;
    //переменная, показывающая конец игры
    private boolean gameOver = false;
    //очки
    private int points = 0;
    //уровень
    private int level = 1;

    //цвет фона фрейма
    private Color frameColor = new Color(0,0,100);

    //переменные для метода mouseMoved
    private boolean newGame = false;
    private boolean modern = false;
    private boolean classic = false;

    MainFrame() {
        String mainTitle = "Tetris v1.0";
        setTitle(mainTitle);
        setSize(670,540);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

        setLocationRelativeTo(null);

        addKeyListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);

        timerMoving.start();
        timerMove.start();

        //запуск фигуры
        figure.launch(this, mainField, auxiliaryField, figure, getGraphics());
    }

    //рисование на фрейме полей, фигур и т.д.
    @Override
    public void paint(Graphics g) {
        //рисование фона фрейма
        g.setColor(frameColor);
        g.fillRect(0,0, this.getWidth(), this.getHeight());

        //рисование игрового поля
        mainField.paint(g);
        //рисование вспомогательного поля
        auxiliaryField.paint(g);

        //рисование установленных фигур
        mainField.figuresDrawing(figure, g);

        //рисование текущей и следующей фигур
        if(!isStartPosition()) {
            //выбор цвета для рисования текущей фигуры
            figure.colorSetting(figure.getCurrentFigure(), g);
            //рисование текущей фигуры
            figure.draw(mainField, g);
            //рисование следующей фигуры
            auxiliaryField.figuresDrawing(figure, g);
        }

        //рисование графического таймера
        graphicTimer.paint(this, g);

        //рисование надписи "NEW GAME"
        newGameText.paint(frameColor, TetrisText.getTextColor1(), g);
        //рисование надписи "POINTS"
        pointsCapture.paint(frameColor, TetrisText.getTextColor2(), g);
        //рисование числа очков
        pointsText.paint(frameColor, TetrisText.getTextColor2(), g);
        //рисование надписи "LEVEL"
        levelCapture.paint(frameColor, TetrisText.getTextColor2(), g);
        //рисование уровня
        levelText.paint(frameColor, TetrisText.getTextColor2(), g);

        if(mode == "modern") {
            //рисование надписи "MODERN"
            modernText.paint(frameColor, TetrisText.getTextColor3(), g);
            //рисование надписи "CLASSIC"
            classicText.paint(frameColor, TetrisText.getTextColor2(), g);
        } else {
            //рисование надписи "MODERN"
            modernText.paint(frameColor, TetrisText.getTextColor2(), g);
            //рисование надписи "CLASSIC"
            classicText.paint(frameColor, TetrisText.getTextColor3(), g);
        }

        //рисование надписи "PAUSE", если пауза
        if(isPause()) pauseText.paint(frameColor, TetrisText.getTextColor4(), g);

        //рисование надписи "GAME OVER", если GAME OVER
        if(isGameOver()) gameOverText.paint(frameColor, TetrisText.getTextColor4(), g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == timerMoving) figure.move(this, mainField, auxiliaryField, figure, graphicTimer, getGraphics());
        if(e.getSource() == timerMove) graphicTimer.dec(this, mainField, auxiliaryField, figure, graphicTimer, getGraphics());
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        //если не пауза и не GAME OVER, то фигуру можно перемещать и поворачивать
        if(!isPause() && !isGameOver()) {
            //нажатие клавиш "Вправо", "Влево", "Вверх", "Вниз"
            if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_LEFT ||
               e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN)
                timerMoving.restart(); //перезапуск таймера, чтобы не было "двойных" перемещений

            switch(e.getKeyCode()) {
                case KeyEvent.VK_RIGHT:
                    if(figure.getDirection() != "RIGHT") figure.setDirection("RIGHT");
                    figure.move(this, mainField, auxiliaryField, figure, graphicTimer, getGraphics());
                    break;
                case KeyEvent.VK_LEFT:
                    if(figure.getDirection() != "LEFT") figure.setDirection("LEFT");
                    figure.move(this, mainField, auxiliaryField, figure, graphicTimer, getGraphics());
                    break;
                case KeyEvent.VK_UP:
                    if(figure.getDirection() != "UP") figure.setDirection("UP");
                    figure.move(this, mainField, auxiliaryField, figure, graphicTimer, getGraphics());
                    break;
                case KeyEvent.VK_DOWN:
                    if(figure.getDirection() != "DOWN") figure.setDirection("DOWN");
                    figure.move(this, mainField, auxiliaryField, figure, graphicTimer, getGraphics());
                    break;
                case KeyEvent.VK_SPACE:
                    figure.rotate(mainField, getGraphics());
                    break;
            }
        }

        //нажатие клавиши "P" ("Пауза")
        if(e.getKeyCode() == KeyEvent.VK_P && !isGameOver()) {
            if(!isPause()) {
                setPause(true);
                timerMoving.stop();
                timerMove.stop();
            } else {
                setPause(false);
                timerMoving.restart();
                timerMove.restart();
            }
        }

        //нажатие клавиши "N" ("Новая игра")
        if(e.getKeyCode() == KeyEvent.VK_N) {
            //рисование полей
            mainField.paint(getGraphics());
            auxiliaryField.paint(getGraphics());
            //заполнение массива игрового поля
            for(int i = 0; i <= mainField.getSize_x() - 1; i++) {
                for(int j = 0; j <= mainField.getSize_y() - 1; j++) {
                    mainField.setFieldArray(i, j,0);
                }
            }
            //заполнение массива вспомогательного поля
            for(int i = 0; i <= auxiliaryField.getSize_x() - 1; i++) {
                for(int j = 0; j <= auxiliaryField.getSize_y() - 1; j++) {
                    auxiliaryField.setFieldArray(i, j,0);
                }
            }

            //запуск фигуры
            setStartPosition(true);
            figure.launch(this, mainField, auxiliaryField, figure, getGraphics());

            //сброс и перезапуск таймеров
            graphicTimer.restart(this, getGraphics());
            timerMoving.restart();
            timerMove.restart();

            //обнуление очков и установка первого уровня
            pointsReset();
            levelReset();

            //установка переменных "pause" и "gameOver" в "false", если необходимо
            if(isPause()) setPause(false);
            if(isGameOver()) setGameOver(false);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
        //нажатие надписи "NEW GAME"
        if(e.getX() >= newGameText.getX0() && e.getX() <= newGameText.getX0() + newGameText.getSize_x() * newGameText.getCellSize() &&
           e.getY() >= newGameText.getY0() && e.getY() <= newGameText.getY0() + newGameText.getSize_y() * newGameText.getCellSize()) {
            //рисование полей
            mainField.paint(getGraphics());
            auxiliaryField.paint(getGraphics());

            //заполнение массива игрового поля
            for(int i = 0; i <= mainField.getSize_x() - 1; i++) {
                for(int j = 0; j <= mainField.getSize_y() - 1; j++) {
                    mainField.setFieldArray(i, j,0);
                }
            }
            //заполнение массива вспомогательного поля
            for(int i = 0; i <= auxiliaryField.getSize_x() - 1; i++) {
                for(int j = 0; j <= auxiliaryField.getSize_y() - 1; j++) {
                    auxiliaryField.setFieldArray(i, j,0);
                }
            }

            //запуск фигуры
            setStartPosition(true);
            figure.launch(this, mainField, auxiliaryField, figure, getGraphics());

            //сброс и перезапуск таймеров
            graphicTimer.restart(this, getGraphics());
            timerMoving.restart();
            timerMove.restart();

            //обнуление очков и установка первого уровня
            pointsReset();
            levelReset();

            //установка переменных "pause" и "gameOver" в "false", если необходимо
            if(isPause()) setPause(false);
            if(isGameOver()) setGameOver(false);
        }

        //нажатие надписи "MODERN"
        if(e.getX() >= modernText.getX0() && e.getX() <= modernText.getX0() + modernText.getSize_x() * modernText.getCellSize() &&
           e.getY() >= modernText.getY0() && e.getY() <= modernText.getY0() + modernText.getSize_y() * modernText.getCellSize()) {
            mode = "modern";
            modernText.paint(TetrisText.getBgColor(), TetrisText.getTextColor3(), getGraphics());
            classicText.paint(frameColor, TetrisText.getTextColor2(), getGraphics());
        }

        //нажатие надписи "CLASSIC"
        if(e.getX() >= classicText.getX0() && e.getX() <= classicText.getX0() + classicText.getSize_x() * classicText.getCellSize() &&
           e.getY() >= classicText.getY0() && e.getY() <= classicText.getY0() + classicText.getSize_y() * classicText.getCellSize()) {
            mode = "classic";
            classicText.paint(TetrisText.getBgColor(), TetrisText.getTextColor3(), getGraphics());
            modernText.paint(frameColor, TetrisText.getTextColor2(), getGraphics());
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {
        //наведение курсора на надпись "NEW GAME"
        if(!newGame &&
           e.getX() >= newGameText.getX0() && e.getX() <= newGameText.getX0() + newGameText.getSize_x() * newGameText.getCellSize() &&
           e.getY() >= newGameText.getY0() && e.getY() <= newGameText.getY0() + newGameText.getSize_y() * newGameText.getCellSize()) {
            newGameText.paint(TetrisText.getBgColor(), TetrisText.getTextColor1(), getGraphics());
            newGame = true;
        }
        if(newGame &&
           !(e.getX() >= newGameText.getX0() && e.getX() <= newGameText.getX0() + newGameText.getSize_x() * newGameText.getCellSize() &&
           e.getY() >= newGameText.getY0() && e.getY() <= newGameText.getY0() + newGameText.getSize_y() * newGameText.getCellSize())) {
            newGameText.paint(frameColor, TetrisText.getTextColor1(), getGraphics());
            newGame = false;
        }

        //наведение курсора на надпись "MODERN"
        if(!modern &&
           e.getX() >= modernText.getX0() && e.getX() <= modernText.getX0() + modernText.getSize_x() * modernText.getCellSize() &&
           e.getY() >= modernText.getY0() && e.getY() <= modernText.getY0() + modernText.getSize_y() * modernText.getCellSize()) {
            if(mode == "modern") {
                modernText.paint(TetrisText.getBgColor(), TetrisText.getTextColor3(), getGraphics());
            } else {
                modernText.paint(TetrisText.getBgColor(), TetrisText.getTextColor2(), getGraphics());
            }
            modern = true;
        }
        if(modern &&
           !(e.getX() >= modernText.getX0() && e.getX() <= modernText.getX0() + modernText.getSize_x() * modernText.getCellSize() &&
           e.getY() >= modernText.getY0() && e.getY() <= modernText.getY0() + modernText.getSize_y() * modernText.getCellSize())) {
            if(mode == "modern") {
                modernText.paint(frameColor, TetrisText.getTextColor3(), getGraphics());
            } else {
                modernText.paint(frameColor, TetrisText.getTextColor2(), getGraphics());
            }
            modern = false;
        }

        //наведение курсора на надпись "CLASSIC"
        if(!classic &&
           e.getX() >= classicText.getX0() && e.getX() <= classicText.getX0() + classicText.getSize_x() * classicText.getCellSize() &&
           e.getY() >= classicText.getY0() && e.getY() <= classicText.getY0() + classicText.getSize_y() * classicText.getCellSize()) {
            if(mode == "classic") {
                classicText.paint(TetrisText.getBgColor(), TetrisText.getTextColor3(), getGraphics());
            } else {
                classicText.paint(TetrisText.getBgColor(), TetrisText.getTextColor2(), getGraphics());
            }
            classic = true;
        }
        if(classic &&
           !(e.getX() >= classicText.getX0() && e.getX() <= classicText.getX0() + classicText.getSize_x() * classicText.getCellSize() &&
           e.getY() >= classicText.getY0() && e.getY() <= classicText.getY0() + classicText.getSize_y() * classicText.getCellSize())) {
            if(mode == "classic") {
                classicText.paint(frameColor, TetrisText.getTextColor3(), getGraphics());
            } else {
                classicText.paint(frameColor, TetrisText.getTextColor2(), getGraphics());
            }
            classic = false;
        }
    }

    //получение режима игры (classic/modern)
    String getMode() {
        return mode;
    }

    //установка статуса игры (начало/не начало)
    void setStartPosition(boolean startPosition) {
        this.startPosition = startPosition;
    }

    //получение статуса игры (начало/не начало)
    boolean isStartPosition() {
        return startPosition;
    }

    //установка статуса игры (пауза/не пауза)
    private void setPause(boolean pause) {
        this.pause = pause;
        if(pause) pauseText.paint(frameColor, TetrisText.getTextColor4(), getGraphics());
        else pauseText.erase(this, getGraphics());
    }

    //получение статуса игры (пауза/не пауза)
    private boolean isPause() {
        return pause;
    }

    //установка статуса игры (конец/не конец)
    private void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
        if(gameOver) gameOverText.paint(frameColor, TetrisText.getTextColor4(), getGraphics());
        else gameOverText.erase(this, getGraphics());
    }

    //получение статуса игры (конец/не конец)
    private boolean isGameOver() {
        return gameOver;
    }

    //увеличение очков
    void pointsIncrease(int inc) {
        points = points + inc;

        if(points < 100) {
            pointsText.paint(frameColor, TetrisText.getTextColor2(),"000" + Integer.toString(points), getGraphics());
        }
        if(points >= 100 && points < 1000) {
            pointsText.paint(frameColor, TetrisText.getTextColor2(),"00" + Integer.toString(points), getGraphics());
        }
        if(points >= 1000 && points < 10000) {
            pointsText.paint(frameColor, TetrisText.getTextColor2(),"0" + Integer.toString(points), getGraphics());
        }
        if(points >= 10000) {
            pointsText.paint(frameColor, TetrisText.getTextColor2(), Integer.toString(points), getGraphics());
        }
    }

    //сброс очков
    private void pointsReset() {
        points = 0;
        pointsText.paint(frameColor, TetrisText.getTextColor2(),"00000", getGraphics());
    }

    //определение уровня
    void levelIncreasingChecking() {
        if(points >= 1000 && points < 2000 && level != 2) {
            timerMoving.setDelay(920);
            level = 2;
        }
        if(points >= 2000 && points < 3000 && level != 3) {
            timerMoving.setDelay(840);
            level = 3;
        }
        if(points >= 3000 && points < 4000 && level != 4) {
            timerMoving.setDelay(760);
            level = 4;
        }
        if(points >= 4000 && points < 5000 && level != 5) {
            timerMoving.setDelay(680);
            level = 5;
        }
        if(points >= 5000 && points < 6000 && level != 6) {
            timerMoving.setDelay(600);
            level = 6;
        }
        if(points >= 6000 && points < 7000 && level != 7) {
            timerMoving.setDelay(520);
            level = 7;
        }
        if(points >= 7000 && points < 8000 && level != 8) {
            timerMoving.setDelay(440);
            level = 8;
        }
        if(points >= 8000 && points < 9000 && level != 9) {
            timerMoving.setDelay(360);
            level = 9;
        }
        if(points >= 9000 && level != 10) {
            timerMoving.setDelay(280);
            level = 10;
        }

        if(level < 10) {
            levelText.paint(frameColor, TetrisText.getTextColor2(),"0" + Integer.toString(level), getGraphics());
        } else {
            levelText.paint(frameColor, TetrisText.getTextColor2(), Integer.toString(level), getGraphics());
        }
    }

    //сброс уровня
    private void levelReset() {
        level = 1;
        levelText.paint(frameColor, TetrisText.getTextColor2(),"01", getGraphics());
        timerMoving.setDelay(1000);
    }

    //проверка конца игры
    void gameOverChecking() {
        //проверка наложения одной фигуры на другую
        if(mainField.getFieldArray(figure.getPart1_location_x() - 1,figure.getPart1_location_y() - 1) != 0 ||
           mainField.getFieldArray(figure.getPart2_location_x() - 1,figure.getPart2_location_y() - 1) != 0 ||
           mainField.getFieldArray(figure.getPart3_location_x() - 1,figure.getPart3_location_y() - 1) != 0 ||
           (figure.getCurrentFigure() != 6 && figure.getCurrentFigure() != 7 && mainField.getFieldArray(figure.getPart4_location_x() - 1,figure.getPart4_location_y() - 1) != 0) ||
           (figure.getCurrentFigure() == 8 && mainField.getFieldArray(figure.getPart5_location_x() - 1,figure.getPart5_location_y() - 1) != 0)) {
            timerMoving.stop();
            timerMove.stop();

            //установка статуса игры "GAME OVER"
            setGameOver(true);
        }
    }

    //получение цвета фона фрейма
    Color getFrameColor() {
        return frameColor;
    }

    //озвучка
    void playSound() {

    }
}