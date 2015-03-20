import torusristinolla.logic.Game;
import torusristinolla.logic.Gameboard;
import torusristinolla.logic.Pelaaja;
import torusristinolla.logic.Token;

//NOTE TO SELF: TESTAA LISÄÄÄÄÄÄ
//NOTE TO SELF part 2: KÄYTTÖLIITTYMÄ PUUTTUU

public class Main {
    public static void main( String[] args ) {
        Pelaaja karo = new Pelaaja(Token.CIRCLE, "Karo");
        Pelaaja juulia = new Pelaaja(Token.CROSS, "Juulia");
        Gameboard lauta = new Gameboard(3, 3);
        Game peli = new Game(lauta, karo, juulia);
        peli.printGameboardInCurrentState();
        System.out.println("");
        peli.playOneTurn(1, 1);
        peli.printGameboardInCurrentState();
    }
}
