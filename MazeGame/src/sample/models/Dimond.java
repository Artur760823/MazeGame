package sample.models;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Dimond extends GameObject {

    private int dimondID;

    public Dimond(int x, int y, int width, int height, Image shape, int dimondID) {
        super(x, y, width, height, shape);
        this.dimondID = dimondID;
    }


    public int getDimondID() {
        return dimondID;
    }
}
