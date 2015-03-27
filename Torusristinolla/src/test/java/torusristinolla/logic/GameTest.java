
package torusristinolla.logic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {
    
    private Game game;
    private Pelaaja pelaaja1;
    private Pelaaja pelaaja2; //Ei ole keinoa pelin kautta hakea pelaajia. ONGELMA???

    @Before
    public void setUp() {
        pelaaja1 = new Pelaaja(Token.CIRCLE, "Ykkönen");
        pelaaja2 = new Pelaaja(Token.CROSS, "Kakkonen");
        Gameboard gb = new Gameboard(4, 4);
        game = new Game(gb, pelaaja1, pelaaja2);
    }
    
    @Test
    public void playerIsOnBoardReturnsFalseWhenCoordinatesNotOnBoard() {
        assertEquals(false, game.playerIsOnBoard(4, 4));
    }
    
    @Test
    public void playOneTurnSetsTokenOnTheBoard() {
        game.playOneTurn(0, 0);
        assertEquals(Token.CIRCLE, game.getBoard().getToken(0,0));
    }
    
    @Test
    public void inTheBeginningThereIsNoWinner() {
        assertEquals(false, game.isThereAWinner());
    }
    
    
    //PITÄISIKÖ OLLA ENEMMÄN ERI VOITTOTAPAUKSIA TESTATTAVANA?!
    
    @Test
    public void doesHorizontalWinningWorkWithNormalVisualWinningLine() {
        game.playOneTurn(1, 1);
        game.playOneTurn(0, 0);
        game.playOneTurn(1, 0);
        game.playOneTurn(2, 2);
        game.playOneTurn(1, 2);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesVerticalWinningWorkWithNormalVisualWinningLine() {
        game.playOneTurn(1, 1);
        game.playOneTurn(0, 0);
        game.playOneTurn(0, 1);
        game.playOneTurn(2, 2);
        game.playOneTurn(2, 1);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesDiagonalWinningWorkWithNormalVisualDescendingWinningLine() {
        game.playOneTurn(0, 0);
        game.playOneTurn(0, 1);
        game.playOneTurn(1, 1);
        game.playOneTurn(2, 1);
        game.playOneTurn(2, 2);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesDiagonalWinningWorkWithNormalVisualAscendingWinningLine() {
        game.playOneTurn(0, 2);
        game.playOneTurn(0, 0);
        game.playOneTurn(1, 1);
        game.playOneTurn(2, 1);
        game.playOneTurn(2, 0);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesHorizontalWinningWorkWithNonVisualWinningLine() {
        game.playOneTurn(1, 1);
        game.playOneTurn(0, 0);
        game.playOneTurn(1, 0);
        game.playOneTurn(2, 2);
        game.playOneTurn(1, 3);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesVerticalWinningWorkWithNonVisualWinningLine() {
        game.playOneTurn(1, 1);
        game.playOneTurn(0, 0);
        game.playOneTurn(0, 1);
        game.playOneTurn(2, 2);
        game.playOneTurn(3, 1);
        assertEquals(true, game.isThereAWinner());
    }
    
    //TESTAA VINOA VOITTOSUORAA NIIN MAAN PERKELEESTI!
}
