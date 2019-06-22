/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codereviewerandrunner;

/**
 *
 * @author charlesarellano
 */

public class newEntry{
    private String topicName; 
    
    public newEntry(String topicName){
        this.topicName = topicName;
    }
    
    public void setTopic(String name){
        this.topicName = name;
        System.out.println("Topic set.");
    }
    
    public String getTopic() {
        
        return this.topicName;
    }
    
}
