import torusristinolla.logic.Game;
import torusristinolla.logic.Gameboard;
import torusristinolla.logic.Player;
import torusristinolla.logic.Token;
import torusristinolla.ui.UI;

//Mitä tapahtuu, jos voittajaa ei löydy?

public class Main {
    public static void main( String[] args ) {
        Player karo = new Player(Token.CROSS, "Karo");
        Player juulia = new Player(Token.CIRCLE, "Juulia");
        Gameboard lauta = new Gameboard(4);
        Game peli = new Game(lauta, karo, juulia);
        UI ui = new UI(peli);
        ui.run();
        
    }
}
