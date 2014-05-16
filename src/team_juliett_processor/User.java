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
public class User {
    private int location;   // 0 = South; 1 = Central; 2 = North
    
    private int soft_start;
    private int soft_end;
    private int [] hard_times;
    
    private Course[] mand;
    private Course[] desired;
    private Course[] option;
    
    public User(int loc, Course[] mand_courses, Course[] desired_courses, Course[] optional_courses, int s_start, int s_end, int[] hard) {
        location = loc;
        mand = mand_courses;
        desired = desired_courses;
        option = optional_courses;
        soft_start = s_start;
        soft_end = s_end;
        hard_times = hard;
    }
    
    public Course[] schedule() {
        if (mand.length > 1){
            
        }
        
        return mand;
    }
    
    private Course[][] split_mandatory(Course[] mands) {
        Course[][] result;
        result = new Course[mands.length][1];   // initialize to be # of mandatory courses x 1
        
        
        int st;
        int en;
        for (int ii = 0; ii < mands.length; ii++) {
        
            st = mands[ii].start_time;
            en = mands[ii].end_time;
            for (int jj = 0; jj < mands.length - 1; jj ++) {
                
            }
        
        
        }
        
        return result;
    }
}
