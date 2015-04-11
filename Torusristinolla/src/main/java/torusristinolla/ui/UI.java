package torusristinolla.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import torusristinolla.logic.Game;

public class UI implements Runnable{
    
    private JFrame frame;
    private Game game;

    public UI(Game game) {
        this.game = game;
    }
    
    public JFrame getFrame() {
        return frame;
    }

    @Override
    public void run() {
        frame = new JFrame("Ristinolla");
        frame.setPreferredSize(new Dimension(
                300 * game.getBoard().getWidth(),
                300 * game.getBoard().getWidth()));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }
    
    private void createComponents(Container container) {
        container.setLayout(new GridLayout(game.getBoard().getWidth(), game.getBoard().getWidth()));

        for (int y = 0; y < game.getBoard().getWidth(); y++) {
            for (int x = 0; x < game.getBoard().getWidth(); x++) {
                JButton j = new JButton();
                TextManager tm = new TextManager(j, game, x, y, frame);
                j.addActionListener(tm);
                j.setFont(new Font("Dialog", 1, 70));
                j.setOpaque(true);
                j.setBackground(Color.white);
                container.add(j);
                System.out.println("button " + x + y + "done"); //Tarvitsenko?
            }
        }
    }
    
}

