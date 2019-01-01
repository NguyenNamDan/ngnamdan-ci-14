import game.GameWindow;

/**
 * Created by huynq on 7/4/17.
 */
public class Program {
    public static void main(String[] args) {
        GameWindow window = new GameWindow(); // cửa sổ game
        window.gamePanel.gameLoop();
    }
}
