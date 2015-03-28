package torusristinolla.logic;

public class Game {
    
    private Gameboard board;
    private boolean win; //True, jos jompikumpi pelaaja voittaa
    private boolean turn; //Kumman pelaajan  - true = pelaaja1 ja false = pelaaja2
    private Player player1;
    private Player player2;
    
    //PELAAJILLA EI SAA OLLA SAMAA MERKKIÄ - MITEN ESTETÄÄN?
    //MITÄ TAPAHTUU, KUN WIN == TRUE?!
    public Game(Gameboard gb, Player player1, Player player2) {
        this.board = gb;
        this.win = false;
        this.turn = true;
        this.player1 = player1;
        this.player2 = player2;
    }
    
    public Gameboard getBoard() {
        return board;
    }
    
    public void playOneTurn(int x, int y) {
        Token merkki = Token.EMPTY;
        
        if(turn) {
            merkki = player1.getToken();
        } else {
            merkki = player2.getToken();
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
        return (x >= 0 && x < board.getWidth() && y >= 0 && y < board.getWidth());
    }
    
    //Tarkistetaan, onko pelilaudalla voittotilanne toisen pelaajan hyväksi.
    private boolean isPlayerWinning(int x, int y, Token merkki) {

        return (verticalWinningLine(x, y, merkki) || horizontalWinningLine(x, y, merkki) || diagonalWinningLine(x, y, merkki));
    }
    
    private boolean verticalWinningLine(int x, int y, Token token) {
        
        if((isThereANormalVerticalWinningLineWithTokenOnTheBottom(x,y,token))
            || (isThereANormalVerticalWinningLineWithTokenInTheMiddle(x,y,token))
            || (isThereANormalVerticalWinningLineWithTokenOnTop(x,y,token))
            || (isThereAVerticalTorusWinningLineWithTokenOnTheVeryBottom(x,y,token))
            || (isThereAVerticalTorusWinningLineWithTokenOnTheSecondRowFromTheBottom(x,y,token)) 
            || (isThereAVerticalTorusWinningLineWithTokenOnTheVeryTop(x,y,token)) 
            || (isThereAVerticalTorusWinningLineWithTokenOnTheSecondRowFromTheTop(x,y,token)) ) {
            return true;
        }
        
        return false;
    }
    
    private boolean horizontalWinningLine(int x, int y, Token token) {
        
        if((isThereANormalHorizontalWinningLineWithTokenOnTheRight(x,y,token))
            || (isThereANormalHorizontalWinningLineWithTokenInTheMiddle(x,y,token))
            || (isThereANormalHorizontalWinningLineWithTokenOnTheLeft(x,y,token))
            || (isThereAHorizontalTorusWinningLineWithTokenOnTheFarRight(x,y,token))
            || (isThereAHorizontalTorusWinningLineWithTokenSecondFromTheRight(x,y,token))
            || (isThereAHorizontalTorusWinningLineWithTokenOnTheFarLeft(x,y,token))
            || (isThereAHorizontalTorusWinningLineWithTokenSecondFromTheLeft(x,y,token)) ) {
            return true;
        }
        
        return false;
    }
    
    private boolean diagonalWinningLine(int x, int y, Token token) {
        
        if((isThereANormalDiagonalDescendingWinningLineOnTheBoardWithTokenInTheMiddle(x,y,token))
             || (isThereANormalDiagonalDescendingWinningLineOnTheBoardWithTokenInTheBottom(x,y,token))
             || (isThereANormalDiagonalDescendingWinningLineOnTheBoardWithTokenOnTop(x,y,token))
             || (isThereANormalDiagonalAscendingWinningLineOnTheBoardWithTokenInTheMiddle(x,y,token))
             || (isThereANormalDiagonalAscendingWinningLineOnTheBoardWithTokenOnTop(x,y,token)) 
             || (isThereANormalDiagonalAscendingWinningLineOnTheBoardWithTokenInTheBottom(x,y,token))
             || (isThereADiagonalTorusWinningLineWhenTokenIsInTheTopLeftCorner(x,y,token))
             || (isThereADiagonalTorusWinningLineWhenTokenIsInTheTopRightCorner(x,y,token))
             || (isThereADiagonalTorusWinningLineWhenTokenIsInTheBottomLeftCorner(x,y,token))
             || (isThereADiagonalTorusWinningLineWhenTokenIsInTheBottomRightCorner(x,y,token))
             || (isThereADiagonalTorusWinningLineWhenTokenIsInTheTopLeftCornerSecondFromTheLeft(x,y,token))
             || (isThereADiagonalTorusWinningLineWhenTokenIsInTheTopLeftCornerOnTheSecondRowFromTheTop(x,y,token))
             || (isThereADiagonalTorusWinningLineWhenTokenIsInTheTopRightCornerSecondFromTheRight(x,y,token)) 
             || (isThereADiagonalTorusWinningLineWhenTokenIsInTheTopRightCornerOnTheSecondRowFromTheTop(x,y,token))
             || (isThereADiagonalTorusWinningLineWhenTokenIsInTheBottomLeftCornerOnTheSecondRowFromTheBottom(x,y,token))
             || (isThereADiagonalTorusWinningLineWhenTokenIsInTheBottomLeftCornerSecondFromTheLeft(x,y,token))
             || (isThereADiagonalTorusWinningLineWhenTokenIsInTheBottomRightCornerSecondFromTheRight(x,y,token))
             || (isThereADiagonalTorusWinningLineWhenTokenIsInTheBottomRightCornerOnTheSecondRowFromTheBottom(x,y,token))) {
            return true;
        }
        return false;
    }
    
    //private boolean isItPlayer1Turn() {
    //    return turn;
    //}
    
    public boolean isThereAWinner() {
        return win;
    }
    
    public void printGameboardInCurrentState() {
        
        for(int rivi = 0; rivi < board.getWidth(); rivi++) {
            for(int sarake = 0; sarake < board.getWidth(); sarake++) {
                if(board.getToken(rivi,sarake) == Token.CIRCLE) {
                    System.out.print(" O ");
                } else if(board.getToken(rivi,sarake) == Token.CROSS) {
                    System.out.print(" X ");
                } else  {
                    System.out.print(" [] ");
                }
            }
            System.out.println("");
        }
    }
    
    private boolean isThereANormalDiagonalDescendingWinningLineOnTheBoardWithTokenInTheMiddle(int x, int y, Token token) {
        if(x-1 >= 0 && x+1 < board.getWidth() && y-1 >= 0 && y+1 < board.getWidth() && board.getToken(x-1,y-1) == token && board.getToken(x+1,y+1) == token) {
            return true;
        }
        return false;
    }
    
    private boolean isThereANormalDiagonalDescendingWinningLineOnTheBoardWithTokenOnTop(int x, int y, Token token) {
        if(x+2 < board.getWidth() && y+2 < board.getWidth() && board.getToken(x+1,y+1) == token && board.getToken(x+2,y+2) == token) {
            return true;
        }
        return false;
    }
    
    private boolean isThereANormalDiagonalDescendingWinningLineOnTheBoardWithTokenInTheBottom(int x, int y, Token token) {
        if(x-2 >= 0 && y-2 >= 0 && board.getToken(x-1,y-1) == token && board.getToken(x-2, y-2) == token) {
            return true;
        }
        return false;
    }
    
    private boolean isThereANormalDiagonalAscendingWinningLineOnTheBoardWithTokenInTheMiddle(int x, int y, Token token) {
        if(x-1 >= 0 && x+1 < board.getWidth() && y-1 >= 0 && y+1 < board.getWidth() && board.getToken(x+1,y-1) == token && board.getToken(x-1,y+1) == token) {
            return true;
        }
        return false;
    }
    
    private boolean isThereANormalDiagonalAscendingWinningLineOnTheBoardWithTokenOnTop(int x, int y, Token token) {
        if(x+2 < board.getWidth() && y-2 >= 0 && board.getToken(x+1,y-1) == token && board.getToken(x+2,y-2) == token) {
            return true;
        }
        return false;
    }
    
    private boolean isThereANormalDiagonalAscendingWinningLineOnTheBoardWithTokenInTheBottom(int x, int y, Token token) {
        if(x-2 >= 0 && y+2 < board.getWidth() && board.getToken(x-1,y+1) == token && board.getToken(x-2,y+2) == token) {
            return true;
        }
        return false;
    }
    
    private boolean isThereADiagonalTorusWinningLineWhenTokenIsInTheTopLeftCorner(int x, int y, Token token) {
        if(x == 0 && y == 0 && board.getToken(board.getWidth()-2,board.getWidth()-1) == token && board.getToken(board.getWidth()-1,board.getWidth()-2) == token) {
            return true;
        }
        return false;
    }
    
    private boolean isThereADiagonalTorusWinningLineWhenTokenIsInTheTopRightCorner(int x, int y, Token token) {
        if(x == 0 && y == board.getWidth()-1 && board.getToken(board.getWidth()-2,0) == token && board.getToken(board.getWidth()-1,1) == token) {
            return true;
        }
        return false;
    }
    
    private boolean isThereADiagonalTorusWinningLineWhenTokenIsInTheBottomLeftCorner(int x, int y, Token token) {
        if(x == board.getWidth()-1 && y == 0 && board.getToken(0,board.getWidth()-2) == token && board.getToken(1,board.getWidth()-1) == token) {
            return true;
        }
        return false;
    }
    
    private boolean isThereADiagonalTorusWinningLineWhenTokenIsInTheBottomRightCorner(int x, int y, Token token) {
        if(x == board.getWidth()-1 && y == board.getWidth()-1 && board.getToken(0,1) == token && board.getToken(1,0) == token) {
            return true;
        }
        return false;
    }
    
    private boolean isThereADiagonalTorusWinningLineWhenTokenIsInTheTopLeftCornerSecondFromTheLeft(int x, int y, Token token) {
        if(x == 0 && y == 1 && board.getToken(1,0) == token && board.getToken(board.getWidth()-1,board.getWidth()-1) == token) {
            return true;
        }
        return false;
    }
    
    private boolean isThereADiagonalTorusWinningLineWhenTokenIsInTheTopLeftCornerOnTheSecondRowFromTheTop(int x, int y, Token token) {
        if(x == 1 && y == 0 && board.getToken(0,1) == token && board.getToken(board.getWidth()-1,board.getWidth()-1) == token) {
            return true;
        }
        return false;
    }
    
    private boolean isThereADiagonalTorusWinningLineWhenTokenIsInTheTopRightCornerSecondFromTheRight(int x, int y, Token token) {
        if(x == 0 && y == board.getWidth()-2 && board.getToken(1,board.getWidth()-1) == token && board.getToken(board.getWidth()-1,0) == token) {
            return true;
        }
        return false;
    }
    
    private boolean isThereADiagonalTorusWinningLineWhenTokenIsInTheTopRightCornerOnTheSecondRowFromTheTop(int x, int y, Token token) {
        if(x == 1 && y == board.getWidth()-1 && board.getToken(0,board.getWidth()-2) == token && board.getToken(board.getWidth()-1,0) == token) {
            return true;
        }
        return false;
    }
    
    private boolean isThereADiagonalTorusWinningLineWhenTokenIsInTheBottomLeftCornerOnTheSecondRowFromTheBottom(int x, int y, Token token) {
        if(x == board.getWidth()-2 && y == 0 && board.getToken(board.getWidth()-1,1) == token && board.getToken(0,board.getWidth()-1) == token) {
            return true;
        }
        return false;
    }
    
    private boolean isThereADiagonalTorusWinningLineWhenTokenIsInTheBottomLeftCornerSecondFromTheLeft(int x, int y, Token token) {
        if(x == board.getWidth()-1 && y == 1 && board.getToken(board.getWidth()-2,0) == token && board.getToken(0,board.getWidth()-1) == token) {
            return true;
        }
        return false;
    }
    
    private boolean isThereADiagonalTorusWinningLineWhenTokenIsInTheBottomRightCornerSecondFromTheRight(int x, int y, Token token) {
        if(x == board.getWidth()-1 && y == board.getWidth()-2 && board.getToken(board.getWidth()-2,board.getWidth()-1) == token && board.getToken(0,0) == token) {
            return true;
        }
        return false;
    }
    
    private boolean isThereADiagonalTorusWinningLineWhenTokenIsInTheBottomRightCornerOnTheSecondRowFromTheBottom(int x, int y, Token token) {
        if(x == board.getWidth()-2 && y == board.getWidth()-1 && board.getToken(board.getWidth()-1,board.getWidth()-2) == token && board.getToken(0,0) == token) {
            return true;
        }
        return false;
    }
    
    private boolean isThereANormalHorizontalWinningLineWithTokenInTheMiddle(int x, int y, Token token) {
        if(y-1 >= 0 && y+1 < board.getWidth() && board.getToken(x,y-1) == token && board.getToken(x,y+1) == token) {
            return true;
        }
        return false;
    }
    
    private boolean isThereANormalHorizontalWinningLineWithTokenOnTheRight(int x, int y, Token token) {
        if(y-2 >= 0 && y-1 >= 0 && board.getToken(x,y-2) == token && board.getToken(x,y-1) == token) {
            return true;
        }
        return false;
    }
    
    private boolean isThereANormalHorizontalWinningLineWithTokenOnTheLeft(int x, int y, Token token) {
        if(y+2 < board.getWidth() && board.getToken(x,y+1) == token && board.getToken(x,y+2) == token) {
            return true;
        }
        return false;
    }
    
    private boolean isThereAHorizontalTorusWinningLineWithTokenOnTheFarRight(int x, int y, Token token) {
        if(y+1 == board.getWidth() && board.getToken(x,0) == token && board.getToken(x,1) == token) {
            return true;
        }
        return false;
    }
    
    private boolean isThereAHorizontalTorusWinningLineWithTokenOnTheFarLeft(int x, int y, Token token) {
        if(y-1 == -1 && board.getToken(x,board.getWidth()-1) == token && board.getToken(x,board.getWidth()-2) == token) {
            return true;
        }
        return false;
    }
    
    private boolean isThereAHorizontalTorusWinningLineWithTokenSecondFromTheLeft(int x, int y, Token token) {
        if(y-1 == 0 && board.getToken(x, y-1) == token && board.getToken(x, board.getWidth()-1) == token) {
            return true;
        }
        return false;
    }
    
    private boolean isThereAHorizontalTorusWinningLineWithTokenSecondFromTheRight(int x, int y, Token token) {
        if(y+2 == board.getWidth() && board.getToken(x,y+1) == token && board.getToken(x,0) == token) {
            return true;
        }
        return false;
    }
    
    private boolean isThereANormalVerticalWinningLineWithTokenInTheMiddle(int x, int y, Token token) {
        if(x-1 >= 0 && x+1 < board.getWidth() && board.getToken(x-1,y) == token && board.getToken(x+1,y) == token) {
            return true;
        }
        return false;
    }
    
    private boolean isThereANormalVerticalWinningLineWithTokenOnTheBottom(int x, int y, Token token) {
        if(x-2 >= 0 && x-1 >= 0 && board.getToken(x-2,y) == token && board.getToken(x-1,y) == token) {
            return true;
        }
        return false;
    }
    
    private boolean isThereANormalVerticalWinningLineWithTokenOnTop(int x, int y, Token token) {
        if(x+2 < board.getWidth() && board.getToken(x+1,y) == token && board.getToken(x+2,y) == token) {
            return true;
        }
        return false;
    }
    
    private boolean isThereAVerticalTorusWinningLineWithTokenOnTheVeryBottom(int x, int y, Token token) {
        if(x+1 == board.getWidth() && board.getToken(0,y) == token && board.getToken(1,y) == token) {
            return true;
        }
        return false;
    }
    
    private boolean isThereAVerticalTorusWinningLineWithTokenOnTheVeryTop(int x, int y, Token token) {
        if(x-1 == -1 && board.getToken(board.getWidth()-1,y) == token && board.getToken(board.getWidth()-2,y) == token) {
            return true;
        }
        return false;
    }
    
    private boolean isThereAVerticalTorusWinningLineWithTokenOnTheSecondRowFromTheBottom(int x, int y, Token token) {
        if(x+2 == board.getWidth() && board.getToken(x+1,y) == token && board.getToken(0,y) == token) {
            return true;
        }
        return false;
    }
    
    private boolean isThereAVerticalTorusWinningLineWithTokenOnTheSecondRowFromTheTop(int x, int y, Token token) {
        if(x-1 == 0 && board.getToken(board.getWidth()-1,y) == token && board.getToken(x-1,y) == token) {
            return true;
        }
        return false;
    }
}
