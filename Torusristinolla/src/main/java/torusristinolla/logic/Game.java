package torusristinolla.logic;

//TOIMII VASTA 3x3-RUUDUKOLLA

public class Game {
    
    private Gameboard board;
    private boolean win; //True, jos jompikumpi pelaaja voittaa
    private boolean turn; //Kumman pelaajan  - true = pelaaja1 ja false = pelaaja2
    private Pelaaja pelaaja1;
    private Pelaaja pelaaja2;
    
    //PELAAJILLA EI SAA OLLA SAMAA MERKKIÄ
    //MITÄ TAPAHTUU, KUN WIN == TRUE?!
    public Game(Gameboard gb, Pelaaja pelaaja1, Pelaaja pelaaja2) {
        this.board = gb;
        this.win = false;
        this.turn = true;
        this.pelaaja1 = pelaaja1;
        this.pelaaja2 = pelaaja2;
    }
    
    public Gameboard getBoard() {
        return board;
    }
    
    public void playOneTurn(int x, int y) {
        Token merkki = Token.EMPTY;
        
        if(turn) {
            merkki = pelaaja1.getToken();
        } else {
            merkki = pelaaja2.getToken();
        }
        
        if(playerIsOnBoard(x,y)) {
            board.setToken(x, y, merkki);
            win = isPlayerWinning(x, y, merkki);
        }
        
        if(turn) {
            turn = false;
        } else {
            turn = true;
        }
    }
    
    public boolean playerIsOnBoard(int x, int y) {
        return (x >= 0 && x < board.getWidth() && y >= 0 && y < board.getHeight());
    }
    
    //Tarkistetaan, onko pelilaudalla voittotilanne toisen pelaajan hyväksi.
    private boolean isPlayerWinning(int x, int y, Token merkki) {

        return (horizontalWinningLine(x, y, merkki) || verticalWinningLine(x, y, merkki) || diagonalWinningLine(x, y, merkki));
    }
    
    //TOIMII VASTA 3x3-RUUDUKOLLA 
    private boolean horizontalWinningLine(int x, int y, Token token) {
        Square[][] lauta = board.getBoard();
        
        if((x-2 >= 0 && x-1 >= 0 && lauta[x-2][y].getToken() == token && lauta[x-1][y].getToken() == token)
            || (x-1 >= 0 && x+1 < board.getWidth() && lauta[x-1][y].getToken() == token && lauta[x+1][y].getToken() == token)
            || (x+1 < board.getWidth() && x+2 < board.getWidth() && lauta[x+1][y].getToken() == token && lauta[x+2][y].getToken() == token) ) {
            return true;
        }
        
        return false;
    }
    
    //TOIMII VASTA 3x3-RUUDUKOLLA
    private boolean verticalWinningLine(int x, int y, Token token) {
        Square[][] lauta = board.getBoard();
        
        if((y-2 >= 0 && y-1 >= 0 && lauta[x][y-2].getToken() == token && lauta[x][y-1].getToken() == token)
            || (y-1 >= 0 && y+1 < board.getWidth() && lauta[x][y-1].getToken() == token && lauta[x][y+1].getToken() == token)
            || (y+1 < board.getWidth() && y+2 < board.getWidth() && lauta[x][y+1].getToken() == token && lauta[x][y+2].getToken() == token) ) {
            return true;
        }
        
        return false;
    }
    
    //TEE TÄMÄ!
    private boolean diagonalWinningLine(int x, int y, Token token) {
        return false;
    }
    
    //private boolean isItPlayer1Turn() {
    //    return turn;
    //}
    
    public boolean isThereAWinner() {
        return win;
    }
    
    public void printGameboardInCurrentState() {
        Square[][] lauta = board.getBoard();
        
        
        for(int rivi = 0; rivi < board.getHeight(); rivi++) {
            for(int sarake = 0; sarake < board.getWidth(); sarake++) {
                if(lauta[rivi][sarake].getToken() == Token.CIRCLE) {
                    System.out.print(" O ");
                } else if(lauta[rivi][sarake].getToken() == Token.CROSS) {
                    System.out.print(" X ");
                } else  {
                    System.out.print(" [] ");
                }
            }
            System.out.println("");
        }
    }
}
