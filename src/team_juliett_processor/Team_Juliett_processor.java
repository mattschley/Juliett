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

        //apple meets MWF 9-950; course id 100
        //orange meets MWF 2-250 course id 101
        //pear meets TTh 1230-150 course id 102
        //plum meets TTh 2 - 320 course id 103
        //banana meets MWF 9-950 course id 104
        Course apple = new Course("apple", 900, 950, 10101, 100);
        Course orange = new Course("orange", 200, 250, 10101, 101);
        Course pear = new Course("pear", 1230, 150, 01010, 102);
        Course plum = new Course("plum", 200, 320, 01010, 103);
        Course banana = new Course("banana", 900, 950, 10101, 100);
       
        
        Course[] courselist;
        courselist = new Course[5];
        courselist[0] = apple;
        courselist[1] = orange;
        courselist[2] = pear;
        courselist[3] = plum;
        courselist[4] = banana;
        
        for (int i = 0; i<=4; i++){
            System.out.println(courselist[i].toString());
            number_of_courses++;
        }
        
        int [][] coursetimes;
        coursetimes = new int[number_of_courses][2];
        for (int i = 0; i<number_of_courses; i++){
            coursetimes[i] = courselist[i].get_times();
        }
        System.out.println(apple.toString()+ " starts at " + coursetimes[0][0] + " and ends at " + coursetimes[0][1] );
       
        
        
        
    
}