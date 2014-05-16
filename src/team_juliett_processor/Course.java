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
    private int start_time;
    private int end_time;
    
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

}   // end definition
