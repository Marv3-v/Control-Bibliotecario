/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tests;

import com.daos.BookDao;
import com.models.Book;

/**
 *
 * @author User
 */
public class UpdateUnits {
    
    public static void main(String[] args) throws ClassNotFoundException {
        
        Book b = BookDao.getBook("2");
        System.out.println("Unidades actuales: " +b.getUnits());
        System.out.println("Unidades disponibles: " + b.getAvailableUnits());
        
        int newUnits = b.getUnits() + 2;
        int newAvailables = b.getAvailableUnits() + 2;
        System.out.println("Se sumaron dos: ahora serán: " + newUnits);
        
        boolean updated = BookDao.updateUnits(newUnits, newAvailables, "2");
        if(updated) {
            System.out.println("Exito Marv, you´re amazing tho!");
        } else{
            System.out.println("Well, it just didn´t work");
        }
        
    }
    
}
