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
    private boolean[] days_of_week;
    
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
    public Course(String n,int st,int et,int id) {
        course_name = n;
        start_time = st; 
        end_time = et; 
        boolean[] days_of_week;
        days_of_week = new boolean[5];
        for(int i = 0; i <= 5; i++){
            days_of_week[i] = false;
        }
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
        int cI = this.days_of_week + c.days_of_week;
        
        //two classes that do not meet on the same day
        if   (cI == 11111 || cI == 11110 || cI == 11101 || cI == 11011 || cI == 10111 || cI == 01111 
           || cI == 11100 || cI == 11001 || cI == 10011 || cI == 00111 || cI == 01110 || cI == 11010 || cI == 01101 || cI == 10110 || cI == 01011 || cI == 10101
           || cI == 00011 || cI == 00110 || cI == 01100 || cI == 11000 || cI == 10001 || cI == 00101 || cI == 10010 || cI == 01001 || cI == 10100 || cI == 01010)
            return false;
        
        //two classes that meet on the same days
        else if (this.days_of_week == c.days_of_week){
            if ((this.start_time == c.start_time) || (this.start_time <= c.end_time && this.start_time >= c.start_time)
                 || (this.end_time >= c.start_time && this.end_time <= c.end_time))
                    return true;
        }
        
        //two classes that have a day of interference....
        {
            
        }
        return false;
    }

}   // end definition
