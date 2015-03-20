package torusristinolla.logic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SquareTest {
    
    public SquareTest() {
    }
    
    private Square ruutu;
    
    @Before
    public void setUp() {
        ruutu = new Square();
    }
    
    @Test
    public void createdSquareIsEmpty() {
        assertEquals(Token.EMPTY, ruutu.getToken());
    }
    
    @Test
    public void setTokenToSquareWorks() {
        ruutu.setToken(Token.CROSS);
        assertEquals(Token.CROSS, ruutu.getToken());
    }
}
