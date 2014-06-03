/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package team_juliett_processor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Ethan
 */
public class Team_Juliett_processor {

    /**
     * @param args the command line arguments
     */
    private static int number_of_courses;
    
    public static void main(String[] args) throws IOException, ParseException{
        
        // ~~ Begin search of the file ~~ //
        BufferedReader br = new BufferedReader(new FileReader("EECS_DB.txt"));
        String line;
        
        
        //Accept representation of one users options 
        User bob;
        
        //~~These are the mandatory and optional arrays as passed by the front end~~//
        int[] bobsIDs = {58458, 58459, 58460, 58461}; //mandatory courses
        int[] bobsIDs2 = new int[4]; //optional courses
        bob = new User(1, bobsIDs, bobsIDs2, 1000, 1700); //make the new user array
        System.out.println(bob.toString());
        
        //Parse the two mandatory and optional arrays// 
        int numberofCourses = bobsIDs.length + bobsIDs2.length;
        
        //~~Create the two course arrays~~//
        Course[] bobsMandCourses = new Course[bobsIDs.length];
        Course[] bobsOptCourses = new Course[bobsIDs2.length];
        
        
        while((line = br.readLine()) != null) {
            
            for (int i=0; i<bobsIDs.length; i++){
                
                String id;
                id = Integer.toString(bobsIDs[i]);
                //System.out.println(courselist[i]);
                if (line.contains(id)){
                    
                    int mdIndex = line.indexOf("meeting_days");
                    int stIndex = line.indexOf("start_time");
                    int etIndex = line.indexOf("end_time");
                    int dIndex = line.indexOf("start_date");
                    int tIndex = line.indexOf("title");
                    int t1Index = line.indexOf("term");
                    
                    // ~~ Start Location Functions ~~ //
                    int lIndex = line.indexOf("room");
                    
                    String loc = (line.substring(lIndex+7, line.indexOf("meeting_days") - 2));
  
                    
                    
                    String title = (line.substring(tIndex+9, t1Index-4));
                    String meetingDays = (line.substring(mdIndex+16, stIndex-4));
                    
                    String startTimeS = "" + (line.substring(stIndex+14,stIndex+16));
                    String startTimeS1 = (line.substring(stIndex+17,stIndex+19));
                    startTimeS += startTimeS1;
                    
                    String endTimeS = (line.substring(etIndex+12, etIndex+14));
                    String endTimeS1 = (line.substring(etIndex+15, etIndex+17));
                    endTimeS += endTimeS1;

                    bobsMandCourses[i] = new Course(id);

                    bobsMandCourses[i].setName(title);
                    bobsMandCourses[i].setDaysofWeek(meetingDays);
                    bobsMandCourses[i].setStartTime(startTimeS);
                    bobsMandCourses[i].setEndTime(endTimeS);
                    bobsMandCourses[i].setLocation(loc);
                    
                    System.out.println(bobsMandCourses[i].getIDString());
                    System.out.println(bobsMandCourses[i].toString());


                    
                    System.out.println("\n");
                    //c.setDaysofWeek(meetingDays));
                    //courses[i] = c;
                }

                
            }
            for (int i=0; i<bobsIDs2.length; i++){
                
                String id;
                id = Integer.toString(bobsIDs2[i]);
                //System.out.println(courselist[i]);
                if (line.contains(id)){
                    
                    int mdIndex = line.indexOf("meeting_days");
                    int stIndex = line.indexOf("start_time");
                    int etIndex = line.indexOf("end_time");
                    int dIndex = line.indexOf("start_date");
                    int tIndex = line.indexOf("title");
                    int t1Index = line.indexOf("term");
                    
                    // ~~ Start Location Functions ~~ //
                    int lIndex = line.indexOf("room");
                    
                    String loc = (line.substring(lIndex+7, line.indexOf("meeting_days") - 2));
  
                    
                    
                    String title = (line.substring(tIndex+9, t1Index-4));
                    String meetingDays = (line.substring(mdIndex+16, stIndex-4));
                    
                    String startTimeS = "" + (line.substring(stIndex+14,stIndex+16));
                    String startTimeS1 = (line.substring(stIndex+17,stIndex+19));
                    startTimeS += startTimeS1;
                    
                    String endTimeS = (line.substring(etIndex+12, etIndex+14));
                    String endTimeS1 = (line.substring(etIndex+15, etIndex+17));
                    endTimeS += endTimeS1;

                    bobsOptCourses[i] = new Course(id);

                    bobsOptCourses[i].setName(title);
                    bobsOptCourses[i].setDaysofWeek(meetingDays);
                    bobsOptCourses[i].setStartTime(startTimeS);
                    bobsOptCourses[i].setEndTime(endTimeS);
                    bobsOptCourses[i].setLocation(loc);
                    
                    System.out.println(bobsOptCourses[i].getIDString());
                    System.out.println(bobsOptCourses[i].toString());


                    
                    System.out.println("\n");
                    //c.setDaysofWeek(meetingDays));
                    //courses[i] = c;
                }

                         
        }
        br.close();
        
        
        
        //~~Begin building the schedule~~//
        
  
        schedule unChecked = new schedule(bobsMandCourses,bobsOptCourses);
        ScheduleChecker a = new ScheduleChecker(unChecked);
        schedule[] validSchedules = a.resolveConflicts();
        ScheduleGenerator b = new ScheduleGenerator(validSchedules, bob);
        schedule finalSchedule = b.getBestSchedule();
      
        //get the course[]
        //move int[] id's
        //lookup course id and send all the information in the key back to jack
      
    }

}
}

