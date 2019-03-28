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
 * To change this license header, choose License Headers in Project Properties
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package connectfour;




import javax.swing.JButton;

import javax.swing.JPanel;

import javax.swing.JLabel;

import javax.swing.JOptionPane;

import java.awt.Point;

import java.util.ArrayList;

import java.awt.GridLayout;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.awt.Dimension;

import java.util.Collections;

import java.util.Random;



/**

 *

 * @author Tang Shaozhe

 */

public class BoardGUI {

    private JButton[][] buttons;

    private Board board;

    private JPanel boardPanel;

    private JLabel playerLabel;

    private ArrayList<Point> points;

    private Random random = new Random();

    private int clickNum = 0;
 
    private boolean win=false;
    
    public BoardGUI(int boardSize,int boardSize2){

        board = new Board(boardSize,boardSize2);

        boardPanel =new JPanel();

        points = new ArrayList<>();

        boardPanel.setLayout(new GridLayout(board.getBoardSize(),board.getBoardSize2()));

        buttons = new JButton[board.getBoardSize()][board.getBoardSize2()];

        for(int i=0;i<board.getBoardSize();++i){

            for(int j=0;j<board.getBoardSize2();++j){

                JButton button = new JButton();

                button.addActionListener(new ButtonListener(i,j));

                button.setPreferredSize(new Dimension(80,50));

                buttons[i][j]=button;

                boardPanel.add(button);

                points.add(new Point(i,j));

            }

        }

        Collections.shuffle(points);

        

        playerLabel =new JLabel(" ");

        playerLabel.setHorizontalAlignment(JLabel.RIGHT);

        playerLabel.setText("Player: "+"X");

    }

    

    public JPanel getBoardPanel(){

        return boardPanel;

    }

    

     public void refresh(int x, int y) {

        JButton button = buttons[x][y];

        Player player = board.get(x, y);

       

        if (player.getNumber() != -1) {        // game starts

           if (player.getNumber()%2==1){       // The discs of the first player are marked with X,

            button.setText("X");

            //check if there is four X in a row

            //check the row

            int A=0;

            while((y-A-1)>-1 && board.get(x, (y-A-1)).getNumber()!=-1 && board.get(x, (y-A-1)).getNumber()%2==1){

                A++;

            }

            int B=0;

            while((y+B+1)<board.getBoardSize2()&& board.get(x, (y+B+1)).getNumber()!=-1 && board.get(x, (y+B+1)).getNumber()%2==1){

                B++;

            }                      

            //check the column

                int C=0;    

            while((x-C-1)>-1 && board.get((x-C-1), y).getNumber() != -1 && board.get((x-C-1), y).getNumber()%2==1){

                C++;

            }

            int D=0;

            while((x+D+1)<board.getBoardSize() && board.get((x+D+1), y).getNumber() != -1 && board.get((x+D+1), y).getNumber()%2==1){

                D++;

            } 

          //check the diagonals       
          // digonal \
            int E=0;    

            while((y-E-1)>-1 &&(x-E-1)>-1&& board.get((x-E-1), (y-E-1)).getNumber()!=-1 && board.get((x-E-1), (y-E-1)).getNumber()%2==1){

                E++;

            }

            int F=0;

            while((x+F+1)<board.getBoardSize() &&(y+F+1)<board.getBoardSize2() && board.get((x+F+1),(y+F+1)).getNumber() != -1 && board.get((x+F+1), (y+F+1)).getNumber()%2==1){

                F++;

            } 

            // diagonal /
            int G=0;    

            while((y-G-1)>-1&&(x+G+1)<board.getBoardSize() && board.get((x+G+1), (y-G-1)).getNumber()!=-1 && board.get((x+G+1), (y-G-1)).getNumber()%2==1){

                G++;

            }

            int H=0;

            while((x-H-1)>-1&&(y+H+1)<board.getBoardSize2() && board.get((x-H-1), (y+H+1)).getNumber()!=-1 && board.get((x-H-1),(y+H+1)).getNumber()%2==1){

                H++;

            }

            if(A+B>2||C+D>2||E+F>2||G+H>2){
             win = true;

             JOptionPane.showMessageDialog(boardPanel, " X have won  the game. ", "Congrats!",

                            JOptionPane.PLAIN_MESSAGE);

           ConnectFourGUI game = new ConnectFourGUI();

            }

     

       }

            else {

               

                //now we check if there is four O in a row

                

            button.setText("O");

            

            //check the row

            int A=0;

            while((y-A-1)>-1 && board.get(x, (y-A-1)).getNumber()!=-1 && board.get(x, (y-A-1)).getNumber()%2==0){

                A++;

            }

            int B=0;

            while((y+B+1)<board.getBoardSize2()&& board.get(x, (y+B+1)).getNumber()!=-1 && board.get(x, (y+B+1)).getNumber()%2==0){

                B++;

            }                      

            //check the column

                int C=0;    

            while((x-C-1)>-1 && board.get((x-C-1), y).getNumber() != -1 && board.get((x-C-1), y).getNumber()%2==0){

                C++;

            }

            int D=0;

            while((x+D+1)<board.getBoardSize() && board.get((x+D+1), y).getNumber() != -1 && board.get((x+D+1), y).getNumber()%2==0){

                D++;

            } 

          // check the diagonals
          // diagonal \

            int E=0;    

            while((y-E-1)>-1 &&(x-E-1)>-1&& board.get((x-E-1), (y-E-1)).getNumber()!=-1 && board.get((x-E-1), (y-E-1)).getNumber()%2==0){

                E++;

            }

            int F=0;

            while((x+F+1)<board.getBoardSize() &&(y+F+1)<board.getBoardSize2() && board.get((x+F+1),(y+F+1)).getNumber() != -1 && board.get((x+F+1), (y+F+1)).getNumber()%2==0){

                F++;

            } 

            //diagonal /
            int G=0;    

            while((y-G-1)>-1&&(x+G+1)<board.getBoardSize() && board.get((x+G+1), (y-G-1)).getNumber()!=-1 && board.get((x+G+1), (y-G-1)).getNumber()%2==0){

                G++;

            }

            int H=0;

            while((x-H-1)>-1&&(y+H+1)<board.getBoardSize2() && board.get((x-H-1), (y+H+1)).getNumber()!=-1 && board.get((x-H-1),(y+H+1)).getNumber()%2==0){

                H++;

            }

            if(A+B>2||C+D>2||E+F>2||G+H>2){
             win = true;

             JOptionPane.showMessageDialog(boardPanel, " O have won  the game. ", "Congrats!",

                            JOptionPane.PLAIN_MESSAGE);

            ConnectFourGUI game = new ConnectFourGUI();

            }

        } 

    }

    else {
            button.setText("");
        }

    }   

    



    class ButtonListener implements ActionListener{

        private int x,y;

        public ButtonListener(int x,int y){

            this.x=x;

            this.y=y;

        }

        @Override

        public void actionPerformed(ActionEvent e){

            if(board.get(0,y).getNumber()==-1){         // The players take turns dropping their disc from the TOP

                int i=board.getBoardSize()-1;

                while(board.get(i,y).getNumber()!=-1){

                    i--;

                }  

                board.get(i,y).setNumber(++clickNum);      // if the click number is odd, then it's player X, otherwise it's player O

                refresh(i, y);              

                if(board.get(i, y).getNumber()%2==0){   

                  playerLabel.setText("Player: "+"X");

                }else{

                  playerLabel.setText("Player: "+"O");

                }

                

                

                if (board.isOver()&&!win) {    // if Player X and O traverse the whole board and there is no winner, then it's a draw

                  JOptionPane.showMessageDialog(boardPanel, "  It's a draw!"

                          + "  Awesome!   ", "Result",

                            JOptionPane.PLAIN_MESSAGE);

                  ConnectFourGUI gui = new  ConnectFourGUI();

                    

                }

            }

        }
    
    }

    

    public JLabel getPlayerLabel() {

        return playerLabel;

    }

    

}

