package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sample.models.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Graphics {

    private Model model;
    private GraphicsContext gc;

    public Graphics(Model model, GraphicsContext gc) {
        this.model = model;
        this.gc = gc;
    }

    public void draw() {

        // Draw Background
        gc.setFill(Color.DARKGREEN);
        gc.fillRect(0, 0, 1200, 750);

        // Draw the Square


        Player player = model.getPlayer();
        gc.setFill(player.getColor());
        gc.fillRect(player.getX(), player.getY(), player.getWidth(), player.getHeight());

        // Draw Exit
        Exit exit = model.getExit();
        gc.setFill(exit.getColor());
        gc.fillRect(exit.getX(), exit.getY(), exit.getWidth(), exit.getHeight());


        for (Wall wall : model.getWalls()) {
            gc.setFill(wall.getColor());
            gc.fillRect(wall.getX(), wall.getY(), wall.getWidth(), wall.getHeight());
            gc.setFill(wall.getColor());
            gc.fillRect(wall.getX(), wall.getY(), wall.getWidth(), wall.getHeight());
        }

        for (GameObject dimond : model.getCoins()) {
            gc.setFill(dimond.getColor());
            gc.drawImage(model.getDimondShape(),dimond.getX(), dimond.getY());
        }
    }

}
