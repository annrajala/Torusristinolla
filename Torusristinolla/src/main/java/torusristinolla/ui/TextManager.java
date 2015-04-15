package torusristinolla.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import torusristinolla.logic.Game;
import torusristinolla.logic.Player;
import torusristinolla.logic.Token;

/**
 * TextManager huolehtii voittajan tulostamisesta ruudulle
 */

public class TextManager implements ActionListener{

    private final JButton button;
    private final Game game;
    private int x;
    private int y;
    private JFrame frame;
    private Player player;

    
    public TextManager(JButton jb, Game g, int x, int y, JFrame f) {
        this.button = jb;
        this.game = g;
        this.x = x;
        this.y = y;
        this.frame = f;
        this.player = game.getPlayer1();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        this.player = game.whosTurn();
        
        System.out.println(x + " " + y);
        if (button.getText().isEmpty()) {
            button.setText(player.getTokenString());
        }
        game.playOneTurn(x, y);
        
        if(game.isThereAWinner()) {
            game.resetBoard(); //Tää ei nyt oo ihan ok...
            
            JOptionPane.showMessageDialog(frame,
                    "Game over! Congratulations to " + (game.whosTurn().getName()),
                    "Winner found!",
                    JOptionPane.PLAIN_MESSAGE);

            return;
        }
    }
}

