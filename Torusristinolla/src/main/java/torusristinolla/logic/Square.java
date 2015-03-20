package torusristinolla.logic;

public class Square {
    
    //Käytetään tilan ilmaisemiseen SquareStatea, jotta meidän ei tarvitse turvautua merkkijonoihin
    private Token token;
    
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
