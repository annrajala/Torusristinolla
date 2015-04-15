package torusristinolla.logic;

/**
 * Luokka huolehtii vuoron pelaamisista ja voiton tarkistuksista. Voittoon riittää 3 merkin voittosuora.
 * 
 * @param win true, jos pelissä on voittaja
 * @param playerInTurn vuorossa oleva pelaaja
 * 
 */

public class Game {
    
    private Gameboard board;
    private boolean win;
    private Player playerInTurn;
    private Player player1;
    private Player player2;
    private WinnerChecker checker;
    
    /**
     * Pelin konstruktori
     * 
     * @param gb käytettävä pelilauta
     * @param player1 ensimmäinen pelaaja
     * @param player2 toinen pelaaja
     */
    public Game(Gameboard gb, Player player1, Player player2) {
        this.board = gb;
        this.win = false;
        this.checker = new WinnerChecker(this.board);
        //Pelaajilla ei saa olla sama merkki
        if(player1.getToken() == player2.getToken()) { 
            player1.changeToken();
        }
        this.player1 = player1;
        this.player2 = player2;
        this.playerInTurn = this.player1;
    }
    
    public Gameboard getBoard() {
        return board;
    }
    
    /**
     * @return vuorossa oleva pelaaja
     */
    public Player whosTurn() {
        return this.playerInTurn;
    }
    
    public Player getPlayer1() {
        return this.player1;
    }
    
    public Player getPlayer2() {
        return this.player2;
    }
    
    /**
     * Suorittaa yhden vuoron pelaamisen eli asettaa vuorossa olevan pelaajan merkin laudalle ja tarkistaa, syntyykö tästä voittosuora
     * @param x asetettavan merkin rivi
     * @param y asetettavan merkin sarake
     */
    public void playOneTurn(int x, int y) {
        Token merkki = Token.EMPTY;
        
        merkki = this.playerInTurn.getToken();
        
        if(playerIsOnBoard(x,y)) {
            board.setToken(x, y, merkki);
            win = this.checker.isPlayerWinning(x, y, merkki);
        }
        
        if(win) {
            return;
        }
        
        switchTurn();
    }
    
    /**
     * Tarkistaa, onko pelaajan merkki laudalla
     * @param x merkin rivi
     * @param y merkin sarake
     * @return true, jos merkki on laudalla
     */
    public boolean playerIsOnBoard(int x, int y) {
        return (x >= 0 && x < board.getWidth() && y >= 0 && y < board.getWidth());
    }
    
    /**
     * Asettaa pelilaudan jälleen tyhjäksi
     */
    public void resetBoard() {

        for (int x = 0; x < board.getWidth(); x++) {
            for (int y = 0; y < board.getWidth(); y++) {
                if (board.getToken(x, y) != Token.EMPTY ) {
                    board.setToken(x, y, Token.EMPTY);
                }
            }
        }
    }
    
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
    
    public void switchTurn() {
        if(this.playerInTurn.equals(this.player1)) {
            this.playerInTurn = this.player2;
        } else {
            this.playerInTurn = this.player1;
        }
    }
}