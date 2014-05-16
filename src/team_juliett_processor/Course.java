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
public class Course {
    
// beginning and end of class--formatted HHMM
    private String course_name; 
    protected int start_time;
    protected int end_time;
    
// days of the week on which the class is held (binary format)
    private int days_of_week;
    
// course ID (not to be confused with course number)
    private int course_id;
    
// course number
    private int course_number;
    
// location on campus (North, Central, or South as 1, 0, -1, respectively)
    private int location;
    
// parameters (area 1 distro, etc.)    
// bool 6 length array
    private boolean[] distros;
    

    // pre-requisites
    
// major/minor requirements

    /*------------------------------------------------------------------------*/
    
// constructor
    public Course(String n,int st,int et,int dow,int id) {
        course_name = n;
        start_time = st; 
        end_time = et; 
        days_of_week = dow; 
        course_id = id; 
        /*course_number = cn; 
        location = l;
        distros = d;*/

        
    }

    /*------------------------------------------------------------------------*/    

// return the start and end times
    public int[] get_times() {
        
        int [] x;
        x = new int[2];
        x[0] = start_time;
        x[1] = end_time;
        
        return x;
    }
    
    public String toString(){
        return course_name;
    }
    
    public boolean conflict (Course c){
        int conflictInt = this.days_of_week + c.days_of_week;
        
        //two classes that do not meet on the same day
        if   (conflictInt == 11111 || conflictInt == 11110 || conflictInt == 11101 || conflictInt == 11011 || conflictInt == 10111 || conflictInt == 01111 
           || conflictInt == 11100 || conflictInt == 11001 || conflictInt == 10011 || conflictInt == 00111 || conflictInt == 11010 || conflictInt == 01101 || conflictInt == 10110 || conflictInt == 01011 || conflictInt == 10101
           || conflictInt == 00011 || conflictInt == 00110 || conflictInt == 01100 || conflictInt == 11000 || conflictInt == 00101 || conflictInt == 10010 || conflictInt == 01001 || conflictInt == 10100 || conflictInt == 01010)
            return false;
        
        //two classes that meet on the same days
        else if ((this.start_time == c.start_time) || (this.start_time <= c.end_time && this.start_time >= c.start_time)
                 || (this.end_time >= c.start_time && this.end_time <= c.end_time))
                    return true;
        
        //two classes that have a day of interference....
        return false;
    }

}   // end definition
