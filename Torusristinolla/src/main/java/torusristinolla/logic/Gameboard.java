package torusristinolla.logic;

/**
 * Ruuduista koostuva neliön muotoinen pelilauta
 */
public class Gameboard {
    
    private Square[][] board;
    private int width;
    
    /**
     * Pelilaudan konstruktori, joka huolehtii, että lauta on neliön muotoinen ja kooltaan vähintään 3x3
     * @param width pelilaudan leveys
     */
    public Gameboard(int width) {
        if(width < 3) {
            this.width = 3;
        } else {
            this.width = width;
        }
        this.board = createBoard(this.width, this.width);
    }
    
    
    /**
     * Luodaan pelilauta taulukkona ruutuja.
     * @param height laudan korkeus
     * @param width laudan leveys
     * @return luotu taulukko
     */
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
    
    public Square[][] getBoard() {
        return board;
    }
    
    /**
     * Asettaa pelilaudalle merkin
     * @param x merkin rivi
     * @param y merkin sarake
     * @param token merkki
     */
    public void setToken(int x, int y, Token token) {
        board[x][y].setToken(token);
    }
    
    /**
     * Palauttaa halutun merkin laudalta
     * @param x merkin rivi
     * @param y merkin sarake
     * @return halutussa ruudussa oleva merkki
     */
    public Token getToken(int x, int y) {
        return board[x][y].getToken();
    }
    
}
