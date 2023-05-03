import game.Game;

/**
 * The product of assignment 3.
 */
public class Ass3Game {
    /**
     * The entry point of the program.
     * @param args A String[]. Ignored
     */
    public static void main(String[] args) {
        Game game = new Game();
        game.initialize();
        game.run();
    }
}
