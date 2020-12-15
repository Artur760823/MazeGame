package sample;

import sample.models.Model;
import javafx.animation.AnimationTimer;

public class Timer extends AnimationTimer {

    public int counter = 1000;
    private Model model;
    private Graphics graphics;

    long lastMillis = -1;

    public Timer(Model model, Graphics graphics) {
        this.model = model;
        this.graphics = graphics;
    }

    public Timer() {
    }

    @Override
    public void handle(long now) {
        long millis = now / 1000000;

        long deltaMillis = 0;

        if (lastMillis != -1) {
            deltaMillis = millis - lastMillis;
        }
        this.model.update(deltaMillis);

        lastMillis = millis;
        graphics.draw();
    }


    public static String clock(int counter) {
        counter--;
        return String.format("%d", counter);
    }

}

