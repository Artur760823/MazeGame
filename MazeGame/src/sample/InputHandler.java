package sample;

import sample.models.GameObject;
import sample.models.Model;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class InputHandler {

    private Model model;

    public InputHandler(Model model) {
        this.model = model;
    }

    public void onKeyPressed(KeyEvent event) {

        GameObject player = model.getPlayer();
        if(event.getCode() == KeyCode.RIGHT) {
            player.setX(player.getX() + 10);
        }
        if(event.getCode() == KeyCode.LEFT) {
            player.setX(player.getX() - 10);
        }
        if(event.getCode() == KeyCode.UP) {
            player.setY(player.getY() - 10);
        }
        if(event.getCode() == KeyCode.DOWN) {
            player.setY(player.getY() + 10);
        }

    }

}
