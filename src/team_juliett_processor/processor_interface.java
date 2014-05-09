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
public interface processor_interface {
    public Course[] parse_course_ids(int[] course_ids);
    
    public boolean mandatory_conflicts(Course[] courses);
    //returns true if two "have to take" courses have a time conflict

    public Course [] generate_good_courselists(Course[] shufflees);
    //works with mandatory_conflicts and autofills "have to take courses"
    //if there are no conflicts, all possible courselists are generated
    //if there is a conflict, courselists are generated accordingly
    
    
}
