package sample.models;

import javafx.scene.paint.Color;

public class Dimond extends GameObject {

    private int dimondID;

    public Dimond(int x, int y, int coinId) {
        super(x, y, 20, 20, Color.BLANCHEDALMOND);
        this.dimondID = coinId;
    }


    public int getCoinId() {
        return dimondID;
    }
}
