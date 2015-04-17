package torusristinolla.logic;

/**
 * WinnerChecker tarkistaa, onko pelissä voittosuoraa
 */

//LOGIIKASSA BUGEJA!!!!!!!!!!!
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
        
        if((NVWLWithTokenOnTheBottom(x,y,token))
            || (NVWLWithTokenInTheMiddle(x,y,token))
            || (NVWLWithTokenOnTop(x,y,token))
            || (TVWLWithTokenOnTheVeryBottom(x,y,token))
            || (TVWLWithTokenOnTheSecondRowFromTheBottom(x,y,token)) 
            || (TVWLWithTokenOnTheVeryTop(x,y,token)) 
            || (TVWLWithTokenOnTheSecondRowFromTheTop(x,y,token)) ) {
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
        
        if((NHWLWithTokenOnTheRight(x,y,token))
            || (NHWLWithTokenInTheMiddle(x,y,token))
            || (NHWLWithTokenOnTheLeft(x,y,token))
            || (THWLWithTokenOnTheFarRight(x,y,token))
            || (THWLWithTokenSecondFromTheRight(x,y,token))
            || (THWLWithTokenOnTheFarLeft(x,y,token))
            || (THWLWithTokenSecondFromTheLeft(x,y,token)) ) {
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
        
        if((NDDWLWithTokenInTheMiddle(x,y,token))
             || (NDDWLWithTokenInTheBottom(x,y,token))
             || (NDDWLWithTokenOnTop(x,y,token))
             || (NDAWLWithTokenInTheMiddle(x,y,token))
             || (NDAWLWithTokenOnTop(x,y,token)) 
             || (NDAWLWithTokenInTheBottom(x,y,token))
             || (TDWLWhenTokenIsInTheTopLeftCorner(x,y,token))
             || (TDWLWhenTokenIsInTheTopRightCorner(x,y,token))
             || (TDWLWhenTokenIsInTheBottomLeftCorner(x,y,token))
             || (TDWLWhenTokenIsInTheBottomRightCorner(x,y,token))
             || (TDWLWhenTokenIsInTheTopLeftCornerSecondFromTheLeft(x,y,token))
             || (TDWLWhenTokenIsInTheTopLeftCornerOnTheSecondRowFromTheTop(x,y,token))
             || (TDWLWhenTokenIsInTheTopRightCornerSecondFromTheRight(x,y,token)) 
             || (TDWLWhenTokenIsInTheTopRightCornerOnTheSecondRowFromTheTop(x,y,token))
             || (TDWLWhenTokenIsInTheBottomLeftCornerOnTheSecondRowFromTheBottom(x,y,token))
             || (TDWLWhenTokenIsInTheBottomLeftCornerSecondFromTheLeft(x,y,token))
             || (TDWLWhenTokenIsInTheBottomRightCornerSecondFromTheRight(x,y,token))
             || (TDWLWhenTokenIsInTheBottomRightCornerOnTheSecondRowFromTheBottom(x,y,token))) {
            return true;
        }
        return false;
    }
    
    //NDDWL = NormalDiagonalDescendingWinningLine
    private boolean NDDWLWithTokenInTheMiddle(int x, int y, Token token) {
        if(x-1 >= 0 && x+1 < board.getWidth() && y-1 >= 0 && y+1 < board.getWidth() && board.getToken(x-1,y-1) == token && board.getToken(x+1,y+1) == token) {
            return true;
        }
        return false;
    }
    
    private boolean NDDWLWithTokenOnTop(int x, int y, Token token) {
        if(x+2 < board.getWidth() && y+2 < board.getWidth() && board.getToken(x+1,y+1) == token && board.getToken(x+2,y+2) == token) {
            return true;
        }
        return false;
    }
    
    private boolean NDDWLWithTokenInTheBottom(int x, int y, Token token) {
        if(x-2 >= 0 && y-2 >= 0 && board.getToken(x-1,y-1) == token && board.getToken(x-2, y-2) == token) {
            return true;
        }
        return false;
    }
    
    // NDAWL = NormalDiagonalAscendingWinningLine
    private boolean NDAWLWithTokenInTheMiddle(int x, int y, Token token) {
        if(x-1 >= 0 && x+1 < board.getWidth() && y-1 >= 0 && y+1 < board.getWidth() && board.getToken(x+1,y-1) == token && board.getToken(x-1,y+1) == token) {
            return true;
        }
        return false;
    }
    
    private boolean NDAWLWithTokenOnTop(int x, int y, Token token) {
        if(x+2 < board.getWidth() && y-2 >= 0 && board.getToken(x+1,y-1) == token && board.getToken(x+2,y-2) == token) {
            return true;
        }
        return false;
    }
    
    private boolean NDAWLWithTokenInTheBottom(int x, int y, Token token) {
        if(x-2 >= 0 && y+2 < board.getWidth() && board.getToken(x-1,y+1) == token && board.getToken(x-2,y+2) == token) {
            return true;
        }
        return false;
    }
    
    // DTWL = TorusDiagonalWinningLine
    private boolean TDWLWhenTokenIsInTheTopLeftCorner(int x, int y, Token token) {
        if(x == 0 && y == 0 && board.getToken(board.getWidth()-2,board.getWidth()-1) == token && board.getToken(board.getWidth()-1,board.getWidth()-2) == token) {
            return true;
        }
        return false;
    }
    
    private boolean TDWLWhenTokenIsInTheTopRightCorner(int x, int y, Token token) {
        if(x == 0 && y == board.getWidth()-1 && board.getToken(board.getWidth()-2,0) == token && board.getToken(board.getWidth()-1,1) == token) {
            return true;
        }
        return false;
    }
    
    private boolean TDWLWhenTokenIsInTheBottomLeftCorner(int x, int y, Token token) {
        if(x == board.getWidth()-1 && y == 0 && board.getToken(0,board.getWidth()-2) == token && board.getToken(1,board.getWidth()-1) == token) {
            return true;
        }
        return false;
    }
    
    private boolean TDWLWhenTokenIsInTheBottomRightCorner(int x, int y, Token token) {
        if(x == board.getWidth()-1 && y == board.getWidth()-1 && board.getToken(0,1) == token && board.getToken(1,0) == token) {
            return true;
        }
        return false;
    }
    
    private boolean TDWLWhenTokenIsInTheTopLeftCornerSecondFromTheLeft(int x, int y, Token token) {
        if(x == 0 && y == 1 && board.getToken(1,0) == token && board.getToken(board.getWidth()-1,board.getWidth()-1) == token) {
            return true;
        }
        return false;
    }
    
    private boolean TDWLWhenTokenIsInTheTopLeftCornerOnTheSecondRowFromTheTop(int x, int y, Token token) {
        if(x == 1 && y == 0 && board.getToken(0,1) == token && board.getToken(board.getWidth()-1,board.getWidth()-1) == token) {
            return true;
        }
        return false;
    }
    
    private boolean TDWLWhenTokenIsInTheTopRightCornerSecondFromTheRight(int x, int y, Token token) {
        if(x == 0 && y == board.getWidth()-2 && board.getToken(1,board.getWidth()-1) == token && board.getToken(board.getWidth()-1,0) == token) {
            return true;
        }
        return false;
    }
    
    private boolean TDWLWhenTokenIsInTheTopRightCornerOnTheSecondRowFromTheTop(int x, int y, Token token) {
        if(x == 1 && y == board.getWidth()-1 && board.getToken(0,board.getWidth()-2) == token && board.getToken(board.getWidth()-1,0) == token) {
            return true;
        }
        return false;
    }
    
    private boolean TDWLWhenTokenIsInTheBottomLeftCornerOnTheSecondRowFromTheBottom(int x, int y, Token token) {
        if(x == board.getWidth()-2 && y == 0 && board.getToken(board.getWidth()-1,1) == token && board.getToken(0,board.getWidth()-1) == token) {
            return true;
        }
        return false;
    }
    
    private boolean TDWLWhenTokenIsInTheBottomLeftCornerSecondFromTheLeft(int x, int y, Token token) {
        if(x == board.getWidth()-1 && y == 1 && board.getToken(board.getWidth()-2,0) == token && board.getToken(0,board.getWidth()-1) == token) {
            return true;
        }
        return false;
    }
    
    private boolean TDWLWhenTokenIsInTheBottomRightCornerSecondFromTheRight(int x, int y, Token token) {
        if(x == board.getWidth()-1 && y == board.getWidth()-2 && board.getToken(board.getWidth()-2,board.getWidth()-1) == token && board.getToken(0,0) == token) {
            return true;
        }
        return false;
    }
    
    private boolean TDWLWhenTokenIsInTheBottomRightCornerOnTheSecondRowFromTheBottom(int x, int y, Token token) {
        if(x == board.getWidth()-2 && y == board.getWidth()-1 && board.getToken(board.getWidth()-1,board.getWidth()-2) == token && board.getToken(0,0) == token) {
            return true;
        }
        return false;
    }
    
    // NHWL = NormalHorizontalWinningLine
    private boolean NHWLWithTokenInTheMiddle(int x, int y, Token token) {
        if(y-1 >= 0 && y+1 < board.getWidth() && board.getToken(x,y-1) == token && board.getToken(x,y+1) == token) {
            return true;
        }
        return false;
    }
    
    private boolean NHWLWithTokenOnTheRight(int x, int y, Token token) {
        if(y-2 >= 0 && y-1 >= 0 && board.getToken(x,y-2) == token && board.getToken(x,y-1) == token) {
            return true;
        }
        return false;
    }
    
    private boolean NHWLWithTokenOnTheLeft(int x, int y, Token token) {
        if(y+2 < board.getWidth() && board.getToken(x,y+1) == token && board.getToken(x,y+2) == token) {
            return true;
        }
        return false;
    }
    //THWL = TorusHorizontalWinningLine
    private boolean THWLWithTokenOnTheFarRight(int x, int y, Token token) {
        if((y+1 == board.getWidth() && board.getToken(x,0) == token && board.getToken(x,1) == token)
                || (y+1 == board.getWidth() && board.getToken(x, 0) == token && y-1 >= 0 && board.getToken(x, y-1) == token)) {
            return true;
        }
        return false;
    }
    
    private boolean THWLWithTokenOnTheFarLeft(int x, int y, Token token) {
        if((y-1 == -1 && board.getToken(x,board.getWidth()-1) == token && board.getToken(x,board.getWidth()-2) == token)
                || (y-1 == -1 && board.getToken(x, board.getWidth()-1) == token && y+1 < board.getWidth() && board.getToken(x, y+1) == token)) {
            return true;
        }
        return false;
    }
    
    private boolean THWLWithTokenSecondFromTheLeft(int x, int y, Token token) {
        if(y-1 == 0 && board.getToken(x, y-1) == token && board.getToken(x, board.getWidth()-1) == token) {
            return true;
        }
        return false;
    }
    
    private boolean THWLWithTokenSecondFromTheRight(int x, int y, Token token) {
        if(y+2 == board.getWidth() && board.getToken(x,y+1) == token && board.getToken(x,0) == token) {
            return true;
        }
        return false;
    }
    
    //NVWL = NormalVerticalWinningLine
    private boolean NVWLWithTokenInTheMiddle(int x, int y, Token token) {
        if(x-1 >= 0 && x+1 < board.getWidth() && board.getToken(x-1,y) == token && board.getToken(x+1,y) == token) {
            return true;
        }
        return false;
    }
    
    private boolean NVWLWithTokenOnTheBottom(int x, int y, Token token) {
        if(x-2 >= 0 && x-1 >= 0 && board.getToken(x-2,y) == token && board.getToken(x-1,y) == token) {
            return true;
        }
        return false;
    }
    
    private boolean NVWLWithTokenOnTop(int x, int y, Token token) {
        if(x+2 < board.getWidth() && board.getToken(x+1,y) == token && board.getToken(x+2,y) == token) {
            return true;
        }
        return false;
    }
    //TVWL = TorusVerticalWinningLine
    private boolean TVWLWithTokenOnTheVeryBottom(int x, int y, Token token) {
        if((x+1 == board.getWidth() && board.getToken(0,y) == token && board.getToken(1,y) == token)
                ||(x+1 == board.getWidth() && board.getToken(0, y) == token && x-1 >= 0 && board.getToken(x-1, y) == token)) {
            return true;
        }
        return false;
    }
    
    private boolean TVWLWithTokenOnTheVeryTop(int x, int y, Token token) {
        if((x-1 == -1 && board.getToken(board.getWidth()-1,y) == token && board.getToken(board.getWidth()-2,y) == token)
                || (x-1 == -1 && board.getToken(board.getWidth()-1, y) == token && x+1 < board.getWidth() && board.getToken(x+1, y) == token)) {
            return true;
        }
        return false;
    }
    
    private boolean TVWLWithTokenOnTheSecondRowFromTheBottom(int x, int y, Token token) {
        if(x+2 == board.getWidth() && board.getToken(x+1,y) == token && board.getToken(0,y) == token) {
            return true;
        }
        return false;
    }
    
    private boolean TVWLWithTokenOnTheSecondRowFromTheTop(int x, int y, Token token) {
        if(x-1 == 0 && board.getToken(board.getWidth()-1,y) == token && board.getToken(x-1,y) == token) {
            return true;
        }
        return false;
    }
}
