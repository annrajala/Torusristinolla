
package torusristinolla.logic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {
    
    //Lisää voittotapauksien testausta?
    
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
    public void doesHorizontalWinningWorkWithNormalVisualWinningLineAndLastTokenOnTheLeft() {
        game.playOneTurn(1, 1);
        game.playOneTurn(0, 0);
        game.playOneTurn(1, 0);
        game.playOneTurn(2, 2);
        game.playOneTurn(1, 2);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesHorizontalWinningWorkWithNormalVisualWinningLineAndLastTokenOnTheRight() {
        game.playOneTurn(1, 2);
        game.playOneTurn(0, 0);
        game.playOneTurn(1, 1);
        game.playOneTurn(2, 2);
        game.playOneTurn(1, 0);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesHorizontalWinningWorkWithNormalVisualWinningLineAndLastTokenInTheMiddle() {
        game.playOneTurn(1, 2);
        game.playOneTurn(0, 0);
        game.playOneTurn(1, 0);
        game.playOneTurn(2, 2);
        game.playOneTurn(1, 1);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesVerticalWinningWorkWithNormalVisualWinningLineAndWithLastTokenOnTheBottom() {
        game.playOneTurn(1, 1);
        game.playOneTurn(0, 0);
        game.playOneTurn(0, 1);
        game.playOneTurn(2, 2);
        game.playOneTurn(2, 1);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesVerticalWinningWorkWithNormalVisualWinningLineAndWithLastTokenOnTheTop() {
        game.playOneTurn(1, 1);
        game.playOneTurn(0, 0);
        game.playOneTurn(2, 1);
        game.playOneTurn(2, 2);
        game.playOneTurn(0, 1);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesVerticalWinningWorkWithNormalVisualWinningLineAndWithLastTokenInTheMiddle() {
        game.playOneTurn(0, 1);
        game.playOneTurn(0, 0);
        game.playOneTurn(2, 1);
        game.playOneTurn(2, 2);
        game.playOneTurn(1, 1);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesDiagonalWinningWorkWithNormalVisualDescendingWinningLineAndWithLastTokenOnTheBottom() {
        game.playOneTurn(0, 0);
        game.playOneTurn(0, 1);
        game.playOneTurn(1, 1);
        game.playOneTurn(2, 1);
        game.playOneTurn(2, 2);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesDiagonalWinningWorkWithNormalVisualDescendingWinningLineAndWithLastTokenOnTheTop() {
        game.playOneTurn(2, 2);
        game.playOneTurn(0, 1);
        game.playOneTurn(1, 1);
        game.playOneTurn(2, 1);
        game.playOneTurn(0, 0);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesDiagonalWinningWorkWithNormalVisualDescendingWinningLineAndWithLastTokenInTheMiddle() {
        game.playOneTurn(0, 0);
        game.playOneTurn(0, 1);
        game.playOneTurn(2, 2);
        game.playOneTurn(2, 1);
        game.playOneTurn(1, 1);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesDiagonalWinningWorkWithNormalVisualAscendingWinningLineAndWithLastTokenOnTheBottom() {
        game.playOneTurn(0, 2);
        game.playOneTurn(0, 0);
        game.playOneTurn(1, 1);
        game.playOneTurn(2, 1);
        game.playOneTurn(2, 0);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesDiagonalWinningWorkWithNormalVisualAscendingWinningLineAndWithLastTokenOnTheTop() {
        game.playOneTurn(2, 0);
        game.playOneTurn(0, 0);
        game.playOneTurn(1, 1);
        game.playOneTurn(2, 1);
        game.playOneTurn(0, 2);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesDiagonalWinningWorkWithNormalVisualAscendingWinningLineAndWithLastTokenInTheMiddle() {
        game.playOneTurn(2, 0);
        game.playOneTurn(0, 0);
        game.playOneTurn(0, 2);
        game.playOneTurn(2, 1);
        game.playOneTurn(1, 1);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesHorizontalWinningWorkWithNonVisualWinningLineAndWithLastTokenOnTheFarRight() {
        game.playOneTurn(1, 1);
        game.playOneTurn(0, 0);
        game.playOneTurn(1, 0);
        game.playOneTurn(2, 2);
        game.playOneTurn(1, 3);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesHorizontalWinningWorkWithNonVisualWinningLineAndWithLastTokenOnTheFarLeft() {
        game.playOneTurn(1, 2);
        game.playOneTurn(0, 0);
        game.playOneTurn(1, 3);
        game.playOneTurn(2, 2);
        game.playOneTurn(1, 0);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesHorizontalWinningWorkWithNonVisualWinningLineAndWithLastTokenSecondFromTheLeft() {
        game.playOneTurn(1, 0);
        game.playOneTurn(0, 0);
        game.playOneTurn(1, 3);
        game.playOneTurn(2, 2);
        game.playOneTurn(1, 1);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesHorizontalWinningWorkWithNonVisualWinningLineAndWithLastTokenSecondFromTheRight() {
        game.playOneTurn(1, 0);
        game.playOneTurn(0, 0);
        game.playOneTurn(1, 3);
        game.playOneTurn(2, 2);
        game.playOneTurn(1, 2);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesVerticalWinningWorkWithNonVisualWinningLineAndWithLastTokenOnTheBottom() {
        game.playOneTurn(1, 1);
        game.playOneTurn(0, 0);
        game.playOneTurn(0, 1);
        game.playOneTurn(2, 2);
        game.playOneTurn(3, 1);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesVerticalWinningWorkWithNonVisualWinningLineAndWithLastTokenOnTheTop() {
        game.playOneTurn(1, 1);
        game.playOneTurn(0, 0);
        game.playOneTurn(3, 1);
        game.playOneTurn(2, 2);
        game.playOneTurn(0, 1);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesVerticalWinningWorkWithNonVisualWinningLineAndWithLastTokenSecondFromTheTop() {
        game.playOneTurn(0, 1);
        game.playOneTurn(0, 0);
        game.playOneTurn(3, 1);
        game.playOneTurn(2, 2);
        game.playOneTurn(1, 1);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesVerticalWinningWorkWithNonVisualWinningLineAndWithLastTokenSecondFromTheBottom() {
        game.playOneTurn(0, 1);
        game.playOneTurn(0, 0);
        game.playOneTurn(3, 1);
        game.playOneTurn(2, 2);
        game.playOneTurn(2, 1);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesDiagonalWinningWorkWithLastTokenInTheTopLeftCorner() {
        game.playOneTurn(2, 3);
        game.playOneTurn(0, 1);
        game.playOneTurn(3, 2);
        game.playOneTurn(2, 1);
        game.playOneTurn(0, 0);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesDiagonalWinningWorkWithLastTokenInTheTopRightCorner() {
        game.playOneTurn(3, 1);
        game.playOneTurn(0, 1);
        game.playOneTurn(2, 0);
        game.playOneTurn(2, 1);
        game.playOneTurn(0, 3);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesDiagonalWinningWorkWithLastTokenInTheBottomRightCorner() {
        game.playOneTurn(0, 1);
        game.playOneTurn(1, 1);
        game.playOneTurn(1, 0);
        game.playOneTurn(2, 1);
        game.playOneTurn(3, 3);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesDiagonalWinningWorkWithLastTokenInTheBottomLeftCorner() {
        game.playOneTurn(1, 3);
        game.playOneTurn(0, 1);
        game.playOneTurn(0, 2);
        game.playOneTurn(2, 1);
        game.playOneTurn(3, 0);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesDiagonalWinningWorkWithLastTokenInTheBottomLeftCornerOnTheSecondRowFromTheBottom() {
        game.playOneTurn(0, 3);
        game.playOneTurn(0, 1);
        game.playOneTurn(3, 1);
        game.playOneTurn(2, 1);
        game.playOneTurn(2, 0);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesDiagonalWinningWorkWithLastTokenInTheBottomLeftCornerSecondFromTheLeft() {
        game.playOneTurn(0, 3);
        game.playOneTurn(0, 1);
        game.playOneTurn(2, 0);
        game.playOneTurn(2, 1);
        game.playOneTurn(3, 1);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesDiagonalWinningWorkWithLastTokenInTheBottomRightCornerSecondFromTheRight() {
        game.playOneTurn(0, 0);
        game.playOneTurn(0, 1);
        game.playOneTurn(2, 3);
        game.playOneTurn(2, 1);
        game.playOneTurn(3, 2);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesDiagonalWinningWorkWithLastTokenInTheBottomRightCornerOnTheSecondFromTheBottom() {
        game.playOneTurn(0, 0);
        game.playOneTurn(0, 1);
        game.playOneTurn(3, 2);
        game.playOneTurn(2, 1);
        game.playOneTurn(2, 3);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesDiagonalWinningWorkWithLastTokenInTheTopRightCornerOnTheSecondFromTheTop() {
        game.playOneTurn(3, 0);
        game.playOneTurn(0, 1);
        game.playOneTurn(0, 2);
        game.playOneTurn(2, 1);
        game.playOneTurn(1, 3);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesDiagonalWinningWorkWithLastTokenInTheTopRightCornerSecondFromTheRight() {
        game.playOneTurn(3, 0);
        game.playOneTurn(0, 1);
        game.playOneTurn(1, 3);
        game.playOneTurn(2, 1);
        game.playOneTurn(0, 2);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesDiagonalWinningWorkWithLastTokenInTheTopLeftCornerSecondFromTheLeft() {
        game.playOneTurn(3, 3);
        game.playOneTurn(0, 1);
        game.playOneTurn(1, 0);
        game.playOneTurn(2, 1);
        game.playOneTurn(0, 1);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesDiagonalWinningWorkWithLastTokenInTheTopLeftCornerOnTheSecondRowFromTheTop() {
        game.playOneTurn(3, 3);
        game.playOneTurn(0, 1);
        game.playOneTurn(0, 1);
        game.playOneTurn(2, 1);
        game.playOneTurn(1, 0);
        assertEquals(true, game.isThereAWinner());
    }
}
