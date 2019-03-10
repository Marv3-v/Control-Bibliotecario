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
public class Book {
    private int id;
    private String title;
    private String description;
    private boolean rentedNow = false;
    private int topicId;
    private Topic topic;

//    public Book(int id, String title, String description, boolean rentedNow, int topicId) {
//        this.id = id;
//        this.title = title;
//        this.description = description;
//        this.rentedNow = rentedNow;
//        this.topicId = topicId;
//    }

    public Book(int id, String title, String description, boolean rentedNow, Topic topic) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.rentedNow = rentedNow;
        this.topic = topic;
    }

//    public Book(String title, String description) {
//        this.title = title;
//        this.description = description;
//    }
    
    public Book(int id, String title, Topic topic) {
        this.id = id;
        this.title = title;
        this.topic = topic;
    }

//    public Book(String title, String description, boolean rentedNow, int topicId) {
//        this.title = title;
//        this.description = description;
//        this.rentedNow = rentedNow;
//        this.topicId = topicId;
//    }
    
    /*
    * Constructor de la clase Book,
    * sirve para insertar datos / libro a la base de datos
    */
    public Book(String title, String description, int topicId) {
        this.title = title;
        this.description = description;
        this.topicId = topicId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isRentedNow() {
        return rentedNow;
        
    }
    
    public String getYesNoRented() {
        return (isRentedNow()?"rentado":"disponible");
        
    }

    public void setRentedNow(boolean rentedNow) {
        this.rentedNow = rentedNow;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }
    
    public String getTopicName() {
        return topic.getName();
    }
    
    public Topic getTopic() {
        return topic;
    }
    
    public int getTopicId(){
        return topic.getTopicId();
    }
    
    public int getTopicI() {
        return topicId;
    }
    
    
}
