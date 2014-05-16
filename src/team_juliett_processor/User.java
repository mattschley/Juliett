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
    private Course[] option;
    
    public User() {
        
    }
    
    public User(int loc, Course[] mand_courses, Course[] optional_courses, int s_start, int s_end, int[] hard) {
        location = loc;
        mand = mand_courses;
        option = optional_courses;
        soft_start = s_start;
        soft_end = s_end;
        hard_times = hard;
    }
    
    private schedule[] schedule(Course[] mands, Course[] option) {
        schedule[] results;
        results = new schedule[0];
        schedule[] temp;
        
        if (mands.length == 0)
            return results;
        
//        for (int ii = 0; ii < mands.length; ii++) {
//            for (int jj = 0; jj < mands.length; jj ++) {
//                if (ii != jj)
//                    if (mands[ii].conflict(mands[jj]))
//                        
//            }
//        }
        
        return results;
    }
    
    public String test() {
        return "Hello, World!";
    }
        

}
