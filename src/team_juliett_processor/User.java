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
    
    public User(int loc, Course[] mand_courses, Course[] desired_courses, Course[] optional_courses, int s_start, int s_end, int[] hard_times) {
        
    }
}
