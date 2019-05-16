/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tests;

import com.daos.BookDao;
import com.daos.RentedDao;
import com.models.Book;
import com.models.Rented;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author User
 */
public class RentBook {
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        
        Date sqlInicio = Date.valueOf("2019-03-22");
        Date sqlFinal = Date.valueOf("2019-03-23");
        
//        No ejecutar hasta asegurarse el número de Disponibles > 0

        Book b = BookDao.getBook("2");
        
//        Primera condición ve si existen las suficientes unidades disponibles
        if(b.getAvailableUnits()>0) {
            System.out.println("Si hay más de una");
            
//            Así que añade la renta, las fechas, cliente, libro, costo
            boolean added = RentedDao.add(new Rented(sqlInicio,sqlFinal,2,1,25));
//            Si es correcto el insert
            if(added) {
                System.out.println("Si se agregó la renta");
                
//                Restará una unidad disponible
//                Se resta una unidad
                int currentA = b.getAvailableUnits();
                int newAvailable = currentA - 1;
                
                
//            Así mismo ejecutar el removeAvailable
                boolean updated = RentedDao.updateAvailable(newAvailable,"2");
                if(updated) {
                    System.out.println("Funcionó todo");
                } else {
                    System.out.println("No se restó la unidad");
                }
            } else {
                System.out.println("No se agregó la renta");
            }
        } else {
            System.out.println("No tienes las unidades suficientes para rentar");
        }
    }
}
