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
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 *
 * @author charlesarellano 6/21/2019
 */
public class CodeReviewerAndRunner {
    
    public static void add() {
        Scanner input = new Scanner(System.in);
        String numSelection = "";
        newEntry app = new newEntry(null, null, null);
        while (true) {
            /* Get user's input for Topic Name */
            System.out.print("Enter topic name: ");
            String name = input.nextLine();
            
            /* Get user's input for Topic Description */
            System.out.println("Enter description: ");
            String desc = input.nextLine();
            
            System.out.println("Enter correct file name(NA for No File): ");
            String fileName = input.nextLine();
            
            fileName = fileCorrectCodeChecker(fileName);
            
            /* Set topic and description and insert into dB */
            app.setTopic(name, desc, fileName);
            
            /* Get the user's selection again */
            System.out.print("Would you like to add another (Y or N): ");
            numSelection = input.nextLine();
            if (numSelection.equals("N")) break;
        }
        mainSelection();
    }
    
    public static String fileCorrectCodeChecker(String fileName) {
        Scanner input = new Scanner(System.in);
        File file = new File("/Users/charlesarellano/Documents/GitHub/CodeReviewerAndRunner/src/codereviewerandrunner/CorrectCode/"+fileName);
            boolean exists = file.isFile();
            if(fileName.equals("NA")){
                exists = true;
                fileName = null;
            }
            while(!exists) {
                System.out.println("Not found in the CorrectCode folder, please try again.");
                System.out.print("Enter correct file name: ");
                fileName = input.nextLine();
                file = new File("/Users/charlesarellano/Documents/GitHub/CodeReviewerAndRunner/src/codereviewerandrunner/CorrectCode/"+fileName);
                exists = file.isFile();
            }
        return fileName;
    }
    
    public static String fileTestCodeChecker(String fileName) {
        Scanner input = new Scanner(System.in);
        File file = new File("/Users/charlesarellano/Documents/GitHub/CodeReviewerAndRunner/src/codereviewerandrunner/TestCode/"+fileName);
            boolean exists = file.isFile();
            if(fileName.equals("NA")){
                exists = true;
                fileName = null;
            }
            while(!exists) {
                System.out.println("Not found in the CorrectCode folder, please try again.");
                System.out.print("Enter correct file name: ");
                fileName = input.nextLine();
                file = new File("/Users/charlesarellano/Documents/GitHub/CodeReviewerAndRunner/src/codereviewerandrunner/TestCode/"+fileName);
                exists = file.isFile();
            }
        return fileName;
    }
    
    public static void viewAll() {
        viewAllEntries app = new viewAllEntries();
        app.view();
    }
    
    public static void clear(){
        System.out.print("\033[H\033[2J");
    }

    public static void correctCodeSelector() {
        Scanner input = new Scanner(System.in);
        System.out.print("Which code would you like to run: ");
        String fileName = input.nextLine();
        
        fileName = fileCorrectCodeChecker(fileName);
        
        runCode app = new runCode();
        app.compileRunCode(fileName);
        
    }
    
    public static void testCodeSelector() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the file to run: ");
        String fileName = input.nextLine();
        
        fileName = fileTestCodeChecker(fileName);
        
        runTestCode app = new runTestCode();
        app.compileRunCode(fileName); // change
        
    }
    
    public static void runner() {
        Scanner input = new Scanner(System.in);
        
        System.out.println("What would you like to run?");
        System.out.println("1:Correct Code\n2:Test your own");
        System.out.print("Select: ");
        String select = input.nextLine();
        
        if (select.equals("1")){
            System.out.println("Would you like to see the list of all runable codes? (Y or N) ");
            select = input.nextLine();
            if (select.equals("Y")) {
                viewExecutableEntries app = new viewExecutableEntries();
                app.view();
                correctCodeSelector();
            } else {
                correctCodeSelector();
            }
        } else {
            // Runner for own code
            testCodeSelector();
        }
        
        // Need to have a runner for Correct Code 
        
         // Need to have a runner for Test Code
    }
    
    

    public static void mainSelection() {
        String welcome = "Please enter your command:\n";
        String menu = "1:Add\n2:View All\n3:Run Code\n4:Clear Screen";
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
                case 3: System.out.print("\n");
                        runner();
                        break;
                case 4: clear();
                        break;
                case 6: System.exit(0);
                        break;
                default: System.out.println("Invalid Selection");
                         break;
            }
            
            System.out.println("\n"+welcome + menu);
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
