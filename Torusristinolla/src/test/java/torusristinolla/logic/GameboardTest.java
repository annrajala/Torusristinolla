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
        gb = new Gameboard(3,3);
    }
    
    @Test
    public void getWidthReturnsWidth() {
        assertEquals(3, gb.getWidth());
    }
    
    @Test
    public void getHeightReturnsHeight() {
        assertEquals(3, gb.getHeight());
    }
    
    //Onkohan tää nyt ihan oikein?
    @Test
    public void getBoardReturnsRightSizeTable() {
        assertEquals(3, gb.getBoard().length);
    }
    
    

}
