package torusristinolla.ui;

import javax.swing.WindowConstants;
import torusristinolla.logic.Game;

/**
 * Käyttöliittymä
 */

public class UI implements Runnable {
    
    private Layout frame;
    private Game game;

    public UI(Game game) {
        this.game = game;
    }
    
    @Override
    public void run() {
        this.frame = new Layout("Torusristinolla", game);
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        frame.addComponentsToPane(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }
    
    public void setGame(Game game) {
        this.game = game;
    }
    
}

