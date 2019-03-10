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
    private String topicDesc;

    public Topic(int topicId, String name, String topicDesc) {
        this.topicId = topicId;
        this.name = name;
        this.topicDesc = topicDesc;
    }
    
     public Topic(String name, String topicDesc) {
        this.name = name;
        this.topicDesc = topicDesc;
    }
     
    public Topic(int idTopic, String name) {
        this.topicId = idTopic;
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

    public String getTopicDesc() {
        return topicDesc;
    }

    public void setTopicDesc(String topicDesc) {
        this.topicDesc = topicDesc;
    }
    
    
}
