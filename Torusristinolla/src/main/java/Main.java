import torusristinolla.logic.Game;
import torusristinolla.logic.Gameboard;
import torusristinolla.logic.Player;
import torusristinolla.logic.Token;
import torusristinolla.ui.UI;

public class Main {
    public static void main( String[] args ) {
        Player karo = new Player(Token.CROSS, "Janne");
        Player juulia = new Player(Token.CIRCLE, "Ansku");
        Gameboard lauta = new Gameboard(3);
        Game peli = new Game(lauta, karo, juulia);
        UI ui = new UI(peli);
        ui.run();
        
    }
}
