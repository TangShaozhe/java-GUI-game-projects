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


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author Tang Shaozhe
 */

public class Race {

    
    private final ArrayList<Creature> creatures;
    private final ArrayList<Weather> weathers;
    private final ArrayList<Creature> liveCreatures;

    
    public Race() {
        creatures = new ArrayList<>();
        liveCreatures = new ArrayList<>();
        weathers = new ArrayList<>();
    }

    public void read(String filename) throws FileNotFoundException,InvalidInputException {

        Scanner sc = new Scanner(new BufferedReader (new FileReader(filename)));
        int numCreatures = sc.nextInt();
        for(int i = 0;i<numCreatures;i++){
            Creature creature;
            String name = sc.next();//read creatures' name
            String type = sc.next(); //read creatures' type          
            int initial_water_level = sc.nextInt();//read creatures' initial water level
            switch(type){
                case "r":
                    creature = new Sandrunner(name,initial_water_level);
                    break;
                case "s":
                    creature = new Sponge(name,initial_water_level);
                    break;
                case "w":
                    creature = new Walker(name,initial_water_level);
                    break;
                default:
                    throw new InvalidInputException();
            }        
            creatures.add(creature);  
        }

        while(sc.hasNext()){
            Weather weather;
            switch(sc.next()){
                case "r":
                    weather = new Rainy();
                    break;
                case "s":
                    weather = new Sunny();
                    break;
                case "c":
                    weather = new Cloudy();
                    break;
                default:
                    throw new InvalidInputException();
            }
            weathers.add(weather);
        }

    }

    
    public void report() {

        System.out.println("Creatures in the Race Competition: ");

        for(int i=0;i<weathers.size();i++){
            System.out.println("\n"+weathers.get(i));
            for(Creature c : creatures){
                if(c.isAlive()){
                    switch(weathers.get(i).getCondition()){
                        case "Rainy":
                            c.rainy();
                        break;
                        case "Cloudy":
                            c.cloudy();
                        break;
                        case "Sunny":
                         c.sunny();
                        break;               
                    }
                    System.out.println( "name: "+c.getName()+", water left: "+ c.water_level+" distance: "+c.distance);
                }        
            } 
        }
           
        for (Creature c : creatures){
            if(c.isAlive()){liveCreatures.add(c);}        
        }
            
            if(liveCreatures.isEmpty()){
                System.out.println("All dead");
            }
            else{
                Creature max=liveCreatures.get(0);
                //find the creature who has the farest distance
                for(int i=0;i<liveCreatures.size();i++){
                    if(liveCreatures.get(i).getDistance()>max.getDistance()){
                        max=liveCreatures.get(i);
                    }                 
                }
                // if there are creatures who have the same distance, then both or all of them are winners
                for(int i=0;i<liveCreatures.size();i++){
                    if(liveCreatures.get(i).getDistance()==max.getDistance()){
                    System.out.println("\n"+ "the winner of the game is :"+ liveCreatures.get(i));
                    }                 
                }  
            }          
    }
}
