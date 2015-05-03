package torusristinolla.logic;

import java.util.HashMap;

/**
 * Luokka huolehtii vuoron pelaamisista. Voittoon riittää 3 merkin voittosuora.
 */

public class Game {
    
    private Gameboard board;
    private boolean win;
    private Player playerInTurn;
    private Player player1;
    private Player player2;
    private WinnerChecker checker;
    private HashMap<Player, Integer> wins;
    private Integer round;
    
    /**
     * Pelin konstruktori
     * 
     * @param gb käytettävä pelilauta
     * @param player1 ensimmäinen pelaaja
     * @param player2 toinen pelaaja
     * 
     * Konstruktori pitää huolen, ettei pelaajilla ole samaa merkkiä.
     * Konstruktorissa luodaan WinnerChecker, asetetaan vuorossa ensin oleva pelaaja ja luodaan voitoista kirjaa pitävä HashMap, jonne kummallekin pelaajalle laitetaan aluksi voittojen lukumääräksi nolla.
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
        this.wins = new HashMap<Player, Integer>();
        this.wins.put(player1, 0);
        this.wins.put(player2, 0);
        this.round = 1;
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
        
        //Pelaaja ei voi asettaa merkkiä ruutun, jos siinä on jo jokin muu merkki
        if(playerIsOnBoard(x,y) && board.getToken(x, y) == Token.EMPTY) {
            board.setToken(x, y, merkki);
            win = this.checker.isPlayerWinning(x, y, merkki);
        }
        
        if(win) {
            this.wins.put(playerInTurn, this.wins.get(playerInTurn) + 1);
            return;
        }
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
                    board.setToken(x, y, Token.EMPTY);
            }
        }
    }
    
    public void resetGame() {
        resetBoard();
        this.win = false;
        this.playerInTurn = this.player1;
        this.round++;
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
    
    public int getPlayer1Score() {
        return this.wins.get(player1);
    }
    
    public int getPlayer2Score() {
        return this.wins.get(player2);
    }
    
    public int getRound() {
        return this.round;
    }
}