package torusristinolla.logic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class WinnerCheckerTest {
    
    private Game game;
    private WinnerChecker checker;
  
    @Before
    public void setUp() {
        Player player1 = new Player(Token.CROSS, "Ykkönen");
        Player player2 = new Player(Token.CROSS, "Kakkonen");
        Gameboard gb = new Gameboard(4);
        game = new Game(gb, player1, player2);
        checker = new WinnerChecker(gb);
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
    public void doesDescendingDiagonalWinningWorkWithLastTokenInTheTopLeftCornerIfTheTokenIsInTheMiddleOfTheLine() {
        game.playOneTurn(1, 1);
        game.playOneTurn(0, 1);
        game.playOneTurn(3, 3);
        game.playOneTurn(2, 1);
        game.playOneTurn(0, 0);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesDescendingDiagonalWinningWorkWithLastTokenInTheTopRightCornerIfTheTokenIsInTheMiddleOfTheLine() {
        game.playOneTurn(1, 2);
        game.playOneTurn(0, 1);
        game.playOneTurn(3, 0);
        game.playOneTurn(2, 1);
        game.playOneTurn(0, 3);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesDescendingDiagonalWinningWorkWithLastTokenInTheBottomRightCornerIfTheTokenIsInTheMiddleOfTheLine() {
        game.playOneTurn(0, 0);
        game.playOneTurn(1, 1);
        game.playOneTurn(2, 2);
        game.playOneTurn(2, 1);
        game.playOneTurn(3, 3);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesDescendingDiagonalWinningWorkWithLastTokenInTheBottomLeftCornerIfTheTokenIsInTheMiddleOfTheLine() {
        game.playOneTurn(0, 1);
        game.playOneTurn(1, 1);
        game.playOneTurn(2, 3);
        game.playOneTurn(2, 1);
        game.playOneTurn(3, 0);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesDescendingDiagonalWinningWorkWithLastTokenInTheBottomLeftCornerOnTheSecondRowFromTheBottomIfTheTokenIsInTheMiddleOfTheLine() {
        game.playOneTurn(3, 1);
        game.playOneTurn(0, 1);
        game.playOneTurn(1, 3);
        game.playOneTurn(2, 1);
        game.playOneTurn(2, 0);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesDescendingDiagonalWinningWorkWithLastTokenInTheMiddleOfTheTopRowIfTheTokenIsInTheMiddleOfTheLine() {
        game.playOneTurn(1, 2);
        game.playOneTurn(0, 1);
        game.playOneTurn(3, 0);
        game.playOneTurn(2, 1);
        game.playOneTurn(0, 1);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesDiagonalWinningWorkWithLastTokenInTheMiddleOfTheBottomRowIfTheTokenIsInTheMiddleOfTheLine() {
        game.playOneTurn(2, 1);
        game.playOneTurn(0, 1);
        game.playOneTurn(0, 3);
        game.playOneTurn(2, 2);
        game.playOneTurn(3, 2);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesDescendingDiagonalWinningWorkWithLastTokenInTheBottomRightCornerOnTheSecondFromTheBottomIfTheTokenIsInTheMiddleOfTheLine() {
        game.playOneTurn(1, 2);
        game.playOneTurn(0, 1);
        game.playOneTurn(3, 0);
        game.playOneTurn(2, 1);
        game.playOneTurn(2, 3);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesDescendingDiagonalWinningWorkWithLastTokenInTheTopLeftCornerIfTheTokenIsOnTheBottomOfTheLine() {
        game.playOneTurn(3, 3);
        game.playOneTurn(0, 1);
        game.playOneTurn(2, 2);
        game.playOneTurn(2, 1);
        game.playOneTurn(0, 0);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesDescendingDiagonalWinningWorkWithLastTokenInTheMiddleOfTheTopRowIfTheTokenIsOnTheBottomOfTheLine() {
        game.playOneTurn(2, 0);
        game.playOneTurn(0, 1);
        game.playOneTurn(3, 1);
        game.playOneTurn(2, 1);
        game.playOneTurn(0, 2);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesDescendingDiagonalWinningWorkWithLastTokenSecondFromTheLeftOnTheTopRowIfTheTokenIsOnTheBottomOfTheLine() {
        game.playOneTurn(2, 3);
        game.playOneTurn(1, 1);
        game.playOneTurn(3, 0);
        game.playOneTurn(2, 1);
        game.playOneTurn(0, 1);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesDescendingDiagonalWinningWorkWithLastTokenInTheMiddleOfTheSecondRowIfTheTokenIsOnTheBottomOfTheLine() {
        game.playOneTurn(3, 0);
        game.playOneTurn(1, 1);
        game.playOneTurn(0, 1);
        game.playOneTurn(2, 1);
        game.playOneTurn(1, 2);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesDescendingDiagonalWinningWorkWithLastTokenInTheFarRightIfTheTokenIsOnTheBottomOfTheLine() {
        game.playOneTurn(1, 2);
        game.playOneTurn(0, 1);
        game.playOneTurn(2, 3);
        game.playOneTurn(2, 1);
        game.playOneTurn(3, 0);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesDescendingDiagonalWinningWorkWithLastTokenOnTheFarRightAndOnTheSecondTopRowIfTheTokenIsOnTheBottomOfTheLine() {
        game.playOneTurn(3, 2);
        game.playOneTurn(0, 1);
        game.playOneTurn(0, 3);
        game.playOneTurn(2, 1);
        game.playOneTurn(1, 0);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesDescendingDiagonalWinningWorkWithLastTokenSecondFromTheLeftAndOnTheBottomRowIfTheTokenIsOnTheBottomOfTheLine() {
        game.playOneTurn(2, 0);
        game.playOneTurn(0, 1);
        game.playOneTurn(1, 3);
        game.playOneTurn(2, 1);
        game.playOneTurn(3, 1);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesDescendingDiagonalWinningWorkWithLastTokeOnTheSecondRowSecondFromTheLeftIfTheTokenIsOnTheBottomOfTheLine() {
        game.playOneTurn(3, 3);
        game.playOneTurn(0, 1);
        game.playOneTurn(0, 0);
        game.playOneTurn(2, 1);
        game.playOneTurn(1, 1);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesDescendingDiagonalWinningWorkWithLastTokenInTheMiddleOfTheTopRowIfTheTokenIsOnTheTopOfTheLine() {
        game.playOneTurn(2, 0);
        game.playOneTurn(0, 1);
        game.playOneTurn(1, 3);
        game.playOneTurn(2, 1);
        game.playOneTurn(0, 2);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesDescendingDiagonalWinningWorkWithLastTokenInTheTopRightCornerIfTheTokenIsOnTheTopOfTheLine() {
        game.playOneTurn(2, 1);
        game.playOneTurn(0, 1);
        game.playOneTurn(1, 0);
        game.playOneTurn(2, 2);
        game.playOneTurn(0, 3);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesDescendingDiagonalWinningWorkWithLastTokenOnTheSecondRowFromTheBottomAndSecondFromTheLeftIfTheTokenIsOnTheTopOfTheLine() {
        game.playOneTurn(0, 0);
        game.playOneTurn(0, 1);
        game.playOneTurn(3, 3);
        game.playOneTurn(2, 1);
        game.playOneTurn(2, 2);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesDescendingDiagonalWinningWorkWithLastTokenOnTheSecondRowFromTheBottomAndOnTheFarRightIfTheTokenIsOnTheTopOfTheLine() {
        game.playOneTurn(0, 1);
        game.playOneTurn(1, 1);
        game.playOneTurn(3, 0);
        game.playOneTurn(2, 1);
        game.playOneTurn(2, 3);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesDescendingDiagonalWinningWorkWithLastTokenInTheBottomRightCornerIfTheTokenIsOnTheTopOfTheLine() {
        game.playOneTurn(0, 0);
        game.playOneTurn(0, 1);
        game.playOneTurn(1, 1);
        game.playOneTurn(2, 1);
        game.playOneTurn(3, 3);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesDescendingDiagonalWinningWorkWithLastTokenInTheMiddleOfTheSecondRowFromTheBottomIfTheTokenIsOnTheTopOfTheLine() {
        game.playOneTurn(0, 3);
        game.playOneTurn(0, 1);
        game.playOneTurn(3, 2);
        game.playOneTurn(2, 2);
        game.playOneTurn(2, 1);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesDescendingDiagonalWinningWorkWithLastTokenOnTheBottomLeftCornertIfTheTokenIsOnTheTopOfTheLine() {
        game.playOneTurn(1, 2);
        game.playOneTurn(1, 1);
        game.playOneTurn(0, 1);
        game.playOneTurn(2, 1);
        game.playOneTurn(3, 0);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesDescendingDiagonalWinningWorkWithLastTokenOnTheBottomRowAndSecondFromTheRighIfTheTokenIsOnTheTopOfTheLine() {
        game.playOneTurn(1, 0);
        game.playOneTurn(0, 1);
        game.playOneTurn(0, 3);
        game.playOneTurn(2, 1);
        game.playOneTurn(3, 2);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesAscendingDiagonalWinningWorkWithLastTokenOnTheTopLeftCornerIfTheTokenIsOnTheTopOfTheLine() {
        game.playOneTurn(2, 2);
        game.playOneTurn(0, 1);
        game.playOneTurn(1, 3);
        game.playOneTurn(2, 1);
        game.playOneTurn(0, 0);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesAscendingDiagonalWinningWorkWithLastTokenOnTheTopLeftCornerSecondFromTheLeftIfTheTokenIsOnTheTopOfTheLine() {
        game.playOneTurn(2, 3);
        game.playOneTurn(1, 1);
        game.playOneTurn(1, 0);
        game.playOneTurn(2, 1);
        game.playOneTurn(0, 1);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesAscendingDiagonalWinningWorkWithLastTokenOnTheSecondRowFromTheBottomAndSecondFromTheLeftIfTheTokenIsOnTheTopOfTheLine() {
        game.playOneTurn(0, 3);
        game.playOneTurn(0, 1);
        game.playOneTurn(3, 0);
        game.playOneTurn(2, 1);
        game.playOneTurn(2, 1);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesAscendingDiagonalWinningWorkWithLastTokenOnTheSecondRowFromTheBottomAndOnTheRightIfTheTokenIsOnTheTopOfTheLine() {
        game.playOneTurn(0, 0);
        game.playOneTurn(0, 1);
        game.playOneTurn(3, 1);
        game.playOneTurn(2, 1);
        game.playOneTurn(2, 2);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesAscendingDiagonalWinningWorkWithLastTokenOnTheBottomRowAndOnTheRightIfTheTokenIsOnTheTopOfTheLine() {
        game.playOneTurn(1, 1);
        game.playOneTurn(0, 1);
        game.playOneTurn(0, 2);
        game.playOneTurn(2, 1);
        game.playOneTurn(3, 3);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesAscendingDiagonalWinningWorkWithLastTokenOnTheBottomRowSecondFromTheLeftIfTheTokenIsOnTheTopOfTheLine() {
        game.playOneTurn(1, 3);
        game.playOneTurn(0, 1);
        game.playOneTurn(0, 0);
        game.playOneTurn(2, 1);
        game.playOneTurn(3, 1);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesAscendingDiagonalWinningWorkWithLastTokenOnTheBottomLeftCornerIfTheTokenIsOnTheTopOfTheLine() {
        game.playOneTurn(1, 2);
        game.playOneTurn(0, 1);
        game.playOneTurn(0, 3);
        game.playOneTurn(2, 1);
        game.playOneTurn(3, 0);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesAscendingDiagonalWinningWorkWithLastTokenOnTheSecondRowFromTheBottomAndOnTheFarLeftIfTheTokenIsOnTheTopOfTheLine() {
        game.playOneTurn(0, 2);
        game.playOneTurn(0, 1);
        game.playOneTurn(3, 3);
        game.playOneTurn(2, 1);
        game.playOneTurn(0, 0);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesAscendingDiagonalWinningWorkWithLastTokenInTheMiddleOfTheTopRowIfTheTokenIsInTheMiddleOfTheLine() {
        game.playOneTurn(3, 2);
        game.playOneTurn(0, 2);
        game.playOneTurn(1, 0);
        game.playOneTurn(2, 1);
        game.playOneTurn(0, 1);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesAscendingDiagonalWinningWorkWithLastTokenInTheTopLeftCornerIfTheTokenIsInTheMiddleOfTheLine() {
        game.playOneTurn(1, 3);
        game.playOneTurn(0, 1);
        game.playOneTurn(3, 1);
        game.playOneTurn(2, 1);
        game.playOneTurn(0, 0);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesAscendingDiagonalWinningWorkWithLastTokenInTheTopRightCornerIfTheTokenIsInTheMiddleOfTheLine() {
        game.playOneTurn(1, 2);
        game.playOneTurn(0, 1);
        game.playOneTurn(3, 0);
        game.playOneTurn(2, 1);
        game.playOneTurn(0, 3);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesAscendingDiagonalWinningWorkWithLastTokenInTheMiddleOfTheLeftmostColumnIfTheTokenIsInTheMiddleOfTheLine() {
        game.playOneTurn(3, 3);
        game.playOneTurn(0, 1);
        game.playOneTurn(1, 1);
        game.playOneTurn(2, 1);
        game.playOneTurn(2, 0);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesAscendingDiagonalWinningWorkWithLastTokenOnTheBottomLeftCornerIfTheTokenIsInTheMiddleOfTheLine() {
        game.playOneTurn(0, 3);
        game.playOneTurn(0, 1);
        game.playOneTurn(2, 1);
        game.playOneTurn(2, 2);
        game.playOneTurn(3, 0);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesAscendingDiagonalWinningWorkWithLastTokenInTheMiddleOfTheBottomRowIfTheTokenIsInTheMiddleOfTheLine() {
        game.playOneTurn(0, 1);
        game.playOneTurn(0, 2);
        game.playOneTurn(2, 3);
        game.playOneTurn(2, 2);
        game.playOneTurn(3, 2);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesAscendingDiagonalWinningWorkWithLastTokenOnTheBottomRightCornerIfTheTokenIsInTheMiddleOfTheLine() {
        game.playOneTurn(0, 2);
        game.playOneTurn(0, 1);
        game.playOneTurn(2, 0);
        game.playOneTurn(2, 2);
        game.playOneTurn(3, 3);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesAscendingDiagonalWinningWorkWithLastTokenInTheMiddleOfTheRightmostColumnIfTheTokenIsInTheMiddleOfTheLine() {
        game.playOneTurn(1, 0);
        game.playOneTurn(0, 1);
        game.playOneTurn(3, 1);
        game.playOneTurn(2, 2);
        game.playOneTurn(2, 3);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesAscendingDiagonalWinningWorkWithLastTokenInTheMiddleOfTheTopRowIfTheTokenIsInTheBottomOfTheLine() {
        game.playOneTurn(3, 2);
        game.playOneTurn(1, 1);
        game.playOneTurn(2, 3);
        game.playOneTurn(2, 2);
        game.playOneTurn(0, 1);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesAscendingDiagonalWinningWorkWithLastTokenOnTheTopRowSecondFromTheRightIfTheTokenIsInTheBottomOfTheLine() {
        game.playOneTurn(2, 0);
        game.playOneTurn(0, 1);
        game.playOneTurn(3, 3);
        game.playOneTurn(2, 2);
        game.playOneTurn(0, 2);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesAscendingDiagonalWinningWorkWithLastTokenOnTheTopRightCornerIfTheTokenIsInTheBottomOfTheLine() {
        game.playOneTurn(2, 1);
        game.playOneTurn(0, 1);
        game.playOneTurn(3, 0);
        game.playOneTurn(2, 2);
        game.playOneTurn(0, 3);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesAscendingDiagonalWinningWorkWithLastTokenInTheMiddleOfTheSecondColumnFromTheLeftIfTheTokenIsInTheBottomOfTheLine() {
        game.playOneTurn(3, 3);
        game.playOneTurn(0, 1);
        game.playOneTurn(0, 2);
        game.playOneTurn(2, 2);
        game.playOneTurn(1, 1);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesAscendingDiagonalWinningWorkWithLastTokenOnTheSecondRowFromTheTopSecondFromTheRightIfTheTokenIsInTheBottomOfTheLine() {
        game.playOneTurn(3, 0);
        game.playOneTurn(0, 1);
        game.playOneTurn(0, 3);
        game.playOneTurn(2, 2);
        game.playOneTurn(1, 2);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesAscendingDiagonalWinningWorkWithLastTokenOnTheSecondRowFromTheTopAndOnTheFarRightIfTheTokenIsInTheBottomOfTheLine() {
        game.playOneTurn(3, 1);
        game.playOneTurn(2, 1);
        game.playOneTurn(0, 1);
        game.playOneTurn(2, 2);
        game.playOneTurn(1, 3);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesAscendingDiagonalWinningWorkWithLastTokenInTheMiddleOfTheSecondColumnFromTheRightIfTheTokenIsInTheBottomOfTheLine() {
        game.playOneTurn(1, 3);
        game.playOneTurn(0, 1);
        game.playOneTurn(0, 0);
        game.playOneTurn(2, 3);
        game.playOneTurn(2, 2);
        assertEquals(true, game.isThereAWinner());
    }
    
    @Test
    public void doesAscendingDiagonalWinningWorkWithLastTokenInTheMiddleOfTheRightmostColumnIfTheTokenIsInTheBottomOfTheLine() {
        game.playOneTurn(0, 2);
        game.playOneTurn(0, 1);
        game.playOneTurn(1, 0);
        game.playOneTurn(2, 2);
        game.playOneTurn(2, 3);
        assertEquals(true, game.isThereAWinner());
    }
}
