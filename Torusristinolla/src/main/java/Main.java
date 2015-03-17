import torusristinolla.logic.Game;
import torusristinolla.logic.Gameboard;

public class Main {
    public static void main( String[] args ) {
        Game peli = new Game(new Gameboard(3, 3));
        peli.printGameboardInCurrentState();
    }
}
