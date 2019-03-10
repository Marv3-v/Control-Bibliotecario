/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tests;

import com.daos.BookDao;
import com.models.Book;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class SelectBook {
    
    public static void main(String[] args) throws ClassNotFoundException {
        
//    List<Book> books = BookDao.getBooks();
//    
//        for (Book book : books) {
//        System.out.println(
//                       book.getDescription() + " " + 
//                       book.getTitle() + " " + 
//                       book.getTopicName().getName());
//        }

    Book b = BookDao.getBook("7");
        System.out.println(" Id tema : " + b.getTopicId() + " nombre: " + b.getTopicName());
//    updated = BookDao.updateBook(idBook, newTitle, newDesc, newIdTopic);

//        List<Book> topicsBook = BookDao.getTopicBooks("1");
//        for (Book book : topicsBook) {
//            System.out.println("Categoria: " + book.getTopicName().getName());
//            System.out.println(
//            " libros : " + book.getTitle());
//        }
        
    
        
    }
    
    
    
}
