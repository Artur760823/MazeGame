package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import sample.models.Model;

public class Main extends Application {
    public static final int WIDTH = 1200;
    public static final int HEIGHT = 750;
    private sample.Timer timer;

//    private sample.Timer timer;
    @Override
    public void start(Stage primaryStage) throws Exception{

        primaryStage.setTitle("AMAZING MAZE");
        //initialize Canvas
        Canvas maze = new Canvas(WIDTH, HEIGHT);
        //initiate Group
        Group mazeGroup = new Group();
        mazeGroup.getChildren().addAll(maze);
        //Scene
        Scene mazeScene = new Scene(mazeGroup);
        primaryStage.setScene(mazeScene);
        primaryStage.show();

        Model model = new Model(WIDTH, HEIGHT);
        Graphics graphics = new Graphics(model, maze.getGraphicsContext2D());
        sample.InputHandler inputHandler = new sample.InputHandler(model);

        mazeScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                inputHandler.onKeyPressed(event);
            }
        });

        timer = new sample.Timer(model, graphics);
        timer.start();

    }
    @Override
    public void stop() throws Exception {
        timer.stop();
        super.stop();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
