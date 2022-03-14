package com.company;

import javax.swing.*;

public class MyLabel extends JLabel {

    private int id;

    public MyLabel() {
        this.id = -1;
    }

    public void changeID(int newId) {
        this.id = newId;
    }

    public int getId() {
        return this.id;
    }
}
