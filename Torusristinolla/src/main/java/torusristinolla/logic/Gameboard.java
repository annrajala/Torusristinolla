package torusristinolla.logic;

public class Gameboard {
    
    private Square[][] board;
    private int width;
    private int height;
    
    public Gameboard(int height, int width) {
        if((height != width) || (height < 3) || (width < 3)) {
            this.height = 3;
            this.width = 3;
        } else {
            this.height = height;
            this.width = width;
        }
        this.board = createBoard(this.height, this.width);
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
    
    //Huom. ei tarvita metodia getHeight, koska width == height
    public int getWidth() {
        return width;
    }
    
    public Square[][] getBoard() {
        return board;
    }
    
    public void setToken(int x, int y, Token token) {
        board[x][y].setToken(token);
    }
    
    public Token getToken(int x, int y) {
        return board[x][y].getToken();
    }
    
}
