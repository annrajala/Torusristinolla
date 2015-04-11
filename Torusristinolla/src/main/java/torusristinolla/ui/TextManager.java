package torusristinolla.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import torusristinolla.logic.Game;
import torusristinolla.logic.Player;
import torusristinolla.logic.Token;


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
        if(game.isThereAWinner()) {
            game.resetBoard();
            
            Player winner = new Player(Token.EMPTY, "anon");
            
            if(game.whosTurn()) {
                winner = game.getPlayer2(); //Huom. pelaaja vaihtuu vuoron jälkeen. Siksi voittaja on edellisen vuoron pelaaja.
            } else {
                winner = game.getPlayer1();
            }
            
            JOptionPane.showMessageDialog(frame,
                    "Game over! Congratulations to " + (winner.getName()),
                    "Winner found!",
                    JOptionPane.PLAIN_MESSAGE);

            return;
        }
        
        if(game.whosTurn()) {
            this.player = game.getPlayer1();
        } else {
            this.player = game.getPlayer2();
        }
        
        System.out.println(x + " " + y);
        if (button.getText().isEmpty()) {
            button.setText(player.getTokenString());
        }
        game.playOneTurn(x, y);

    }
}

