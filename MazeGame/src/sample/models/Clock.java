package sample.models;

import javafx.scene.paint.Color;


public class Clock extends GameObject {

    private String text;

    public Clock(int x, int y, int width, int height,Color color, String text) {
        super(x, y, width, height);
        this.text = text;
    }
}
