package com.company;

import javax.sound.midi.SysexMessage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import static com.company.Main.convertToTime;
import static com.company.StartPage.*;

public class GamePage extends JFrame implements ActionListener, MouseListener{

    private JPanel panelTop = new JPanel();
    private JLabel labelTop2 = new JLabel();
    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();
    private JPanel panelBot = new JPanel();
    private JPanel buttonPanelBot = new JPanel();
    private JPanel resultPanel = new JPanel();
    private JLabel[] resultLabels;
    private JButton[] buttons = new JButton[8];
    private JLabel labelBot = new JLabel();
    private MyLabel[] label1;
    private JLabel[] label2;

    // GAMEPLAY
    private int pointer = 0;
    private Colours colours = new Colours();
    private Brushes brushes = new Brushes();
    private int w, h;
    private int originalTime;
    Random randomize;
    private int[] random;
    private int seconds;
    private JLabel labelTimer = new JLabel();
    private JButton buttonRestart = new JButton();
    private JButton buttonHome = new JButton();
    private boolean endOfGame;
    private boolean isGameMode1;
    private JLabel labelWin = new JLabel();
    private JLabel labelLost = new JLabel();

    // PICTURES
    private Picture[] buttPictures = new Picture[7];
    private Picture[] buttAnimPictures = new Picture[7];

    //********************************************************************************************************************************************************
    //********************************************************************************************************************************************************
    private Picture picLogo2 = new Picture(path1.toAbsolutePath().toString() + "/startpage/Untitled-2.png");
    private Picture picBackGround = new Picture(path1.toAbsolutePath().toString() + "/startpage/Untitled-3.png");
    private Picture picEmpty = new Picture(path1.toAbsolutePath().toString() + "/gamepage/Empty.png");
    private Picture buttBack = new Picture(path1.toAbsolutePath().toString() + "/gamepage/backButt.png");
    private Picture buttBackAnim = new Picture(path1.toAbsolutePath().toString() + "/gamepage/backButtAnim.png");
    private Picture picDoubleCheck = new Picture(path1.toAbsolutePath().toString() + "/gamepage/DoubleCheck.png");
    private Picture picCheck = new Picture(path1.toAbsolutePath().toString() + "/gamepage/Check.png");
    private Picture picFailCheck = new Picture(path1.toAbsolutePath().toString() + "/gamepage/failCheck.png");
    private Picture picRestart = new Picture(path1.toAbsolutePath().toString() + "/gamepage/Restart.png");
    private Picture picRestartAnim = new Picture(path1.toAbsolutePath().toString() + "/gamepage/RestartAnim.png");
    private Picture picHome = new Picture(path1.toAbsolutePath().toString() + "/gamepage/ButtHome.png");
    private Picture picHomeAnim = new Picture(path1.toAbsolutePath().toString() + "/gamepage/ButtHomeAnim.png");
    private Picture youWin = new Picture(path1.toAbsolutePath().toString() + "/gamepage/youWin.png");
    private Picture youLost = new Picture(path1.toAbsolutePath().toString() + "/gamepage/youLost.png");
    //********************************************************************************************************************************************************


    public GamePage(int diff1, int diff2, int time, boolean isMode1) {
        this.setSize(120*diff1+60, 60*diff2+280); //148
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("colourly");
        this.setResizable(false);
        this.getContentPane().setBackground(backGroundColor);
        this.setVisible(true);

        // GAMEPLAY
        w = diff1;
        h = diff2;
        isGameMode1 = isMode1;
        endOfGame = false;
        originalTime = time;
        random = new int[w];
        randomize = new Random();
        for (int i = 0; i < w; i++) {
            random[i] = randomize.nextInt(7);
        }
        System.out.print("//------------------------//\n         ");
        displayArray(random);
        System.out.println("//------------------------//");



        // TOP PANEL
        picHome.resizeImage(5);
        picHomeAnim.resizeImage(5);
        buttonHome.setBounds(diff1*120 - 28 , 40, 75, 75);
        buttonHome.setOpaque(false);
        buttonHome.addActionListener(this);
        buttonHome.addMouseListener(this);
        buttonHome.setContentAreaFilled(false);
        buttonHome.setBorderPainted(false);
        buttonHome.setIcon(picHome);
        
        picRestart.resizeImage(5);
        picRestartAnim.resizeImage(5);
        buttonRestart.setBounds(14, 40, 75, 75);
        buttonRestart.setOpaque(false);
        buttonRestart.addActionListener(this);
        buttonRestart.addMouseListener(this);
        buttonRestart.setContentAreaFilled(false);
        buttonRestart.setBorderPainted(false);
        buttonRestart.setIcon(picRestart);

        labelTimer.setBounds(60*diff1-20, 90, 100, 50);
        labelTimer.setForeground(plainTextColorAnim2);
        labelTimer.setHorizontalAlignment(JLabel.CENTER);
        labelTimer.setFont(font3);

        seconds = time;
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (seconds < 0) labelTimer.setText("0 : 00");
                else labelTimer.setText(convertToTime(seconds, " : "));
                if (time != 0 && seconds >= 0 && !endOfGame) {
                    seconds--;
                } else if (seconds < 3600 && time == 0 && !endOfGame){
                    seconds++;
                }
                if (seconds < 0 || seconds >= 3600) {
                    label1[pointer].setIcon(picEmpty);
                    endGame(false);
                }
            }
        };
        timer.scheduleAtFixedRate(task, 0, 1000);

        labelTop2.setBounds(60*diff1-120, 20, 400, 105);
        picLogo2.resizeImage(14);
        labelTop2.setIcon(picLogo2);
        picBackGround.resizeImage(50);
        panelTop.setBounds(0, 0, 120*diff1+60, 140);
        panelTop.setBackground(backGroundColor);
        panelTop.setLayout(null);
        panelTop.add(buttonRestart);
        panelTop.add(buttonHome);
        panelTop.add(labelTimer);
        panelTop.add(labelTop2);

        // BOTTOM PANEL
        panelBot.setBounds(0, 60*diff2+160, 120*diff1+60, 150);
        labelBot.setBounds(0, 0, 120*diff1+60, 60);
        panelBot.add(labelBot);
        panelBot.setBackground(backGroundColor);
        panelBot.setLayout(null);

        buttonPanelBot.setBounds(40+(diff1-4)*60, 0, 460, 60);
        buttonPanelBot.setLayout(new GridLayout(1, 8, 0, 0));
        buttonPanelBot.setBackground(backGroundColor);

        // BUTTONS ON BOTTOM PANEL
        for (int i = 0; i<8; i++) {
            buttons[i] = new JButton();
            buttons[i].setOpaque(false);
            buttons[i].addActionListener(this);
            buttons[i].addMouseListener(this);
            buttons[i].setContentAreaFilled(false);
            buttons[i].setBorderPainted(false);
            buttons[i].setVisible(true);
            buttonPanelBot.add(buttons[i]);
        }

        //********************************************************************************************************************************************************
        buttPictures[0] = new Picture(path1.toAbsolutePath().toString() + "/gamepage/RedButt.png");
        buttPictures[1] = new Picture(path1.toAbsolutePath().toString() + "/gamepage/OrangeButt.png");
        buttPictures[2] = new Picture(path1.toAbsolutePath().toString() + "/gamepage/YellowButt.png");
        buttPictures[3] = new Picture(path1.toAbsolutePath().toString() + "/gamepage/GreenButt.png");
        buttPictures[4] = new Picture(path1.toAbsolutePath().toString() + "/gamepage/BlueButt.png");
        buttPictures[5] = new Picture(path1.toAbsolutePath().toString() + "/gamepage/IndigoButt.png");
        buttPictures[6] = new Picture(path1.toAbsolutePath().toString() + "/gamepage/VioletButt.png");
        //********************************************************************************************************************************************************

        for (int i = 0; i < 7; i++) {
            buttPictures[i].resizeImage(5);
        }

        buttBack.resizeImage(5);
        buttBackAnim.resizeImage(5);
        buttons[7].setIcon(buttBackAnim);

        //********************************************************************************************************************************************************
        buttAnimPictures[0] = new Picture(path1.toAbsolutePath().toString() + "/gamepage/RedButtAnim.png");
        buttAnimPictures[1] = new Picture(path1.toAbsolutePath().toString() + "/gamepage/OrangeButtAnim.png");
        buttAnimPictures[2] = new Picture(path1.toAbsolutePath().toString() + "/gamepage/YellowButtAnim.png");
        buttAnimPictures[3] = new Picture(path1.toAbsolutePath().toString() + "/gamepage/GreenButtAnim.png");
        buttAnimPictures[4] = new Picture(path1.toAbsolutePath().toString() + "/gamepage/BlueButtAnim.png");
        buttAnimPictures[5] = new Picture(path1.toAbsolutePath().toString() + "/gamepage/IndigoButtAnim.png");
        buttAnimPictures[6] = new Picture(path1.toAbsolutePath().toString() + "/gamepage/VioletButtAnim.png");
        //********************************************************************************************************************************************************

        for (int i = 0; i < 7; i++) {
            buttAnimPictures[i].resizeImage(5);
            buttons[i].setIcon(buttAnimPictures[i]);

        }

        youWin.resizeImage(8);
        youLost.resizeImage(8);
        labelWin.setBounds(120, 0, 300, 65);
        labelWin.setHorizontalAlignment(JLabel.CENTER);
        labelWin.setIcon(youWin);
        labelLost.setBounds(310, 0, 200, 65);
        labelLost.setIcon(youLost);
        labelWin.setVisible(false);
        labelLost.setVisible(false);
        //////////////////////////////////////////////////////////////////////////////////
        resultPanel.setBounds(26, 0, w*60, 60);
        resultPanel.setBackground(backGroundColor);
        resultPanel.setLayout(new GridLayout(1, w));
        resultLabels = new JLabel[w];
        for (int i = 0; i < w; i++) {
            resultLabels[i] = new JLabel();
            resultLabels[i].setIcon(colours.getColourImage(random[i]));
            resultPanel.add(resultLabels[i]);
        }
        //////////////////////////////////////////////////////////////////////////////////
        panelBot.add(labelWin);
        panelBot.add(labelLost);
        panelBot.add(resultPanel);
        resultPanel.setVisible(false);
        panelBot.add(buttonPanelBot);

        // PANEL 1
        panel1.setBounds(20, 140, 60*diff1, 60*diff2);
        panel1.setBackground(backGroundColor);
        panel1.setLayout(new GridLayout(diff2, diff1, 0, 0));

        picEmpty.resizeImage(5);
        label1 = new MyLabel[diff1*diff2];
        for (int i = 0; i < diff1*diff2; i++) {
            label1[i] = new MyLabel();
            label1[i].setSize(60, 60);
            label1[i].setIcon(picEmpty);
            label1[i].setHorizontalAlignment(JLabel.CENTER);
            panel1.add(label1[i]);
        }
        label1[0].setIcon(brushes.getBasicBrush());

        // PANEL 2
        panel2.setBounds(diff1*60+40, 140, 60*diff1, 60*diff2);
        panel2.setBackground(backGroundColor);
        panel2.setLayout(new GridLayout(diff2, diff1, 0, 0));

        picFailCheck.resizeImage(5);
        picDoubleCheck.resizeImage(5);
        picCheck.resizeImage(5);
        label2 = new JLabel[diff1*diff2];
        for (int i = 0; i < diff1*diff2; i++) {
            label2[i] = new JLabel();
            label2[i].setSize(60, 60);
            label2[i].setIcon(picEmpty);
            label2[i].setHorizontalAlignment(JLabel.CENTER);
            panel2.add(label2[i]);
        }

        // ADDING TO FRAME
        this.add(panelTop);
        this.add(panelBot);
        this.add(panel1);
        this.add(panel2);

    }

    private void displayArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private int[] reverseArray(int[] arr) {
        for(int i = 0; i < arr.length / 2; i++)
        {
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
        return arr;
    }

    private boolean isInRow(int what) {
        for (int i = 0; i<w; i++) {
            if (what == random[i]) {
                return true;
            }
        }
        return false;
    }

    private void putChecks(int row) {
        int[] results = new int[w];
        int[] numColours = new int[7];
        int[] numColours2 = new int[7];

        for (int i = 0; i < 7; i++) numColours[i] = 0;
        for (int i = 0; i < 7; i++) numColours2[i] = 0;
        for (int i = 0; i < random.length; i++) numColours[random[i]]++;

        for (int i = 0; i < w; i++) {
            if (label1[row*w + i].getId() == random[i]) {
                numColours2[random[i]]++;
                results[i] = 2;
            }  else {
                results[i] = 0;
            }
        }
        for (int i = 0; i < w; i++) {
            if (isInRow(label1[row*w + i].getId()) && numColours2[label1[row*w + i].getId()] < numColours[label1[row*w + i].getId()] && results[i] != 2) {
                numColours2[label1[row*w + i].getId()]++;
                results[i] = 1;
            }
        }
        System.out.println("---------------------------------");
        displayArray(results);
        // ---------------------------------------------------------------------------------------------------
        if (isGameMode1) {
            Arrays.sort(results);
            results = reverseArray(results);
        }
        // ---------------------------------------------------------------------------------------------------

        for (int i = 0; i < w; i++) {
            switch (results[i]) {
                case 2:
                    label2[i+row*w].setIcon(picDoubleCheck);
                    break;
                case 1:
                    label2[i+row*w].setIcon(picCheck);
                    break;
                case 0:
                    label2[i+row*w].setIcon(picFailCheck);
                    break;
            }
        }
        if (hasWon(results)) endGame(true);
    }

    private boolean hasWon(int[] arr) {
        for (int num: arr) {
            if (num != 2) return false;
        }
        return true;
    }

    private void restartGame() {
        endOfGame = false;
        resultPanel.setVisible(false);
        buttonPanelBot.setVisible(true);
        seconds = originalTime;
        for (int i = 0; i < buttons.length-1; i++) {
            buttons[i].setEnabled(true);
            buttons[i].setVisible(true);
            buttons[i].setIcon(buttAnimPictures[i]);
        }
        buttons[7].setEnabled(true);
        buttons[7].setVisible(true);
        buttons[7].setIcon(buttBackAnim);
        for (int i = 0; i < w*h; i++) {
            label1[i].setIcon(picEmpty);
            label1[i].changeID(-1);
            label2[i].setIcon(picEmpty);
        }
        for (int i = 0; i < w; i++) {
            random[i] = randomize.nextInt(7);
            resultLabels[i].setIcon(colours.getColourImage(random[i]));
        }
        label1[0].setIcon(brushes.getBasicBrush());
        System.out.print("//------------------------//\n        ");
        displayArray(random);
        System.out.println("//------------------------//");
        pointer = 0;
        labelLost.setVisible(false);
        labelWin.setVisible(false);
    }

    private void endGame(boolean won) {
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setEnabled(false);
            buttons[i].setVisible(false);
        }
        endOfGame = true;
        if (!won) {
            resultPanel.setVisible(true);
            labelLost.setVisible(true);
        } else {
            labelWin.setVisible(true);
        }
        buttonPanelBot.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i<7; i++) {
            if (e.getSource() == buttons[i]) {
                label1[pointer].setIcon(colours.getColourImage(i));
                label1[pointer].changeID(i);
                pointer++;
                if (pointer % w == 0) {
                    putChecks(pointer / w - 1);
                }
                if (pointer >= w * h && !endOfGame) {
                    endGame(false);
                } else if (!endOfGame) {
                    label1[pointer].setIcon(brushes.getBrush(i));
                }
            }
        }
        if (e.getSource() == buttons[7] && pointer % w != 0) {
            label1[pointer].setIcon(picEmpty);
            pointer--;
            label1[pointer].setIcon(brushes.getBasicBrush());
            label1[pointer].changeID(-1);
        }
        if (e.getSource() == buttonRestart) {
            restartGame();
        }
        if (e.getSource() == buttonHome) {
            new StartPage();
            this.dispose();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }


    @Override
    public void mousePressed(MouseEvent e) {

    }


    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

        if (!endOfGame) {
            for (int i = 0; i < 7; i++) {
                if (e.getSource() == buttons[i]) {
                    buttons[i].setIcon(buttPictures[i]);
                    label1[pointer].setIcon(brushes.getBrush(i));
                }
            }
            if (e.getSource() == buttons[7]) {
                buttons[7].setIcon(buttBack);
            }
        }
        if (e.getSource() == buttonRestart) {
            buttonRestart.setIcon(picRestartAnim);
        }
        if (e.getSource() == buttonHome) {
            buttonHome.setIcon(picHomeAnim);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (!endOfGame) {
            for (int i = 0; i < 7; i++) {
                if (e.getSource() == buttons[i]) {
                    buttons[i].setIcon(buttAnimPictures[i]);
                    label1[pointer].setIcon(brushes.getBasicBrush());
                }
            }
            if (e.getSource() == buttons[7]) {
                buttons[7].setIcon(buttBackAnim);
            }
        }
        if (e.getSource() == buttonRestart) {
            buttonRestart.setIcon(picRestart);
        }
        if (e.getSource() == buttonHome) {
            buttonHome.setIcon(picHome);
        }
    }


}
