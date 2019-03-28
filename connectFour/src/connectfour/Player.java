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

/**
 *
 * @author Tang Shaozhe
 */

 public class Player{

    private int number;

    

    public Player(){        // set default number as -1

        number=-1;

    }

     

    public int getNumber(){

        return number;

    }

    

    public void setNumber(int number){      

        this.number=number;

    }

    

 }

