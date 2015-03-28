import torusristinolla.logic.Game;
import torusristinolla.logic.Gameboard;
import torusristinolla.logic.Player;
import torusristinolla.logic.Token;

//VIIKKO 4: TEE KÄYTTÖLIITTYMÄ!!!
//VIIKKO 5: Mieti, miten saat parhaat tulokset totetutettua

//VOITTOON RIITTÄÄ 3:N MERKIN SUORA

public class Main {
    public static void main( String[] args ) {
        Player karo = new Player(Token.CROSS, "Karo");
        Player juulia = new Player(Token.CROSS, "Juulia");
        Gameboard lauta = new Gameboard(3, 3);
        Game peli = new Game(lauta, karo, juulia);
        peli.printGameboardInCurrentState();
        System.out.println("");
        peli.playOneTurn(0, 0);
        peli.printGameboardInCurrentState();
        System.out.println("");
        peli.playOneTurn(0, 1);
        peli.printGameboardInCurrentState();
        System.out.println("");
        peli.playOneTurn(2, 1);
        peli.printGameboardInCurrentState();
        System.out.println("");
        peli.playOneTurn(2, 2);
        peli.printGameboardInCurrentState();
        System.out.println("");
        peli.playOneTurn(1, 2);
        peli.printGameboardInCurrentState();
        System.out.println("");
        if(peli.isThereAWinner()) {
            System.out.println("JEE");
        }
    }
}
