/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codereviewerandrunner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author charlesarellano
 */
public class viewAllEntries {
    
    public void view() {
        String host = "jdbc:derby://localhost:1527/ReviewInformation";
        String username = "Charles";
        String password = "password";
        int count = 1;
        try {
            Connection con = DriverManager.getConnection( host, username, password );
            Statement stmt = con.createStatement();
            String SQL = "SELECT * FROM INFORMATION";
            ResultSet rs = stmt.executeQuery(SQL);
            
            System.out.print("\nALL ENTRIES:\n");
            while (rs.next()) {
                String topic = rs.getString("topic");
                String desc = rs.getString("description");
                
                System.out.println(count + " " + topic);
                count++;
            }
            
            System.out.print("\n");
        }
        catch (SQLException err) {
            System.err.println(err.getMessage());
    }
    
}
}
