package torusristinolla.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Tämä luokka on reset-painikkeen kuuntelua varten
 */
public class ResetGameListener implements ActionListener {
    
    private Layout frame;
    
    
    public ResetGameListener(Layout frame) {
        super();
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.reset();
    }
    
}
