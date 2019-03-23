/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

/**
 *
 * @author User
 */
public class Topic {
    
    private int topicId;
    private String name;

    public Topic(int topicId, String name) {
        this.topicId = topicId;
        this.name = name;
    }
    
     public Topic(String name) {
        this.name = name;
    }
     
    public int getTopicId() {
        return topicId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
        
}
