package torusristinolla.logic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PelaajaTest {
    
    public PelaajaTest() {
    }
    
    private Pelaaja pelaaja;
    
    @Before
    public void setUp() {
        pelaaja = new Pelaaja(Token.CIRCLE, "Nimetön");
    }
    
    @Test
    public void getNameReturnsPlayersName() {
        assertEquals("Nimetön", pelaaja.getName());
    }
    
    @Test
    public void getTokenReturnsPlayersToken() {
        assertEquals(Token.CIRCLE, pelaaja.getToken());
    }
}
