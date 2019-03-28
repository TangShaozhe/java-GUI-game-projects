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



import javax.swing.JFrame;

import java.awt.BorderLayout;

import javax.swing.JMenuBar;

import javax.swing.JMenu;

import javax.swing.JMenuItem;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.net.URL;
/**
 *
 * @author Tang Shaozhe
 */

class ConnectFourGUI {

    private JFrame frame;

    private BoardGUI boardGUI;

    

    private final int INITIAL_BOARD_SIZE = 8;

    private final int INITIAL_BOARD_SIZE2 = 5;

    public ConnectFourGUI(){

        frame = new JFrame("Connect Four");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        

        boardGUI = new BoardGUI(INITIAL_BOARD_SIZE,INITIAL_BOARD_SIZE2);

        frame.getContentPane().add(boardGUI.getBoardPanel(),BorderLayout.CENTER);

        frame.getContentPane().add(boardGUI.getPlayerLabel(), BorderLayout.SOUTH);



        JMenuBar menuBar = new JMenuBar();

        frame.setJMenuBar(menuBar);

        JMenu gameMenu = new JMenu("Game");

        menuBar.add(gameMenu);

        JMenu newMenu = new JMenu("New");

        gameMenu.add(newMenu);

        URL url = ConnectFourGUI.class.getResource("connect4.jpg");
        
        

            JMenuItem sizeMenuItem = new JMenuItem(8 + "x" + 5);

            newMenu.add(sizeMenuItem);

            sizeMenuItem.addActionListener(new ActionListener(){

                @Override

                public void actionPerformed(ActionEvent e){

                   frame.getContentPane().remove(boardGUI.getBoardPanel());

                   frame.getContentPane().remove(boardGUI.getPlayerLabel());

                   boardGUI = new BoardGUI(8,5);

                   frame.getContentPane().add(boardGUI.getBoardPanel(),

                            BorderLayout.CENTER);

                   frame.getContentPane().add(boardGUI.getPlayerLabel(), BorderLayout.SOUTH);

                   frame.pack();

                }

            });

            

            JMenuItem sizeMenuItem2 = new JMenuItem(10 + "x" + 6);

            newMenu.add(sizeMenuItem2);

            sizeMenuItem2.addActionListener(new ActionListener(){

                @Override

                public void actionPerformed(ActionEvent e){

                   frame.getContentPane().remove(boardGUI.getBoardPanel());

                   frame.getContentPane().remove(boardGUI.getPlayerLabel());

                   boardGUI = new BoardGUI(10,6);

                   frame.getContentPane().add(boardGUI.getBoardPanel(),

                            BorderLayout.CENTER);

                   frame.getContentPane().add(boardGUI.getPlayerLabel(), BorderLayout.SOUTH);

                   frame.pack();

                }

            });

            

            JMenuItem sizeMenuItem3 = new JMenuItem(12 + "x" + 7);

            newMenu.add(sizeMenuItem3);

            sizeMenuItem3.addActionListener(new ActionListener(){

                @Override

                public void actionPerformed(ActionEvent e){

                   frame.getContentPane().remove(boardGUI.getBoardPanel());

                   frame.getContentPane().remove(boardGUI.getPlayerLabel());

                   boardGUI = new BoardGUI(12,7);

                   frame.getContentPane().add(boardGUI.getBoardPanel(),

                            BorderLayout.CENTER);

                   frame.getContentPane().add(boardGUI.getPlayerLabel(), BorderLayout.SOUTH);

                   frame.pack();

                }

            });

        

        JMenuItem exitMenuItem = new JMenuItem("Exit");

        gameMenu.add(exitMenuItem);

        exitMenuItem.addActionListener(new ActionListener(){

            @Override

            public void actionPerformed(ActionEvent ae){

                System.exit(0);

            }

            

        });

        frame.pack();

        frame.setVisible(true);

    }

}

