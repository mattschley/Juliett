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
    
    private int start;
    private int end;
    
    private Course[] mand;
    private Course[] option;
    
    public User() {
        
    }
    
    public User(int loc, int[] mand_courses, int[] optional_courses, int start_t, int end_t) {
        location = loc;
        int mand_len = mand_courses.length;
        int option_len = optional_courses.length;
        
        mand = new Course[mand_len];
        for (int ii = 0; ii < mand_len; ii++) {
            mand[ii] = new Course(mand_courses[ii] + "");
        }
        
        option = new Course[option_len];
        for (int ii = 0; ii < option_len; ii++) {
            option[ii] = new Course(optional_courses[ii] + "");
        }
        
        
        start = start_t;
        end = end_t;
    }
    
    
    public String test() {
        return "Hello, World!";
    }
        

}
