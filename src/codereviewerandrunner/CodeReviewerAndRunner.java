/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codereviewerandrunner;
import java.util.Scanner;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement; // to execute SQL statements 
import java.sql.ResultSet;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/** 
 * RESULT SET: 1) Move Forward through records
 * Type number 1 on the list above is called a TYPE_FORWARD_ONLY ResultSet. 
 * 
 * 2) Move Backwards and forward through records and detect any changes
 * Number 2 on the list is a TYPE_SCROLL_SENSITIVE ResultSet. 
 * 
 * 3) Same as 2 but neglect any changes
 * The third ResultSet option is called TYPE_SCROLL_INSENSITIVE.
 */


/**
 *
 * @author charlesarellano 6/21/2019
 */
public class CodeReviewerAndRunner {
    
    public static void add() {
        Scanner input = new Scanner(System.in);
        String numSelection = "";
        newEntry app = new newEntry(null, null);
        while (true) {
            /* Get user's input for Topic Name */
            System.out.print("Enter topic name: ");
            String name = input.nextLine();
            
            /* Get user's input for Topic Description */
            System.out.println("Enter description: ");
            String desc = input.nextLine();
            
            /* Set topic and description and insert into dB */
            app.setTopic(name, desc);
            
            /* Get the user's selection again */
            System.out.print("Would you like to add another (Y or N): ");
            numSelection = input.nextLine();
            if (numSelection.equals('N')) break;
        }
        mainSelection();
    }
    
    public static void viewAll() {
        viewAllEntries app = new viewAllEntries();
        app.view();
    }
    
    public static void clear(){
        System.out.print("\033[H\033[2J");
    }

    public static void mainSelection() {
        String welcome = "Please enter your command:\n";
        String menu = "1:Add\n2:View All\n4:Clear Screen";
        System.out.println(welcome + menu);
        System.out.print("Selection: ");
        Scanner input = new Scanner(System.in);
        String numSelectionStr = input.nextLine();
        int numSelection = Integer.parseInt(numSelectionStr);
        while (numSelection != 6) {
            switch(numSelection) {
                case 1: add();
                        break;
                case 2: viewAll();
                        break;
//                case 3: runner();
//                        break;
                case 4: clear();
                        break;
                case 6: System.exit(0);
                        break;
                default: System.out.println("Invalid Selection");
                         break;
            }
            
            System.out.println(welcome + menu);
            System.out.print("Selection: ");
            numSelectionStr = input.nextLine();
            numSelection = Integer.parseInt(numSelectionStr);
        }
        System.exit(0);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // TODO code application logic here
        mainSelection();

    }
    
}
