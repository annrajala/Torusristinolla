
package torusristinolla.logic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testataan luokan Game toimivuutta.
 */

public class GameTest {
    
    private Game game;
    private Player player1;
    private Player player2;
   
    @Before
    public void setUp() {
        player1 = new Player(Token.CROSS, "Ykkönen");
        player2 = new Player(Token.CROSS, "Kakkonen");
        Gameboard gb = new Gameboard(4);
        game = new Game(gb, player1, player2);
    }
    
    @Test
    public void playersHaveDifferentTokens() {
        Token token = Token.EMPTY;
        if(player1.getToken() != Token.CIRCLE) {
            token = Token.CIRCLE;
        } else {
            token = Token.CROSS;
        }
        assertEquals(token, player2.getToken());
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
    
    @Test
    public void whosTurnReturnsPlayerOneInTheBeginning() {
        assertEquals(player1, game.whosTurn());
    }
    
    @Test
    public void switchTurnWorks() {
        game.switchTurn();
        assertEquals(player2, game.whosTurn());
    }
}
