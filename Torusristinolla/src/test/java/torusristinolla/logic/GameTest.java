
package torusristinolla.logic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {
    
    //VAATII HITOSTI LISÄÄ TAVARAA
    
    private Game game;
    private Pelaaja pelaaja1;
    private Pelaaja pelaaja2; //Ei ole keinoa pelin kautta hakea pelaajia. ONGELMA???

    @Before
    public void setUp() {
        pelaaja1 = new Pelaaja(Token.CIRCLE, "Ykkönen");
        pelaaja2 = new Pelaaja(Token.CROSS, "Kakkonen");
        Gameboard gb = new Gameboard(3, 3);
        game = new Game(gb, pelaaja1, pelaaja2);
    }
    
    @Test
    public void playerIsOnBoardReturnsFalseWhenCoordinatesNotOnBoard() {
        assertEquals(false, game.playerIsOnBoard(3, 3));
    }
    
    @Test
    public void playOneTurnSetsTokenOnTheBoard() {
        game.playOneTurn(0, 0);
        Square[][] lauta = game.getBoard().getBoard();
        assertEquals(Token.CIRCLE, lauta[0][0].getToken());
    }
    
    @Test
    public void inTheBeginningThereIsNoWinner() {
        assertEquals(false, game.isThereAWinner());
    }
    
    
    
    //TEHTY 3x3-RUUDUKOLLE
    @Test
    public void doesHorizontalWinningWork() {
        game.playOneTurn(1, 1);
        game.playOneTurn(0, 0);
        game.playOneTurn(1, 0);
        game.playOneTurn(2, 2);
        game.playOneTurn(1, 2);
        assertEquals(true, game.isThereAWinner());
    }
    
    
    //TEHTY 3x3-RUUDUKOLLE
    @Test
    public void doesVerticalWinningWork() {
        game.playOneTurn(1, 1);
        game.playOneTurn(0, 0);
        game.playOneTurn(0, 1);
        game.playOneTurn(2, 2);
        game.playOneTurn(2, 1);
        assertEquals(true, game.isThereAWinner());
    }
    
}
