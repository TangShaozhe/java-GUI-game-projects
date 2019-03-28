/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maze;

import com.sun.org.apache.xalan.internal.lib.ExsltDatetime;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;
import javafx.scene.input.KeyCharacterCombination;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.KeyStroke;
import javax.swing.Timer;

/**
 *
 * @author Tang
 */
public class GameEngine extends JPanel {

    private final int FPS = 240;

    private JPanel boardPanel;
    
    private final int Player_Width = 25;
    private final int Player_Height = 25;
    private final int Dragon_Diameter =25;

    private boolean paused = false;
    private Image background;
    private int levelNum = 0;
    private Level level;
    private Dragon dragon;
    private Player player;
    private Timer newFrameTimer;
    private final Timer timer;
    private char keypress;
    private Sprite exit;
    private JLabel timeLabel;


    private Long startTime;

    public GameEngine() {
        super();
        exit = new Sprite(19 * 30, 0 * 30, 30, 30, new ImageIcon("data/images/ddd.png").getImage());
        
        this.getInputMap().put(KeyStroke.getKeyStroke("A"), "pressed left");
        this.getActionMap().put("pressed left", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                keypress = 'L';
            }
        });
        this.getInputMap().put(KeyStroke.getKeyStroke("D"), "pressed right");
        this.getActionMap().put("pressed right", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                keypress = 'R';
            }
        });
        this.getInputMap().put(KeyStroke.getKeyStroke("W"), "pressed up");
        this.getActionMap().put("pressed up", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                keypress = 'U';
            }
        });
        this.getInputMap().put(KeyStroke.getKeyStroke("S"), "pressed down");
        this.getActionMap().put("pressed down", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                keypress = 'D';
            }
        });
        
        this.getInputMap().put(KeyStroke.getKeyStroke("ESCAPE"), "escape");
        this.getActionMap().put("escape", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                paused = !paused;
            }
        });
        restart();
        newFrameTimer = new Timer(1000 / FPS, new NewFrameListener());
        newFrameTimer.start();
        
                timeLabel = new JLabel(" ");

        timeLabel.setHorizontalAlignment(JLabel.RIGHT);
        timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeLabel.setText(elapsedTime() + " ms");
            }
        });
        startTime = System.currentTimeMillis();
        timer.start();
        
        
    }
    
    public long elapsedTime() {
            return System.currentTimeMillis() - startTime;
    }

    public void restart() {
        try {
            level = new Level("data/levels/level0" + levelNum + ".txt");
        } catch (IOException ex) {
            Logger.getLogger(GameEngine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        Image playerImage = new ImageIcon("data/images/baby.jpg").getImage();
        player = new Player(40, 580, Player_Width, Player_Height, playerImage);
        Image dragonImage = new ImageIcon("data/images/dragon.png").getImage();
        dragon = new Dragon(0, 0, Dragon_Diameter, Dragon_Diameter, dragonImage);
        dragon.random(level.getBrickLists(), player);
        
        startTime = System.currentTimeMillis();
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        grphcs.drawImage(background, 0, 0, 900, 600, null);
        level.draw(grphcs);
        dragon.draw(grphcs);
        exit.draw(grphcs);
        player.draw(grphcs);
    }

    class NewFrameListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
        
            if (!paused) {
                player.move(keypress, level.getBrickLists());
                keypress = 'B';
                dragon.move(level.getBrickLists());

                if (dragon.collidesWith(player)) {

                    restart();
                }

                if(player.collidesWith(exit))
                {
                    JOptionPane.showMessageDialog(boardPanel,"congratulations! You find your path to succeed");
                    Long endTime = System.currentTimeMillis();
                    Long time = endTime - startTime;
                    String name = MazeGUI.getPlayerName();
                    GameRank.addData(time, name);
                    try {
                        GameRank.SaveData("data/data.dat");
                    } catch (IOException ex) {
                        Logger.getLogger(GameEngine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                    }
                    
                    int valuex=JOptionPane.showConfirmDialog(boardPanel,
                                    "Whether to continue the game？", "Please make sure the",
                                    JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if (valuex==JOptionPane.NO_OPTION) {
                        System.exit(0);
                    }
                    restart();
                }
                repaint();
            }
       
        }
    }}

