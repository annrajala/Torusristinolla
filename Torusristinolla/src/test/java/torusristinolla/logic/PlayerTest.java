package torusristinolla.logic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testataan luokan Player toimivuutta.
 */

public class PlayerTest {
    
    public PlayerTest() {
    }
    
    private Player pelaaja;
    
    @Before
    public void setUp() {
        pelaaja = new Player(Token.CIRCLE, "Nimetön");
    }
    
    @Test
    public void getNameReturnsPlayersName() {
        assertEquals("Nimetön", pelaaja.getName());
    }
    
    @Test
    public void getTokenReturnsPlayersToken() {
        assertEquals(Token.CIRCLE, pelaaja.getToken());
    }
    
    @Test
    public void doesChangeTokenWork() {
        pelaaja.changeToken();
        assertEquals(Token.CROSS, pelaaja.getToken());
    }
}
