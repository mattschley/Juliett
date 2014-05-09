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
    
    public void identify_mandatory_conflicts(Course[] courses);

    public Course [] generate_all_schedules(Course[] shufflees);
    
    
}
