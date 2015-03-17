package torusristinolla.logic;

public class Square {
    
    //Käytetään tilan ilmaisemiseen luokkaa SquareState, jotta meidän ei tarvitse turvautua merkkijonoihin
    private SquareState state;
    
    public Square() {
        state = SquareState.EMPTY;
    }
    
    public SquareState getState() {
        return state;
    }
    
    public void setState(SquareState tila) {
        state = state;
    }
    
   
}
