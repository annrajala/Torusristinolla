package torusristinolla.ui;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import torusristinolla.logic.Game;

/**
 * Layout huolehtii ruudulla näkyvän graafikan toteuttamisesta.
 */

public class Layout extends JFrame{
    private Game game;
    private GridLayout grid;
    private Label playerInTurn;
    private Label score1;
    private Label score2;
    private Label lap;
    
    /**
     * Luodaan frame.
     * @param name pelin nimi
     * @param game käytettävä Game-olio
     */
    public Layout(String name, Game game) {
        super(name);
        setResizable(false);
        this.game = game;
        this.grid = new GridLayout(this.game.getBoard().getWidth(), this.game.getBoard().getWidth());
    }
    
    /**
     * Lisätään containeriin ruudulle piirrettävän komponentit.
     * @param pane Tänne lisätään komponentit
     */
    public void addComponentsToPane(final Container pane) {
        final JPanel components = new JPanel();
        JPanel texts = new JPanel();
        JPanel situation = new JPanel();
        components.setLayout(grid);
        components.setPreferredSize(new Dimension(
                100 * game.getBoard().getWidth(),
                100 * game.getBoard().getWidth()));
        
        this.playerInTurn = new Label("Player: " + game.getPlayer2().getName());
        
        for (int y = 0; y < game.getBoard().getWidth(); y++) {
            for (int x = 0; x < game.getBoard().getWidth(); x++) {
                JButton j = new JButton();
                TextManager tm = new TextManager(j, game, x, y, this, playerInTurn);
                j.addActionListener(tm);
                j.setFont(new Font("Arial", Font.BOLD, 70));
                j.setOpaque(true);
                j.setBackground(Color.BLACK);
                components.add(j);
            }
        }
        
        texts.add(playerInTurn);
        
        Label vali = new Label("          ");
        texts.add(vali);
        
        ActionListener resetGameListener = new ResetGameListener(this);
        JMenuItem reset = new JMenuItem("Reset game");
        reset.addActionListener(resetGameListener);
        texts.add(reset);
        
        this.score1 = new Label(game.getPlayer1().getName() + " score: " + game.getPlayer1Score());
        Label vali2 = new Label("   ");
        this.score2 = new Label(game.getPlayer2().getName() + " score: " + game.getPlayer2Score());
        Label vali3 = new Label("   ");
        this.lap = new Label("Lap: " + game.getLap());
        
        situation.add(score1);
        situation.add(vali2);
        situation.add(score2);
        situation.add(vali3);
        situation.add(lap);
        
        pane.add(components, BorderLayout.NORTH);
        pane.add(situation, BorderLayout.CENTER);
        pane.add(texts, BorderLayout.SOUTH);
    }
    
    /**
     * Palauttaa kentän, johon vuorossa oleva pelaaja voidaan kirjoittaa vuoron vaihtuessa.
     * @return kenttä, johon vuorossa oleva pelaaja kirjoitetaan
     */
    public Label getPlayerInTurnField() {
        return this.playerInTurn;
    }
    
    /**
     * Resettaa pelilaudan ja pelin. Piirtää komponentit uudelleen.
     */
    public void reset() {
        game.resetGame();
        this.getContentPane().removeAll();
        this.addComponentsToPane(this.getContentPane());
        this.repaint();
        this.pack();
        setVisible(true);
    }
}
