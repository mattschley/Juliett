/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package team_juliett_processor;

/**
 *
 * @author Ethan
 */
public class Team_Juliett_processor {

    /**
     * @param args the command line arguments
     */
    private static int number_of_courses;
    
    public static void main(String[] args) {

        //math meets MWF 9-950; course id 100
        //english meets MWF 11-1150 course id 101
        //eecs meets MWF 12-1250 course id 102
        //history meets TTh 1230 - 150 course id 103
        //banana meets MWF 9-950 course id 104
        Course math = new Course       ("math", 900, 950,  10101, 100);
        Course english = new Course("english", 1100, 1150, 10101, 101);
        Course eecs = new Course      ("eecs", 1200, 1250, 10101, 105);
        
        Course history = new Course ("history", 1230, 150, 01010, 102);
        Course science = new Course  ("science",1230, 150, 01010, 103);
        Course gym = new Course          ("gym", 200, 320, 01010, 104);
        
        
       
        
        Course[] courselist;
        courselist = new Course[5];
        courselist[0] = math;
        courselist[1] = english;
        courselist[2] = history;
        courselist[3] = science;
        courselist[4] = eecs;
        
        Course mandatory[] = {math, history, science};
        Course desired[] = {english, eecs, gym};
        Course optional[] = {science};
        int hardsofttimes[] = {800, 800};
    
        
        for (int i = 0; i<=4; i++){
            System.out.println(courselist[i].toString());
            number_of_courses++;
        }
        
        int [][] coursetimes;
        coursetimes = new int[number_of_courses][2];
        for (int i = 0; i<number_of_courses; i++){
            coursetimes[i] = courselist[i].get_times();
        }
        System.out.println(math.toString()+ " starts at " + coursetimes[0][0] + " and ends at " + coursetimes[0][1] );
       
        User jimbo = new User (1, mandatory, desired, optional, 800, 600, hardsofttimes);
        System.out.println(math.conflict(science));
        System.out.println(math.conflict(eecs));
        System.out.println(history.conflict(science));
         
}