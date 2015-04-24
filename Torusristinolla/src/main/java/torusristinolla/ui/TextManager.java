package torusristinolla.ui;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import torusristinolla.logic.Game;
import torusristinolla.logic.Player;

/**
 * TextManager huolehtii pelimerkin, vuorossa olevan pelaajan ja voittajan tulostamisesta ruudulle
 */

public class TextManager implements ActionListener{

    private final JButton button;
    private final Game game;
    private int x;
    private int y;
    private Layout frame;
    private Player player;
    private Label playerInTurnField;

    
    public TextManager(JButton jb, Game g, int x, int y, Layout f, Label label) {
        this.button = jb;
        this.game = g;
        this.x = x;
        this.y = y;
        this.frame = f;
        this.playerInTurnField = label;
        this.player = game.getPlayer1();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Player previousPlayer = game.whosTurn();
        
        game.switchTurn();
        
        this.player = game.whosTurn();
        
        playerInTurnField.setText("Player: " + previousPlayer.getName());
        
        if (button.getText().isEmpty()) {
            button.setText(player.getTokenString());
        }
        
        game.playOneTurn(x, y);
        
        if(game.isThereAWinner()) {
            
            JOptionPane.showMessageDialog(frame,
                    "Game over! Congratulations to " + (this.player.getName()),
                    "Winner found!",
                    JOptionPane.PLAIN_MESSAGE);
            
            return;
        }
    }
}

