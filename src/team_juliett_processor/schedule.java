/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package team_juliett_processor;

/**
 *
 * @author talilaifer
 */
public class schedule {
    
    private Course[] courses;
    private int rating;
    static private int[] warning_messages;
    
    
    private String warningmessage;
    
    public schedule(Course[] courses){
        warningmessage = "";
        Course[] test = courses;
        rating = 0; 
       
    }
    public void processWarningArray(int[] n){
    for(int i = 0; i < n.length; i++){
        int warning_instance = n[i];
        setWarningMessage(warning_instance);
    }
    
    }
    
    public void setWarningMessage(int n){
        if (n == NOLUNCH)
            warningmessage += "you can't eat lunch!";
        else if (n == LONGWALK){warningmessage += "you will have a long walk";}
        
        else
        warningmessage += "warning detected";
        
    }
    
    public String getWarningMessage(){
        return warningmessage;
    }
    
       
        
    public static final int NOLUNCH = 41; 
    public static final int LONGWALK = 42;
    
    
}
