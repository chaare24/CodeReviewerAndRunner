/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codereviewerandrunner;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author charlesarellano
 */
public class viewExecutableEntries extends viewAllEntries{
    @Override
    public void retrieve(Connection con) {
        int count = 1;
        try {
            Statement stmt = con.createStatement();
            String SQL = "SELECT * FROM INFORMATION WHERE Code IS NOT NULL";
            ResultSet rs = stmt.executeQuery(SQL);
            
            System.out.print("\nALL ENTRIES:\n");
            while (rs.next()) {
                String topic = rs.getString("topic");
                String desc = rs.getString("description");
                String fN = rs.getString("code");
                
                if(fN == null){
                    fN="";
                }
                
                System.out.println(count + " " + topic + " " + fN);
                count++;
            }
        }catch (SQLException err) {
            System.err.println(err.getMessage());
        }
    }
}
