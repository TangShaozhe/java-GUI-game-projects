/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maze;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;
import java.lang.Math;
/**
 *
 * @author Tang
 */
public class Dragon extends Sprite {

    private double velx;
    private double vely;
    private Random ran = new Random();
    private int dragon_movement = 3;
    private int n=0;

    public Dragon(int x, int y, int width, int height, Image image) {
        super(x, y, width, height, image);
        velx = 1;
        vely = 1;
    }

    public void random(ArrayList<Brick> brick, Player player)
    {
        while(this.collides(brick)||this.collidesWith(player)||Math.abs(this.x - player.x) < 30||Math.abs(this.y - player.y) < 30)

        {
            x = ran.nextInt(600);
            y = ran.nextInt(600);
        }
             
    }

    public void move(ArrayList<Brick> brick) {
        
        int r = ran.nextInt(4);
        if(n ==0 )
        {
            x = x-dragon_movement;
                   if(collides(brick)||x <=0)
                   {
                        x = x+dragon_movement;
                        n=r;
                    }
            
        }else
            if(n == 1)
            {
                y =y- dragon_movement ;
                if(collides(brick)||y<=0)
                {
                    y = y + dragon_movement;
                    n=r;
                }
               
            }else 
                if(n== 2)
                {
                    y = y + dragon_movement;
                    if(collides(brick)||y >=570)
                    {
                       y =y- dragon_movement ;
                       n=r;
                    }
                }
                else     
                    if(n == 3)
                    {
                         x = x+dragon_movement;
                         if(collides(brick)||x >=570)
                         {
                             x = x-dragon_movement;
                             n=r;
                         }
                    }
                    else if(n == 4)
                    {
                        
                    }

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
    

    
    public void invertVelX() {
        velx = ran.nextInt(4);
    }

    public void invertVelY() {
        vely = ran.nextInt(4);

    }

}
