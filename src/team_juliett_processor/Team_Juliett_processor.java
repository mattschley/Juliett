/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package team_juliett_processor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Ethan
 */
public class Team_Juliett_processor {

    /**
     * @param args the command line arguments
     */
    private static int number_of_courses;
    
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new FileReader("EECS_DB.txt"));
        
        
        String line;
        
        while((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
        
        User bob;
        int[] mands;
        int[] options;
        mands = new int[3];
        options = new int[3];
        
        mands[0] = mands[1] = mands[2] = options[0] = options[1] = options[2] = 3;
        
        bob = new User(1, mands, options, 0, 1);
        
        System.out.println(bob.test());
   
    }
}