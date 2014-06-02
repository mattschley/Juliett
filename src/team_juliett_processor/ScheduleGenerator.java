/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package team_juliett_processor;

/**
 *
 * @author Jeremymidvidy
 */
public class ScheduleGenerator 
{
    //a list of schedules that are can feasibly made
    private schedule[] validSchedules;
    private int numOfMandClasses;
    
    //Initalizes the list of schedules that must be passed from the main function
    public ScheduleGenerator(schedule[] VS)
    {
        validSchedules = VS;
        getNumOfMandClasses();
    }
    
    private void getNumOfMandClasses()
    {
        
    }
    public void RankSchedules(schedule[] s)
    {
        for(int i = 0; i < s[i].getMandClasses().length; i++) //change this
        {
            //Check what has the most number of mandatory classes - highest rank automatically
            
        }
    }
    
}


