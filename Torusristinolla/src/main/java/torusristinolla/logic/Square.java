package torusristinolla.logic;

public class Square {
    
    //Käytetään tilan ilmaisemiseen SquareStatea, jotta meidän ei tarvitse turvautua merkkijonoihin
    private Token state;
    
    public Square() {
        this.state = Token.EMPTY;
    }
    
    public Token getToken() {
        return state;
    }
    
    public void setState(Token tila) {
        state = tila;
    }
    
   
}
