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

public abstract class Creature {

    private String name;
    private String type;
    private final int initial_water_level;
    int water_level;

    protected int distance;
    private boolean living=false;
    protected int max_water;

    public Creature(String name,String type,int initial_water_level){
        this.living = false;
        this.name=name;
        this.type=type;
        this.distance=0;
        this.water_level=initial_water_level;
        this.initial_water_level=initial_water_level;
        this.living=false;
    }

   

   

    
//Introduce sunny methods for each days to update creatures' water lelel and distance
    public void sunny(){
        
    }

    
//Introduce cloudy methods for each days to update creatures' water lelel and distance
    public void cloudy(){

    }

    
//Introduce rainy methods for each days to update creatures' water lelel and distance
    public void rainy(){    

    }

   

    
// check the life of the creature
    public boolean isAlive(){
        if(water_level>=0){
            living = true;
        }
        return living;
    }

//to read creatures' name
    public String getName() {
        return name;
    }

   
// update value of creatures'name 
    public void setName(String name) {
        this.name=name;
    }

    
// to read the type of creatures
    public String getType() {
        return type;
    }

    
// update value of creatures'type
    public void setType(String type) {
        this.type=type;
    }

    

// to read the distance of each creature
    public int getDistance() {
        return distance;
    }


// to make all non-private methods of the super class accessible
    @Override

//to produce a textual form of result
    public String toString(){

        return  name +" and there is  "+water_level +" water level left,"+" whose distance is: "+distance  ;

    }

    
}

