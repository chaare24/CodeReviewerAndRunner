/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codereviewerandrunner;
import java.util.Scanner;
import java.util.ArrayList;
import org.omg.CORBA.SystemException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author charlesarellano 6/21/2019
 */
public class CodeReviewerAndRunner {
    
    public static void add(int count) {
        Scanner input = new Scanner(System.in);
        String topicName = "", numSelection = "";
        ArrayList<newEntry> eArr = new ArrayList<newEntry>();
        eArr.add(new newEntry(null));
        
        while (!numSelection.equals("6")) {
            // Get user's input for Topic Name 
            System.out.print("Enter topic name: ");
            String name = input.nextLine();
            eArr.get(count).setTopic(name);
            
            // Get the user's selection again
            System.out.print("Would you like to add another (6 to terminate): ");
            numSelection = input.nextLine();
            count++;
            if (numSelection.equals('6')) break;
        }
        mainSelection(count);
    }

    public static void mainSelection(int count) {
        System.out.println("1:Add\n2:Find\n3:View All");
        System.out.print("Selection: ");
        Scanner input = new Scanner(System.in);
        String numSelection = input.nextLine();
        while (!numSelection.equals("6")) {
            if (numSelection.equals("1"))
            {
                add(count);
                count++;

            }
           
        }
        System.exit(0);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        // TODO code application logic here
        try {
        String host = "jdbc:derby://localhost:1527/ReviewInformation";
        String username = "Charles";
        String password = "password";
        
        
        Connection con = DriverManager.getConnection( host, username, password );
        
        }
        catch (SQLException err) {
            System.err.println(err.getMessage());
        }
        int count = 0;
        mainSelection(count);

    }
    
}
