/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maze;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import jdk.nashorn.internal.parser.TokenType;

/**
 *
 * @author Tang
 */
public class Player extends Sprite {
    private final int player_movement = 15;

    private final Image blackView = new ImageIcon("data/images/blackView.png").getImage();
    public Player(int x, int y, int width, int height, Image image) {
        super(x, y, width, height, image);
    }

   public void move(char newMove, ArrayList<Brick> brick) {
        if(newMove == 'U' )
        {
            y =y- player_movement ;
            if(collides(brick)||y<=0)
            {
                y = y + player_movement;
            }
        }else
            if(newMove == 'D')
            {
                 y = y + player_movement;
                if(collides(brick)||y >=590)
                {
                   y =y- player_movement ;
                }
            }else 
                if(newMove == 'L')
                {
                    x = x-player_movement;
                    if(collides(brick)||x <=0)
                    {
                        x = x+player_movement;
                    }
                }
                else     
                    if(newMove == 'R')
                    {
                         x = x+player_movement;
                        if(collides(brick)||x >=590)
                        {
                            x = x-player_movement;;
                        }
                    }
                    else if(newMove == 'B')
                    {
                        
                    }

    }
   
   @Override
    public boolean collidesWith(Sprite other) {
        Rectangle rect = new Rectangle(x, y, width/2, height/2);
        Rectangle otherRect = new Rectangle(other.x, other.y, other.width, other.height);        
        return rect.intersects(otherRect);
    }
   public boolean collides(ArrayList<Brick> bricks)
   {
       //Brick collidedWith = null;
        for (Brick brick : bricks) {
            if (this.collidesWith(brick)) {
                return true;
            }
        }
       return false;
   }

    
   


    @Override
    public void draw(Graphics g) {
        g.drawImage(image, x-(width/2), y-(height/2), width, height, null);
        g.drawImage(blackView, x-600, y-600, 1200, 1200, null);
    }

}
