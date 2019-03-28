// Tang Shaozhe
//
// QS4OZ8
//
// Creature
//
// 2018/10/16 23:58:14
//
// This solution was submitted and prepared by Tang Shaozhe, QS4OZ8 for the
// Creature assignment of the Practical software engineering I. course.
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

package creature;



import java.io.FileNotFoundException;



/**

 *

 * @author Tang Shaozhe

 */

public class main {

    public static void main(String[] args){
        Race race = new Race();
        try {
            race.read("input.txt");
        } catch (FileNotFoundException e) {
            System.out.println("No input file is found!");
            System.exit(-1);
        } catch (InvalidInputException e) {
            System.out.println("Input is invalid");
             System.exit(-1);
        }
        race.report();
        
    }
}

