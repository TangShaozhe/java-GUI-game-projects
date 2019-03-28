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

/**
 *
 * @author Tang Shaozhe
 */

public class Sandrunner extends Creature{

    public Sandrunner(String name,int initial_water_level){
        super(name,"Sandrunner",initial_water_level);
        this.max_water = 8;
    }
    
    @Override
     public void sunny(){
        this.distance+=3;
        this.water_level-=1;
        if(this.water_level>max_water){this.water_level=8;}
    }

    @Override
    public void cloudy(){
        this.distance +=1;
        this.water_level +=0;
        if(this.water_level >max_water){this.water_level=8;}
    }

    
    @Override
    public void rainy(){
        this.distance += 0;
        this.water_level += 3;
        if(this.water_level >max_water){this.water_level=8;}
    }

}

