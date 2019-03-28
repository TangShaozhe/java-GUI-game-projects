// Tang Shaozhe
//
// QS4OZ8
//
// 1. Connect Four
//
// 2018/11/28 02:05:56
//
// This solution was submitted and prepared by Tang Shaozhe, QS4OZ8 for the
// 1. Connect Four assignment of the Practical software engineering I. course.
//
// I declare that this solution is my own work.
//
// I have not copied or used third party solutions.
//
// I have not passed my solution to my classmates, neither  made it public.
//
// Students� regulation of E鰐v鰏 Lor醤d University (ELTE Regulations
// Vol. II. 74/C. � ) states that as long as a student presents another
// student抯 work - or at least the significant part of it - as his/her own
// performance, it will count as a disciplinary fault. The most serious
// consequence of a disciplinary fault can be dismissal of the student from
// the University.

/*

 * To change this license header, choose License Headers in Project Properties.

 * To change this template file, choose Tools | Templates

 * and open the template in the editor.

 */

package connectfour;



import java.awt.Point;

/**
 *
 * @author Tang Shaozhe
 */

public class Board {

    private Player[][] board;

    private final int boardSize;   // board width

    private final int boardSize2;   // board length


    public Player get(int x, int y) {

        return board[x][y];

    }

    

    public Player get(Point point) {

        int x = (int)point.getX();

        int y = (int)point.getY();

        return get(x, y);

    }

    

    public int getBoardSize() {

        return boardSize;

    }

    

    public int getBoardSize2() {

        return boardSize2;

    }

    

    public Board(int boardSize,int boardSize2){

        this.boardSize=boardSize;

        this.boardSize2=boardSize2;

        board = new Player[this.boardSize][this.boardSize2];

        for(int i=0;i<this.boardSize;++i){

            for(int j=0;j<this.boardSize2;++j){

                board[i][j]=new Player() ;

            }

        }

    }

    

    public boolean isOver(){             // if Player X and O traverse the whole board , then the game is over
                                          // if there is no winner, there will be a draw
        for(int i=0;i<boardSize;i++){

            for(int j=0;j<boardSize2;j++){

                if(board[i][j].getNumber()==-1){

                    return false;

                }

            }

        }

        return true;

    }

}

    

