package com.company;

import javax.swing.*;

//-------------------------------------------------------------------------------------------------------------------------------------------------------
// this extended class is to help the result checking by giving an id to the JLabel class
//-------------------------------------------------------------------------------------------------------------------------------------------------------

public class MyLabel extends JLabel {

    private int id;

    // makes id -1 (no colour)
    public MyLabel() {
        this.id = -1;
    }

    //change id
    public void changeID(int newId) {
        this.id = newId;
    }

    // return id
    public int getId() {
        return this.id;
    }
}
