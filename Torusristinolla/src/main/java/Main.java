import torusristinolla.logic.Game;
import torusristinolla.logic.Gameboard;
import torusristinolla.logic.Player;
import torusristinolla.logic.Token;
import torusristinolla.ui.UI;

public class Main {
    public static void main( String[] args ) {
        Player p1 = new Player(Token.CROSS, "Player 1");
        Player p2 = new Player(Token.CIRCLE, "Player 2");
        Gameboard lauta = new Gameboard(4);
        Game peli = new Game(lauta, p2, p1);
        UI ui = new UI(peli);
        ui.run();
        
    }
}
