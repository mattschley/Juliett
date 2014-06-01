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
    private int warning_message;
    
    
    private String warningmessage;
    
    public schedule(){
        warningmessage = "";
    }
    
    
    public void setWarngingMessage(int n){
        if (n == NOLUNCH)
            warningmessage += "you can't eat lunch!";
        
        
        warningmessage += "warning detected";
        
    }
    
    public String getWarningMessage(){
        return warningmessage;
    }
    
       
        
    public static final int NOLUNCH = 41; 
    
    
    
}
