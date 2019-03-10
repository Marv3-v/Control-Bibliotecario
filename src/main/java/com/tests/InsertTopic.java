/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tests;

import com.daos.TopicDao;
import com.models.Topic;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class InsertTopic {
    public static void main(String[] args) {
        Topic topic = new Topic("Ciencia Ficción","genero popular...");
        try {
            if(TopicDao.addTopic(topic)) {
                System.out.println("Query Ok");
            } else {
                System.out.println("Error");
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException - error insertar : " + ex.getMessage());
            Logger.getLogger(InsertTopic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
