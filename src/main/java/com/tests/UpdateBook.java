/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tests;

import com.daos.BookDao;

/**
 *
 * @author User
 */
public class UpdateBook {
    public static void main(String[] args) throws ClassNotFoundException {
        boolean updated = BookDao.updateBook("1", "Bichos 2","el arbol empezó pequeño...","2");
        if(updated) {
            System.out.println("QueryOk!");
        } else {
            System.out.println("ERROR");
        }
        
    }
}
