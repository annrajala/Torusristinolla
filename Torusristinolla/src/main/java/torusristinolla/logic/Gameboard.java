package torusristinolla.logic;

public class Gameboard {
    
    private Square[][] board;
    private int width;
    private int height;
    
    //MITÄ JOS ON EPÄSOPIVAT PARAMETRIT? MINIMILAUTA?!
    //SAAKO OLLA EPÄNELIÖ?
    public Gameboard(int height, int width) {
        this.height = height;
        this.width = width;
        this.board = createBoard(height, width);
    }
    
    
    // Luodaan pelilauta taulukkona ruutuja.
    private Square[][] createBoard(int height, int width) {
        Square[][] ruudukko = new Square[height][width];
        
        for(int rivi = 0; rivi < height; rivi++) {
            for(int sarake = 0; sarake < width; sarake++) {
                ruudukko[rivi][sarake] = new Square();
            }
        }
        
        return ruudukko;
    }
    
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }
    
    public Square[][] getBoard() {
        return board;
    }
    
    public void setToken(int x, int y, Token token) {
        board[x][y].setToken(token);
    }
    
}
