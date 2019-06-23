/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codereviewerandrunner;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author charlesarellano
 */

public class newEntry{
    private String topicName; 
    private String topicDesc;
    private String topicFile;
    
    private Connection connect() {
        Connection con = null;
        String host = "jdbc:derby://localhost:1527/ReviewInformation";
        String username = "Charles";
        String password = "password";
        try {
            con = DriverManager.getConnection( host, username, password );
        }
        catch (SQLException err) {
            System.err.println(err.getMessage());
        }
        return con;
    }
    
    public void insert(String name, String desc, String fileName) {
        String sql = "INSERT INTO INFORMATION(topic,description,code,runtime) VALUES(?,?,?,?)";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, desc);
            pstmt.setString(3, fileName);
            pstmt.setString(4, null);
            pstmt.executeUpdate();
            System.out.println("Inserted into dB.");
        } catch (SQLException e) {
            System.out.println("DESC ERROR?");
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Constructor
     * @param topicName name of the topic 
     * @param desc description of the topic
    */
    public newEntry(String topicName, String desc, String fileName){
        this.topicName = topicName;
        this.topicDesc = desc;
        this.topicFile = fileName;
    }
    
    /**
     * @param name name of the topic 
     * @param desc description of the topic
     * 
     * Inserts information into database
    */
    
    public void setTopic(String name, String desc, String fileName){
        this.topicName = name;
        this.topicDesc = desc;
        this.topicFile = fileName;
        insert(name, desc, fileName);
    }
    
    public String getTopicName() {
        return this.topicName;
    }
    
    public String getTopicDesc() {
        return this.topicDesc;
    }
    
}
