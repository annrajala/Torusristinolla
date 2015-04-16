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
    
    public Layout(String name, Game game) {
        super(name);
        setResizable(false);
        this.game = game;
        this.grid = new GridLayout(this.game.getBoard().getWidth(), this.game.getBoard().getWidth());
    }
    
    public void addComponentsToPane(final Container pane) {
        final JPanel components = new JPanel();
        JPanel texts = new JPanel();
        components.setLayout(grid);
        components.setPreferredSize(new Dimension(
                150 * game.getBoard().getWidth(),
                150 * game.getBoard().getWidth()));
        
        this.playerInTurn = new Label("Player: " + game.getPlayer1().getName());
        
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
        
        pane.add(components, BorderLayout.NORTH);
        pane.add(texts, BorderLayout.SOUTH);
    }
    
    public Label getPlayerInTurnField() {
        return this.playerInTurn;
    }
    
    public void reset() {
        game.resetGame();
        this.getContentPane().removeAll();
        this.addComponentsToPane(this.getContentPane());
        this.repaint();
        this.pack();
        setVisible(true);
    }
}