/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maze;

import java.util.Random;
import java.util.Stack;

/**
 *
 * @author Tang
 */
public class MazeRandom {
    private final static int dirUp = 0;  
    private final static int dirRight = 1;  
    private final static int dirDown = 2;  
    private final static int dirLeft = 3;  
      
    private final static int gridWall = 1;  
    private final static int gridEmpty = 0;  
    private final static int gridBlind = -1;  
    private final static int gridPath = 2;  
      
    private int width;  
    private int height;  
    private MazePoint[][] matrix;  
    private int[][] maze;  
      
    /**
     * Construct a maze, initialize the width and height of the maze, and initialize the lattice containing MazePoint
     * @param height
     * @param width 
     */ 
    public MazeRandom(int height, int width) {  
        this.width = width;  
        this.height = height;  
        this.matrix = new MazePoint[height][width];  
        for (int i=0; i<height; i++)  
            for (int j=0; j<width; j++)  
                matrix[i][j] = new MazePoint();  
        this.maze = new int[2*height+1][2*width+1];  //Construct mazes with a width of 2*height+1 and a length of 2*width+1
    }  
      
    /**
     * Check whether the neighbors above, below, left, and right of the target point can be accessed, 
     * and if the target point exceeds the threshold, it is considered to have been accessed
     * @param x
     * @param y
     * @param dir
     * @return 
     */
    public boolean isNeighborOK(int x, int y, int dir) {  
        boolean isNeighborVisited = false;  
        switch ( dir ) {  
        case dirUp:  
            if ( x <= 0 )  
                isNeighborVisited = true;  
            else  
                isNeighborVisited = matrix[x-1][y].isVisited();  
            break;  
        case dirRight:  
            if ( y >= width - 1 )  
                isNeighborVisited = true;  
            else  
                isNeighborVisited = matrix[x][y+1].isVisited();  
            break;  
        case dirDown:  
            if ( x >= height - 1 )  
                isNeighborVisited = true;  
            else  
                isNeighborVisited = matrix[x+1][y].isVisited();  
            break;  
        case dirLeft:  
            if ( y <= 0 )  
                isNeighborVisited = true;  
            else  
                isNeighborVisited = matrix[x][y-1].isVisited();  
            break;  
        }  
        return !isNeighborVisited;  //If the dot is unvisited (isNeighborVisited is false), the return value is true, indicating that neighbors may be visited
    }  
      
    /**
     * Check that at least one of the top, bottom, left, and right of the target point is accessible
     * @param x
     * @param y
     * @return 
     */
    public boolean isNeighborOK(int x, int y) {  
        return (this.isNeighborOK(x, y, dirUp) || this.isNeighborOK(x, y, dirRight) ||  
                this.isNeighborOK(x, y, dirDown) || this.isNeighborOK(x, y, dirLeft));  
    }  
      
    /**
     * Get a direction that can be accessed
     * @param x
     * @param y
     * @return 
     */
    public int getRandomDir(int x, int y) {  
        int dir = -1;  
        Random rand = new Random();  
        if ( isNeighborOK(x, y) ) {  
            do {  
                dir = rand.nextInt(4);  
            } while ( !isNeighborOK(x, y, dir) );  //The dir direction is not accessible
        }  
        return dir;  
    }  
      
    /**
     * Sets adjacent accessible points as paths
     * @param x
     * @param y
     * @param dir 
     */
    public void pushWall(int x, int y, int dir) {  
        switch ( dir ) {  
        case dirUp:  
            matrix[x][y].setWallUp(false);  
            matrix[x-1][y].setWallDown(false); 
            break;  
        case dirRight:  
            matrix[x][y].setWallRight(false);  
            matrix[x][y+1].setWallLeft(false);  
            break;  
        case dirDown:  
            matrix[x][y].setWallDown(false);  
            matrix[x+1][y].setWallUp(false);  
            break;  
        case dirLeft:  
            matrix[x][y].setWallLeft(false);  
            matrix[x][y-1].setWallRight(false);  
            break;  
        }  
    }  
      
    /* 
     * depth-first traversal
     */  
    public void traversal() {  
        int x = 0;  
        int y = 0;  
        Stack<Integer> stackX = new Stack<Integer>();  
        Stack<Integer> stackY = new Stack<Integer>();  
        do {  
            MazePoint p = matrix[x][y];  
            if ( !p.isVisited() ) {  
                p.setVisited(true);  
            }  
            if ( isNeighborOK(x, y) ) {  
                int dir = this.getRandomDir(x, y);  
                this.pushWall(x, y, dir);  
                stackX.add(x);  //Save coordinate information
                stackY.add(y);  //Save coordinate information
                switch ( dir ) {  
                case dirUp:  
                    x--;  
                    break;  
                case dirRight:  
                    y++;  
                    break;  
                case dirDown:  
                    x++;  
                    break;  
                case dirLeft:  
                    y--;  
                    break;  
                }  
            }  
            else {  
                x = stackX.pop();  
                y = stackY.pop();  
            }  
        } while ( !stackX.isEmpty() );  
    }  
      
    /* 
     * Construct the maze from the right and bottom walls of the MazePoint lattice
     */  
    public void create() {  
        for (int j=0; j<2*width+1; j++)  
        	maze[0][j] = gridWall;         
        for (int i=0; i<height; i++) {  
            maze[2*i+1][0] = gridWall;  
            for (int j=0; j<width; j++) {  
                maze[2*i+1][2*j+1] = gridEmpty;  
                if ( matrix[i][j].isWallRight() )  
                    maze[2*i+1][2*j+2] = gridWall;  
                else  
                    maze[2*i+1][2*j+2] = gridEmpty;  
            }  
            maze[2*i+2][0] = 1;  
            for (int j=0; j<width; j++) {  
                if ( matrix[i][j].isWallDown() )  
                    maze[2*i+2][2*j+1] = gridWall;  
                else  
                    maze[2*i+2][2*j+1] = gridEmpty;  
                maze[2*i+2][2*j+2] = gridWall;  
            }  
        }  
        maze[0][2*width] = gridEmpty;
        maze[1][2*width] = gridEmpty;
        maze[2*height - 1][0] = gridEmpty;
        maze[2*height][0] = gridEmpty;
    }  
    
    private void clean() {
        this.matrix = new MazePoint[height][width];  
        for (int i=0; i<height; i++)  
            for (int j=0; j<width; j++)  
                matrix[i][j] = new MazePoint();  
        this.maze = new int[2*height+1][2*width+1];  //Construct mazes with a width of 2*height+1 and a length of 2*width+1
    }
    
    public void creates() {
        this.create();
        int [][]temp = new int[2*height+1][2*width+1];
        for (int i = 0; i < 2 * height +1; i++) {
            for (int j = 0; j < 2 * width + 1; j++) {
                temp[i][j] = maze[i][j];
            }
        }
        
        this.clean();
        this.traversal(); 
        this.create();
        for (int i = 0; i < 2 * height +1; i++) {
            for (int j = 0; j < 2 * width + 1; j++) {
                if (temp[i][j] == gridEmpty) {
                    maze[i][j] = temp[i][j];
                }
            }
        }
    }

    /**
     * Get an access direction in the maze array
     * @param x
     * @param y
     * @return 
     */ 
    public int getBreakOutDir(int x, int y) {  
        int dir = -1;  
        if ( maze[x][y+1] == 0 )  
            dir = dirRight;  
        else if ( maze[x+1][y] == 0 )  
            dir = dirDown;  
        else if ( maze[x][y-1] == 0 )  
            dir = dirLeft;  
        else if ( maze[x-1][y] == 0 )  
            dir = dirUp;  
        return dir;  
    }  
      
    /* 
     * Find a path from the point (1, 1) to the point (2*height-1, 2*width-1)
     */  
    public void findPath() {  
        int x = 1;  
        int y = 1;  
        Stack<Integer> stackX = new Stack<Integer>();  
        Stack<Integer> stackY = new Stack<Integer>();  
        do {  
            int dir = this.getBreakOutDir(x, y);  
            if ( dir == -1 ) {  
                maze[x][y] = gridBlind;  //The direction that does not exist is set as a blind spot
                x = stackX.pop();  
                y = stackY.pop();  
            }  
            else {  
                maze[x][y] = gridPath;  
                stackX.add(x);  
                stackY.add(y);  //Save path point coordinate information
                switch ( dir ) {  
                case dirUp:  
                    x--;  
                    break;  
                case dirRight:  
                    y++;  
                    break;  
                case dirDown:  
                    x++;  
                    break;  
                case dirLeft:  
                    y--;  
                    break;  
                }  
            }  
        } while ( !(x == 2*height-1 && y == 2*width-1) );  
        maze[x][y] = gridPath;  
    }  
      
    /**
     * Clear the path in the maze
     */
    public void reset() {  
        for (int i=0; i<2*height+1; i++)  
            for (int j=0; j<2*width+1; j++)  
                if ( maze[i][j] != gridWall )  
                    maze[i][j] = gridEmpty;  
    }  
    
    /**
     * Determine if it's a wall
     * @param i
     * @param j
     * @return 
     */
    public boolean isWall(int i, int j) {
        return maze[i][j] == gridWall;
    }
}
