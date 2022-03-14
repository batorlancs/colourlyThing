package com.company;

import static com.company.StartPage.path1;

public class Brushes {
    private Picture brush = new Picture(path1.toAbsolutePath() + "/brush/brush.png");
    private Picture[] brushPictures;

    public Brushes() {
        brush.resizeImage(5);
        brushPictures = new Picture[7];

        brushPictures[0] = new Picture(path1.toAbsolutePath() + "/brush/brush0.png");
        brushPictures[1] = new Picture(path1.toAbsolutePath() + "/brush/brush1.png");
        brushPictures[2] = new Picture(path1.toAbsolutePath() + "/brush/brush2.png");
        brushPictures[3] = new Picture(path1.toAbsolutePath() + "/brush/brush3.png");
        brushPictures[4] = new Picture(path1.toAbsolutePath() + "/brush/brush4.png");
        brushPictures[5] = new Picture(path1.toAbsolutePath() + "/brush/brush5.png");
        brushPictures[6] = new Picture(path1.toAbsolutePath() + "/brush/brush6.png");

        for (int i = 0; i < brushPictures.length; i++) {
            brushPictures[i].resizeImage(5);
        }
    }

    public Picture getBrush(int which) {
        return brushPictures[which];
    }

    public Picture getBasicBrush() {
        return brush;
    }
}
