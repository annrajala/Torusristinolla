package torusristinolla.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Tämä luokka on "New game"-painikkeen kuuntelua varten
 */
public class NewGameListener implements ActionListener {
    
    private Layout frame;
    
    public NewGameListener(Layout frame) {
        super();
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.reset();
    }
    
}
