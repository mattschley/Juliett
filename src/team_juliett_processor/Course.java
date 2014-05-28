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
        days_of_week = new boolean[5];
        //days_of_week[0] = false;
        for(int i = 0; i < 5; i++){
            //days_of_week[i] = new boolean();
            days_of_week[i] = false;
        }
        course_id = id; 
        /*course_number = cn; 
        location = l;
        distros = d;*/

        
    }
    
    public Course(int course_id) {
        this.course_name = "" + course_id;
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
    
    public boolean[] get_days_of_week(){
        return days_of_week;
    }
            
    public boolean conflict (Course c){
        for (int i = 0; i <5; i++){
            if (this.days_of_week[i] && c.days_of_week[i])
                if ((this.start_time == c.start_time) || (this.start_time < c.end_time && this.start_time > c.start_time)
                                                      || (this.end_time > c.start_time && this.end_time < c.end_time))
                    return true;
        }
        return false;
    }
    
    public void setDaysofWeek(String t){
        if (t.contains("Mo"))
            days_of_week[0] = true;
        if (t.contains("Tu"))
            days_of_week[1] = true;
        if (t.contains("We"))
            days_of_week[2] = true;
        if (t.contains("Th"))
            days_of_week[3] = true;
        if (t.contains("Fr"))
            days_of_week[4] = true;
    }
    
    public String getDaysofWeek(){
        return "----" + this.course_name + "----" +
                "\nMo: " + days_of_week[0] + 
                "\nTu: " + days_of_week[1] + 
                "\nWe: " + days_of_week[2] + 
                "\nTh: " + days_of_week[3] + 
                "\nFr: " + days_of_week[4];
    }

}   // end definition
