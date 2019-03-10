/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tests;

import com.daos.BookDao;
import com.models.Book;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class InsertBook {
    
    
    public static void main(String[] args) throws ClassNotFoundException {
        Book book = new Book("Maze","te pierdes",2);
        try {
            
        if(BookDao.addBook(book)) {
            System.out.println("Query ok!");
        } else {
            System.out.println("Error al insertar libro: ");
        }
        } catch(ClassNotFoundException e) {
            System.out.println("error :" + e.getMessage());
        }
    
        
    }
    
    
    
}
