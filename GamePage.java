package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static com.company.StartPage.backGroundColor;
import static com.company.StartPage.plainTextColor;

public class GamePage extends JFrame implements ActionListener, MouseListener{

    private JPanel panelTop = new JPanel();
    private JLabel labelTop = new JLabel();
    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();
    private JPanel panelBot = new JPanel();
    private JPanel buttonPanelBot = new JPanel();
    private JButton[] buttons = new JButton[8];
    private JLabel labelBot = new JLabel();
    private JLabel[] label1;
    private JLabel[] label2;

    // GAMEPLAY
    private int pointer = 0;
    private Colours colours = new Colours();

    // PICTURES
    private Picture picEmpty = new Picture("/Users/camohinthisb1/IdeaProjects/colourlyThing/src/com/company/Empty.png");
    //private Picture picEmpty = new Picture("Empty.png");
    private Picture picBackGround = new Picture("/Users/camohinthisb1/IdeaProjects/colourlyThing/src/com/company/Untitled-3.png");
    //private Picture picBackGround = new Picture("Untitled-3.png");
    private Picture[] buttPictures = new Picture[7];
    private Picture[] buttAnimPictures = new Picture[7];
    private Picture buttBack = new Picture("/Users/camohinthisb1/IdeaProjects/colourlyThing/src/com/company/backButt.png");
    private Picture buttBackAnim = new Picture("/Users/camohinthisb1/IdeaProjects/colourlyThing/src/com/company/backButtAnim.png");


    public GamePage(int diff1, int diff2, int time) {
        this.setSize(120*diff1+60, 60*diff2+148);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("colourly");
        this.setResizable(false);
        this.getContentPane().setBackground(backGroundColor);
        this.setVisible(true);

        // TOP PANEL
        picBackGround.resizeImage(50);
        panelTop.setBounds(0, 0, 120*diff1+60, 60);
        //labelTop.setBounds(0, 0, 120*diff1+60, 60);
        //labelTop.setIcon(picBackGround);
        //panelTop.add(labelTop);
        panelTop.setBackground(backGroundColor);
        panelTop.setLayout(null);

        // BOTTOM PANEL
        panelBot.setBounds(0, 60*diff2+60, 120*diff1+60, 60);
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

        buttPictures[0] = new Picture("/Users/camohinthisb1/IdeaProjects/colourlyThing/src/com/company/RedButt.png");
        buttPictures[1] = new Picture("/Users/camohinthisb1/IdeaProjects/colourlyThing/src/com/company/OrangeButt.png");
        buttPictures[2] = new Picture("/Users/camohinthisb1/IdeaProjects/colourlyThing/src/com/company/YellowButt.png");
        buttPictures[3] = new Picture("/Users/camohinthisb1/IdeaProjects/colourlyThing/src/com/company/GreenButt.png");
        buttPictures[4] = new Picture("/Users/camohinthisb1/IdeaProjects/colourlyThing/src/com/company/BlueButt.png");
        buttPictures[5] = new Picture("/Users/camohinthisb1/IdeaProjects/colourlyThing/src/com/company/IndigoButt.png");
        buttPictures[6] = new Picture("/Users/camohinthisb1/IdeaProjects/colourlyThing/src/com/company/VioletButt.png");

        for (int i = 0; i < 7; i++) {
            buttPictures[i].resizeImage(5);
        }

        buttBack.resizeImage(5);
        buttBackAnim.resizeImage(5);
        buttons[7].setIcon(buttBackAnim);

        buttAnimPictures[0] = new Picture("/Users/camohinthisb1/IdeaProjects/colourlyThing/src/com/company/RedButtAnim.png");
        buttAnimPictures[1] = new Picture("/Users/camohinthisb1/IdeaProjects/colourlyThing/src/com/company/OrangeButtAnim.png");
        buttAnimPictures[2] = new Picture("/Users/camohinthisb1/IdeaProjects/colourlyThing/src/com/company/YellowButtAnim.png");
        buttAnimPictures[3] = new Picture("/Users/camohinthisb1/IdeaProjects/colourlyThing/src/com/company/GreenButtAnim.png");
        buttAnimPictures[4] = new Picture("/Users/camohinthisb1/IdeaProjects/colourlyThing/src/com/company/BlueButtAnim.png");
        buttAnimPictures[5] = new Picture("/Users/camohinthisb1/IdeaProjects/colourlyThing/src/com/company/IndigoButtAnim.png");
        buttAnimPictures[6] = new Picture("/Users/camohinthisb1/IdeaProjects/colourlyThing/src/com/company/VioletButtAnim.png");

        for (int i = 0; i < 7; i++) {
            buttAnimPictures[i].resizeImage(5);
            buttons[i].setIcon(buttAnimPictures[i]);

        }

        panelBot.add(buttonPanelBot);

        // PANEL 1
        panel1.setBounds(20, 60, 60*diff1, 60*diff2);
        panel1.setBackground(backGroundColor);
        panel1.setLayout(new GridLayout(diff2, diff1, 0, 0));

        picEmpty.resizeImage(5);
        label1 = new JLabel[diff1*diff2];
        for (int i = 0; i < diff1*diff2; i++) {
            label1[i] = new JLabel();
            label1[i].setSize(60, 60);
            label1[i].setIcon(picEmpty);
            label1[i].setHorizontalAlignment(JLabel.CENTER);
            panel1.add(label1[i]);
        }
        System.out.println(diff1*diff2);

        // PANEL 2
        panel2.setBounds(diff1*60+40, 60, 60*diff1, 60*diff2);
        panel2.setBackground(backGroundColor);
        panel2.setLayout(new GridLayout(diff2, diff1, 0, 0));

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

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i<7; i++) {
            if (e.getSource() == buttons[i]) {
                label1[pointer].setIcon(colours.getColourImage(i));
                pointer++;
            }
        }
        if (e.getSource() == buttons[7]) {
            pointer--;
            label1[pointer].setIcon(picEmpty);
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
            }
        }
        if (e.getSource() == buttons[7]) {
            buttons[7].setIcon(buttBackAnim);
        }
    }
}
