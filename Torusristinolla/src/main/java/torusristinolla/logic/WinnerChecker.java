package torusristinolla.logic;

/**
 * WinnerChecker tarkistaa, onko pelissä voittosuoraa
 */

public class WinnerChecker {
    
    private Gameboard board;
    
    public WinnerChecker(Gameboard board) {
        this.board = board;
    }
    
    /**
     * Tarkistetaan, syntyykö pelilaudalla voittotilanne toisen pelaajan hyväksi, kun tiedetään hänen viimeisimmän merkkinsä sijainti
     * @param x pelaajan merkin rivi
     * @param y pelaajan merkin sarake
     * @param merkki pelaajan merkki
     * @return true, jos pelaajan asettamalla merkillä syntyy voittosuora
     */
    public boolean isPlayerWinning(int x, int y, Token merkki) {

        return (verticalWinningLine(x, y, merkki) || horizontalWinningLine(x, y, merkki) || diagonalWinningLine(x, y, merkki));
    }
    
    /**
     * Tarkistaako, syntyykö voittajalle pystysuora voittolinja, kun tiedetään pelaajan viimeisen merkin sijainti
     * @param x merkin rivi
     * @param y merkin sarake
     * @param token pelaajan merkki
     * @return true, jos pelaajalla on voittava pystysuora
     */
    private boolean verticalWinningLine(int x, int y, Token token) {
        
        if((VWLWithTokenOnTheBottom(x,y,token))
            || (VWLWithTokenInTheMiddle(x,y,token))
            || (VWLWithTokenOnTop(x,y,token))) {
            return true;
        }
        
        return false;
    }
    
    /**
     * Tarkistaako, syntyykö voittajalle vaakasuora voittolinja, kun tiedetään pelaajan viimeisen merkin sijainti
     * @param x merkin rivi
     * @param y merkin sarake
     * @param token pelaajan merkki
     * @return true, jos pelaajalla on voittava vaakasuora
     */
    private boolean horizontalWinningLine(int x, int y, Token token) {
        
        if((HWLWithTokenOnTheRight(x,y,token))
            || (HWLWithTokenInTheMiddle(x,y,token))
            || (HWLWithTokenOnTheLeft(x,y,token))) {
            return true;
        }
        
        return false;
    }
    
    /**
     * Tarkistaako, syntyykö voittajalle vino voittosuora, kun tiedetään pelaajan viimeisen merkin sijainti
     * @param x merkin rivi
     * @param y merkin sarake
     * @param token pelaajan merkki
     * @return true, jos pelaajalla on voittava vinosuora
     */
    private boolean diagonalWinningLine(int x, int y, Token token) {
        if((DDWLWithTokenInTheMiddle(x,y,token))
             || (DDWLWithTokenInTheBottom(x,y,token))
             || (DDWLWithTokenOnTop(x,y,token))
             || (DAWLWithTokenInTheMiddle(x,y,token))
             || (DAWLWithTokenOnTop(x,y,token)) 
             || (DAWLWithTokenInTheBottom(x,y,token))) {
            return true;
        }
        return false;
    }
    
    //DDWL = DiagonalDescendingWinningLine
    private boolean DDWLWithTokenInTheMiddle(int x, int y, Token token) {
        if((x-1 >= 0 && x+1 < board.getWidth() && y-1 >= 0 && y+1 < board.getWidth() && board.getToken(x-1,y-1) == token && board.getToken(x+1,y+1) == token)
                || (x == 0 && y == 0 && board.getToken(x+1, y+1) == token && board.getToken(board.getWidth()-1, board.getWidth()-1) == token)
                || (x == 0 && y-1 >= 0 && y+1 <= board.getWidth()-1 && board.getToken(x+1, y+1) == token && board.getToken(board.getWidth()-1, y-1) == token)
                || (x == 0 && y == board.getWidth()-1 && board.getToken(x+1, 0) == token && board.getToken(board.getWidth()-1, y-1) == token)
                || (x-1 >= 0 && x+1 <= board.getWidth()-1 && y == 0 && board.getToken(x+1, y+1) == token && board.getToken(x-1, board.getWidth()-1) == token)
                || (x == board.getWidth()-1 && y == 0 && board.getToken(0, y+1) == token && board.getToken(x-1, board.getWidth()-1) == token)
                || (x == board.getWidth()-1 && y-1 >= 0 && y+1 <= board.getWidth()-1 && board.getToken(0, y+1) == token && board.getToken(x-1, y-1) == token)
                || (x == board.getWidth()-1 && y == board.getWidth()-1 && board.getToken(x-1, y-1) == token && board.getToken(0, 0) == token)
                || (x-1 >= 0 && x+1 <= board.getWidth()-1 && y == board.getWidth()-1 && board.getToken(x-1, y-1) == token && board.getToken(x+1, 0) == token)) {
            return true;
        }
        return false;
    }
    
    private boolean DDWLWithTokenOnTop(int x, int y, Token token) {
        if((x+2 < board.getWidth() && y+2 < board.getWidth() && board.getToken(x+1,y+1) == token && board.getToken(x+2,y+2) == token)
                || (x >= 0 && x+2 <= board.getWidth()-1 && y+2 == board.getWidth() && board.getToken(x+1, y+1) == token && board.getToken(x+2, 0) == token)
                || (x+2 == board.getWidth() && y+2 == board.getWidth() && board.getToken(x+1, y+1) == token && board.getToken(0, 0) == token)
                || (x >= 0 && x+2 <= board.getWidth()-1 && y == board.getWidth()-1 && board.getToken(x+1, 0) == token && board.getToken(x+2, 1) == token)
                || (x+2 == board.getWidth() && y == board.getWidth()-1 && board.getToken(x+1, 0) == token && board.getToken(0, 1) == token)
                || (x == board.getWidth()-1 && y == board.getWidth()-1 && board.getToken(0, 0) == token && board.getToken(1, 1) == token)
                || (x+2 == board.getWidth() && y >= 0 && y+2 <= board.getWidth()-1 && board.getToken(x+1, y+1) == token && board.getToken(0, y+2) == token)
                || (x+1 == board.getWidth() && y>= 0 && y+2 <= board.getWidth()-1 && board.getToken(0, y+1) == token && board.getToken(1, y+2) == token)
                || (x+1 == board.getWidth() && y+2 == board.getWidth() && board.getToken(0, y+1) == token && board.getToken(1, 0) == token)) {
            return true;
        }
        return false;
    }
    
    private boolean DDWLWithTokenInTheBottom(int x, int y, Token token) {
        if((x-2 >= 0 && y-2 >= 0 && board.getToken(x-1,y-1) == token && board.getToken(x-2, y-2) == token)
                || (x == 0 && y == 0 && board.getToken(board.getWidth()-1, board.getWidth()-1) == token && board.getToken(board.getWidth()-2, board.getWidth()-2) == token)
                || (x == 0 && y-2 >= 0 && y <= board.getWidth()-1 && board.getToken(board.getWidth()-2, y-2) == token && board.getToken(board.getWidth()-1, y-1) == token)
                || (x-2 >= 0 && x <= board.getWidth()-1 && y == 0 && board.getToken(x-2, board.getWidth()-2) == token && board.getToken(x-1, board.getWidth()-1) == token)
                || (x-1 == 0 && y-2 >= 0 && y <= board.getWidth()-1 && board.getToken(x-1, y-1) == token && board.getToken(board.getWidth()-1, y-2) == token)
                || (x == 0 && y-1 == 0 && board.getToken(board.getWidth()-1, y-1) == token && board.getToken(board.getWidth()-2, board.getWidth()-1) == token)
                || (x-1 == 0 && y == 0 && board.getToken(x-1, board.getWidth()-1) == token && board.getToken(board.getWidth()-1, board.getWidth()-2) == token)
                || (x-2 >= 0 && x <= board.getWidth()-1 && y-1 == 0 && board.getToken(x-1, y-1) == token && board.getToken(x-2, board.getWidth()-1) == token)
                || (x-1 == 0 && y-1 == 0 && board.getToken(x-1, y-1) == token && board.getToken(board.getWidth()-1, board.getWidth()-1) == token)) {
            return true;
        }
        return false;
    }
    
    // DAWL = DiagonalAscendingWinningLine
    private boolean DAWLWithTokenInTheMiddle(int x, int y, Token token) {
        if((x-1 >= 0 && x+1 < board.getWidth() && y-1 >= 0 && y+1 < board.getWidth() && board.getToken(x+1,y-1) == token && board.getToken(x-1,y+1) == token)
                || (x == 0 && y-1 >= 0 && y+1 <= board.getWidth()-1 && board.getToken(board.getWidth()-1, y+1) == token && board.getToken(x+1, y-1) == token)
                || (x == 0 && y == 0 && board.getToken(board.getWidth()-1, y+1) == token && board.getToken(1, board.getWidth()-1) == token)
                || (x == 0 && y == board.getWidth()-1 && board.getToken(x+1, y-1) == token && board.getToken(board.getWidth()-1, 0) == token)
                || (x-1 >= 0 && x+1 <= board.getWidth()-1 && y == 0 && board.getToken(x-1, y+1) == token && board.getToken(x+1, board.getWidth()-1) == token)
                || (x == board.getWidth()-1 && y == 0 && board.getToken(x-1, y+1) == token && board.getToken(0, board.getWidth()-1) == token)
                || (x == board.getWidth()-1 && y-1 >= 0 && y+1 <= board.getWidth()-1 && board.getToken(0, y-1) == token && board.getToken(x-1, y+1) == token)
                || (x == board.getWidth()-1 && y == board.getWidth()-1 && board.getToken(0, y-1) == token && board.getToken(board.getWidth()-2, 0) == token)
                || (x-1 >= 0 && x+1 <= board.getWidth()-1 && y == board.getWidth()-1 && board.getToken(x-1, 0) == token && board.getToken(x+1, y-1) == token)) {
            return true;
        }
        return false;
    }
    
    private boolean DAWLWithTokenOnTop(int x, int y, Token token) {
        if((x+2 < board.getWidth() && y-2 >= 0 && board.getToken(x+1,y-1) == token && board.getToken(x+2,y-2) == token)
                || (x >= 0 && x+2 <= board.getWidth()-1 && y-1 == 0 && board.getToken(x+1, y-1) == token && board.getToken(x+2, board.getWidth()-1) == token)
                || (x >= 0 && x+2 <= board.getWidth()-1 && y == 0 && board.getToken(x+1, board.getWidth()-1) == token && board.getToken(x+2, board.getWidth()-2) == token)
                || (x+1 == board.getWidth()-1 && y-1 == 0 && board.getToken(x+1, y-1) == token && board.getToken(0, board.getWidth()-1) == token)
                || (x+1 == board.getWidth()-1 && y-2 >= 0 && y <= board.getWidth()-1 && board.getToken(x+1, y-1) == token && board.getToken(0, y-2) == token)
                || (x == board.getWidth()-1 && y-2 >= 0 && y <= board.getWidth()-1 && board.getToken(0, y-1) == token && board.getToken(1, y-2) == token)
                || (x == board.getWidth()-1 && y-1 == 0 && board.getToken(0, y-1) == token && board.getToken(1, board.getWidth()-1) == token)
                || (x == board.getWidth()-1 && y == 0 && board.getToken(0, board.getWidth()-1) == token && board.getToken(1, board.getWidth()-2) == token)
                || (x+1 == board.getWidth()-1 && y == 0 && board.getToken(x+1, board.getWidth()-1) == token && board.getToken(0, board.getWidth()-2) == token)) {
            return true;
        }
        return false;
    }
    
    private boolean DAWLWithTokenInTheBottom(int x, int y, Token token) {
        if((x-2 >= 0 && y+2 < board.getWidth() && board.getToken(x-1,y+1) == token && board.getToken(x-2,y+2) == token)
                || (x == 0 && y >= 0 && y+2 <= board.getWidth()-1 && board.getToken(board.getWidth()-1, y+1) == token && board.getToken(board.getWidth()-2, y+2) == token)
                || (x == 0 && y+2 == board.getWidth() && board.getToken(board.getWidth()-1, y+1) == token && board.getToken(board.getWidth()-2, 0) == token)
                || (x == 0 && y+1 == board.getWidth() && board.getToken(board.getWidth()-1, 0) == token && board.getToken(board.getWidth()-2, 1) == token)
                || (x-1 == 0 && y >= 0 && y+2 <= board.getWidth()-1 && board.getToken(x-1, y+1) == token && board.getToken(board.getWidth()-1, y+2) == token)
                || (x-1 == 0 && y+2 == board.getWidth() && board.getToken(x-1, y+1) == token && board.getToken(board.getWidth()-1, 0) == token)
                || (x-1 == 0 && y+1 == board.getWidth() &&  board.getToken(x-1, 0) == token && board.getToken(board.getWidth()-1, 1) == token)
                || (x-2 >= 0 && x < board.getWidth()-1 && y+2 == board.getWidth() && board.getToken(x-1, y+1) == token && board.getToken(x-2, 0) == token)
                || (x-2 >= 0 && x < board.getWidth()-1 && y+1 == board.getWidth() && board.getToken(x-1, 0) == token && board.getToken(x-2, 1) == token)) {
            return true;
        }
        return false;
    }
    
    // HWL = HorizontalWinningLine
    private boolean HWLWithTokenInTheMiddle(int x, int y, Token token) {
        if((y-1 >= 0 && y+1 < board.getWidth() && board.getToken(x,y-1) == token && board.getToken(x,y+1) == token)
                || (y == 0 && board.getToken(x, y+1) == token && board.getToken(x, board.getWidth()-1) == token)
                || (y == board.getWidth()-1 && board.getToken(x, y-1) == token && board.getToken(x, 0) == token)) {
            return true;
        }
        return false;
    }
    
    private boolean HWLWithTokenOnTheRight(int x, int y, Token token) {
        if((y-2 >= 0 && y-1 >= 0 && board.getToken(x,y-2) == token && board.getToken(x,y-1) == token)
                || (y == 0 && board.getToken(x, board.getWidth()-1) == token && board.getToken(x, board.getWidth()-2) == token)
                || (y == 1 && board.getToken(x, 0) == token && board.getToken(x, board.getWidth()-1) == token)) {
            return true;
        }
        return false;
    }
    
    private boolean HWLWithTokenOnTheLeft(int x, int y, Token token) {
        if((y+2 < board.getWidth() && y >= 0 && board.getToken(x,y+1) == token && board.getToken(x,y+2) == token)
                || (y == board.getWidth()-2 && board.getToken(x, y+1) == token && board.getToken(x, 0) == token)
                || (y == board.getWidth()-1 && board.getToken(x, 0) == token && board.getToken(x, 1) == token)) {
            return true;
        }
        return false;
    }
    
    //VWL = VerticalWinningLine
    private boolean VWLWithTokenInTheMiddle(int x, int y, Token token) {
        if((x-1 >= 0 && x+1 < board.getWidth() && board.getToken(x-1,y) == token && board.getToken(x+1,y) == token)
                || (x == 0 && board.getToken(x+1, y) == token && board.getToken(board.getWidth()-1, y) == token)
                || (x == board.getWidth()-1 && board.getToken(x-1, y) == token && board.getToken(0, y) == token)) {
            return true;
        }
        return false;
    }
    
    private boolean VWLWithTokenOnTheBottom(int x, int y, Token token) {
        if((x-2 >= 0 && x-1 >= 0 && board.getToken(x-2,y) == token && board.getToken(x-1,y) == token)
                || (x == 0 && board.getToken(board.getWidth()-1, y) == token && board.getToken(board.getWidth()-2, y) == token)
                || (x == 1 && board.getToken(0, y) == token && board.getToken(board.getWidth()-1, y) == token)) {
            return true;
        }
        return false;
    }
    
    private boolean VWLWithTokenOnTop(int x, int y, Token token) {
        if((x+2 < board.getWidth() && board.getToken(x+1,y) == token && board.getToken(x+2,y) == token)
                || (x == board.getWidth()-1 && board.getToken(0, y) == token && board.getToken(1, y) == token)
                || (x == board.getWidth()-2 && board.getToken(x+1, y) == token && board.getToken(0, y) == token)) {
            return true;
        }
        return false;
    }
}
