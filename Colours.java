package com.company;

import static com.company.StartPage.path1;


//-------------------------------------------------------------------------------------------------------------------------------------------------------
// this class is to help managing the color pictures to fill in panel1 (your guess)
//-------------------------------------------------------------------------------------------------------------------------------------------------------

public class Colours {

    private Picture[] colours = new Picture[7];

    Colours() {

        // IMPORTING PICTURES
        // 0:red 1:orange 3:yellow 4:green 5:blue 6:indigo 7:violet
        colours[0] = new Picture(path1.toAbsolutePath().toString() + "/colours/Red.png");
        colours[1] = new Picture(path1.toAbsolutePath().toString() + "/colours/Orange.png");
        colours[2] = new Picture(path1.toAbsolutePath().toString() + "/colours/Yellow.png");
        colours[3] = new Picture(path1.toAbsolutePath().toString() + "/colours/Green.png");
        colours[4] = new Picture(path1.toAbsolutePath().toString() + "/colours/Blue.png");
        colours[5] = new Picture(path1.toAbsolutePath().toString() + "/colours/Indigo.png");
        colours[6] = new Picture(path1.toAbsolutePath().toString() + "/colours/Violet.png");

        for (int i = 0; i < colours.length; i++) {
            colours[i].resizeImage(5);
        }

    }

    //-------------------------------------------------------------------------------------------------------------------------------------------------------
    // RETURN THE COLOR PICTURE WHICHEVER COLOR BUTTON WAS PRESSED
    //-------------------------------------------------------------------------------------------------------------------------------------------------------
    public Picture getColourImage(int which) {
        return colours[which];
    }

}
