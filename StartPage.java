package com.company;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.*;

public class StartPage extends JFrame implements ActionListener, MouseMotionListener {

    private JPanel panel = new JPanel();
    private JLabel label1 = new JLabel("choose difficulty");
    private JLabel label2 = new JLabel("normal");

    private Font font1 = new Font("Calibri", Font.BOLD, 15);
    private Font font2 = new Font("Calibri", Font.PLAIN, 15);
    private Font font3 = new Font("Calibri", Font.BOLD, 20);

    private Color plainTextColor = new Color(138, 138, 138);

    //difficulty colors
    private Color color4 = new Color(152, 222, 124);
    private Color color5 = new Color(245, 241, 137);
    private Color color6 = new Color(255, 167, 84);
    private Color color7 = new Color(255, 114, 92);
    private Color color8 = new Color(228, 130, 255);

    //difficulty buttons
    private JButton button4 = new JButton("4");
    private JButton button5 = new JButton("5");
    private JButton button6 = new JButton("6");
    private JButton button7 = new JButton("7");
    private JButton button8 = new JButton("8");

    //other buttons
    private JButton buttonStart = new JButton("start game");


    StartPage() {
        initComponents();
    }

    private void initComponents() {
        // FRAME SETUP
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setTitle("colourly");
        this.getContentPane().setBackground(new Color(69, 69, 69));
        this.add(panel);


        // PANEL SETUP
        panel.setLayout(null);
        panel.setBounds(0, 0, 500, 500);
        panel.setBackground(new Color(69, 69, 69));

        // ------------CHOOSE THE DIFFICULTY --------------------//

        label1.setBounds(50, 130, 400, 50);
        label1.setHorizontalAlignment(JLabel.CENTER);
        label1.setFont(font1);
        label1.setForeground(plainTextColor);

        label2.setBounds(50, 200, 400, 50);
        label2.setHorizontalAlignment(JLabel.CENTER);
        label2.setFont(font1);
        label2.setForeground(color5);

        createDiffButton(button4, 50, 150);
        createDiffButton(button5, 130, 150);
        button5.setForeground(color5);
        createDiffButton(button6, 210, 150);
        createDiffButton(button7, 290, 150);
        createDiffButton(button8, 370, 150);

        // ----- start game button ------------------------------//

        buttonStart.setBounds(50, 400, 400, 50);
        buttonStart.setForeground(plainTextColor);
        buttonStart.addActionListener(this);
        buttonStart.setBorderPainted(false);
        buttonStart.setFont(font3);

        // ------------------------------------------------------//

        // ADDING TO PANEL
        panel.add(label1);
        panel.add(label2);
        panel.add(button4);
        panel.add(button5);
        panel.add(button6);
        panel.add(button7);
        panel.add(button8);
        panel.add(buttonStart);

        // ADDING TO FRAME
        this.add(panel);

        // SET FRAME VISIBLE
        this.setVisible(true);
    }
    
    private void createDiffButton(JButton button, int x, int y) {
        button.setBounds(x, y, 80, 80);
        button.setForeground(plainTextColor);
        button.addActionListener(this);
        button.setBorderPainted(false);
        button.setFont(font1);
    }

    private JButton getDiffButtonEnabled() {
        if (button4.getForeground() != plainTextColor)
            return button4;
        if (button5.getForeground() != plainTextColor)
            return button5;
        if (button6.getForeground() != plainTextColor)
            return button6;
        if (button7.getForeground() != plainTextColor)
            return button7;
        if (button8.getForeground() != plainTextColor)
            return button8;
        return buttonStart;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == button4 || e.getSource() == button5 || e.getSource() == button6 || e.getSource() == button7 || e.getSource() == button8) {

            // sets the enabled button to disabled color
            getDiffButtonEnabled().setForeground(plainTextColor);

            if (e.getSource() == button4) {
                button4.setForeground(color4);
                label2.setForeground(color4);
                label2.setText("easy");
            }
            if (e.getSource() == button5) {
                button5.setForeground(color5);
                label2.setForeground(color5);
                label2.setText("normal");
            }
            if (e.getSource() == button6) {
                button6.setForeground(color6);
                label2.setForeground(color6);
                label2.setText("hard");
            }
            if (e.getSource() == button7) {
                button7.setForeground(color7);
                label2.setForeground(color7);
                label2.setText("extreme");
            }
            if (e.getSource() == button8) {
                button8.setForeground(color8);
                label2.setForeground(color8);
                label2.setText("heroic");
            }
        }

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        System.out.println("oh heloooo");
    }
}
