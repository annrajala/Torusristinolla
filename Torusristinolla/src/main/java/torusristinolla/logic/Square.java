package torusristinolla.logic;

/**
 * Yksi ruutu pelilaudalla
 */
public class Square {
    
    private Token token;
    
    /**
     * Konstruktori asettaa ruudun merkin ensin tyhjäksi.
     */
    public Square() {
        this.token = Token.EMPTY;
    }
    
    public Token getToken() {
        return token;
    }
    
    public void setToken(Token merkki) {
        token = merkki;
    }
    
   
}
