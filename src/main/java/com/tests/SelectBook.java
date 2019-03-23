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
        
    List<Book> books = BookDao.getBooks();
    
//        for (Book book : books) {
//        System.out.println(
//                       book.getDescription() + " " + 
//                       book.getTitle() + " " + 
//                       book.getTopicName());
//        }

    Book b = BookDao.getBook("2");
        System.out.println("libro: " + b.getTitle() +
                           "  tema: " + b.getTopicName() +
                           "  idTema : " + b.getTopicId() +
                           " unidades: " + b.getUnits() + 
                            "   " +  b.getYesNoActive());


//        List<Book> topicsBook = BookDao.getTopicBooks("1");
        
//        for (Book book : topicsBook) {
//            System.out.println("Categoria: " + book.getTopicName());
//            System.out.println(
//            " libros : " + book.getTitle());
//        }
        
    
        
    }
    
    
    
}
