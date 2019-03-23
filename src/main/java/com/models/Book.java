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
    private boolean active = true;
    private int units;
    private int availableUnits;
    private int topicId;
    private Topic topic;


//    public Book(int id, String title, String description, boolean rentedNow, int topicId) {
//        this.id = id;
//        this.title = title;
//        this.description = description;
//        this.rentedNow = rentedNow;
//        this.topicId = topicId;
//    }

    public Book(int id, String title, String description, Topic topic) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.topic = topic;
    }
    
    public Book(int idBook) {
        this.id = idBook;
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

    
  
    /**
     * Método constructor de la clase Book, sirve para el detalle de un libro
     * @param id
     * @param title
     * @param description
     * @param units
     * @param availableU
     * @param active
     * @param topic 
     */
    public Book(int id, String title, String description, int units, int availableU, boolean active, Topic topic ) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.units = units;
        this.availableUnits = availableU;
        this.active = active;
        this.topic = topic;
    }

    /**
     * Constructor exclusivo para añadir un nuevo libro de la clase Book
     * @param title
     * @param desc
     * @param topicId
     * @param units
     * @param availableU 
     */
    public Book(String title, String desc, int topicId, int units, int availableU) {
        this.title = title;
        this.description = desc;
        this.topicId = topicId;
        this.units = units;
        this.availableUnits = availableU;
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
    
    public boolean isActive() {
        return active;
    }
    
    public String getYesNoActive() {
        return (isActive()?"Activo":"Inactivo");
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public int getAvailableUnits() {
        return availableUnits;
    }

    public void setAvailableUnits(int availableUnits) {
        this.availableUnits = availableUnits;
    }
    
    
}
