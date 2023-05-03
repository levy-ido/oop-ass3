package game;

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;
import game.collision.Collidable;
import game.sprites.Background;
import game.sprites.Ball;
import game.sprites.Block;
import game.sprites.Paddle;
import game.sprites.Sprite;

import java.awt.Color;

/**
 * Holds the sprites and collidables. Responsible for animating the sprites.
 */
public class Game {
    private final SpriteCollection sprites;
    private final GameEnvironment environment;
    private GUI gui;

    /**
     * Constructs a new Game object.
     */
    public Game() {
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
    }
    /**
     * Adds a given collidable to the games' environment.
     * @param c A Collidable representing the collidable to add to the games' environment
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * Adds a given sprite to the games' sprites.
     * @param s A Sprite representing the sprite to add to the games' sprites
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * Creates the borders of the game.
     */
    private void createBorders() {
        new Block(0.0, 0.0, 20.0, 600.0, Color.GRAY).addToGame(this);
        new Block(20.0, 0.0, 760.0, 20.0, Color.GRAY).addToGame(this);
        new Block(780.0, 0.0, 20.0, 600.0, Color.GRAY).addToGame(this);
        new Block(20.0, 580.0, 760.0, 20.0, Color.GRAY).addToGame(this);
    }

    /**
     * Creates the balls of the game.
     */
    private void createBalls() {
        Ball ball1 = new Ball(200.0, 300.0, 10, Color.WHITE);
        ball1.setVelocity(0.0, 5.0);
        ball1.setGameEnvironment(this.environment);
        ball1.addToGame(this);
        Ball ball2 = new Ball(600.0, 300.0, 10, Color.WHITE);
        ball2.setVelocity(0.0, 5.0);
        ball2.setGameEnvironment(this.environment);
        ball2.addToGame(this);
    }

    private void createPaddle() {
        Paddle paddle = new Paddle(350.0, 550.0, 100.0, 30.0, Color.YELLOW, gui.getKeyboardSensor());
        paddle.addToGame(this);
    }

    /**
     * Initializes this game.
     */
    public void initialize() {
        this.gui = new GUI("Game Title", 800, 600);
        createBackground();
        createBorders();
        createBalls();
        createPaddle();
        createBlocks();
    }

    /**
     * Creates the games' background.
     */
    private void createBackground() {
        new Background(20.0, 20.0, 760.0, 560.0, Color.BLUE).addToGame(this);
    }

    /**
     * Creates the games' block patterns.
     */
    private void createBlocks() {
        Color[] colorArray = {Color.GRAY, Color.RED, Color.YELLOW, Color.BLUE, Color.PINK, Color.GREEN};
        double blockWidth = 760.0 / 16.0;
        double blockHeight = 560.0 / 20.0;
        double blockX = 20.0 + 4.0 * blockWidth;
        for (int i = 0; i < colorArray.length; ++i) {
            double y = 20.0 + 3.0 * blockHeight + i * blockHeight;
            for (int j = 0; j < 12 - i; ++j) {
                double x = blockX + j * blockWidth;
                new Block(x, y, blockWidth, blockHeight, colorArray[i]).addToGame(this);
            }
            blockX += blockWidth;
        }
    }

    /**
     * Animates the game.
     */
    public void run() {
        int framesPerSecond = 60;
        int millisecondsPerFrame = 1000 / framesPerSecond;
        Sleeper sleeper = new Sleeper();
        while (true) {
            long startTime = System.currentTimeMillis();
            DrawSurface d = gui.getDrawSurface();
            this.sprites.drawAllOn(d);
            gui.show(d);
            this.sprites.notifyAllTimePassed();
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}
