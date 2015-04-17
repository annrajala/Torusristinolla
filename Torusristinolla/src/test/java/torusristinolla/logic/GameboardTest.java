package torusristinolla.logic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameboardTest {
    
    public GameboardTest() {
    }
    
    private Gameboard gb;
    
    @Before
    public void setUp() {
        gb = new Gameboard(3);
    }
    
    @Test
    public void setTokenSetsTokenRight() {
        gb.setToken(0, 0, Token.CROSS);
        Square[][] lauta = gb.getBoard();
        assertEquals(Token.CROSS, lauta[0][0].getToken());
    }
    
    @Test
    public void getTokenReturnsRightToken() {
        Square[][] lauta = gb.getBoard();
        lauta[0][0].setToken(Token.CIRCLE);
        assertEquals(Token.CIRCLE, gb.getToken(0,0));
    }
    
    
    @Test
    public void gameboardIs3x3SquareIfGivenWidthSmallerThanThree() {
        gb = new Gameboard(2);
        assertEquals(3, gb.getWidth());
    }
    
    @Test
    public void getWidthReturnsWidth() {
        assertEquals(3, gb.getWidth());
    }
    
    @Test
    public void getBoardReturnsRightSizeTable() {
        assertEquals(3, gb.getBoard().length);
    }
    
    

}
