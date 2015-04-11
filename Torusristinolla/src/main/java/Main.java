import torusristinolla.logic.Game;
import torusristinolla.logic.Gameboard;
import torusristinolla.logic.Player;
import torusristinolla.logic.Token;
import torusristinolla.ui.UI;

//VIIKKO 4: KÄYTTÖLIITTYMÄ!!!
//VIIKKO 5: Mieti, miten saat parhaat tulokset totetutettua + parantele käyttöliittymää

// BUGI!! Voittaja tulee näkyviin vasta, kun toinen pelaaja klikkaa ruutua + mites toi resettaus?
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
