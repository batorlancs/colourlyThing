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
    private JButton buttonRestart = new JButton("restart");

    // PICTURES
    private Picture[] buttPictures = new Picture[7];
    private Picture[] buttAnimPictures = new Picture[7];
    //********************************************************************************************************************************************************
//    private Picture picEmpty = new Picture("/Users/camohinthisb1/IdeaProjects/colourlyThing/src/com/company/Empty.png");
//    private Picture picBackGround = new Picture("/Users/camohinthisb1/IdeaProjects/colourlyThing/src/com/company/Untitled-3.png");
//    private Picture buttBack = new Picture("/Users/camohinthisb1/IdeaProjects/colourlyThing/src/com/company/backButt.png");
//    private Picture buttBackAnim = new Picture("/Users/camohinthisb1/IdeaProjects/colourlyThing/src/com/company/backButtAnim.png");
    //********************************************************************************************************************************************************
    private Picture picLogo2 = new Picture(path1.toAbsolutePath().toString() + "/Untitled-2.png");
    private Picture picBackGround = new Picture(path1.toAbsolutePath().toString() + "/Untitled-3.png");
    private Picture picEmpty = new Picture(path1.toAbsolutePath().toString() + "/Empty.png");
    private Picture buttBack = new Picture(path1.toAbsolutePath().toString() + "/backButt.png");
    private Picture buttBackAnim = new Picture(path1.toAbsolutePath().toString() + "/backButtAnim.png");
    private Picture picDoubleCheck = new Picture(path1.toAbsolutePath().toString() + "/DoubleCheck.png");
    private Picture picCheck = new Picture(path1.toAbsolutePath().toString() + "/Check.png");
    private Picture picFailCheck = new Picture(path1.toAbsolutePath().toString() + "/failCheck.png");
    //********************************************************************************************************************************************************


    public GamePage(int diff1, int diff2, int time) {
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
        originalTime = time;
        random = new int[w];
        randomize = new Random();
        for (int i = 0; i < w; i++) {
            random[i] = randomize.nextInt(7);
        }
        displayArray(random);
        

        // TOP PANEL
        
        buttonRestart.setBounds(10, 65, 100, 50);
        buttonRestart.setOpaque(false);
        buttonRestart.addActionListener(this);
        buttonRestart.addMouseListener(this);
        buttonRestart.setOpaque(false);
        buttonRestart.setContentAreaFilled(false);
        buttonRestart.setBorderPainted(false);
        buttonRestart.setFont(font1);
        buttonRestart.setForeground(plainTextColorAnim2);
        buttonRestart.setHorizontalAlignment(JLabel.CENTER);

        labelTimer.setBounds(60*diff1-20, 90, 100, 50);
        labelTimer.setForeground(plainTextColorAnim2);
        labelTimer.setHorizontalAlignment(JLabel.CENTER);
        labelTimer.setFont(font3);

        seconds = time;
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (time != 0) {
                    seconds--;
                } else {
                    seconds++;
                }
                labelTimer.setText(convertToTime(seconds, " : "));
                System.out.println(seconds);
            }
        };
        timer.scheduleAtFixedRate(task, 1000, 1000);


        labelTop2.setBounds(60*diff1-120, 20, 400, 105);
        picLogo2.resizeImage(14);
        labelTop2.setIcon(picLogo2);
        picBackGround.resizeImage(50);
        panelTop.setBounds(0, 0, 120*diff1+60, 140);
        panelTop.setBackground(backGroundColor);
        panelTop.setLayout(null);
        panelTop.add(buttonRestart);
        panelTop.add(labelTimer);
        panelTop.add(labelTop2);

        // BOTTOM PANEL
        panelBot.setBounds(0, 60*diff2+160, 120*diff1+60, 150);
        labelBot.setBounds(0, 0, 120*diff1+60, 60);
        //labelBot.setIcon(picBackGround);
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

//        buttPictures[0] = new Picture("/Users/camohinthisb1/IdeaProjects/colourlyThing/src/com/company/RedButt.png");
//        buttPictures[1] = new Picture("/Users/camohinthisb1/IdeaProjects/colourlyThing/src/com/company/OrangeButt.png");
//        buttPictures[2] = new Picture("/Users/camohinthisb1/IdeaProjects/colourlyThing/src/com/company/YellowButt.png");
//        buttPictures[3] = new Picture("/Users/camohinthisb1/IdeaProjects/colourlyThing/src/com/company/GreenButt.png");
//        buttPictures[4] = new Picture("/Users/camohinthisb1/IdeaProjects/colourlyThing/src/com/company/BlueButt.png");
//        buttPictures[5] = new Picture("/Users/camohinthisb1/IdeaProjects/colourlyThing/src/com/company/IndigoButt.png");
//        buttPictures[6] = new Picture("/Users/camohinthisb1/IdeaProjects/colourlyThing/src/com/company/VioletButt.png");
        //********************************************************************************************************************************************************
        buttPictures[0] = new Picture(path1.toAbsolutePath().toString() + "/RedButt.png");
        buttPictures[1] = new Picture(path1.toAbsolutePath().toString() + "/OrangeButt.png");
        buttPictures[2] = new Picture(path1.toAbsolutePath().toString() + "/YellowButt.png");
        buttPictures[3] = new Picture(path1.toAbsolutePath().toString() + "/GreenButt.png");
        buttPictures[4] = new Picture(path1.toAbsolutePath().toString() + "/BlueButt.png");
        buttPictures[5] = new Picture(path1.toAbsolutePath().toString() + "/IndigoButt.png");
        buttPictures[6] = new Picture(path1.toAbsolutePath().toString() + "/VioletButt.png");
        //********************************************************************************************************************************************************

        for (int i = 0; i < 7; i++) {
            buttPictures[i].resizeImage(5);
        }

        buttBack.resizeImage(5);
        buttBackAnim.resizeImage(5);
        buttons[7].setIcon(buttBackAnim);

//        buttAnimPictures[0] = new Picture("/Users/camohinthisb1/IdeaProjects/colourlyThing/src/com/company/RedButtAnim.png");
//        buttAnimPictures[1] = new Picture("/Users/camohinthisb1/IdeaProjects/colourlyThing/src/com/company/OrangeButtAnim.png");
//        buttAnimPictures[2] = new Picture("/Users/camohinthisb1/IdeaProjects/colourlyThing/src/com/company/YellowButtAnim.png");
//        buttAnimPictures[3] = new Picture("/Users/camohinthisb1/IdeaProjects/colourlyThing/src/com/company/GreenButtAnim.png");
//        buttAnimPictures[4] = new Picture("/Users/camohinthisb1/IdeaProjects/colourlyThing/src/com/company/BlueButtAnim.png");
//        buttAnimPictures[5] = new Picture("/Users/camohinthisb1/IdeaProjects/colourlyThing/src/com/company/IndigoButtAnim.png");
//        buttAnimPictures[6] = new Picture("/Users/camohinthisb1/IdeaProjects/colourlyThing/src/com/company/VioletButtAnim.png");
        //********************************************************************************************************************************************************
        buttAnimPictures[0] = new Picture(path1.toAbsolutePath().toString() + "/RedButtAnim.png");
        buttAnimPictures[1] = new Picture(path1.toAbsolutePath().toString() + "/OrangeButtAnim.png");
        buttAnimPictures[2] = new Picture(path1.toAbsolutePath().toString() + "/YellowButtAnim.png");
        buttAnimPictures[3] = new Picture(path1.toAbsolutePath().toString() + "/GreenButtAnim.png");
        buttAnimPictures[4] = new Picture(path1.toAbsolutePath().toString() + "/BlueButtAnim.png");
        buttAnimPictures[5] = new Picture(path1.toAbsolutePath().toString() + "/IndigoButtAnim.png");
        buttAnimPictures[6] = new Picture(path1.toAbsolutePath().toString() + "/VioletButtAnim.png");
        //********************************************************************************************************************************************************

        for (int i = 0; i < 7; i++) {
            buttAnimPictures[i].resizeImage(5);
            buttons[i].setIcon(buttAnimPictures[i]);

        }

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
        for (int i = 0; i < w; i++) {
            if (label1[row*w + i].getId() == random[i]) {
                results[i] = 2;
            } else if (isInRow(label1[row*w + i].getId())) {
                results[i] = 1;
            } else {
                results[i] = 0;
            }
        }
        System.out.println("---------------------------------");
        displayArray(results);
        //Arrays.sort(results);
        //results = reverseArray(results);
        displayArray(results);

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
    }

    private void restartGame() {
        seconds = originalTime;

        for (int i = 0; i < w*h; i++) {
            label1[i].setIcon(picEmpty);
            label2[i].setIcon(picEmpty);
        }
        for (int i = 0; i < w; i++) {
            random[i] = randomize.nextInt(7);
        }
        label1[0].setIcon(brushes.getBasicBrush());
        displayArray(random);
        pointer = 0;
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
                if (pointer == w * h) {
                    // END GAME
                }
                label1[pointer].setIcon(brushes.getBrush(i));
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

    @Override
    public void mouseExited(MouseEvent e) {
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


}
