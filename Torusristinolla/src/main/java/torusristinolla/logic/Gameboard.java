package torusristinolla.logic;

public class Gameboard {
    
    private Square[][] board;
    private int width;
    private int height;
    
    public Gameboard(int width, int height) {
        width = width;
        height = height;
        board = createBoard(width, height);
    }
    
    
    // Luodaan pelilauta taulukkona ruutuja.
    private Square[][] createBoard(int width, int height) {
        Square[][] ruudukko = new Square[width][height];
        
        for(int i = 0; i < width; i++) {
            for(int a = 0; a < height; a++) {
                ruudukko[i][a] = new Square();
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
    
    public Square[][] getLauta() {
        return board;
    }
    
}
