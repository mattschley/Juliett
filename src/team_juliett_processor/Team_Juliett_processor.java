/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package team_juliett_processor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Ethan
 */
public class Team_Juliett_processor {

    /**
     * @param args the command line arguments
     */
    private static int number_of_courses;
    
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new FileReader("EECS_DB.txt"));
        
        
        String line;
        
        /*//THIS IS FOR TESTING
        Course course1;
        course1 = new Course(58458);
        Course course2;
        course2 = new Course(58459);
        Course course3;
        course3 = new Course(58460);
        Course course4;
        course4 = new Course(58461);
        
        Course[] courselist;
        courselist = new Course[4]
        courselist[0] = course1;
        courselist[1] = course2;
        courselist[2] = course3;
        courselist[3] = course4;
        //THIS IS FOR TESTING*/
        
        int[] courselist = {58458, 58459, 58460, 58461};
        
        
        while((line = br.readLine()) != null) {
            System.out.println(line);
            for (int i=0; i<courselist.length; i++){
                String id;
                id = Integer.toString(courselist[i]);
                if (line.contains(id){
                    int mdIndex;
                    mdIndex = line.indexOf("meeting_days");
                    int stIndex; 
                    stIndex = line.indexOf("start_time");
                    String meetingDays = (line.substring(mdIndex+16, stIndex-4));
                    System.out.println(meetingDays);
            }
            }
        }
        br.close();
        
        User bob;
        int[] mands;
        int[] options;
        mands = new int[3];
        options = new int[3];
        
        mands[0] = mands[1] = mands[2] = options[0] = options[1] = options[2] = 3;
        
        bob = new User(1, mands, options, 0, 1);
        
        System.out.println(bob.test());
   
    }
}