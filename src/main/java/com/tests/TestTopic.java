/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tests;

import com.models.Book;
import com.models.Topic;

/**
 *
 * @author User
 */
public class TestTopic {
    
    public static void main(String[] args) {
        Topic t = new Topic(2,"Misterio");
        Book b = new Book(1,"titulo","primer libro",t);
        System.out.println(" Id tema : " + b.getTopicId());
    }
}
