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
    private int rating;
    private schedule bestSchedule;
    private User bob;
    
    //Initalizes the list of schedules that must be passed from the main function
    public ScheduleGenerator(schedule[] VS, User b)
    {
        validSchedules = VS;
        rating = 0;
        bestSchedule = null;
        bob = b;
    }
     
    //this is the main function
    public schedule getBestSchedule()
    {
        if(bestSchedule == null)
            RankSchedules(validSchedules); //internal call to the rankSchedules method
        return bestSchedule;
    }
    
    private void RankSchedules(schedule[] s)
    {
        
        //Create local variables for this method
        schedule[] inOrder = new schedule[s.length];
        schedule[] poss = validSchedules;
        
        //Rank each schedule indivudally
        for(int i = 0; i < poss.length; i++)
        {
            int rank = rateSchedule(poss[i]);
            poss[i].setRank(rank);
         }
        
        //Order the list based on rank
        for(int i = 0; i < poss.length; i++)
        {
            //sort the arry based on rank
            
        }
        
        bestSchedule = inOrder[0];
    }
    
    public int rateSchedule(schedule s)
    {
        //Three sets of local variables for this method
        int scheduleScore;
        int scheduleSt;
        int scheduleEt;
        Course lastCourseOfDay = null;
        Course firstCourseOfDay = null;
        
        Course[] a = s.getAllCourses();
       
        //Sort the courses in chronilogical order
        sortByTime(a);
        
        //Initialize the local variables with the sorted array of courses
        int userStartTime = bob.getStartTime();
        int userEndTime = bob.getEndTime();
        
        scheduleSt = a[0].start_time;
        firstCourseOfDay = a[0];
        
        scheduleEt = a[a.length-1].end_time;
        lastCourseOfDay = a[a.length-1];
        
        //change schedule score based on the number of mandatory courses in the schedule - most significant
        rankOnNumOfMandatoryClasses(s);
        
        //change scheduleScore based on the start and end time prefrences - middle significant
        rankOnTimePrefrences(userStartTime, userEndTime, scheduleSt, scheduleEt, s);
        
        //change the schedule score based on the locations of each class - least significant
        rankOnLocation(s);
        
        return s.scheduleScore;
    }
    
    private void rankOnNumOfMandatoryClasses(schedule a)
    {
        int numberofMands = 0;
        Course[] mands = a.getMandCourses();
        numberofMands = howManyMands(mands, a);
        if (numberofMands == 1)
            a.scheduleScore += 10;
        else if(numberofMands == 2)
            a.scheduleScore += 20;
        else if(numberofMands == 3)
            a.scheduleScore += 30;
        else if(numberofMands == 4)
            a.scheduleScore += 40;
        else
            a.scheduleScore -= 10;
    }
    
    private void rankOnTimePrefrences(int uS, int uE, int sS, int sE, schedule a)
    {
        //now adjust the schedule scores based on time conflicts and prefrences
        if(sS >= uS && sE <= uE)
            a.scheduleScore += 10;
        else if(sS < uS && sE <= uE)
            a.scheduleScore += 5;
        else if(sS >= uS && sE > uE)
            a.scheduleScore += 5;
        else
            a.scheduleScore += -5;
    }
       
  
    
    private void rankOnLocation(schedule s)
    {
        int totalRank = 0;
        Course[] a = s.getAllCourses();
        
        //compare the location of the first class to where they live on campus
        //high ranking because most important
        if(a[0].getLocation() == bob.getLoc())
            totalRank+=5;
        else
            totalRank-=5;
        
        //change totalRank based on the location of the next classes
        for(int i = 1; i < a.length - 1; i++)
        {
            if(a[i].nextLocationRank(a[i+1]) == 1)
                totalRank += 2;
            else
                totalRank-=1;
        }
        
        //then change scheduleScore according to the total rank of schedules
        if(totalRank >= 5)
            s.scheduleScore+= 3;
        if(totalRank <= 1 && totalRank >=-1)
            s.scheduleScore+=1;
        if(totalRank <= -1 && totalRank >= -5)
            s.scheduleScore-=-1;
        if(totalRank <= -5)
            s.scheduleScore-=3; 
    }
     
    private int howManyMands(Course[] m, schedule k){
        int mandL = m.length;
        Course[] allCourses = k.getAllCourses();
        
        int numMands = 0;
        for (int i=0; i<mandL; i++){
            for (int j = 0; j<4; j++)
                if(m[i].compareTo(allCourses[j]) == 1)
                     numMands++;   
        }
        return numMands;
    }
    
    public void sortByTime(Course[] x) 
    {
        int n = x.length;
        for (int pass=1; pass < n; pass++)
        { 
            // count how many times
            // This next loop becomes shorter and shorter
            for (int i=0; i < n-pass; i++) 
            {
                 if (x[i].start_time > x[i+1].start_time) 
                 {
                    // exchange elements
                    Course temp = x[i];  x[i] = x[i+1];  x[i+1] = temp;
                }
            }
        }
    }

    
}


