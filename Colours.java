package com.company;

import static com.company.StartPage.path1;

public class Colours {

    private Picture[] colours = new Picture[7];

    Colours() {
        // 0:red 1:orange 3:yellow 4:green 5:blue 6:indigo 7:violet
//        colours[0] = new Picture("/Users/camohinthisb1/IdeaProjects/colourlyThing/src/com/company/Red.png");
//        colours[1] = new Picture("/Users/camohinthisb1/IdeaProjects/colourlyThing/src/com/company/Orange.png");
//        colours[2] = new Picture("/Users/camohinthisb1/IdeaProjects/colourlyThing/src/com/company/Yellow.png");
//        colours[3] = new Picture("/Users/camohinthisb1/IdeaProjects/colourlyThing/src/com/company/Green.png");
//        colours[4] = new Picture("/Users/camohinthisb1/IdeaProjects/colourlyThing/src/com/company/Blue.png");
//        colours[5] = new Picture("/Users/camohinthisb1/IdeaProjects/colourlyThing/src/com/company/Indigo.png");
//        colours[6] = new Picture("/Users/camohinthisb1/IdeaProjects/colourlyThing/src/com/company/Violet.png");

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

    public Picture getColourImage(int which) {
        return colours[which];
    }

}
