/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maze;

import java.awt.Graphics;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import javax.swing.ImageIcon;

/**
 *
 * @author Tang
 */
public class Level {

    private final int Brick_Width = 30;
    private final int Brick_Height = 30;
    ArrayList<Brick> bricks;

    public Level(String levelPath) throws IOException {
        loadLevel(levelPath);
    }
    
    public ArrayList<Brick> getBrickLists()
    {
        return bricks;
    }
    
    public void loadLevel(String levelPath) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(levelPath));
        bricks = new ArrayList<>();
        MazeRandom maze = new MazeRandom(30, 20);
        maze.traversal();  
        maze.creates();     
        
        int y = 0;
        for(int i = 0; i < 19 ;i++){
            for(int j = 0; j < 20 ; j++)
            {
                Image image = new ImageIcon("data/images/bbb.jpg").getImage();
                if (maze.isWall(i, j)) {
                    bricks.add(new Brick(i * Brick_Width, j * Brick_Height, Brick_Width, Brick_Height, image));
                }
            }
        }
    }

    public boolean collides(Dragon dragon) {
        Brick collidedWith = null;
        for (Brick brick : bricks) {
            if (dragon.collidesWith(brick)) {
                collidedWith = brick;
                break;
            }
        }
        if (collidedWith != null) {
            
            return true;
        } else {
            return false;
        }
    }
    
    
    
   
    public void draw(Graphics g) {
        for (Brick brick : bricks) {
            brick.draw(g);
        }
    }

}
