package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StartPage extends JFrame implements ActionListener, MouseMotionListener {

    private JPanel panel = new JPanel();
    private JLabel label1 = new JLabel("choose colour code length");
    private JLabel label2 = new JLabel("normal");
    private JLabel label3 = new JLabel("choose number of guesses");

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

    //difficulty buttons
    private JButton button14 = new JButton("4");
    private JButton button15 = new JButton("5");
    private JButton button16 = new JButton("6");
    private JButton button17 = new JButton("7");
    private JButton button18 = new JButton("8");

    //other buttons
    private JButton buttonStart = new JButton("start game");

    //design
    private Picture picLogo = new Picture("Untitled-2.png");
    private JLabel labelLogo = new JLabel();

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

        // ------------CHOOSE THE COLOUR LENGTH -----------------//

        label1.setBounds(50, 130, 400, 50);
        label1.setHorizontalAlignment(JLabel.CENTER);
        label1.setFont(font1);
        label1.setForeground(plainTextColor);

        label2.setBounds(50, 310, 400, 50);
        label2.setHorizontalAlignment(JLabel.CENTER);
        label2.setFont(font1);
        label2.setForeground(color5);

        createDiffButton(button4, 50, 150);
        button4.setForeground(color4);
        createDiffButton(button5, 130, 150);
        createDiffButton(button6, 210, 150);
        createDiffButton(button7, 290, 150);
        createDiffButton(button8, 370, 150);

        // ------------CHOOSE THE NUMBER OF GUESSES -------------//

        label3.setBounds(50, 210, 400, 50);
        label3.setHorizontalAlignment(JLabel.CENTER);
        label3.setFont(font1);
        label3.setForeground(plainTextColor);

        createDiffButton(button18, 50, 230);
        createDiffButton(button17, 130, 230);
        createDiffButton(button16, 210, 230);
        button16.setForeground(color6);
        createDiffButton(button15, 290, 230);
        createDiffButton(button14, 370, 230);

        // ----- start game button ------------------------------//

        buttonStart.setBounds(50, 400, 400, 50);
        buttonStart.setForeground(plainTextColor);
        buttonStart.addActionListener(this);
        buttonStart.setBorderPainted(false);
        buttonStart.setFont(font3);

        // ----- DESIGN -----------------------        ----------//
        labelLogo.setIcon(picLogo);
        labelLogo.setBounds(0, 0, 500, 100);

        // ------------------------------------------------------//

        // ADDING TO PANEL
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(labelLogo);
        panel.add(button4); panel.add(button5); panel.add(button6); panel.add(button7); panel.add(button8);
        panel.add(button14); panel.add(button15); panel.add(button16); panel.add(button17); panel.add(button18);
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

    private JButton getDiffButtonEnabled(JButton button4, JButton button5, JButton button6, JButton button7, JButton button8) {
        if (button4.getForeground() != plainTextColor)
            return button4;
        if (button5.getForeground() != plainTextColor)
            return button5;
        if (button6.getForeground() != plainTextColor)
            return button6;
        if (button7.getForeground() != plainTextColor)
            return button7;
        return button8;
    }

    private int getScoreDiff(JButton button4, JButton button5, JButton button6, JButton button7, JButton button8) {
        JButton butt = getDiffButtonEnabled(button4, button5, button6, button7, button8);
        if (butt.getForeground() == color4) return 1;
        if (butt.getForeground() == color5) return 2;
        if (butt.getForeground() == color6) return 3;
        if (butt.getForeground() == color7) return 4;
        return 5;
    }

    private void calculateDiff() {
        int sum = getScoreDiff(button4, button5, button6, button7, button8) + getScoreDiff(button14, button15, button16, button17, button18);
        switch (sum) {
            case 2: label2.setText("very easy"); label2.setForeground(color4); break;
            case 3: label2.setText("easy"); label2.setForeground(color4); break;
            case 4: label2.setText("normal"); label2.setForeground(color5); break;
            case 5: label2.setText("difficult"); label2.setForeground(color5); break;
            case 6: label2.setText("hard"); label2.setForeground(color6); break;
            case 7: label2.setText("very hard"); label2.setForeground(color6); break;
            case 8: label2.setText("extreme"); label2.setForeground(color7); break;
            case 9: label2.setText("heroic"); label2.setForeground(color7); break;
            case 10: label2.setText("legendary"); label2.setForeground(color8); break;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == button4 || e.getSource() == button5 || e.getSource() == button6 || e.getSource() == button7 || e.getSource() == button8) {

            // sets the enabled button to disabled color
            getDiffButtonEnabled(button4, button5, button6, button7, button8).setForeground(plainTextColor);

            if (e.getSource() == button4) {
                button4.setForeground(color4);
            }
            if (e.getSource() == button5) {
                button5.setForeground(color5);
            }
            if (e.getSource() == button6) {
                button6.setForeground(color6);
            }
            if (e.getSource() == button7) {
                button7.setForeground(color7);
            }
            if (e.getSource() == button8) {
                button8.setForeground(color8);
            }
        }

        if (e.getSource() == button14 || e.getSource() == button15 || e.getSource() == button16 || e.getSource() == button17 || e.getSource() == button18) {

            // sets the enabled button to disabled color
            getDiffButtonEnabled(button14, button15, button16, button17, button18).setForeground(plainTextColor);

            if (e.getSource() == button14) {
                button14.setForeground(color8);
            }
            if (e.getSource() == button15) {
                button15.setForeground(color7);
            }
            if (e.getSource() == button16) {
                button16.setForeground(color6);
            }
            if (e.getSource() == button17) {
                button17.setForeground(color5);
            }
            if (e.getSource() == button18) {
                button18.setForeground(color4);
            }
        }
        calculateDiff();
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        System.out.println("oh heloooo");
    }
}
