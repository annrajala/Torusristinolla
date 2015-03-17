package torusristinolla.logic;

public class Game {
    
    private Gameboard board;
    private boolean win;
    
    public Game(Gameboard lauta) {
        board = lauta;
    }
    
    public Gameboard getBoard() {
        return board;
    }
    
    //Tarkistetaan, onko pelilaudalla voittotilanne toisen pelaajan hyväksi.
    private boolean isPlayerWinning() {
        return (horizontalWinningLine() || verticalWinningLine() || diagonalWinningLine());
    }
    
    private boolean horizontalWinningLine() {
        return false;
    }

    private boolean verticalWinningLine() {
        return false;
    }
    
    private boolean diagonalWinningLine() {
        return false;
    }
    
    public void printGameboardInCurrentState() {
        Square[][] lauta = board.getLauta();
        
        System.out.println("HNNNG");
        
        for(int i = 0; i < board.getWidth(); i++) {
            System.out.print("_");
            System.out.println("");
        }
        
        for(int i = 0; i < board.getHeight(); i++) {
            System.out.print("|");
            for(int a = 0; a < board.getWidth(); a++) {
                if(lauta[i][a].getState() == SquareState.CIRCLE) {
                    System.out.print("O|");
                } else if(lauta[i][a].getState() == SquareState.CROSS) {
                    System.out.print("X|");
                } else  {
                    System.out.println(" |");
                }
            }
            System.out.println("");
        }
        
        for(int i = 0; i < board.getWidth(); i++) {
            System.out.print("_");
        }
    }
    
}
