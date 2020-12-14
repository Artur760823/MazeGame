package sample.models;

import javafx.scene.paint.Color;
import sample.Timer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Model {

    Timer clock = new Timer();
    int width;
    int height;

    private Player player = new Player(250, 640);
    //Exit Object
    private Exit exit = new Exit(600, 0, 50, 20, Color.RED);
    private Wall wallFirstOne = new Wall(650, 0, 550, 20);
    private Wall wallFirstTwo = new Wall(0, 0, 600, 20);
    private Wall wallLeft = new Wall(0, 0, 20, 750);
    private Wall wallRight = new Wall(1180, 0, 20, 750);
    private Wall wallSecondOne = new Wall(1000, 75, 200, 20);
    private Wall wallSecondTwo = new Wall(0, 75, 950, 20);
    private Wall wallThirdOne = new Wall(550, 150, 650, 20);
    private Wall wallThirdTwo = new Wall(0, 150, 500, 20);
    private Wall wallFourthOne = new Wall(250, 225, 950, 20);
    private Wall wallForthTwo = new Wall(0, 225, 200, 20);
    private Wall wallFifthOne = new Wall(1000, 300, 200, 20);
    private Wall wallFifthTwo = new Wall(0, 300, 950, 20);
    private Wall wallSixthOne = new Wall(550, 375, 650, 20);
    private Wall wallSixthTwo = new Wall(0, 375, 500, 20);
    private Wall wallSeventhOne = new Wall(250, 450, 950, 20);
    private Wall wallSeventhTwo = new Wall(0, 450, 200, 20);
    private Wall wallEightOne = new Wall(650, 525, 550, 20);
    private Wall wallEightTwo = new Wall(0, 525, 600, 20);
    private Wall wallNinthOne = new Wall(1000, 600, 200, 20);
    private Wall wallNinthTwo = new Wall(0, 600, 950, 20);
    private Wall wallBottom = new Wall(0, 675, 1200, 75);

    private int counter = 1000;
    private Clock reverseClock = new Clock(0, 750, 50, 50, Color.WHITE, clock.clock(counter));


    protected ArrayList<Wall> walls = new ArrayList<>();


    private List<Dimond> dimonds = new ArrayList<>();


    public void setWallFirstTwo(Wall wallFirstTwo) {
        this.wallFirstTwo = wallFirstTwo;
    }

    /**
     * The constructor creates the playing field with all objects.
     *
     * @param width
     * @param height
     */
    public Model(int width, int height) {
        this.width = width;
        this.height = height;

        init(width, height);
    }

    public Player getPlayer() {
        return player;
    }

    //Exit Geter
    public Exit getExit() {
        return exit;
    }

    public Clock getClock() {
        return reverseClock;
    }

    public Wall getWallTopOne() {
        return wallFirstOne;
    }

    public Wall getWallFirstTwo() {
        return wallFirstTwo;
    }

    public Wall getWallFirstOne() {
        return wallFirstOne;
    }

    public Wall getWallLeft() {
        return wallLeft;
    }

    public Wall getWallRight() {
        return wallRight;
    }

    public Wall getWallSecondOne() {
        return wallSecondOne;
    }

    public Wall getWallSecondTwo() {
        return wallSecondTwo;
    }

    public Wall getWallThirdOne() {
        return wallThirdOne;
    }

    public Wall getWallThirdTwo() {
        return wallThirdTwo;
    }

    public Wall getWallFourthOne() {
        return wallFourthOne;
    }

    public Wall getWallForthTwo() {
        return wallForthTwo;
    }

    public Wall getWallFifthOne() {
        return wallFifthOne;
    }

    public Wall getWallFifthTwo() {
        return wallFifthTwo;
    }

    public Wall getWallSixthOne() {
        return wallSixthOne;
    }

    public Wall getWallSixthTwo() {
        return wallSixthTwo;
    }

    public Wall getWallSeventhOne() {
        return wallSeventhOne;
    }

    public Wall getWallSeventhTwo() {
        return wallSeventhTwo;
    }

    public Wall getWallEightOne() {
        return wallEightOne;
    }

    public Wall getWallEightTwo() {
        return wallEightTwo;
    }

    public Wall getWallNinthOne() {
        return wallNinthOne;
    }

    public Wall getWallNinthTwo() {
        return wallNinthTwo;
    }

    public Wall getWallBottom() {
        return wallBottom;
    }

    public ArrayList<Wall> getWalls() {
        return walls;
    }

    public List<Dimond> getCoins() {
        return dimonds;
    }

    /*
     * Arrangement of objects on the playing field
     */
    private void init(int width, int height) {
        Random positionsGenerator = new Random(System.currentTimeMillis());
        int numberOfDimonds = 20;
        int dimondDiameter = 20;
        for (int i = 0; i < numberOfDimonds; i++) {
            int x = positionsGenerator.nextInt(width - dimondDiameter) + dimondDiameter / 2;
            int y = positionsGenerator.nextInt(height - dimondDiameter) + dimondDiameter / 2;
            Dimond dimond = new Dimond(x, y, i + 1);
            this.dimonds.add(dimond);
        }
        walls.add(wallFirstOne);
        walls.add(wallFirstTwo);
        walls.add(wallLeft);
        walls.add(wallRight);
        walls.add(wallSecondOne);
        walls.add(wallSecondTwo);
        walls.add(wallThirdOne);
        walls.add(wallThirdTwo);
        walls.add(wallFourthOne);
        walls.add(wallForthTwo);
        walls.add(wallFifthOne);
        walls.add(wallFifthTwo);
        walls.add(wallSixthOne);
        walls.add(wallSixthTwo);
        walls.add(wallSeventhOne);
        walls.add(wallSeventhTwo);
        walls.add(wallEightOne);
        walls.add(wallEightTwo);
        walls.add(wallNinthOne);
        walls.add(wallNinthTwo);
        walls.add(wallBottom);
    }

    private boolean playerObjectCollider(Player player, GameObject otherObject) {
        boolean horizontalCollide = false;
        int squareLeft = player.getX();
        int squareRight = player.getX() + player.getWidth();
        int otherObjectLeft = otherObject.getX();
        int otherObjectRight = otherObject.getX() + otherObject.getWidth();
        if (squareRight > otherObjectLeft && squareLeft < otherObjectRight) {
            horizontalCollide = true;
        }

        boolean verticalCollide = false;

        int squareTop = player.getY();
        int squareBottom = player.getY() + player.getHeight();

        int otherObjectTop = otherObject.getY();
        int otherObjectBottom = otherObject.getY() + otherObject.getHeight();

        if (squareBottom > otherObjectTop && squareTop < otherObjectBottom) {
            verticalCollide = true;
        }

        boolean collide = horizontalCollide && verticalCollide;

        return collide;
    }

    private Dimond dimondCollider() {
        for (Dimond dimond : dimonds) {
            if (playerObjectCollider(player, dimond)) {
                return dimond;
            }
        }
        return null;
    }

    private boolean wallCollider(Player player) {
        for (Wall item : walls) {
            if (playerObjectCollider(player, item))
                return true;
        }
        return false;
    }

    public void update(long deltaMillis) {

        Dimond hitDimond = dimondCollider();
        if (hitDimond != null) {
            System.out.println("KA-SHING! " + hitDimond.getCoinId());
            dimonds.remove(hitDimond);
        }
    }

    public boolean canMove(int x, int y) {
        Player dummyPlayer = new Player(x, y);
        if (wallCollider(dummyPlayer)) {
            return false;
        }
        return true;
    }
}
